package task3;

import util.BinaryHeap;

public class Taxicab implements Comparable<Taxicab> {

    int i, j;
    long sum;

    public Taxicab(int i, int j) {
        this.i = i;
        this.j = j;
        sum = (long) i * i * i + (long) j * j * j;
    }

    @Override
    public String toString() {
        return "Taxicab{" +
                "i=" + i +
                ", j=" + j +
                ", sum=" + sum +
                '}';
    }

    public static void main(String[] args) {
        int n = Integer.valueOf(args[0]);
        BinaryHeap<Taxicab> pq = new BinaryHeap<>(false);
        for (int i = 1; i <=n; i++) {
            pq.insert(new Taxicab(i, i));
        }
        Taxicab start = new Taxicab(0,0);
        while (!pq.isEmpty()){
            Taxicab curr = pq.delMax();
            if (curr.sum == start.sum) {
                System.out.println(curr + " == " + start);
            }
            start = curr;
            if (curr.j < n) {
                pq.insert(new Taxicab(curr.i, ++curr.j));
            }
        }
    }

    @Override
    public int compareTo(Taxicab that) {
        if (this.sum < that.sum) return -1;
        else if (this.sum > that.sum) return +1;
        else if (this.i < that.i) return -1;
        else if (this.i > that.i) return +1;
        else return 0;
    }
}
