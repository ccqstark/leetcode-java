package 数组.No4寻找两个正序数组的中位数;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        // 两个数组总长度若为奇数
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            // 中位数就是第k个数
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            // 若为偶数，则是中间两个数的平均数
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    /**
     * 核心方法，拿到两个数组中的第k小的数
     */
    public int getKthElement(int[] nums1, int[] nums2, int k) {
        // 初始化一些变量，包括长度、当前index、第k小的数
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                // nums1已经用完，就在nums2中把剩下的k用完
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                // num2已经用完，就在nums1中把剩下的k用完
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                // 若只需再找一个数，就在两个数组当前index中找较小的那个
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2; // 把当前掰成两半，分别给nums1和nums2用
            // min是为了防止数据越界，-1是因为减去才是下标
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            // 各数组得到新下标的对应的值pivot
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            // pivot1小于pivot2，则可以淘汰nums1下标处于[index1, newIndex1]对应的数
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else { // 同理，否则淘汰掉nums2下标处于[index2, newIndex2]对应的数
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
