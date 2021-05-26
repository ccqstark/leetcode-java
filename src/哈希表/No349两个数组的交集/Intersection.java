package 哈希表.No349两个数组的交集;

import java.util.HashSet;

public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {

        // null数组或长度为0的数组
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        // 建立2个hashset，一个用来存集合1的元素，一个用来存交集
        HashSet<Integer> eleset1 = new HashSet<>();
        HashSet<Integer> reset = new HashSet<>();

        // 遍历集合1，把集合1中出现的元素放在eleset1中
        for (int ele : nums1) {
            eleset1.add(ele);
        }

        // 遍历集合2并找出交集（同时有去重功能）
        for (int ele : nums2) {
            if (eleset1.contains(ele)) {
                reset.add(ele);
            }
        }

        // 转为数组
        int[] reArr = new int[reset.size()];
        int index = 0;
        for (int ele : reset) {
            reArr[index++] = ele;
        }

        return reArr;
    }

}
