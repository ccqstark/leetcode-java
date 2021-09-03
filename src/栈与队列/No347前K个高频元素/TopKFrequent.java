package 栈与队列.No347前K个高频元素;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        // 统计频率
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 把map中的每条项目独立拿出来
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        // 优先队列，降序
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) ->
                o2.getValue() - o1.getValue()
        );
        // 放入优先队列中，自动排序
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
        }
        // 弹出前k个放入结果集
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().getKey();
        }

        return result;
    }
}
