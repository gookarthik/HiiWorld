import java.util.StringJoiner;
import java.util.ArrayList;

public class StringJoin {
	public static void main(String[] args) {
		ArrayList<String> str = new ArrayList<>();
		str.add("Ram");
		str.add("Lakshman");
		str.add("Bharata");
		str.add("Kshatrugna");
		
		StringJoiner sj1 = new StringJoiner(",");
		
		sj1.setEmptyValue("String is Empty");
		System.out.println(sj1);
		
		sj1.add(str.get(0)).add(str.get(1));
		System.out.println(sj1);
		
		StringJoiner sj2 = new StringJoiner(":");
		
		sj2.add(str.get(2)).add(str.get(3));
		
		sj1.merge(sj2);
		
		System.out.println(sj1);
		
	}
	

}
