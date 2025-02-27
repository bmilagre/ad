package ch.hslu.ad.sw02;

public class Main {
    public static void main(String[] args) {
        String[] words = {"toll", "sind", "Datenstrukturen"};

        for (String word : words) {
            Stack stack = new Stack(word.length());
            //System.out.println("Current word: " + word + "; with length: " + word.length());

            for (String s : word.split("")) {
                stack.push(s);
            }

            while(stack.size() > 0){
                System.out.print(stack.pop());
            }

            System.out.println();
        }
    }
}
