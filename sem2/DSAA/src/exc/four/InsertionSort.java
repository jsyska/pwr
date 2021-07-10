package exc.four;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] array) { //descending, growing from the end
        int len = array.length;
        int[] arr = Arrays.copyOf(array, len);
        for (int i = len-2; i >= 0; i--) {
            int current = arr[i];
            int j = i+1;
            while (j <= len-1 && arr[j] > current) {
                arr[j-1] = arr[j];
                j++;
            }
            arr[j-1] = current;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = { 76, 71, 5, 57, 12, 50, 20, 93, 20, 55, 62, 3 };
        insertionSort(arr);
    }
}
