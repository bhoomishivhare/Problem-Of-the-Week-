import java.util.*;

public class Solution {

    // Function to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // Use LinkedHashMap to maintain insertion order
        LinkedHashMap<Integer, Integer> freqMap = new LinkedHashMap<>();

        for (int num : A) {
            if (isPrime(num)) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int num : result) {
                System.out.print(num + " ");
            }
        }

        sc.close();
    }
}
