package exc.one;

import java.util.Arrays;

public class NextPermutation {

    public static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) i--;
        if (i <= 0) return false;
        int j = arr.length - 1;
        while (arr[j] <= arr[i - 1]) j--;
        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;
        j = arr.length - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] test = {4,9,6,8,7,5,3,2,1};
        nextPermutation(test);
        System.out.println(Arrays.toString(test));
    }

}
