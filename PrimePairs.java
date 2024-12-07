import java.util.*;

public class PrimePairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        if (n < 2) {
            System.out.println(-1);
            return;
        }
        
        // Sieve of Eratosthenes to find all primes up to n
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime numbers
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        // Finding two primes such that a + b = n
        for (int prime : primes) {
            int complement = n - prime;
            if (complement > 1 && isPrime[complement]) {
                System.out.println(prime + " " + complement);
                return;
            }
        }
        
        System.out.println(-1);
    }
}
