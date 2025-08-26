# Prime Numbers with Multiple Occurrences

## Problem Overview

Given an integer array A containing N elements, identify all **prime numbers** that appear **more than once** in the array and collect them in an output array **B**. The output must preserve the **first appearance order** of those primes in A. If no such primes exist, output `-1`.


## Input / Output

**Input**

* First line: integer `N` — size of array A.
* Second line: `N` space-separated integers — the elements of A.

**Output**

* Print space-separated primes that occur more than once in A following their first occurrence order.
* If none, print `-1`.

---

## Constraints

* `1 ≤ N ≤ 10^5`
* `-10^6 ≤ A[i] ≤ 10^6`
* Only numbers `> 1` are considered for primality.

---

## Approaches (explained) ⚙️

### Approach 1 — Brute force (naive)

**Idea**: For each element `x` in the array, check whether `x` is prime; if yes, scan the array counting occurrences of `x`. If count > 1, add to output (avoid duplicates in output).

**Time complexity**: O(N \* (N + sqrt(M))) in worst-case (where M is magnitude of numbers) — very slow for `N = 10^5`.

**Space complexity**: O(1) (extra) excluding output.

**When to use**: Only for tiny inputs; not suitable for constraints here.

---

### Approach 2 — HashMap + primality test per distinct value

**Idea**:

1. Traverse A once and build a frequency map `freq` (`HashMap<Integer,Integer>`).
2. Maintain a list of numbers in the order they first appear (e.g., `LinkedHashMap` or a `List` of keys while inserting into a normal `HashMap`).
3. For each key `k` in insertion order: if `k > 1` and `freq[k] > 1` and `isPrime(k)` → add to output.

**Primality testing**: use `isPrime(k)` by checking divisibility up to `sqrt(k)` — O(√k). For many distinct keys (up to `10^5`), total cost could be `O(U * sqrt(M))` where `U` is unique keys. With `M = 10^6`, sqrt(M) \~ 1000 so worst-case \~10^8 operations — borderline but might pass in optimized Java with fast I/O.

**Time complexity**: O(N) to build freq + O(U \* sqrt(M)) for primality checks.

**Space complexity**: O(U) for freq map.

**Pros**: Simple, uses only numbers that actually appear.
**Cons**: Can be slow if many unique numbers.

---

### Approach 3 — Sieve of Eratosthenes + frequency counting (recommended) ✅

**Idea**:

1. Precompute primality for all integers from `0` to `MAX = 10^6` using the Sieve of Eratosthenes. This gives O(MAX log log MAX) precomputation.
2. Traverse the input once and record frequency using a `LinkedHashMap<Integer,Integer>` (preserves insertion order), or a `HashMap` plus a `List` recording first-occurrence order.
3. Iterate keys in insertion order; for each key `k`:

   * if `k > 1` and `freq[k] > 1` and `isPrimeSieve[k]` → add `k` to output.
4. If output empty → print `-1`.

**Time complexity**: O(MAX log log MAX) + O(N) ≈ O(10^6) + O(N) which is fast for given constraints.

**Space complexity**: O(MAX) for sieve + O(U) for freq map. Using a boolean array of size `MAX+1` requires \~1 MB (since boolean\[] representation often uses one byte per entry; adjust for JVM specifics). An `int[]` frequency array of size `MAX+1` costs \~4MB — both acceptable within typical online-judge limits.

**Pros**: Fast and predictable; ideal for the input bounds.
**Cons**: Slight memory overhead due to sieve, but negligible for `MAX = 10^6`.

---

## Recommended algorithm (detailed steps)

1. Read `N` and the `N` integers of array `A`.
2. Prepare a boolean array `isPrime` with size `MAX + 1` where `MAX = 1_000_000`. Fill it using the Sieve of Eratosthenes.
3. Create a `LinkedHashMap<Integer, Integer> freq` to store counts while preserving first insertion order. For each number `x` in `A`:

   * increment `freq[x]` (use `getOrDefault(x,0)+1`).
4. Initialize an empty list `result`.
5. Iterate through `freq.entrySet()` in insertion order; for each `key=k`:

   * if `k > 1` and `freq.get(k) > 1` and `k <= MAX` and `isPrime[k]` then `result.add(k)`.
6. If `result` is empty -> print `-1`.
   Else print elements of `result` separated by spaces.





## Complexity Summary

* Time: `O(MAX log log MAX + N)` using sieve approach (recommended).
* Space: `O(MAX + U)` where `U` is number of unique values in input.

---

If you want, I can now:

* provide the **Java implementation** using the recommended approach, or
* create the `Solution.java` file and a sample test input file in your repo structure.

Choose an option or tell me to proceed and I will generate the code and files. 🚀
