
public class StringToInteger {
	public static void main(String args[])
    {
        int decimalExample = Integer.parseInt("20");
        int signedPositiveExample = Integer.parseInt("+20");
        int signedNegativeExample = Integer.parseInt("-20");
        int radixExample = Integer.parseInt("20",16);
        int stringExample = Integer.parseInt("geeks",29);
 
        System.out.println(decimalExample);
        System.out.println(signedPositiveExample);
        System.out.println(signedNegativeExample);
        System.out.println(radixExample);
        System.out.println(stringExample);
        
        int decimal = Integer.valueOf("30");
        int signedPositive = Integer.valueOf("+30");
        int signedNegative = Integer.valueOf("-30");
        int radix = Integer.valueOf("30",10);
        int string = Integer.valueOf("abc",25);
 
        System.out.println(decimal);
        System.out.println(signedPositive);
        System.out.println(signedNegative);
        System.out.println(radix);
        System.out.println(string);
    }
    }


