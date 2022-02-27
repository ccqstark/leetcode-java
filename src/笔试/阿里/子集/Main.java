package 笔试.阿里.子集;
/**
 * 题目链接：https://www.nowcoder.com/questionTerminal/a55198d2e65746009110226f2f6c8533
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 读入数据组数
        int groupNum = sc.nextInt();
        for (int i = 0; i < groupNum; i++) {
            // 读入物品数
            int objectNum = sc.nextInt();
            // 用一个二维数组来存储一组物品的x和y值
            int[][] nums = new int[objectNum][2];
            for (int j = 0; j < objectNum; j++) {
                nums[j][0] = sc.nextInt();
            }
            for (int j = 0; j < objectNum; j++) {
                nums[j][1] = sc.nextInt();
            }
            // 核心函数
            int ans = findObject(nums);
            System.out.println(ans);
        }
    }

    // 核心函数
    public static int findObject(int[][] nums) {

        // 排序，对x升序排，如果x相同的话y从大到小排，为的是防止重复统计x（下面的逻辑中如果y降序就不会被统计下去，从而达到排除重复x的效果）
        Arrays.sort(nums, (o1, o2) -> {
            if (o1[0] > o2[0]) return 1;
            else if (o1[0] < o2[0]) return -1;
            else {
                if (o1[1] < o2[1]) return 1;
                else return -1;
            }
        });
        // 此时我们对x已经排序好了，x已经保持是单调非递减，所以只需要关注y即可，我们要找出y中的最长单调子序列
        // 把y单独提取出来
        int[] y = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            y[i] = nums[i][1];
        }
        // 用于存放严格单调的、被选出来的数
        int[] tails = new int[y.length];
        // 表示被选出来的数的长度，也就是最终的答案
        int tailsLen = 0;
        // 遍历所有的y
        for (int num : y) {
            // 这里用二分法查找当前num对应在单调序列的位置
            int l = 0, r = tailsLen;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (num > tails[mid]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            // 有可能会覆盖之前的数，但是不影响最终的长度，我们只关心最终的长度
            tails[l] = num;
            // 最终比序列中现有的所有数都大，那就可以扩展序列的长度
            if (tailsLen == l) {
                tailsLen++;
            }
        }
        return tailsLen;
    }

}
