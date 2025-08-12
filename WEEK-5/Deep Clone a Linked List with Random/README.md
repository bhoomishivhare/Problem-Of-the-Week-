 Deep Clone a Linked List with Random Pointer

## 📝 Problem Statement  
You are given a singly linked list where each node contains:  
- **next**: Points to the next node in the list  
- **random**: Points to any node in the list (or `null`)  

Your task is to create a **deep copy** of this list.  
That means each node in the cloned list should be a **completely new object**,  
having the same value, `next`, and `random` pointer structure as the original.  

---

## 🔹 Approach 1: HashMap (Original → Clone Mapping)  
💡 Idea:  
- Use a `HashMap` to store the mapping between **original node → cloned node**.  
- First pass: Create clone nodes and store mapping.  
- Second pass: Assign `next` and `random` pointers using the map.

📍 Steps:  
Step 1: If head is `null`, return `null`.  
Step 2: Create a map `originalToClone`.  
Step 3: Traverse original list and create clones without links, store in map.  
Step 4: Traverse again, set `next` and `random` using map lookups.  
Step 5: Return the cloned head.

⏳ Complexity:  
Time: **O(N)** (two passes)  
Space: **O(N)** for map

---

## 🔹 Approach 2: Interleaving Nodes (No Extra Space)  
💡 Idea:  
- Insert cloned nodes in between original nodes (O(1) extra space).  
- Set random pointers for clones using original’s random link.  
- Separate original and clone lists.

📍 Steps:  
Step 1: Traverse original list, insert cloned node after each original node.  
Step 2: Set cloned node’s `random = original.random.next` (if `random` exists).  
Step 3: Detach clone list from the interleaved structure.  
Step 4: Return cloned head.

⏳ Complexity:  
Time: **O(N)** (three passes)  
Space: **O(1)** (in-place)

---

## 🔹 Approach 3: Recursive with Memoization  
💡 Idea:  
- Use recursion to clone nodes on-the-fly.  
- Maintain a `HashMap` to avoid re-cloning visited nodes.  
- Works naturally for `random` links too.

📍 Steps:  
Step 1: If current node is `null`, return `null`.  
Step 2: If node already cloned in map, return it.  
Step 3: Create new clone node, store in map.  
Step 4: Recursively set `next` and `random` pointers.  
Step 5: Return clone.

⏳ Complexity:  
Time: **O(N)** (each node cloned once)  
Space: **O(N)** recursion + map

---
