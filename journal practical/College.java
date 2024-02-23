class Student
{
	private String name;
	private int year;
	public Student(String name,int year)
	{
		this.name=name;
		this.year=year;
	}
	public String getName()
	{
		return name;
	}
	public int getYear()
	{
		return year;
	}
	public String toString()
	{
		return ": "+getName() +", Year: "+getYear();
	}
}

class FirstYear extends Student
{
	public FirstYear(String name)
	{
		super(name,1);
	}
	public String toString()
	{
		return "First Year:"+ super.toString();
	}
}

class SecondYear extends Student
{
	public SecondYear(String name)
	{
		super(name,2);
	}
	public String toString()
	{
		return "SecondYear:"+super.toString();
	}
}

class ThirdYear extends Student
{
	public ThirdYear(String name)
	{
		super(name,3);
	}
	public String toString()
	{
		return "ThirdYear:"+super.toString();
	}
}
class College
{
	public static void main(String[] args)
	{
		FirstYear fyStudent=new FirstYear("Rupesh");
		SecondYear syStudent=new SecondYear("Janga");
		ThirdYear tyStudent=new ThirdYear("Taklu");

		System.out.println(fyStudent);
		System.out.println(syStudent);
		System.out.println(tyStudent);
	}
}