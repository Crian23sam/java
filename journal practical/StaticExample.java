public class StaticExample {
    
 
    public static int add(int a, int b) {
        return a + b;
    }


    public static int multiply(int a, int b) {
        return a * b;
    }


    public static String concatenateStrings(String str1, String str2) {
        return str1 + str2;
    }

    public static void main(String[] args) {
        
        int sumResult = StaticExample.add(5, 3);

        int multiplyResult = StaticExample.multiply(4, 6);

        String concatenatedString = StaticExample.concatenateStrings("Welcome", "User");

        System.out.println("Sum Result: " + sumResult);

        System.out.println("Multiply Result: " + multiplyResult);

        System.out.println("Concatenated String: " + concatenatedString);
    }
}