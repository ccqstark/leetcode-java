package 回溯.No332重新安排行程;

import java.util.*;

public class Solution {
    private LinkedList<String> result = new LinkedList<>();
    // Map<出发地点, Map<到达地点, 航班次数>>
    private Map<String, Map<String, Integer>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        // 遍历tickets填充map
        for (List<String> t : tickets) {
            Map<String, Integer> temp;
            if (map.containsKey(t.get(0))) {
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0)+1);
            } else {
                // 因为key要排序，有多个结果时优先使用字母顺序靠前的，所以用TreeMap
                temp = new TreeMap<>();
                temp.put(t.get(1), 1);
                map.put(t.get(0), temp);
            }
        }
        // 一定是JFK开头
        result.add("JFK");
        backtracking(tickets.size());

        return result;
    }


    boolean backtracking(int ticketNum) {
        // 如果票数+1等于经历的站点数，说明每张票都用了
        if (ticketNum + 1 == result.size()) {
            return true;
        }
        // 拿到路径的最后一个
        Map<String, Integer> lastMap = map.get(result.getLast());
        // 这里要判空，因为又可能某个站点从未作为起始点
        if (lastMap!=null) {
            // Map.Entry来遍历key和对应的value
            for (Map.Entry<String, Integer> m : lastMap.entrySet()) {
                int count = m.getValue();
                if (count > 0) {
                    // 回溯，既要把航班次数-1，又要在路径上添加与删除
                    // 由于我们用了TreeMap，所以此时的遍历的key已经是排好序的了
                    // 所有最后答案会优先返回字典序靠前的结果
                    m.setValue(count - 1);
                    result.add(m.getKey());
                    if (backtracking(ticketNum)) {
                        return true;
                    }
                    result.removeLast();
                    m.setValue(count);
                }
            }
        }

        return false;
    }
}
