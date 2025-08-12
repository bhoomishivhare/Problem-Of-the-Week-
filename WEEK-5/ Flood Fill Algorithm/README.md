

## 📝 Problem Statement  
You are given a 2D matrix `image` of characters representing colors.  
You also have a starting position `(sr, sc)` and a new color `C`.  

Perform a **flood fill** starting from `(sr, sc)` — change the starting pixel and all 4-directionally connected pixels with the same **original color** to the new color.

---

## 🔹 Approach 1: DFS (Recursive)  
💡 **Idea:**  
- Store the original color of the starting pixel.  
- If the color is already `C`, return.  
- Run DFS from `(sr, sc)`, replacing the color and visiting all valid neighbors with the same original color.

📍 **Steps:**  
1. Get the original color at `(sr, sc)`.  
2. If it’s the same as the new color, return the image.  
3. Perform DFS:
   - Change current pixel to `C`.
   - Recur for all 4 neighbors (up, down, left, right) having the same original color.
4. Return updated image.

⏳ **Complexity:**  
- **Time:** O(N × M) (each pixel visited at most once)  
- **Space:** O(N × M) recursion stack

---

## 🔹 Approach 2: BFS (Queue)  
💡 **Idea:**  
- Use a queue to process pixels layer-by-layer.
- Change color when dequeuing and enqueue neighbors of the same original color.

📍 **Steps:**  
1. Get the original color at `(sr, sc)`.  
2. If original color == new color, return image.  
3. Push `(sr, sc)` into queue.  
4. While queue not empty:  
   - Pop front pixel and change to new color.  
   - Push neighbors with same original color into queue.
5. Return updated image.

⏳ **Complexity:**  
- **Time:** O(N × M)  
- **Space:** O(N × M) for queue

---

## 🔹 Approach 3: Iterative DFS (Stack)  
💡 **Idea:**  
- Same as recursive DFS, but avoid recursion depth limit by using an explicit stack.

📍 **Steps:**  
1. Get original color of `(sr, sc)`.  
2. If original color == new color, return image.  
3. Push `(sr, sc)` into stack.  
4. While stack not empty:  
   - Pop top pixel, change to new color.  
   - Push valid neighbors with same original color onto stack.
5. Return updated image.

⏳ **Complexity:**  
- **Time:** O(N × M)  
- **Space:** O(N × M) for stack

---

