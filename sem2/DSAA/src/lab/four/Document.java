package lab.four;

import java.util.ListIterator;
import java.util.Scanner;

public class Document{
    public String name;
    public TwoWayCycledOrderedListWithSentinel<Link> link;

    public Document(String name, Scanner scan) {
        this.name=name.toLowerCase();
        link=new TwoWayCycledOrderedListWithSentinel<Link>();
        load(scan);
    }
    public void load(Scanner scan) {
        //TODO
        while (scan.hasNext()) {
            String next = scan.next();
            if (next.equals("eod")) {
                return;
            }
            if (correctLink(next)) {
                Link linkToAdd = createLink(next);
                link.add(linkToAdd);
            }
        }
    }

    public static boolean isCorrectId(String id) {
        return id.matches("[a-zA-Z][a-zA-Z0-9_]*");
    }

    // accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
    private static Link createLink(String link) {
        Link linkToAdd;
        if (link.contains("(") && link.contains(")")) {
            int weight = Integer.parseInt(link.split("\\(")[1].split("\\)")[0]);
            linkToAdd = new Link(link.split("=")[1].split("\\(")[0], weight);
        } else {
            linkToAdd = new Link(link.substring(5));
        }
        return linkToAdd;
    }

    private static boolean correctLink(String link) {
        if (link.contains("(") && link.contains(")")) {
            try {
                int weight = Integer.parseInt(link.split("\\(")[1].split("\\)")[0]);
                if (weight < 1) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
            return link.substring(5).matches("[a-zA-Z][a-zA-Z0-9_\\(\\)]*");
        } else {
            return link.startsWith("link=") && link.substring(5).matches("[a-zA-Z][a-zA-Z0-9_]*");
        }
    }

    public String toString() {
        if (link.size == 0) {
            return "Document: " + name.toLowerCase();
        }

        String output = "Document: " + name.toLowerCase() + "\n";
        String line = "";

        for (Link l : link) {
            if (line.split(" ").length < 10) {
                line += l.toString() + " ";
            } else {
                line.trim();
                output += line + "\n";
                line = "";
                line += l.toString() + " ";
            }
        }
        output += line;
        return output;
    }


    public String toStringReverse() {
        if (link.size == 0) {
            return "Document: " + name.toLowerCase();
        }
        String output = "Document: " + name.toLowerCase() + "\n";
        String line = "";
        ListIterator<Link> iter = link.listIterator();
        while (iter.hasNext())
            iter.next();
        //TODO
        while (iter.hasPrevious()) {
            if (line.split(" ").length < 10) {
                line += iter.previous().toString() + " ";
            } else {
                line.trim();
                output += line + "\n";
                line = "";
                line += iter.previous().toString() + " ";
            }
        }
        output += line;
        return output;
    }


    //    public String toStringReverse() {
//        if (link.size == 0) {
//            return "Document: " + name.toLowerCase();
//        }
//
//        ArrayList<Link> rev = new ArrayList<>();
//        for (Link link : link) {
//            rev.add(link);
//        }
//        Collections.reverse(rev);
//
//        String output = "Document: " + name.toLowerCase() + "\n";
//        String line = "";
//        for (Link l : rev) {
//            if (line.split(" ").length < 10) {
//                line += l.toString() + " ";
//            } else {
//                line.trim();
//                output += line + "\n";
//                line = "";
//                line += l.toString() + " ";
//            }
//        }
//        output += line;
//        return output;
//    }

}
