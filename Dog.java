
public class Dog {
	String name;
	int age;
	String City;
	String Color;
	
	public Dog(String name,int age, String City, String Color) {
		this.name = name;
		this.age = age;
		this.City = City;
		this.Color = Color;
		
	}
	public String getName() {
		return name;
	}
		
	public int getAge() {
		return age;
	}
		
	public String getCity() {
		return City;
	}
		
	public String getColor() {
		return Color;
	}
	
	public String toPrint()
	{
		return("My name is"+ this.getName() + "My age" + this.getAge() + "City" + this.getCity() + "My Color" + this.getColor());
		
	}
	
	public static void main(String[] args)  {
		Dog obj = new Dog("Scooby",6,"Mysore","Black");
		
		System.out.println(obj.toPrint());

	}

}
