package exc.two;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorIncrements<T> implements Iterator<T> {
    private Iterator<T> iterator;
    private int increments;
    private boolean hasNextElement = true;
    private T nextElement;
    public IteratorIncrements(Iterator<T> it, int k){
        iterator=it;
        increments=k;
    }
    private void nextElementValid(){
        int index = 0;
        while (iterator.hasNext()){
            index++;
            nextElement=iterator.next();
            if (index==increments) {
                return;
            }
        }
        hasNextElement =false;
        nextElement=null;
    }
    @Override
    public boolean hasNext() {
        return hasNextElement;
    }

    @Override
    public T next() throws NoSuchElementException {

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