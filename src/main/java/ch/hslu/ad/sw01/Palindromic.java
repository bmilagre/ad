package ch.hslu.ad.sw01;

public class Palindromic {

    public static void main(String[] args) {
        Palindromic p = new Palindromic();
        boolean result = p.palindromic(12);
        System.out.println("Ergebnis: " + result);
    }

    public boolean palindromic(final int n) {
        int[] array = String.valueOf(n)
                .chars()
                .map(Character::getNumericValue)
                .toArray();

        if (array.length == 1) {
            return true;
        }

        for (int i = 0; i < array.length / 2; i++) {
            int rightIndex = array.length - 1 - i;

            if (array[i] != array[rightIndex]) {
                return false;
            }
        }

        return true;
    }
}
