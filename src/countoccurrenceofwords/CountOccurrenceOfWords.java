
import java.util.*;

public class CountOccurrenceOfWords {

    public static void main(String[] args) {
        // Set text in a string
        String text = "Good morning. Have a good class. "
                + "Have a good visit. Have fun!";

        // Create a TreeMap to hold words as key and count as value
        Map<String, Integer> map = new TreeMap<>(
                (s1, s2) -> s1.compareTo(s2));

        String[] words = text.split("[\\s+\\p{P}]");
        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();

            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }

        List<Map.Entry<String, Integer>> entries
                = new ArrayList<>(map.entrySet());
        entries.sort((entry1, entry2)
                -> entry1.getValue().compareTo(entry2.getValue()));

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
