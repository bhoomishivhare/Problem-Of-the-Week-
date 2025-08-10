public class SearchWithoutMulDivShift {

    // ---------------------------------------------------
    // Helper: Integer division by 2 using repeated subtraction
    // (No division, multiplication, or bit-shift)
    // ---------------------------------------------------
    // private static int divideByTwo(int num) {
    //     // Handle negative numbers properly
    //     boolean negative = num < 0;
    //     if (negative) num = -num;

    //     int count = 0;
    //     int sum = 0;
    //     while (sum + 2 <= num) {
    //         sum += 2;
    //         count++;
    //     }
    //     return negative ? -count : count;
    // }

    // ---------------------------------------------------
    // Approach 1: Binary Search using divideByTwo to find mid
    // ---------------------------------------------------
    // public static boolean binarySearchApproach1(int[] arr, int x) {
    //     int low = 0;
    //     int high = arr.length - 1;

    //     while (low <= high) {
    //         int mid = low + divideByTwo(high - low);
    //         if (arr[mid] == x) {
    //             return true;
    //         } else if (arr[mid] < x) {
    //             low = mid + 1;
    //         } else {
    //             high = mid - 1;
    //         }
    //     }

    //     return false;
    // }

    // ---------------------------------------------------
    // Approach 3: Binary Search with division by 2 emulation
    // Slightly different implementation of divideByTwo
    // ---------------------------------------------------
    private static int divideByTwoAlt(int num) {
        // Alternative repeated subtraction
        if (num < 0) num = -num;

        int result = 0;
        int temp = 0;
        while (temp + 2 <= num) {
            temp += 2;
            result++;
        }
        return result;
    }

    public static boolean binarySearchApproach3(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + divideByTwoAlt(high - low);
            if (arr[mid] == x) {
                return true;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
