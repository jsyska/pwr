package lab.twelve;
import java.util.LinkedList;

public interface IStringMatcher {
    LinkedList<Integer> validShifts(String pattern, String text);
}