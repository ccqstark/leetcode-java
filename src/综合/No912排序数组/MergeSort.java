package 综合.No912排序数组;

public class MergeSort {

    public int[] MySort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    // 归并排序
    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        // 算出中间位置，并进行递归
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        // 定义指针、临时数组等变量
        int i = l, j = mid + 1;
        int[] tmp = new int[r - l + 1];
        int cnt = 0;
        // 利用双指针将i、j中较小的数放入临时数组
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        // 把i、j中剩下的直接按顺序放入
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }
        while (j <= r) {
            tmp[cnt++] = nums[j++];
        }

        // 将排好序的临时数组中的元素，迁移到正式数组中
        for (int k = 0; k < r - l + 1; k++) {
            nums[l + k] = tmp[k];
        }
    }

}
