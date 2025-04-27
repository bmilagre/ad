package ch.hslu.ad.sw09;

import java.util.ArrayList;
import java.util.List;

public class FixedSizeHeap implements IntegerHeapInterface {
    List<Integer> heap;

     /*
       parent(i) = floor(i/2)
       left(i) = 2*i
       right(i) = 2*i + 1
     */

    public FixedSizeHeap(int size) {
        heap = new ArrayList<>(size);
        heap.add(0);
    }

    @Override
    public void push(int number) {
        heap.add(number);
        int i = heap.size() - 1; // index position of pushed value

        while (i > 1 && heap.get(i) > heap.get(i / 2)) { // while i smaller than parent
            int temp = heap.get(i);
            heap.set(i, heap.get(i / 2));
            heap.set(i / 2, temp);
            i = i / 2;
        }
    }

    @Override
    public int pop() {
        if (heap.size() <= 1) { // Nur Dummy-Element vorhanden
            return 0;
        }

        int top = heap.get(1); // Get top value to return
        heap.set(1, heap.get(heap.size() - 1)); // Place the last element to the top
        heap.remove(heap.size() - 1); // remove last element
        int i = 1;

        while (2 * i < heap.size()) {
            int left = 2 * i;
            int right = 2 * i + 1;
            int largerChild = left;

            if (right < heap.size() && heap.get(right) > heap.get(left)) {
                largerChild = right;
            }

            if (heap.get(i) < heap.get(largerChild)) {
                int temp = heap.get(i);
                heap.set(i, heap.get(largerChild));
                heap.set(largerChild, temp);
                i = largerChild;
            } else {
                break;
            }
        }

        return top;
    }

    public void heapify(ArrayList<Integer> arr) {
        // 0-th position is moved to the end
        arr.add(arr.get(0));

        heap = arr;
        int cur = (heap.size() - 1) / 2;
        while (cur > 0) {
            // Percolate Down
            int i = cur;
            while (2 * i < heap.size()) {
                if (2 * i + 1 < heap.size() && heap.get(2 * i + 1) > heap.get(2 * i) && heap.get(i) < heap.get(2 * i + 1)) {
                    // Swap right child
                    int tmp = heap.get(i);
                    heap.set(i, heap.get(2 * i + 1));
                    heap.set(2 * i + 1, tmp);
                    i = 2 * i + 1;
                } else if (heap.get(i) < heap.get(2 * i)) {
                    // Swap left child
                    int tmp = heap.get(i);
                    heap.set(i, heap.get(2 * i));
                    heap.set(2 * i, tmp);
                    i = 2 * i;
                } else {
                    break;
                }
            }
            cur--;
        }
    }
}
