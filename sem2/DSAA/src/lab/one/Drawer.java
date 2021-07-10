package lab.one;

public class Drawer {
    public Drawer() {
    }

    private static void drawLine(int n, char ch) {
        String line = "";
        for (int i = 0; i < n; i++) {
            line += Character.toString(ch);
        }
        System.out.print(line);
    }

    public static void drawPyramidMethod(int n, int x) {
        for(; x < n + 1; ++x) {
            for(int i = 0; i < x; ++i) {
                drawLine(n-i-1,' ');
                drawLine( i*2+1, 'X');
                System.out.println();
            }
        }

    }

    public static void drawPyramid(int n) {
        drawPyramidMethod(n, n);

    }

    public static void drawChristmassTree(int n) {
        drawPyramidMethod(n, 1);
    }
}
