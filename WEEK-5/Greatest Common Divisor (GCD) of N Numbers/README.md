 
📝 Problem Statement
You are given n integers.
Your task is to find the Greatest Common Divisor (GCD) — the largest integer that divides all numbers in the array without leaving a remainder.

🔹 Approach 1: Naive Factorization
💡 Idea:

Find all factors of the smallest number in the list.

Check from largest factor to smallest to see which divides all numbers.

📍 Steps:

Identify the smallest number in the array (potential GCD can’t be larger than this).

Find all factors of this smallest number.

For each factor (starting from largest), check if it divides all numbers.

The first factor that divides all numbers is the GCD.

⏳ Complexity:

Time: O(min(arr) × n) in worst case

Space: O(1)

⚠️ Not efficient for large numbers — suitable only for small constraints.
-------------------------------------
🔹 Approach 2: Iterative Euclidean Algorithm
💡 Idea:

GCD of multiple numbers can be computed as:

matlab
Copy
Edit
gcd(a1, a2, a3, ... an) = gcd(...gcd(gcd(a1, a2), a3)..., an)
Use the Euclidean Algorithm:

matlab
Copy
Edit
gcd(a, b) = gcd(b, a % b)
📍 Steps:

Initialize result = arr[0]

Loop through array:

result = gcd(result, arr[i])

Return result

⏳ Complexity:

Time: O(n × log M) (M = max element)

Space: O(1)


----------------------------------------------------
🔹 Approach 3: Recursive Euclidean Algorithm
💡 Idea:

Same as iterative, but use recursion for gcd(a, b).

📍 Steps:

matlab
Copy
Edit
gcd(a, b):  
    if b == 0 → return a  
    else return gcd(b, a % b)  
Apply recursively to all elements in the array.

⏳ Complexity:

Time: O(n × log M)

Space: O(log M) (recursion stack)

✅ Recommendation: Use Approach 2 (Iterative Euclidean Algorithm) for large datasets.
⚡ Handles up to 10^5 numbers and values up to 10^9 efficiently
