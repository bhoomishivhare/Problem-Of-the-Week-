Problem Overview 💡

You are asked to implement a curried function add_subtract that alternately adds and subtracts the numbers passed to it.

The first number is always added.

The second number is subtracted.

The third number is added.

The fourth number is subtracted, and so on.

-----
Input Format 📝

A sequence of integers passed as curried arguments.

Each number can be positive or negative.

Output Format 🖨️

Return the final computed integer after applying alternating addition and subtraction.

Constraints ⚠️

At least one number will always be provided.

The function can handle up to 10^5 chained arguments without performance issues.

Approaches / Solution Ideas 🛠️
1️⃣ Recursive Approach

Treat the curried function as a chain of functions where each function accepts one integer.

Maintain a running total and a flag to indicate addition or subtraction.

Each successive call updates the total and flips the flag.

Steps:

Start with the first number → add to total.

Flip the operation for the next number → subtract.

Repeat recursively for the next numbers until no more numbers are provided.

Return the final result.

Pros: Clean, natural for curried functions.
Cons: Deep recursion may need tail-call optimization in some languages.

2️⃣ Iterative / State-based Approach

Maintain a running total.

Maintain a Boolean flag addNext that alternates after each number.

Each function call adds or subtracts based on the flag.

Return a new function that continues the chain until the user decides to get the result.

Pros: Handles large numbers of chained calls efficiently.
Cons: Slightly more boilerplate in languages like Java.

3️⃣ Closure / Lambda Approach (JavaScript / Python style)

Use closures to maintain state across chained calls.

The closure keeps track of total and next operation.

Each call updates the total and returns itself until the chain ends.

--------
Key Insights 🔑

Alternating operations → maintain a simple flag.

Curried function → each function call returns another function unless the chain ends.

Can be implemented efficiently with O(n) time complexity
