APPROACH 1- BRUTE FORCE
public class MinimumInSortedArray {
  
    public static int findMinimum(int[] nums) {
        // Step 1: Assume first element is minimum
        int minElement = nums[0];

        // Step 2: Traverse the array
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < minElement) {
                minElement = nums[i]; // Update if smaller found
            }
        }

        // Step 3: Return the smallest element
        return minElement;
    }
}

APPROACH-2-OPTIMAL APPROACH
public class MinimumInSortedArrayOptimal {

    public static int findMinimumBinary(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int minValue = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // If left half is sorted
            if (nums[start] <= nums[mid]) {
                minValue = Math.min(minValue, nums[start]);
                start = mid + 1;
            } 
            // If right half is sorted
            else {
                minValue = Math.min(minValue, nums[mid]);
                end = mid - 1;
            }
        }

        return minValue;
    }
}
