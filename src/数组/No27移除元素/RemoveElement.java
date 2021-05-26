package 数组.No27移除元素;

public class RemoveElement {

    // 混合暴力法
    public int removeElement1(int[] nums, int val) {
        int len = nums.length;
        for (int left = 0; left < len; left++) {
            if (nums[left] == val) {
                // left位于最后一个元素时
                if (left == len - 1) {
                    return len - 1;
                }
                int right = left + 1;
                while (right <= len - 1 && nums[right] == val) right++;
                if (right == len - 1 && nums[right] == val) {
                    // right超过长度时
                    return len - (right - left);
                }
                //  把元素right处整体前移到left
                moveUp(left, right, nums, len);
                len = len - (right - left);
            }
        }
        return len;
    }

    // 该函数用于将right及后面的元素完前移到left位置
    public void moveUp(int left, int right, int[] nums, int len) {
        int step = len - 1 - right;
        for (int i = 0; i <= step; i++) {
            nums[left + i] = nums[right + i];
        }
    }

    // 双指针法
    public int removeElement2(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }

}
