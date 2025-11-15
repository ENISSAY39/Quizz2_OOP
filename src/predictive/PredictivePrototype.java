package predictive;

public class PredictivePrototype {

    /**
     * Convertit un mot en signature numérique T9.
     * Exemple : "home" -> "4663".
     *
     * Les caractères non alphabétiques sont remplacés par un espace ' '.
     *
     * NOTE :
     * On utilise ici un StringBuffer plutôt qu'un String car il permet
     * d'accumuler les caractères efficacement. String est immuable :
     * à chaque concaténation, un NOUVEL objet est créé. StringBuffer
     * utilise un buffer interne modifiable → beaucoup plus efficace.
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

    /**
     * Convertit une lettre alphabétique en chiffre T9.
     */
    private static char mapToDigit(char c) {
        if ("abc".indexOf(c) != -1) return '2';
        if ("def".indexOf(c) != -1) return '3';
        if ("ghi".indexOf(c) != -1) return '4';
        if ("jkl".indexOf(c) != -1) return '5';
        if ("mno".indexOf(c) != -1) return '6';
        if ("pqrs".indexOf(c) != -1) return '7';
        if ("tuv".indexOf(c) != -1) return '8';
        if ("wxyz".indexOf(c) != -1) return '9';
        return ' '; // sécurité
    }

    /**
     * Petit main() to test question 1
     */
    public static void main(String[] args) {
        System.out.println(wordToSignature("home"));   // should display 4663
        System.out.println(wordToSignature("hello"));  // 43556
        System.out.println(wordToSignature("he!!o"));  // 43 5  (espace for non-alpha caracrters)
    }
}
