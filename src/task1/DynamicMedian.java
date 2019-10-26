package task1;

import util.BinaryHeap;

public class DynamicMedian {
    private BinaryHeap<Integer> less, more;

    public DynamicMedian() {
        less = new BinaryHeap<>(false);
        more = new BinaryHeap<>(true);
    }


    public boolean isEmpty() {
        return less.isEmpty() && more.isEmpty();
    }

    public void insert(int elem) {
        if (isEmpty()) {
            less.insert(elem);
        } else {
            if (elem > median()) {
                less.insert(elem);
            } else {
                more.insert(elem);
            }
        }
        fix();
    }

    public int removeMedian() {
        if (less.size() > more.size()) {
            return less.delMax();
        } else if (less.size() == more.size()) {
            return less.max() > more.max() ? more.delMax() : less.delMax();
        }
        return more.delMax();
    }

    public int median() {
        if (less.size() > more.size()) {
            return less.max();
        } else if (less.size() == more.size()) {
            return less.max() > more.max() ? more.max() : less.max();
        }
        return more.max();
    }

    private void fix() {
        if (Math.abs(less.size() - more.size()) > 1) {
            if (less.size() > more.size()) {
                more.insert(less.delMax());
            } else {
                less.insert(more.delMax());
            }
        }
    }
}
