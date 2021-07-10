package exc.one;

public class SecondSmallest {

    private static int getSecondSmallest(int[] data) {
        if (data.length == 0)
            throw new IllegalStateException();

        int firstElement = data[0];
        int idx = 1;

        while (idx < data.length && firstElement == data[idx])
            idx ++;


        if (idx == data.length)
            throw new IllegalStateException();



        int secondSmallest = Math.max(firstElement, data[idx]);
        int smallest = Math.min(firstElement, data[idx]);

        for (; idx<data.length; idx++) {
            int value = data[idx];

            if (value < smallest) {
                secondSmallest = smallest;
                smallest = value;
            } else if (value > smallest && value < secondSmallest) {
                secondSmallest = value;
            }
        }

        return secondSmallest;
    }

    public static void main(String[] args) {
//        drawPascalTriangle(10);
        System.out.println(getSecondSmallest(new int[]{9, 3, 5, 4, 7, 1, 5, 1, 9}));
    }

}
