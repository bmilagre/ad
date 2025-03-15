package ch.hslu.ad.sw04;

import java.util.Arrays;

public class HashSet<T> implements HashSetInterface<T> {

    private static final int SIZE = 10;
    private final Object[] array = new Object[SIZE];

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        String t1 = "Hallo";

        System.out.println("Text " + t1 + "; Hash: " + set.getHash(t1));
        set.add(t1);

        String t2 = "AD";
        System.out.println("Text " + t2 + "; Hash: " + set.getHash(t2));
        set.add(t2);

        String t3 = "1234";
        System.out.println("Text " + t3 + "; Hash: " + set.getHash(t3));
        set.add(t3);

        System.out.println(set.toString());
    }

    @Override
    public void add(T element) {
        int index = this.getHash(element);

        if (array[index] == null) {
            array[index] = element;
        }
    }

    @Override
    public void remove(T element) {
        int index = this.getHash(element);

        if (array[index] != null) {
            array[index] = null;
        }
    }

    @Override
    public boolean contains(T element) {
        int index = this.getHash(element);

        if (array[index] != null) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    protected int getHash(T element) {
        return Math.abs(element.hashCode()) % SIZE;
    }
}
