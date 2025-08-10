------------------------------------------------------------
# Search in a Sorted List Without Multiplication, Division, or Bit-Shifts

## 📝 Problem Statement  
Given a sorted list of integers `arr` and a target value `x`, determine if `x` exists in the list in **O(log N)** time.  
**Constraints:** No multiplication (*), division (/), or bit-shift (<<, >>) operations allowed.

---

## 🔹 Approach 1: Binary Search with Repeated Addition/Subtraction for Mid Calculation  
💡 Idea:  
- Perform binary search in the usual way.  
- To compute the midpoint `mid = low + (high - low) / 2`, replace division with a custom integer division function using repeated subtraction.

📍 Steps:  
Step 1: Implement integer division function `divideByTwo(int num)` using subtraction.  
Step 2: Use it to compute `mid = low + divideByTwo(high - low)`  
Step 3: Perform standard binary search comparison with `arr[mid]`  
Step 4: Return true if found, else false

⏳ Complexity:  
Time: O(log N * D) where D is cost of division (linear in worst case)  
Space: O(1)

---

## 🔹 Approach 2: Binary Search Using Exponential Search for Mid Approximation  
💡 Idea:  
- Instead of calculating exact mid, use exponential search to find a midpoint approximately halfway between `low` and `high`.  
- Use repeated addition to move towards the middle index.

📍 Steps:  
Step 1: Use two pointers or counters to approximate mid by incrementing from `low` to `high`  
Step 2: Use this approximate mid to do the usual binary search steps  
Step 3: Adjust boundaries based on comparison  
Step 4: Continue until search space narrows

⏳ Complexity:  
Time: O(log N) with some overhead from approximation  
Space: O(1)

---

## 🔹 Approach 3: Binary Search Using Bitwise Arithmetic Emulation  
💡 Idea:  
- Emulate division by 2 using arithmetic operations without direct division, multiplication, or bit-shift.  
- For example, use right-shift by 1 implemented as `num / 2` using repeated subtraction internally.

📍 Steps:  
Step 1: Create helper function to perform integer division by 2 (or other needed ops) without forbidden operations.  
Step 2: Use this function to compute mid inside binary search.  
Step 3: Continue binary search normally.

⏳ Complexity:  
Time: O(log N * D) where D is the cost of division emulation  
Space: O(1)

---


