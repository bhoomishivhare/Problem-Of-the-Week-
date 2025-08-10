import java.util.*;

public class FirstRecurringCharacter {

    // ---------------------------------------------------
    // Approach 1: Using HashSet (Optimal)
    // ---------------------------------------------------
    public static Character firstRecurringUsingSet(String s) {
        Set<Character> seen = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (seen.contains(ch)) {
                return ch;
            }
            seen.add(ch);
        }
        return null;
    }

    // ---------------------------------------------------
    // Approach 2: Using HashMap to track first and second occurrences
    // ---------------------------------------------------
    public static Character firstRecurringUsingMap(String s) {
        Map<Character, Integer> firstIndexMap = new HashMap<>();
        int earliestSecondIndex = Integer.MAX_VALUE;
        Character result = null;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!firstIndexMap.containsKey(ch)) {
                firstIndexMap.put(ch, i);
            } else {
                // Second occurrence found
                if (i < earliestSecondIndex) {
                    earliestSecondIndex = i;
                    result = ch;
                }
            }
        }

        return result;
    }

    // ---------------------------------------------------
    // Approach 3: Using fixed size array for ASCII charset
    // ---------------------------------------------------
    public static Character firstRecurringUsingArray(String s) {
        // Assuming ASCII charset (256 characters)
        int[] firstIndex = new int[256];
        Arrays.fill(firstIndex, -1);
        int earliestSecondIndex = Integer.MAX_VALUE;
        Character result = null;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (firstIndex[ch] == -1) {
                firstIndex[ch] = i;
            } else {
                if (i < earliestSecondIndex) {
                    earliestSecondIndex = i;
                    result = ch;
                }
            }
        }

        return result;
    }
}
