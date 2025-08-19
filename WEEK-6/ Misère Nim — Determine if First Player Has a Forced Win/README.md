#  Misère Nim — Determine if First Player Has a Forced Win

## 📖 Problem Description

The game of **Nim** is played on several heaps of stones. Two players alternate turns. On a turn, a player removes one or more stones from exactly one heap. In this variant (**misère Nim**), the player who takes the **last stone loses**. ❌🪨

Given three non-zero starting heap sizes `[a, b, c]`, decide whether the first player (the player who moves first) has a forced win assuming both players play optimally. 🤔

---

## ⌨️ Input Format

* A list/array of three positive integers: `[a, b, c]` (each > 0).

## 🖥️ Output Format

* Return **True ✅** if the first player has a forced win, otherwise **False ❌**.

---

## 🔍 Examples

**Example 1:**

```
Input: [3, 4, 5]
Output: True ✅
Explanation: Under optimal play, first player can force a win.
```

**Example 2:**

```
Input: [1, 1, 1]
Output: False ❌
Explanation: With three heaps of 1, first player loses under misère rules.
```

**Example 3:**

```
Input: [1, 1, 2]
Output: True ✅
```

---

## 💡 Key Observation (Theory — Misère Nim)

For **misère Nim** the optimal-play rule is:

1. 🪙 **If all heaps have size 1**:

   * First player wins **iff the number of heaps is even ➡️ ✅**.
   * If number of heaps is odd ➡️ ❌ first player loses.

2. 🪙 **Otherwise (some heap ≥ 2 exists)**:

   * Game is equivalent to **normal Nim**.
   * Compute XOR (nim-sum) of heap sizes ⊕.
   * If `nim-sum != 0` → first player has a winning strategy 🎯.
   * If `nim-sum == 0` → first player loses ⚠️.

---

## 🛠️ Algorithm

1. Let `a, b, c` be the heap sizes.
2. If **all heaps = 1**:

   * Return ✅ True if number of heaps is even, else ❌ False.
3. Otherwise:

   * Compute `xor = a ^ b ^ c`.
   * If `xor != 0` → return ✅ True.
   * Else → return ❌ False.

---

## ⏱️ Complexity Analysis

* **Time Complexity**: `O(1)` ⚡ (for three heaps, or `O(n)` for n heaps).
* **Space Complexity**: `O(1)` 📦.

---


