------------------------------------------------------------
 Count Unival Subtrees-

## 📝 Problem Statement  
Given the root of a binary tree, count the number of unival (universal value) subtrees present in it.  
A unival subtree is defined as a subtree where all nodes have the same value.  
A single node is considered a unival subtree.

---

## 🔹 Approach 1: Post-order Traversal (Recursive)  
💡 Idea:  
- Recursively traverse the tree in post-order (left, right, root).  
- For each node, check if left and right subtrees are unival.  
- Current subtree is unival if left and right subtrees are unival and node’s value equals children’s values (if present).  
- Maintain a global count of unival subtrees.

📍 Steps:  
Step 1: Recursively check left subtree for unival and count  
Step 2: Recursively check right subtree for unival and count  
Step 3: Check if current node forms a unival subtree based on conditions  
Step 4: Increment count if yes  
Step 5: Return if current subtree is unival to parent call

⏳ Complexity:  
Time: O(n) — each node visited once  
Space: O(h) — recursion stack, h = tree height

---

## 🔹 Approach 2: Iterative Post-order Traversal  
💡 Idea:  
- Use a stack to simulate post-order traversal.  
- For each node, store info about subtree values and if it’s unival.  
- Calculate and count unival subtrees while traversing.

📍 Steps:  
Step 1: Use two stacks or modified DFS for post-order traversal  
Step 2: Track whether left and right subtrees are unival  
Step 3: Compute if current subtree is unival  
Step 4: Increment count accordingly

⏳ Complexity:  
Time: O(n)  
Space: O(h)

*Note:* This approach is more complex to implement and less intuitive than recursion.

---

## 🔹 Approach 3: Bottom-Up Dynamic Programming (Memoization)  
💡 Idea:  
- Use a helper function that returns a custom result containing:  
 • Is subtree unival?  
 • Number of unival subtrees in this subtree  
- Recursively combine results from children to compute for parent.

⏳ Complexity:  
Time: O(n)  
Space: O(h)

---
