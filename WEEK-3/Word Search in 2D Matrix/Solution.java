
// Week 3 - Problem-3: Check if a word exists horizontally (left-to-right) or vertically (top-to-bottom) in a matrix

public class WordSearch2D {

    // ---------------------------------------------------
    // Approach 1: Convert rows and columns to strings and use substring check
    // ---------------------------------------------------
    public static boolean wordExistsUsingStringMatch(char[][] matrix, String word) {
        int M = matrix.length;
        int N = matrix[0].length;

        // Check rows
        for (int i = 0; i < M; i++) {
            StringBuilder rowStr = new StringBuilder();
            for (int j = 0; j < N; j++) {
                rowStr.append(matrix[i][j]);
            }
            if (rowStr.toString().contains(word)) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < N; j++) {
            StringBuilder colStr = new StringBuilder();
            for (int i = 0; i < M; i++) {
                colStr.append(matrix[i][j]);
            }
            if (colStr.toString().contains(word)) {
                return true;
            }
        }

        return false;
    }

    // ---------------------------------------------------
    // Approach 2: Character-by-character check without building strings
    // ---------------------------------------------------
    public static boolean wordExistsCharByChar(char[][] matrix, String word) {
        int M = matrix.length;
        int N = matrix[0].length;
        int L = word.length();

        // Check rows
        for (int i = 0; i < M; i++) {
            for (int start = 0; start <= N - L; start++) {
                int k;
                for (k = 0; k < L; k++) {
                    if (matrix[i][start + k] != word.charAt(k)) break;
                }
                if (k == L) return true;
            }
        }

        // Check columns
        for (int j = 0; j < N; j++) {
            for (int start = 0; start <= M - L; start++) {
                int k;
                for (k = 0; k < L; k++) {
                    if (matrix[start + k][j] != word.charAt(k)) break;
                }
                if (k == L) return true;
            }
        }

        return false;
    }
}
