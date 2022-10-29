package 周赛.No306;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Two {
    public int edgeScore(int[] edges) {
        Map<Integer, Long> map = new TreeMap<>();
        for (int i = 0; i < edges.length; i++) {
            Long old = map.getOrDefault(edges[i], 0L);
            map.put(edges[i], old + i);
        }
        Long maxVal = 0L;
        int maxNode = edges[0];
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
                maxNode = entry.getKey();
            }
            else if (entry.getValue().equals(maxVal) && entry.getKey() < maxNode) {
                maxNode = entry.getKey();
            }
        }

        return maxNode;
    }
}
