package predictive;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Command-line program for Part 1:
 * Usage example:
 *   java predictive.Sigs2WordsProto 4663 43556 96753 69 6263 47
 *
 * Output example (format requested by the assignment):
 * 4663: [hood, ione, ioof, good, hond, inne, gond, hone, hoof, gone, goof, home, gome]
 * 43556: [gekko, hello]
 * ...
 */
public class Sigs2WordsProto {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("Usage: java predictive.Sigs2WordsProto <sig1> <sig2> ...");
            return;
        }

        List<String> sigs = Arrays.asList(args);
        for (String sig : sigs) {
            Set<String> matches = PredictivePrototype.signatureToWords(sig);
            System.out.println(sig + ": " + matches);
        }
    }
}
