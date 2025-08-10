------------------------------------------------------------
-> Step Words Finder

## 📝 Problem Statement  
Given an input word **W** and a dictionary of valid words, find all "step words" that can be formed by:  
- Adding exactly one letter to **W**  
- Then anagramming the result to form a dictionary word

Print all such step words in lexicographical order.

----------------------------------------------------------------------------

## 🔹 Approach: Frequency Counting  
💡 **Idea:**  
- Count character frequencies of input word **W**.  
- For each dictionary word:  
 - Skip if length != |W| + 1  
 - Count frequencies of the dictionary word  
 - Check if it can be formed by adding exactly one letter to **W** (frequency difference check)

📍 **Steps:**  
Step 1: Compute frequency map of **W**.  
Step 2: For each word in dictionary:  
 - If length != |W| + 1, continue  
 - Compute frequency map of candidate word  
 - Calculate difference in counts for all characters  
 - The word is valid if exactly one character count differs by +1 and rest are equal  

⏳ **Complexity:**  
Time: O(N * K) where N = dictionary size, K = average word length  
Space: O(K) for frequency arrays

---
