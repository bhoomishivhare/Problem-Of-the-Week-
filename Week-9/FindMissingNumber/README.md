# First Missing Positive Integer  

## Problem Statement
Given an unsorted array of integers `arr[]`, return the smallest positive integer that is missing.  

- The array may contain duplicates and negative numbers.  
- You may modify the input array in-place.  
- Goal: O(n) time and O(1) extra space.  


---

## Approaches

### 1. Naïve Approach – Sorting
**Idea:**  
- Sort the array.  
- Start from 1 and check sequentially which positive number is missing.  

**Steps:**  
1. Sort the array in ascending order.  
2. Keep a variable `smallest = 1`.  
3. Traverse the array:  
   - If you see `smallest`, increment it.  
4. At the end, `smallest` is the missing integer.  

**Complexity:**  
- Time: O(n log n) because of sorting.  
- Space: O(1) (if we allow in-place sorting).  
- Not optimal, since we need O(n) time.

---

### 2. Hashing Approach – Using a Set
**Idea:**  
- Store all numbers in a HashSet.  
- Then check from 1 to n+1 which number is missing.  

**Steps:**  
1. Insert all elements into a HashSet.  
2. Start with `smallest = 1`.  
3. Check sequentially:  
   - If `smallest` is not in the set, return it.  
   - Otherwise, increment and continue.  

**Complexity:**  
- Time: O(n)  
- Space: O(n) (extra memory for the set).  
- Fails the constant space requirement.

---

### 3. Optimal Approach – Index Placement Trick
**Idea:**  
- The key observation is: if the array length is `n`, the missing number must be in the range `[1, n+1]`.  
- Place each number `x` in its correct index `x-1` (only if 1 ≤ x ≤ n).  
- After rearranging, scan through the array.  
  - If `arr[i] != i+1`, then `i+1` is the missing number.  
  - If all positions are correct, the answer is `n+1`.  

**Steps:**  
1. Traverse the array.  
   - While `arr[i]` is in the range `[1, n]` and not already in its correct position, swap it with the element at index `arr[i] - 1`.  
2. After this rearrangement, the array will be "almost sorted" with respect to positive integers.  
3. Traverse again:  
   - For the first index `i` where `arr[i] != i+1`, return `i+1`.  
4. If all positions are correct, return `n+1`.  

**Complexity:**  
- Time: O(n) (each element is swapped at most once).  
- Space: O(1) (constant extra space).  
- This is the required solution.

---

## Final Recommendation
- Sorting or HashSet approaches are simpler but not optimal.  
- The **Index Placement Trick** is the best solution since it meets both O(n) time and O(1) space requirements.  

---



