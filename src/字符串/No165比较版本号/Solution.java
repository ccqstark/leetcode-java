package 字符串.No165比较版本号;

public class Solution {
    // 法1：分割字符串
    public static int compareVersion1(String version1, String version2) {
        // 注意，split函数里的参数是正则，如果要表示.要用\\.
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int n = Math.max(arr1.length, arr2.length);
        // 就是一个个比较，较短的那个后面补0
        for (int i = 0; i < n; i++) {
            String c1 = i > arr1.length - 1 ? "0" : arr1[i];
            String c2 = i > arr2.length - 1 ? "0" : arr2[i];
            int v1 = Integer.parseInt(c1);
            int v2 = Integer.parseInt(c2);
            if (v1 > v2) return 1;
            else if (v1 < v2) return -1;
        }
        return 0;
    }

    // 法2：双指针（空间复杂度较优）
    public int compareVersion2(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            // 把字符串转为十进制数再比较
            while (i < n && version1.charAt(i) != '.') {
                x = x * 10 + (version1.charAt(i) - '0');
                i++;
            }
            i++;
            int y = 0;
            // 字符串2也同理
            while (j < m && version2.charAt(j) != '.') {
                y = y * 10 + (version2.charAt(j) - '0');
                j++;
            }
            j++;
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }

}
