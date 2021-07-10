package exc.four;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] array) { //descending, growing from the beginning
        int len = array.length;
        int[] arr = Arrays.copyOf(array, len);
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if (arr[j] < arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] arr = { 76, 71, 5, 57, 12, 50, 20, 93, 20, 55, 62, 3 };
        bubbleSort(arr);
    }
}