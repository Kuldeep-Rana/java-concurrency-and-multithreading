import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {
        int k = 3;
        List<Integer> songIds = new ArrayList<>();
        int[] arr = {58, 20, 58, 45, 81, 32, 58, 45, 11, 79, 98, 45, 81, 58, 63};
        //solution 1
        var map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int id = arr[i];
          if (map.containsKey(id)) {
                int count = map.get(id) + 1;
                map.put(id, count);
            } else {
                map.put(id, 1);
            }
        }
        System.out.println(map);

        var map1 = map.values().stream().sorted(Comparator.reverseOrder()).limit(3).toList();
        System.out.println(map1);

        //solution 2
    }
}
