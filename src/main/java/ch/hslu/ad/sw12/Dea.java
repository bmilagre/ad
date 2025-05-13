package ch.hslu.ad.sw12;

public class Dea {

    public static void main(String[] args) {
        String[] language = {"0", "010", "01110", "0111010", "0101110", "0101010", "1", "011110" };

        for (String s : language) {
            System.out.println("Check if " + s + " is part of language");
            System.out.println(isWordLanguage(s));
            System.out.println("...");
        }
    }

    public static boolean isWordLanguage(final String s) {
        char[] chars = s.toCharArray();

        // Wenn erstes gleich 1 -> false
        if (chars[0] == '1') {
            return false;
        }

        for (int i = 1; i < chars.length - 1; i++) {
            //Sofern nachfolgende Null existiert -> false
            if (chars[i] == '0' && (chars[i - 1] == '0' || chars[i + 1] == '0')) {
                return false;
            }

            int numbOfOnes = 0;
            boolean onesStarted = false;

            // Ob nachfolgende Einsen existieren und Ungerade
            int j = i;
            while (j < chars.length - 1 && chars[j] == '1') {
                numbOfOnes++;
                onesStarted = true;
                j++;
            }

            // Überprüfe, ob eine Gruppe von Einsen gefunden wurde und ob ihre Anzahl ungerade ist
            if (onesStarted && numbOfOnes % 2 == 0) {
                return false;
            }

            // Wenn eine Gruppe von Einsen gefunden wurde, muss danach eine '0' folgen (innerhalb der Grenzen)
            if (onesStarted && j < chars.length - 1 && chars[j] != '0') {
                return false;
            }

            // Setze i auf die Position nach der potenziellen '0' nach der Einergruppe
            i = j;

        }

        if (chars.length  > 1 && chars[chars.length  - 1] != '0') {
            return false;
        }

        return true;
    }
}
