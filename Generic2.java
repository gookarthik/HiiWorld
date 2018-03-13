
public class Generic2 {
	static <T> void genericDisplay(T element)
	{
		System.out.println(element.getClass().getName()+"="+element);
	}
	public static void main(String[] args) 
	{
		genericDisplay(16);
		genericDisplay("Karthik");
		genericDisplay(1.5);
		
	}

}
