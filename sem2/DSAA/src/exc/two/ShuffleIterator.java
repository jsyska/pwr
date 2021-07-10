package exc.two;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ShuffleIterator<T> implements Iterator<T> {
    private Iterator<T> firstIterator;
    private Iterator<T> secondIterator;
    private T firstArray[];
    private T secondArray[];
    private int pos2;
    private int pos1;
    private int turn = 0;
    private boolean hasNextElement = true;
    private T nextElement;

    public ShuffleIterator(Iterator<T> it1,Iterator<T> it2){
        firstIterator=it1;
        secondIterator=it2;
    }

    private void nextElementValid(){
        int index = 0;
        if(turn ==0 ) {
            while (firstIterator.hasNext()) {
                index++;
                nextElement = firstIterator.next();
                if (index == 1) {
                    turn = 1;
                    return;
                }
            }
            hasNextElement = false;
            nextElement = null;
            turn = 1;
        }
        else{
            while (secondIterator.hasNext()) {
                index++;
                nextElement = firstIterator.next();
                if (index == 1) {
                    turn = 0;
                    return;
                }
            }
            hasNextElement = false;
            nextElement = null;
            turn = 0;
        }
    }

    @Override
    public boolean hasNext() {
        return hasNextElement;
    }


    @Override
    public T next() {
        if (hasNextElement) {
            T nextEl = nextElement;
            nextElementValid();
            return nextEl;
        }
        else throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}
