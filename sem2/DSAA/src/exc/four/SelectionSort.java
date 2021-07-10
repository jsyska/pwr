package exc.four;

import java.util.Arrays;

public class SelectionSort {

    private static void sort(int[] arr) {
        int min;
        int minIdx;
        int nextIdx;
        for (int i = arr.length - 1; i >= 0; i--) {
            min = arr[i];
            minIdx = i;
            nextIdx = i - 1;
            while (nextIdx >= 0) {
                if (arr[nextIdx] < min) {
                    min = arr[nextIdx];
                    minIdx = nextIdx;
                }
                nextIdx--;
            }
            swap(arr, minIdx, i);
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void swap(int[] arr, int idxA, int idxB) {
        int temp = arr[idxA];
        arr[idxA] = arr[idxB];
        arr[idxB] = temp;
    }

    public static void main(String[] args) {
        int[] testArray = {76, 71, 5, 57, 12, 50, 20, 93, 20, 55, 62, 3};
        System.out.println(Arrays.toString(testArray));
        sort(testArray);
    }
}