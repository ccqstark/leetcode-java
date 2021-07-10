package 哈希表.No454四数相加II;

import java.util.HashMap;

public class FourSumCount {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        // 用于存放A和B中两两之和的组合数
        HashMap<Integer, Integer> hashMap = new HashMap();
        // 遍历A和B，把A和B之和作为key，把这个和出现的次数作为value
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                if (hashMap.containsKey(sum)) {
                    hashMap.replace(sum, hashMap.get(sum) + 1);
                } else {
                    hashMap.put(sum, 1);
                }
            }
        }

        // 存放和为0的组合数
        int count = 0;
        // 遍历C和D，找出 0-(C+D) 的数量
        for (int i : nums3) {
            for (int j : nums4) {
                int sum = i + j;
                if (hashMap.containsKey(-sum)) {
                    count += hashMap.get(-sum);
                }
            }
        }

        return count;
    }

}
