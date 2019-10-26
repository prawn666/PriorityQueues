package task1;

public class Main {
    public static void main(String[] args) {
        DynamicMedian dm = new DynamicMedian();
        for (int i = 0; i < 5; i++) {
            dm.insert(i);
            System.out.println(dm.median());
        }
    }
}
