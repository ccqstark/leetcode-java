package 综合.No69x的平方根;

public class Solution {
    // 推荐使用：二分查找法
    public int mySqrt(int x) {
        int l = 0, r = x, ans = 0;
        while (l <= r) {
            // 这里最好养成习惯，避免(l+r)/2溢出的写法
            int mid = l + (r - l) / 2;
            // 为了找到平方根小于x的尽可能大的数，所以此时要向右查找
            if ((long) (mid) * (mid) <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
