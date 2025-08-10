------------------------------------------------------------
## 📝 Problem Statement  
Given `N` students (0 to N-1) and their friendship relationships as an adjacency list,  
count the total number of friend groups (connected components).  
Friendship is mutual and undirected.

---

## 🔹 Approach 1: Depth-First Search (DFS)  
💡 Idea:  
- Treat students as graph nodes and friendships as edges.  
- Use DFS to explore and mark all nodes connected to a starting node.  
- Each DFS call from an unvisited node finds one connected component.

📍 Steps:  
Step 1: Initialize visited set  
Step 2: Initialize count = 0  
Step 3: For each student from 0 to N-1:  
  - If not visited, do DFS starting from this node  
  - Increment count by 1  
Step 4: Return count

⏳ Complexity:  
Time: O(N + E), where E is number of edges  
Space: O(N) for recursion and visited set

---

## 🔹 Approach 2: Breadth-First Search (BFS)  
💡 Idea:  
- Same as DFS but using BFS queue to explore nodes layer-wise.

📍 Steps:  
Step 1: Initialize visited set  
Step 2: Initialize count = 0  
Step 3: For each student 0 to N-1:  
  - If not visited, start BFS from this node  
  - Mark all reachable nodes as visited  
  - Increment count  
Step 4: Return count

⏳ Complexity:  
Time: O(N + E)  
Space: O(N) for queue and visited

---

## 🔹 Approach 3: Union-Find (Disjoint Set Union - DSU)  
💡 Idea:  
- Initialize each student as its own group.  
- For each friendship edge, union the two sets.  
- At the end, count unique parents/groups.

📍 Steps:  
Step 1: Initialize parent array where parent[i] = i  
Step 2: Define find and union functions  
Step 3: For each friendship edge (u, v), union sets of u and v  
Step 4: Count unique parents after all unions  
Step 5: Return count

⏳ Complexity:  
Time: Almost O(N + E) with path compression  
Space: O(N)

---

