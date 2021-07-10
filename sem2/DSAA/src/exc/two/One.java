package exc.two;

import java.util.Arrays;
import java.util.Iterator;


public class One<T> implements Iterator<T> {
    private final Iterator<T> iterator;
    private T nextItem;


    private final int step;
    private int currentStep = 0;
    private boolean hasNext = true;


    One(Iterator<T> iterator, int k) {
        this.iterator = iterator;
        this.step = k;
        this.getNextItem();
    }

    private void getNextItem() {
        while (this.iterator.hasNext()) {
            this.nextItem = this.iterator.next();

            if (this.currentStep % this.step == 0) {
                this.currentStep++;
                return;
            }
            this.currentStep++;
        }

        this.nextItem = null;
        this.hasNext = false;
    }

    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override
    public T next() {
        var item = this.nextItem;
        this.getNextItem();
        return item;
    }

    public static void main(String[] args) {
        var data = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        var iter = new One<>(Arrays.stream(data).iterator(), 5);

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }
}