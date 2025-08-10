------------------------------------------------------------
#  Smallest Non-Representable Sum

 📝 Problem Statement  
You have a sorted array of positive integers representing coin denominations.  
Find the smallest positive integer that cannot be formed by any subset sum of these coins.

------------------------------------------------------------
## 🔹 Approach 1: Brute Force (Not Practical)  
💡 Idea: Generate all subset sums and find the smallest missing positive integer.  
📍 Steps:  
- Generate all sums (exponential time)  
- Check missing integer starting from 1  
⏳ Time Complexity: O(2^n)  
⚠️ Not feasible for large n.

------------------------------------------------------------
## 🔹 Approach 2: Greedy Linear-Time Algorithm (Optimal) ✅  
💡 Idea:  
Keep track of smallest non-representable sum (`res`), initially 1.  
For each coin:  
- If coin ≤ res, update res = res + coin  
- Else break and return res  

📍 Steps:  
1. Initialize res = 1  
2. For each coin in array:  
 - If coin ≤ res: res += coin  
 - Else break  
3. Return res  

⏳ Time Complexity: O(n)  
📦 Space Complexity: O(1)

------------------------------------------------------------
## 📌 Example  
Input: 1 2 3 10  
Output: 7  

📝 Explanation:  
You can make sums up to 6, but not 7.

------------------------------------------------------------
