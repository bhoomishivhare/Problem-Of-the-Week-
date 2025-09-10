# Swap Even and Odd Bits

**Company:** Cisco  
**Difficulty:** Medium  
**Topic:** Bit Manipulation  

---

## Problem Statement
You are given an unsigned 8-bit integer. The task is to swap every even-positioned bit with the adjacent odd-positioned bit.  

- Bits are counted from the right, starting at position 1.  
- Example transformations:  
  - `10101010 → 01010101`  
  - `11100010 → 11010001`  

### Input Format
- A single integer `n` (0 ≤ n ≤ 255).  

### Output Format
- An integer after swapping even and odd bits.  

---


**Explanation**  
- Binary of 226 = `11100010`.  
- After swapping even and odd bits → `11010001`.  
- Decimal value = 209.  

---

## Approaches

### 1. Brute Force Bit-by-Bit Swap
**Idea:**  
- Iterate over all 8 bits of the number.  
- For each pair of bits `(i, i+1)`, swap their values using bitwise operations.  

**Steps:**  
1. Loop through positions `1, 3, 5, 7`.  
2. Extract the bit at position `i` and the bit at `i+1`.  
3. Swap them by clearing original bits and setting them in opposite places.  

**Complexity:**  
- Time: O(8) = constant (since it’s always 8 bits).  
- Space: O(1).  
- Simple but requires explicit looping.

---

### 2. Efficient Bitmasking Approach
**Idea:**  
- Use bit masks to extract even and odd bits directly.  
- Perform bit shifts to swap them.  

**Masks Used:**  
- `0xAA` = `10101010` → extracts even-positioned bits.  
- `0x55` = `01010101` → extracts odd-positioned bits.  


**Explanation:**  
1. `(n & 0xAA)` keeps only even-positioned bits.  
2. `(n & 0x55)` keeps only odd-positioned bits.  
3. Shift even bits right by 1, odd bits left by 1.  
4. Combine with bitwise OR.  

**Complexity:**  
- Time: O(1).  
- Space: O(1).  
- This is the most elegant one-line solution.  

---

## Final Recommendation
- Brute force works but is less elegant.  
- The bitmasking formula is optimal and concise, making it the best solution for production use.  

---




