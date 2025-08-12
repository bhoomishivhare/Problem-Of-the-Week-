import java.util.*;

class Solution {

    // ---------- APPROACH 1: DFS Recursive ----------
    // public char[][] floodFillDFSRecursive(char[][] image, int sr, int sc, char newColor) {
    //     char originalColor = image[sr][sc];
    //     if (originalColor == newColor) return image;
    //     dfs(image, sr, sc, originalColor, newColor);
    //     return image;
    // }

    // private void dfs(char[][] image, int row, int col, char originalColor, char newColor) {
    //     int n = image.length;
    //     int m = image[0].length;

    //     if (row < 0 || row >= n || col < 0 || col >= m || image[row][col] != originalColor) return;

    //     image[row][col] = newColor;

    //     dfs(image, row - 1, col, originalColor, newColor); // Up
    //     dfs(image, row + 1, col, originalColor, newColor); // Down
    //     dfs(image, row, col - 1, originalColor, newColor); // Left
    //     dfs(image, row, col + 1, originalColor, newColor); // Right
    // }

    // ---------- APPROACH 2: DFS Iterative ----------
    // public char[][] floodFillDFSIterative(char[][] image, int sr, int sc, char newColor) {
    //     char originalColor = image[sr][sc];
    //     if (originalColor == newColor) return image;

    //     Stack<int[]> stack = new Stack<>();
    //     stack.push(new int[]{sr, sc});

    //     while (!stack.isEmpty()) {
    //         int[] pos = stack.pop();
    //         int r = pos[0], c = pos[1];

    //         if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != originalColor)
    //             continue;

    //         image[r][c] = newColor;

    //         stack.push(new int[]{r - 1, c}); // Up
    //         stack.push(new int[]{r + 1, c}); // Down
    //         stack.push(new int[]{r, c - 1}); // Left
    //         stack.push(new int[]{r, c + 1}); // Right
    //     }

    //     return image;
    // }

    // ---------- APPROACH 3: BFS Iterative ----------
    public char[][] floodFillBFS(char[][] image, int sr, int sc, char newColor) {
        char originalColor = image[sr][sc];
        if (originalColor == newColor) return image;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0], c = pos[1];

            if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != originalColor)
                continue;

            image[r][c] = newColor;

            queue.add(new int[]{r - 1, c}); // Up
            queue.add(new int[]{r + 1, c}); // Down
            queue.add(new int[]{r, c - 1}); // Left
            queue.add(new int[]{r, c + 1}); // Right
        }

        return image;
    }
}
