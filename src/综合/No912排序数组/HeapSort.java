package 综合.No912排序数组;

public class HeapSort {

    public int[] MySort(int[] arr) {
        heapSort(arr);
        return arr;
    }

    // 堆排序
    public void heapSort(int[] arr) {
        // 创建大根堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            // 从下往上调整，保证每个父节点都大于子节点
            adjustHeap(arr, i, arr.length);
        }

        // 堆排序
        // 就是利用大根堆的特性，每次得出堆中的最大数，然后再一步步缩减堆的范围
        for (int i = arr.length - 1; i >= 0; i--) {
            // 把最顶端的数（也就是当前堆中的最大数）与当前堆最末尾的数进行交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 再度调整堆
            adjustHeap(arr, 0, i);
        }
    }

    // 调整堆的方法
    public void adjustHeap(int[] arr, int parent, int length) {
        // 先用temp存第一个父节点
        int temp = arr[parent];
        // 左子节点的下标是这样算的
        int lChild = 2 * parent + 1;

        // 循环直到子节点超出范围（length是开区间）
        while (lChild < length) {

            // 试试右子节点会不会更大一点
            int rChild = lChild + 1;
            if (rChild < length && arr[rChild] > arr[lChild]) {
                lChild = rChild;
            }

            // 如果temp大于等于两个子节点，就可以退出循环
            if (temp >= arr[lChild]) {
                break;
            }

            // 如果子节点有更大的值，就放到当前父节点
            arr[parent] = arr[lChild];

            // 向下继续
            parent = lChild;
            lChild = 2 * parent + 1;
        }
        // 把temp放到新的位置
        arr[parent] = temp;
    }
}
