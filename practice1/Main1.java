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
}

class FirstYear extends Student
{
	public FirstYear(String name)
	{
		super(name,1);
	}
	public String toString()
	{
		return "First Year"+ super.toString();
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
		return "SecondYear"+super.toString();
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
		return "ThirdYear"+super.toString();
	}
}
class Main1
{
	public static void main(String[] args)
	FirstYear fyStudent=new FirstYear("John");
}