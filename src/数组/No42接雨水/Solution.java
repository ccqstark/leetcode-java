package 数组.No42接雨水;

/**
 * @author ccqstark
 * @description 接雨水是非常经典与常考的题，还是hard，所以要仔细研究下
 * @date 2022/2/23 22:41
 */
public class Solution {
    // 法1：暴力双指针,时间复杂度O(n^2),空间复杂度O(1)
    public int trap1(int[] height) {
        int rain = 0;
        for (int i = 0; i < height.length; i++) {
            // 第一根和最后一根不能接雨水
            if (i == 0 || i == height.length - 1) continue;
            // 分别找出当前位置左边和右边最高的柱子
            int lHeight = height[i];
            int rHeight = height[i];
            // 暴力就暴力在直接循环找左右最大值
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > lHeight) lHeight = height[j];
            }
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > rHeight) rHeight = height[j];
            }
            // 当前柱子可以接的雨水量 = 左右最高柱子中较小的 - 当前柱子高度
            rain += Math.min(lHeight, rHeight) - height[i];
        }

        return rain;
    }

    // 法2：动态规划法，时间复杂度O(n),空间复杂度O(n)
    public int trap2(int[] height) {
        int n = height.length;
        // 数组下标i位置元素分别表示当前位置左边/右边的最大值(不包括下标i元素本身)
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        // 与法1的区别就是用dp求出左右最大值，优化了时间复杂度，但是需要额外的空间提高了空间复杂度
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        int rain = 0;
        for (int i = 1; i < n - 1; i++) {
            // 注意要判断一下接的雨水是否大于0再累加，因为有可能左右两边最大的柱子都比自身小
            int h = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (h > 0) rain += h;
        }

        return rain;
    }

    // 法3: 优化双指针,时间复杂度：O(n),空间复杂度：O(1)，可以说是最优解法了
    public int trap3(int[] height) {
        // 维护左右指针，然后边移动边更新leftMax和rightMax，表示当前left和right走过的最大值
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int rain = 0;
        // left和right最终会在所有柱子中最高点相遇，那里不会有雨水，跳出循环
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            // 不移动的那一方此时一定就在max位置，以left移动right不移动为例：
            // 此时right就在rightMax处，那么如果此时height[left]<height[right]，则一定有leftMax<rightMax
            // 此时leftMax一定就是left处左右最高柱子中较小的那个
            // （尽管此时rightMax不是真正的left右侧的最高柱子，但是leftMax比它小了的话说明也一定会小于右边真正最高的那条柱子）
            if (height[left] < height[right]) {
                // 然后积累雨水的计算就还是左右最高柱子中的较矮者去减去当前高度
                rain += leftMax - height[left];
                left++;
            } else { // 反之同理
                rain += rightMax - height[right];
                right--;
            }
        }
        // 此解法巧妙就巧妙在利用两个指针和max变量的比较可以直接得到当前位置左右最高柱子中的较矮者
        // 直接理解可能比较难懂，实际模拟一下会好很多
        return rain;
    }

    // 法4：单调栈，时空复杂度都是O(n)，略
}
