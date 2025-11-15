package predictive;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PredictivePrototype {

    /**
     * Q1 – Converts a word into its T9 numeric signature.
     * Example: "home" -> "4663".
     *
     * We use StringBuffer instead of String because String is immutable:
     * every concatenation would create a new object. StringBuffer modifies
     * an internal buffer, so it is more efficient for building strings
     * character-by-character.
     */
    public static String wordToSignature(String word) {
        StringBuffer result = new StringBuffer();

        for (char c : word.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result.append(mapToDigit(c));
            } else {
                result.append(' ');
            }
        }

        return result.toString();
    }

    // Helper method: maps letters to T9 digits
    private static char mapToDigit(char c) {
        if ("abc".indexOf(c) != -1) return '2';
        if ("def".indexOf(c) != -1) return '3';
        if ("ghi".indexOf(c) != -1) return '4';
        if ("jkl".indexOf(c) != -1) return '5';
        if ("mno".indexOf(c) != -1) return '6';
        if ("pqrs".indexOf(c) != -1) return '7';
        if ("tuv".indexOf(c) != -1) return '8';
        if ("wxyz".indexOf(c) != -1) return '9';
        return ' ';
    }

    /**
     * Q2 – Returns the set of words from the dictionary matching a numeric signature.
     * The resulting words:
     *  - must be lowercase
     *  - must contain no duplicates (hence the Set)
     *
     * IMPORTANT:
     * This implementation is INEFFICIENT because:
     *  - it reads the entire dictionary file EVERY time the method is called,
     *  - it recomputes each word's signature every time.
     * Complexity: O(N) per call, where N = number of lines in words.txt.
     *
     * The assignment explicitly forbids storing the dictionary in memory for the prototype.
     */
    public static Set<String> signatureToWords(String signature) {
        Set<String> result = new HashSet<>();

        File dict = new File("words.txt");
        if (!dict.exists()) {
            System.out.println("Error: words.txt not found!");
            return result;
        }

        try (Scanner sc = new Scanner(dict, StandardCharsets.UTF_8)) {
            while (sc.hasNextLine()) {
                String word = sc.nextLine().trim().toLowerCase();

                if (!isValidWord(word)) continue;

                if (wordToSignature(word).equals(signature)) {
                    result.add(word);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading words.txt: " + e.getMessage());
        }

        return result;
    }

    // Checks whether a word contains only alphabetical characters
    private static boolean isValidWord(String word) {
        return word.matches("[a-zA-Z]+");
    }

    // Optional test main
    public static void main(String[] args) {
        System.out.println("wordToSignature(\"home\") = " + wordToSignature("home"));
        System.out.println("signatureToWords(\"4663\") = " + signatureToWords("4663"));
    }
}
