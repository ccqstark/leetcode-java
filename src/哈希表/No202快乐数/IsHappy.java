package 哈希表.No202快乐数;

import java.util.HashSet;

public class IsHappy {
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        int sum = 0;
        while (n != 1) {
            // 遇到重复的数说明会陷入死循环
            if (hashSet.contains(n)) {
                return false;
            }
            hashSet.add(n);

            // 计算sum
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }

            n = sum;
            sum = 0;
        }

        return true;
    }
}
