package exc.five;

import java.util.*;
public class BucketSort {



    static void bucketSort(int arr[], int n, int x)
    {
        if (n <= 0)
            return;


        Vector<Integer>[] buckets = new Vector[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new Vector<>();
        }

        for (int i = 0; i < n; i++) {
            int idx = arr[i]/(x*buckets.length);
            buckets[idx].add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            insertSort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }

    public static void insertSort(Vector arr) {

        int n = arr.size();
        for(int i =n-2; i>-1; --i){
            int key = (int)arr.get(i);
            int j = i+1;
            while (j<n && (int)arr.get(j)<key){
                arr.set((j-1),arr.get(j));
                j=j+1;
            }
            arr.set((j-1),key);
        }
    }

    public static void main(String args[])
    {
        int arr[] = { 5,5,4,23,67,4,3,14,152,151,21,515};

        int n = arr.length;
        bucketSort(arr, n,67);

        System.out.println("Sorted array is ");
        for (int el : arr) {
            System.out.print(el + " ");
        }
    }
}
