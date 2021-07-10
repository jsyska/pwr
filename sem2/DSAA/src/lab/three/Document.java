package lab.three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Document{
    public String name;
    public TwoWayUnorderedListWithHeadAndTail<Link> link;
    public Document(String name, Scanner scan) {
        this.name=name;
        link=new TwoWayUnorderedListWithHeadAndTail<Link>();
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
                Link linkToAdd = new Link(next.split("=")[1].toLowerCase());
                link.add(linkToAdd);
            }
        }
    }
    // accepted only small letters, capitalic letter, digits nad '_' (but not on the begin)
    public static boolean correctLink(String link) {
        //TODO
        return link.startsWith("link=") && link.substring(5).matches("[a-z][a-z0-9_]*");
    }

    @Override
    public String toString() {
        String output = "Document: " + name;
        for (Link link : link) {
            output += "\n" + link.ref;
        }
        return output;
    }

    public String toStringReverse() {
        ArrayList<Link> revLink = new ArrayList<>();
        for (Link link : link) {
            revLink.add(link);
        }
        Collections.reverse(revLink);
        String output = "Document: " + name;
        for (Link link : revLink) {
            output += "\n" + link.ref;
        }
        return output;
    }

}