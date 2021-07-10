package lab.one;

import lab.one.Document;
import lab.one.Drawer;

import java.util.Scanner;

public class Main {
    static Scanner scan;

    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("START");
        scan = new Scanner(System.in);
        boolean halt = false;

        while(true) {
            while(true) {
                String line;
                do {
                    do {
                        if (halt) {
                            System.out.println("END OF EXECUTION");
                            scan.close();
                            return;
                        }

                        line = scan.nextLine();
                    } while(line.length() == 0);
                } while(line.charAt(0) == '#');

                System.out.println("!" + line);
                String[] word = line.split(" ");
                int value;
                if (word[0].equalsIgnoreCase("py") && word.length == 2) {
                    value = Integer.parseInt(word[1]);
                    Drawer.drawPyramid(value);
                } else if (word[0].equalsIgnoreCase("ct") && word.length == 2) {
                    value = Integer.parseInt(word[1]);
                    Drawer.drawChristmassTree(value);
                } else if (word[0].equalsIgnoreCase("ld") && word.length == 2) {
                    Document.loadDocument(word[1], scan);
                } else if (word[0].equalsIgnoreCase("ha") && word.length == 1) {
                    halt = true;
                } else {
                    System.out.println("Wrong command");
                }
            }
        }
    }
}
