import java.util.Scanner;

public class Prac3b{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        try {
            if (age < 18) {
                throw new MyException("Age must be greater than 18");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}

class MyException extends Exception {

    public MyException(String message) {
        super(message);
    }
}