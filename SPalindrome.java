import java.util.Scanner;

public class Main {

    public static char wow(char s) {
        if (s == 'A' || s == 'b' || s == 'd' || s == 'H' || s == 'I' || s == 'M' || s == 'O' || s == 'o' ||
            s == 'p' || s == 'q' || s == 'Y' || s == 'T' || s == 'U' || s == 'V' || s == 'v' || s == 'W' || 
            s == 'w' || s == 'X' || s == 'x') {
            return '1';
        } else {
            return '0';
        }
    }

    public static char wow2(char s) {
        if (s == 'A' || s == 'H' || s == 'I' || s == 'M' || s == 'O' || s == 'o' || s == 'Y' || s == 'T' ||
            s == 'U' || s == 'V' || s == 'v' || s == 'W' || s == 'w' || s == 'X' || s == 'x') {
            return '1';
        } else {
            return '0';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();  // Input the string
        int n = st.length();    // Length of the string

        if (n == 1) {
            if (wow2(st.charAt(0)) - 48 == 1) {
                System.out.println("TAK");
            } else {
                System.out.println("NIE");
            }
            return;
        }

        int m = n / 2 - 1;
        int x = 0;

        // Check the middle character if length is odd
        if (n % 2 == 1) {
            x = m + 1;
            if (wow2(st.charAt(x)) - 48 != 1) {
                System.out.println("NIE");
                return;
            }
        }

        StringBuilder st2 = new StringBuilder();
        StringBuilder st3 = new StringBuilder();

        // Process the first half of the string
        for (int i = 0; i <= m; i++) {
            if (wow(st.charAt(i)) - 48 == 1) {
                char c = st.charAt(i);
                if (c == 'p') c = 'q';
                else if (c == 'q') c = 'p';
                else if (c == 'b') c = 'd';
                else if (c == 'd') c = 'b';
                st2.append(c);
            } else {
                System.out.println("NIE");
                return;
            }
        }

        int a = m + 1;
        if (n % 2 == 1) a = m + 2;

        // Reverse the second half of the string
        for (int i = n - 1; i >= a; i--) {
            st3.append(st.charAt(i));
        }

        // Compare the transformed first half with the reversed second half
        if (st2.toString().equals(st3.toString())) {
            System.out.println("TAK");
        } else {
            System.out.println("NIE");
        }
    }
}
