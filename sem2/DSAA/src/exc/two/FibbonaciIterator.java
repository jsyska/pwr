package exc.two;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FibbonaciIterator<T> implements Iterator<Integer> {
    private int array[] = new int[0];
    int index = 0;

    public FibbonaciIterator(){}

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if(index <=1){
            array = Arrays.copyOf(array,array.length+1);
            array[index]=1;
            index ++;
            return 1;
        } else{
            array = Arrays.copyOf(array,array.length+1);
            int result =array[index-2]+array[index-1];
            array[index] = result;
            index++;
            return result;
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
//
//    private int n;
//
//    public IterableFibonacci(int n) {
//        this.n = n;
//    }
//
//    public Iterator<Integer> iterator() {
//        return new FibonacciIterator();
//    }
//
//    private class FibonacciIterator implements Iterator<Integer> {
//
//        private int num1 = 1;
//        private int num2 = 1;
//        private int count = 0;
//
//        public boolean hasNext() {
//            return count < n;
//        }
//
//
//        public Integer next() {
//            int aux = num1;
//            num1 = num2;
//            num2 = num1 + aux;
//            count++;
//            return aux;
//        }
//    }
//
//    public static void main(String [] args) {
//        IterableFibonacci fibonacci = new IterableFibonacci(6);
//
//        for (int fib: fibonacci) {
//            System.out.println(fib);
//        }
//    }



}
