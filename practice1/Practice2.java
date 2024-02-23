import java.util.Scanner

class Practice2
{
public static void main()
{
byte b1;
short s1;

Scanner scin=new Scanner(System.in)
System.out.println("Byte value for b1 range 0-255");
b1 = scin.nextByte();
sh1 = scin.nextShort();
b1++;
sh1--;

b1=b1+sh1;
sh1=b1-sh1;
b1=b1-sh1;

System.out.println("b1="+b1);
System.out.println("sh1="+sh1);
}
}