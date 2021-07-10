package exc.two;

import java.util.Iterator;

public class ArrayTest {
    public static void main(String[] args) {

        //Iterator increment

//        Integer[] arr = {5,3,5,6,7,1,4};
//        ArrayIterator<Integer> iterator = new ArrayIterator<Integer>(arr);
//        IteratorIncrements<Integer> iteratorIncrements = new IteratorIncrements<>(iterator,2);
//
//        while (iteratorIncrements.hasNext()){
//            System.out.println(iteratorIncrements.next());
//        }


        // Fibbonacci iterator

        FibbonaciIterator fb = new FibbonaciIterator();
        System.out.println(fb.next());
        System.out.println(fb.next());
        System.out.println(fb.next());
        System.out.println(fb.next());
        System.out.println(fb.next());
        System.out.println(fb.next());
        System.out.println(fb.next());
        System.out.println(fb.next());
        System.out.println(fb.next());
        System.out.println(fb.next());


//          Integer[] arr1 = {1,2,3,4,5};
//          Integer[] arr2 = {11,12,13};



    }
}
