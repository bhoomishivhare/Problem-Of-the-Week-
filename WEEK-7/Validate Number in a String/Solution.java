public class ValidateNumber {

    public static boolean isValidNumber(String s) {
        if (s == null || s.isEmpty()) return false;

        // Trim leading and trailing spaces
        s = s.trim();

        // Regex pattern for a valid number
        String numberPattern = "^[+-]?((\\d+(\\.\\d*)?)|(\\.\\d+))([eE][+-]?\\d+)?$";

        return s.matches(numberPattern);
    }

    // Driver code
    public static void main(String[] args) {
        String[] testCases = {
            "0", " 0.1 ", "abc", "1 a", "2e10",
            " -90E3 ", " 1e", "e3", "6e-1", "99e2.5",
            "53.5e93", " --6 ", "-+3", "95a54e53"
        };

        for (String test : testCases) {
            System.out.println("\"" + test + "\" -> " + isValidNumber(test));
        }
    }
}
