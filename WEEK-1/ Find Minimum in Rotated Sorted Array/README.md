Problem Statement
You are given a rotated sorted array (with no duplicate elements). Your task is to find the minimum element in the array.

Example:
Input: nums = [4,5,6,7,0,1,2]  
Output: 0

Approaches
1️⃣ Brute Force Approach
Idea: Simply scan through the entire array and keep track of the smallest element found.

Steps:
* Initialize minElement as the first element.
* Iterate through all elements.
* Update minElement whenever a smaller element is found.

COMPLEXITIES-
Time Complexity: O(n) — need to check every element.
Space Complexity: O(1) — no extra space used.

2️⃣ Better Approach (Not Very Common Here)
Idea: Since the array is rotated, the pivot point determines where the smallest element lies. We can try linear scanning until the order breaks.

Steps:
* Start from the first element.
* Move forward while the next element is greater than the current one.
* The first point where this condition breaks is the minimum element.

COMPLEXITIES-
Time Complexity: O(n) in worst case.
Space Complexity: O(1).

3️⃣ Optimal Approach — Binary Search (O(log n))
Idea: The minimum element will be the pivot point where rotation happened.

Steps:
* Initialize low = 0, high = n-1.
* If the array is already sorted (nums[low] < nums[high]), return nums[low].
* Find mid = (low + high) / 2.
* If nums[mid] >= nums[low], the minimum lies in the right half → move low = mid + 1.
* Else, it lies in the left half → move high = mid.
* Continue until low == high, which is the index of the minimum element.

COMPLEXITIES-  
Time Complexity: O(log n) — halves the search space every step.
Space Complexity: O(1) — only a few variables used.

 Complexity Summary
Approach            	Time Complexity       	Space Complexity
Brute Force	               O(n)                    	O(1)
Better Approach            O(n)                   	O(1)
Optimal	                   O(log n)               	O(1)



