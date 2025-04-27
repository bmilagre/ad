package ch.hslu.ad.sw09;

import java.util.Arrays;

public class MyApp {

    public static void main(String[] args) {
        FixedSizeHeap heap = new FixedSizeHeap(5);

        heap.push(10);
        heap.push(20);
        heap.push(3);
        heap.push(7);
        heap.push(12);

        System.out.println(Arrays.toString(heap.heap.toArray()));
    }
}
