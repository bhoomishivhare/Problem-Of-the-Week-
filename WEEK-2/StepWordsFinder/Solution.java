
// Week 2 - Problem-3: Find all step words by adding one letter + anagram

import java.util.*;

public class StepWordsFinder {

    // ---------------------------------------------------
    // Approach 1: Brute Force - Generate all anagrams (VERY SLOW)
    // ---------------------------------------------------
    /*
    // Generate all unique anagrams of the given char array and add to set
    private static void generateAnagrams(char[] arr, int index, Set<String> anagrams) {
        if (index == arr.length) {
            anagrams.add(new String(arr));
            return;
        }
        Set<Character> used = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if (!used.contains(arr[i])) {
                used.add(arr[i]);
                swap(arr, i, index);
                generateAnagrams(arr, index + 1, anagrams);
                swap(arr, i, index);
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Brute force: For each letter 'a' to 'z', add to inputWord, generate anagrams, check dictionary
    public static List<String> bruteForceStepWords(String inputWord, Set<String> dict) {
        List<String> result = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            String extended = inputWord + ch;
            char[] chars = extended.toCharArray();
            Set<String> anagrams = new HashSet<>();
            generateAnagrams(chars, 0, anagrams);
            for (String anagram : anagrams) {
                if (dict.contains(anagram)) {
                    result.add(anagram);
                }
            }
        }
        // Remove duplicates and sort
        Set<String> uniqueResult = new HashSet<>(result);
        List<String> sortedResult = new ArrayList<>(uniqueResult);
        Collections.sort(sortedResult);
        return sortedResult;
    }
    */

    // ---------------------------------------------------
    // Approach 2 & 3: Frequency Counting Check (Optimized)
    // ---------------------------------------------------
    private static int[] getFreq(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    private static boolean isStepWord(int[] baseFreq, int[] candidateFreq) {
        int diffCount = 0;
        for (int i = 0; i < 26; i++) {
            int diff = candidateFreq[i] - baseFreq[i];
            if (diff < 0) return false;        // candidate can't have fewer chars than base
            if (diff > 1) return false;        // only one letter added allowed
            if (diff == 1) diffCount++;
            if (diffCount > 1) return false;   // more than one letter added
        }
        return diffCount == 1;
    }

    // ---------------------------------------------------
    // Main method
    // ---------------------------------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputWord = sc.nextLine().trim();
        int n = Integer.parseInt(sc.nextLine().trim());

        // Load dictionary
        Set<String> dict = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dict.add(sc.nextLine().trim());
        }

        // Uncomment below to run brute force approach (only for small inputs)
        /*
        List<String> bruteResult = bruteForceStepWords(inputWord, dict);
        for (String word : bruteResult) {
            System.out.println(word);
        }
        */

        // Optimized frequency-based approach (recommended)
        int[] baseFreq = getFreq(inputWord);
        List<String> result = new ArrayList<>();

        for (String candidate : dict) {
            if (candidate.length() != inputWord.length() + 1) continue;

            int[] candidateFreq = getFreq(candidate);

            if (isStepWord(baseFreq, candidateFreq)) {
                result.add(candidate);
            }
        }

        Collections.sort(result);
        for (String word : result) {
            System.out.println(word);
        }

        sc.close();
    }
}
