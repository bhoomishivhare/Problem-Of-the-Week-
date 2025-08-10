------------------------------------------------------------
 Word Search in 2D Matrix (Easy)

 📝 Problem Statement  
Given a 2D matrix of uppercase English letters and a target word, determine if the word exists either:  
- Horizontally left-to-right in any row  
- Vertically top-to-bottom in any column

Return `true` if found, otherwise `false`.

---

## 🔹 Approach 1: Direct String Matching  
💡 Idea:  
- For each row, convert the row to a string and check if the target word is a substring.  
- For each column, convert the column to a string and check if the target word is a substring.

📍 Steps:  
Step 1: Iterate through each row: build a string and check substring  
Step 2: Iterate through each column: build a string and check substring  
Step 3: Return true if found in any row or column, else false

⏳ Complexity:  
Time: O(M*N*L) where L is length of the word (usually ≤ max(M, N))  
Space: O(max(M, N)) for string building

---

## 🔹 Approach 2: Direct Character-by-Character Check  
💡 Idea:  
- Instead of converting rows and columns to strings, check character-by-character for the target word in each row and column.  
- Early break if mismatch found.

📍 Steps:  
Step 1: For each row and each possible start index, check characters against the target word  
Step 2: For each column and each possible start index, check characters against the target word  
Step 3: Return true if match found, else false

⏳ Complexity:  
Time: O(M*N*L)  
Space: O(1)

---

## 🔹 Approach 3: Using Trie (If multiple queries expected)  
💡 Idea:  
- Build a trie for all rows and columns strings.  
- Query the trie for the target word.  
- Useful if many words need to be searched repeatedly.

⏳ Complexity:  
Preprocessing: O(M*N)  
Query: O(L)

---

