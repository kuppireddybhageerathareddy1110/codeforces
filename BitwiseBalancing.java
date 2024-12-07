import java.util.Scanner;
import java.util.NoSuchElementException;

public class Main {
    public static long pow(long x, long y, long m) {
        long ans = 1;
        x %= m;
        while (y > 0) {
            if ((y & 1) == 1) {
                ans = (ans * x) % m;
            }
            x = (x * x) % m;
            y >>= 1;
        }
        return ans;
    }

    public static void solve(Scanner sc) {
        try {
            long b = sc.nextLong();
            long c = sc.nextLong();
            long d = sc.nextLong();
            long a = 0;

            for (int i = 0; i < 61; ++i) {
                long bi = (b >> i) & 1;
                long ci = (c >> i) & 1;
                long di = (d >> i) & 1;

                if (di == 1) {
                    if (bi == 0 && ci == 1) {
                        System.out.println(-1);
                        return;
                    }
                    if ((bi == 0 && ci == 0) || (bi == 1 && ci == 0)) {
                        a |= (1L << i);
                    }
                } else {
                    if (bi == 1 && ci == 0) {
                        System.out.println(-1);
                        return;
                    }
                    if ((bi == 1 && ci == 1) || (bi == 0 && ci == 1)) {
                        a |= (1L << i);
                    }
                }
            }
            System.out.println(a);
        } catch (NoSuchElementException e) {
            System.out.println("Input is missing or incorrect");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int TCS = sc.nextInt();
            for (int TC = 1; TC <= TCS; ++TC) {
                solve(sc);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Input is missing or incorrect");
        }
    }
}
