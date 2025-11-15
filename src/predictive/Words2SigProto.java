package predictive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Command-line program for Part 1:
 * Usage example:
 *   java predictive.Words2SigProto home hello world my name is
 *
 * Output example (exact format requested by the assignment):
 * input: [home, hello, world, my, name, is]
 * output: 4663 43556 96753 69 6263 47
 */
public class Words2SigProto {
    public static void main(String[] args) {
        // If no arguments provided, print usage and exit
        if (args == null || args.length == 0) {
            System.out.println("Usage: java predictive.Words2SigProto <word1> <word2> ...");
            return;
        }

        // Prepare input list in lowercase (but keep original tokens for printing as given)
        List<String> input = new ArrayList<>(Arrays.asList(args));
        System.out.println("input: " + input);

        // Compute signatures
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            String token = args[i];
            String sig = PredictivePrototype.wordToSignature(token);
            if (i > 0) output.append(' ');
            output.append(sig);
        }

        System.out.println("output: " + output.toString());
    }
}
