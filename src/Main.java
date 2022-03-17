import java.util.*;

public class Main {
    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int n = Math.max(arr1.length, arr2.length);
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

    public static void main(String[] args) {
        compareVersion("0.1", "1.1");
    }
}
