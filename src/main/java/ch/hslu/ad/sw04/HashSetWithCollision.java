package ch.hslu.ad.sw04;

import java.util.Arrays;

public class HashSetWithCollision<T> implements HashSetInterface<T> {

    private static final int SIZE = 10;
    private final Object[] array = new Object[SIZE];
    private int currentSize = 0;

    public static void main(String[] args) {
        HashSetWithCollision<String> set = new HashSetWithCollision<>();

        String t1 = "Hallo";
        System.out.println("Text " + t1 + "; Hash: " + t1.hashCode() + "; Index: " + set.getHash(t1));
        set.add(t1);

        String t2 = "AD";
        System.out.println("Text " + t2 + "; Hash: " + t2.hashCode() + "; Index: " + set.getHash(t2));
        set.add(t2);

        String t3 = "1234";
        System.out.println("Text " + t3 + "; Hash: " + t3.hashCode() + "; Index: " + set.getHash(t3));
        set.add(t3);

        System.out.println(set.toString());
        System.out.println("");
        System.out.println("");

        String t4 = "FB";
        String t5 = "Ea";

        System.out.println("Text " + t4 + "; Hash: " + t4.hashCode() + "; Index: " + set.getHash(t4));
        System.out.println("Text " + t5 + "; Hash: " + t5.hashCode() + "; Index: " + set.getHash(t5));

        set.add(t4);
        set.add(t5);

        System.out.println("Set enthält " + t4 + ": " + set.contains(t4));
        System.out.println("Set enthält " + t5 + ": " + set.contains(t5));
        System.out.println("Array: " + set.toString());
        System.out.println("Size: " + set.size());

        System.out.println("");
        System.out.println("");

        set.remove(t4);
        set.remove(t5);

        System.out.println("Set enthält " + t4 + ": " + set.contains(t4));
        System.out.println("Set enthält " + t5 + ": " + set.contains(t5));
        System.out.println("Array: " + set.toString());
        System.out.println("Size: " + set.size());
    }

    @Override
    public void add(T element) {
        if (!this.isFull()) {
            int index = this.getHash(element);

            // If current index is empty, just add it.
            if (array[index] == null) {
                array[index] = element;
                this.currentSize++;
            } else {
                int currentIndex = index;

                // Check for next higher empty stop
                while (array[currentIndex] != null) {
                    currentIndex = (currentIndex + 1) % SIZE;
                }
                array[currentIndex] = element;
                this.currentSize++;
            }
        }
    }

    @Override
    public void remove(T element) {
        int index = this.getHash(element);

        if (array[index] != null && array[index].equals(element)) {
            array[index] = null;
            this.currentSize--;
        } else {
            int currentIndex = index + 1;

            while (array[currentIndex] != null) {
                if (array[currentIndex].equals(element)) {
                    array[currentIndex] = null;
                    currentSize--;
                    break;
                }

                currentIndex++;
            }
        }
    }

    @Override
    public boolean contains(T element) {
        int index = this.getHash(element);

        while (array[index] != null) {
            if (array[index].equals(element)) {
                return true;
            }

            index = (index + 1) % SIZE;
        }

        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    protected int size() {
        return this.currentSize;
    }

    protected boolean isFull() {
        return this.currentSize == this.array.length;
    }

    protected int getHash(T element) {
        return Math.abs(element.hashCode()) % SIZE;
    }
}
