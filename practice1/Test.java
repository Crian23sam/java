class Base
{
	public int calc(int x,int y)
	{
		System.out.println("Base");
		return(x+y);
	}
}

class Derived extends Base
{
	public int calc(int x,int y)
	{
		//super.calc(x,y);
		System.out.println("Derived");
		return(x-y);
	}
}

/*class Derived1 extends Derived
{
	private int result;
	public static int calcResult()
	{
		result=x*y;
		return(result);
	}

	public void setXY(int x,int y)
	{
	//super.setX(x);
	super.x=x;
	super.y=y;
	//super.setY(y);
	}
}*/


class Test
{
		public static void main(String args[])
		{
			Derived dobj1=new Base();
			int result=dobj1.calc(10,20);
			System.out.println(result);
			
		}
}

