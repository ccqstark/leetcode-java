package 贪心.No406根据身高重建队列;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 先根据身高h进行从大到小进行排序
        Arrays.sort(people, (a, b) -> {
            // 如果h一样，就按k从小到大排
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        LinkedList<int[]> queue = new LinkedList<>();

        // 按k插入到链表指定下标
        for(int[] person : people){
            queue.add(person[1], person);
        }

        // 注意这里要指出返回的是二维int数组类型，因为原方法返回的是Object[]，无法强转
        return queue.toArray(new int[people.length][]);
    }
}
