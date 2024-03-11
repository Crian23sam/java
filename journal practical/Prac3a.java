public class Prac3a{
    public static void main(String[] args) {
        try {
            // Example 1: ArrayIndexOutOfBoundsException
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // Trying to access an index out of bounds

            // Example 2: NullPointerException
            String str = null;
            System.out.println(str.length()); // Trying to access a method on a null object

            // Example 3: ArithmeticException
            int result = 10 / 0; // Division by zero
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }
    }
}
