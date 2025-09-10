# Autocomplete System

**Company:** Twitter  
**Difficulty:** Medium  
**Topic:** Strings, Trie, Hashing  

---

## Problem Statement
Implement an autocomplete system that, given a query prefix and a set of possible strings, returns all the words that begin with that prefix.  

This mimics real-world autocomplete features in applications like Twitter, Google, and code editors.  

---

## Input Format
- First line: Integer `N`, the number of words in the dictionary.  
- Second line: `N` space-separated strings (the dictionary).  
- Third line: A string `s` (the query prefix).  

## Output Format
- Print all words from the dictionary that start with the prefix `s`.  

---

## Constraints
- 1 ≤ N ≤ 10^5  
- Each word length ≤ 50  
- Query string length ≤ 50  

---

---

## Approaches

### 1. Brute Force Search
**Idea:**  
Check every word in the dictionary to see if it starts with the prefix.  

**Steps:**  
1. Iterate through all words.  
2. For each word, compare the first characters with the prefix.  
3. If it matches, add it to the result list.  

**Complexity:**  
- Time: O(N * L), where `N` is the number of words and `L` is the length of the prefix.  
- Space: O(1).  
- Simple to implement but inefficient when `N` is large.  

---

### 2. Trie (Prefix Tree) Approach – Efficient
**Idea:**  
Preprocess the dictionary into a Trie data structure for fast prefix lookups.  

**Steps:**  
1. Insert all words into a Trie. Each node represents a character.  
2. Traverse the Trie using the prefix `s`.  
3. From the node where the prefix ends, perform a DFS or BFS to collect all words with that prefix.  

**Complexity:**  
- Time: O(L + K), where `L` is the length of the prefix and `K` is the number of results collected.  
- Space: O(N * W), where `W` is the average word length (for storing the Trie).  
- Much more efficient for repeated queries on the same dictionary.  

---

## Final Recommendation
- Use **Brute Force** if the dictionary is very small or queries are rare.  
- Use a **Trie** if the dictionary is large and multiple autocomplete queries are expected.  

---


