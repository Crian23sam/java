class Construct{
	private int value;

	public Construct() 
	{
		this.value = 0;
	}

  
	public Construct(int initial_value) 
	{
		this.value = initial_value;
	}

	public Construct(Construct otherInstance) 
	{
		this.value = otherInstance.value;
	}

  
    public int getValue()
	{
		return this.value;
	}

	public static void main(String[] args)
	{

		Construct objDefault = new Construct();

    
	        Construct objOverloaded = new Construct(42);

     
	        Construct objCopy = new Construct(objOverloaded);

     
	        System.out.println("Default Constructor Value: " + objDefault.getValue());
	        System.out.println("Overloaded Constructor Value: " + objOverloaded.getValue());
	        System.out.println("Copy Constructor Value: " + objCopy.getValue());
 	}
}