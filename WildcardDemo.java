import java.util.List;
import java.util.Arrays;

public class WildcardDemo {
	public static void main(String[] args)
	{
		
	
	List<Integer> list1= Arrays.asList(4,5,6,7);
	System.out.println("Total sum is :" + sum(list1));
	
	List<Double> list2 = Arrays.asList(2.3,6.4,9.8,7.8);
	System.out.println("Total sum is :" +sum(list2));
	
	}
	
	public static double sum(List<? extends Number> list)
	{
		double sum =0;
		for(Number i: list)
		{
			sum+=i.doubleValue();
			
		}
		return sum;
		
		
	}
}