package 数组.剑指Offer40最小的k个数;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 看到这题可以联想到No215数据中的第K个最大元素，都是topK问题，解法思路类似
 * 一般都是"大小根堆"或"快排变种（快选）"两种思路
 */
public class Solution {

    // 法1：大根堆
    public int[] getLeastNumbers(int[] arr, int k) {

        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        // 默认为小根堆，需要重写比较方法
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);

        // 遍历数组，如果堆的size小于k就可以直接放进去
        // 如果size大于等于k，再看如果比堆顶还小，就poll堆顶再放入
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        // 最后把堆中数据取出放入数据即可
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = pq.poll();
        return res;
    }

    // 法2：快排变种


}
