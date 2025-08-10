------------------------------------------------------------

## 📝 Problem Statement  
Given a string `s`, return the first character that repeats (i.e., appears more than once) with the earliest second occurrence.  
If no character repeats, return `null`.

---

## 🔹 Approach 1: Using HashSet (Optimal)  
💡 Idea:  
- Traverse the string from left to right.  
- Keep track of characters seen so far in a HashSet.  
- As soon as a character is seen again, return it immediately.

📍 Steps:  
Step 1: Initialize empty HashSet  
Step 2: For each character in the string:  
  - If it exists in the set, return it  
  - Else, add it to the set  
Step 3: If no repeats found, return null

⏳ Complexity:  
Time: O(n)  
Space: O(min(n, charset_size))

---

## 🔹 Approach 2: Using HashMap to Track First Indices  
💡 Idea:  
- Store the first occurrence index of each character in a HashMap.  
- Traverse the string again or while iterating, track repeating characters and record second occurrence indices.  
- Find the character with the minimum second occurrence index.

📍 Steps:  
Step 1: Initialize empty HashMap<char, int> for first occurrences  
Step 2: Initialize variables to track earliest second occurrence index and character  
Step 3: Iterate over the string characters with index:  
  - If character not in map, store index  
  - Else update earliest second occurrence if current index < recorded earliest  
Step 4: Return character with earliest second occurrence or null

⏳ Complexity:  
Time: O(n)  
Space: O(n)

---

## 🔹 Approach 3: Using Array for ASCII Characters (If charset known and small)  
💡 Idea:  
- Use a fixed-size integer array (e.g., length 256) to track counts or first indices.  
- Same logic as HashMap but faster access.

⏳ Complexity:  
Time: O(n)  
Space: O(1)

---

## 📌 Example

Input: `"acbbac"`  
Output: `"b"`  
Explanation:  
- 'a' repeats at indices 0 and 4  
- 'b' repeats earlier at indices 2 and 3 → 'b' is the first recurring character

Input: `"abcdef"`  
Output: `null` (no repeats)

Input: `"abca"`  
Output: `"a"`

---

