import java.lang.*;
import java.io.*;
import java.util.*;
 

public class ReverseString {
public static void main(String[] args) {
	
	String input = "Basavanagudi";
	String input2 = "JP Nagar";
	
	StringBuilder input1 = new StringBuilder();
	input1.append(input);
	
	input1 = input1.reverse();
	System.out.println(input1);
	
	char[] st = input2.toCharArray();
	for(int i=st.length-1;i>=0;i--)
	{
		System.out.println(st[i]);
	}
}
}
