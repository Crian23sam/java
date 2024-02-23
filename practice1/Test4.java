class Maths
{
	public void Maths(int a, int b)
	{
		return a+b;
	}

	public void Maths(int a,int b)
	{
		return a-b;
	}
	
	public void Maths(int a,int b)
	{
		return a*b;
	}
	
	public void Maths(int a,int b)
	{
		return a/b;
	}
	
}


class Test4
{
	public static void main(String args[])
	{
		Maths obj=new Maths();
		System.out.println(obj.Maths(10,20));
	}
}