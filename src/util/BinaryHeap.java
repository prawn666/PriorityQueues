package util;

import java.util.ArrayList;

public class BinaryHeap<T extends Comparable<T>> {
    private int N;
    private ArrayList<T> array;
    private boolean more;

    public BinaryHeap(boolean more) {
        this.more = more;
        array = new ArrayList<>();
        array.add(0, null);
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(T element) {
        array.add(++N, element);
        swim(N);
    }

    public T delMax() {
        T max = array.get(1);
        swap(1, N--);
        sink(1);
        array.set(N + 1, null);
        return max;
    }

    public int size() {
        return N;
    }

    public T max() {
        return array.get(1);
    }

    private void swim(int k) {
        while (k > 1 && more(k, k / 2)) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j < N && more(j + 1, j)) {
                j++;
            }
            if (!more(j, k)) break;
            swap(k, j);
            k = j;
        }
    }

    private boolean more(int k, int k2) {
        return array.get(k).compareTo(array.get(k2)) > 0 == more;
    }

    private void swap(int k, int k2) {
        T tmp = array.get(k);
        array.set(k, array.get(k2));
        array.set(k2, tmp);
    }
}
