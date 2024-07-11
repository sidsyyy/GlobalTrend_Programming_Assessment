package GlobalTrend;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class Ques2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        // Demonstrating ConcurrentModificationException
        try {
            for (String s : list) {
                if (s.equals("Two")) {
                    list.remove(s); // This will throw ConcurrentModificationException
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException caught: " + e.getMessage());
        }

        // Proper way to modify the list using Iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals("Three")) {
                iterator.remove(); // Safe way to remove an element
            }
        }

        System.out.println("List after modifications: " + list);
    }
}

