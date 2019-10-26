package task2;

public class Main {
    public static void main(String[] args) {
        BinaryHeapRandom<Integer> bh = new BinaryHeapRandom<>(true);
        for (int i = 0; i < 100; i++) {
            bh.insert(i);
        }
        for (int i = 0; i < 100; i++) {
            bh.delRandom();
        }
    }
}
