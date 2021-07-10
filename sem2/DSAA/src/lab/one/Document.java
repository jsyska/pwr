package lab.one;

import java.util.Scanner;

public class Document {
    public Document() {
    }

    public static void loadDocument(String name, Scanner scan) {
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] words = line.split(" ");
            for(String s: words){
                if(s.equals("eod"))
                    return;
                if(s.length()>5 && s.substring(0,5).toLowerCase().equals("link=")){
                    if(correctLink(s.substring(5))){
                        System.out.println(s.substring(5).toLowerCase());
                    }
                }
            }
        }
    }

    public static boolean correctLink(String link) {
        if(Character.isLetter(link.charAt(0))){
            String[] letters = link.split("");
            for(String s: letters){
                if(Character.isLetter(s.charAt(0)) || Character.isDigit(s.charAt(0)) || s.equals("_"))
                    return true;
            }
            return false;
        }
        return false;
    }
}
