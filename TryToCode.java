package org.sitenv.spring.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

public class TryToCode {

	static StringBuffer result = null;
	static String line = null;
	static HttpClient client = null;
	static HttpGet request = null;
	static HttpResponse response = null;
	static BufferedReader rd = null;
	static JSONObject data = null, entry = null, res = null;
	static JSONArray entries = null;
	static String id = "";
	static int u = 0;
	static String justdate = "", url = "";
	static List<String> readthelist = null;
	static List<String> listread = null;
	static List<String> readid = null;
	static String full_url = null;
	static String res_type = null;

	private static List<String> readFile(String path) {
		String line = null;
		readthelist = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			while ((line = reader.readLine()) != null) {
				readthelist.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return readthelist;
	}

	private void getResourceByPatientId(String url, String resourceName) throws Exception {

		resourceName = "Observation";
		readid = readFile("C:\\Users\\it-su\\Desktop\\oberved.txt");

		for (int j = 0; j < readid.size(); j++) 
		{
			url = "https://open-ic.epic.com/FHIR/api/FHIR/DSTU2/Observation?_id="+readid.get(j);
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(url);

			// add request header
			request.addHeader("Accept", "application/json+fhir");

			HttpResponse response = client.execute(request);

			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
			if (response.getStatusLine().getStatusCode() == 200) {
				BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

				StringBuffer result = new StringBuffer();
				String line = "";
				while ((line = rd.readLine()) != null) {
					result.append(line);
				}

				System.out.println(result.toString());

				// Bundle bundle1 = (Bundle)
				// ctx.newJsonParser().parseResource(response.toString());
				JSONObject data = new JSONObject(result.toString());

				if (data.has("entry")) {
					System.out.println(data.getJSONArray("entry").length());
					System.out.println(data.getJSONArray("entry"));

					JSONArray entryList = data.getJSONArray("entry");
					if (entryList != null) {
						try {
							String contextPath = System.getProperty("catalina.base");
							File destDir = new File(contextPath + "/karthik/test/");

							if (!destDir.exists()) {
								destDir.mkdirs();
							}
							String fileName = resourceName + ".ndjson";

							File ndJsonFile = new File(destDir.getAbsolutePath() + "/" + fileName);
							// StringBuilder responseData = new StringBuilder();

							// PrintWriter pw = new PrintWriter(ndJsonFile);

							FileWriter fw = new FileWriter(ndJsonFile.getAbsolutePath(), true); // the true will append
																								// the new data
							System.out.println("Writing data into file ...");
							// for(Patient patient : patients){
							for (int i = 0; i < entryList.length(); i++) {

								System.out.println(".");
								StringBuilder exportData = new StringBuilder();

								exportData.append(entryList.get(i));
								exportData.append('\n');
								fw.write(exportData.toString());
							}
							System.out.println("Data added to the file : " + ndJsonFile.getAbsolutePath());
							fw.close();

						} catch (Exception e) {
							System.out.println(e.getMessage());
						}

					}
				}

			}

		}

	}

	public static void main(String[] args) {
		TryToCode see = new TryToCode();
		try {
			see.getResourceByPatientId("", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
