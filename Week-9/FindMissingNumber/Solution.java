import java.util.*;

public class FirstMissingPositive {

    // -------------------------
    // 1️⃣ Naïve Approach (Sorting)
    // -------------------------
    public static int missingNumberSort(int[] arr) {
        Arrays.sort(arr);
        int smallest = 1;
        for (int num : arr) {
            if (num == smallest) {
                smallest++;
            }
        }
        return smallest;
    }

    // -------------------------
    // 2️⃣ Hashing Approach (Set)
    // -------------------------
    public static int missingNumberHash(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int smallest = 1;
        while (true) {
            if (!set.contains(smallest)) {
                return smallest;
            }
            smallest++;
        }
    }

    // -------------------------
    // 3️⃣ Optimal Approach (Index Placement Trick)
    // -------------------------
    public static int missingNumberOptimal(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            // place arr[i] at correct position if possible
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                int correctIndex = arr[i] - 1;
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
        }

        // check which index is incorrect
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    // -------------------------
    // MAIN
    // -------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        // Run all approaches
        System.out.println("Naive (Sorting): " + missingNumberSort(arr.clone()));
        System.out.println("Hashing (Set): " + missingNumberHash(arr.clone()));
        System.out.println("Optimal (Index Placement): " + missingNumberOptimal(arr.clone()));
    }
}
