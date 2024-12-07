import java.util.Scanner;

public class MagicNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.next();  // Read the number as a string
        
        // Regular expression to check if the number is a valid magic number
        if (number.matches("(1|14|144)+")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
