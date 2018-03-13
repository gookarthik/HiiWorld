
public class StringBufferToString {
	public static void main(String[] args) {
		StringBuffer sbr = new StringBuffer("Geeks");
		
		String str = sbr.toString();
		System.out.println(str);
		
		sbr.append("fofgeeks");
		System.out.println(sbr);
		System.out.println(str);
		
		
	}

}
