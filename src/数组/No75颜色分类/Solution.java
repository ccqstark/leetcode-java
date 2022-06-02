package 数组.No75颜色分类;

public class Solution {

    // 法1: 单指针法
    public void sortColors(int[] nums) {
        // 表示连续的0或1的末端，相当于分界线
        int head = 0;
        // 先处理0，把0都放到head处，此时的head是0和1的分界线
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, head, i);
                head++;
            }
        }
        // 再处理1，把1都放到head处，此时的head是1和2的分界线
        for (int i = head; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, head, i);
                head++;
            }
        }
    }

    // 法2: 双指针法
    public void sortColors2(int[] nums) {
        // 定义两个指针，分别为"01"分界和"12"分界线
        int p0 = 0, p1 = 0;
        // 只需要遍历一次
        for (int i = 0; i < nums.length; i++) {
            // 碰到"0"的情况比较特殊
            if (nums[i] == 0) {
                swap(nums, p0, i);
                // 如果p0和p1错开你，就要把i和p1位置的再交换一次，因为上面一步交换中，p0位置一定是个"1"，所以要还给p1
                if (p0 < p1) {
                    swap(nums, p1, i);
                }
                // 两个指针要一起向后移动
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                // 碰到"1"的情况和法1一样
                swap(nums, p1, i);
                p1++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
