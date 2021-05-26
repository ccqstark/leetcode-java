import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        hashtable.put(1,1);
        hashtable.put(1,2);
        System.out.println(hashtable.get(1));
    }

}
