import java.util.Scanner;

class New
{
public static void main(String[] args)
{

byte b1;
short sh1;

Scanner scin=new Scanner(System.in);
System.out.println("Byte value:");
b1 = scin.nextByte();
System.out.println("Short value:");
sh1 = scin.nextShort();
b1++;
sh1--;
System.out.println("Before Swapping");
System.out.println("b1="+b1);
System.out.println("sh1="+sh1);

/*
b1=b1+sh1;
sh1=b1-sh1;
b1=b1-sh1;*/

sh1=(short) (sh1 + b1);
b1=(byte) (sh1 - b1);
sh1=(short) (sh1 - b1);

System.out.println("After Swapping");
System.out.println("b1="+b1);
System.out.println("sh1="+sh1);


}
}