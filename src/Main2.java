import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    static void solution(char[] origin, char[] target) {
        int n = origin.length;
        int[][] dp = new int[n][n];
        // 记录进行过修改的地方
        char[] mod = new char[n];
        Arrays.fill(mod, ' ');
        // 初始化
        if (origin[0] != target[0]) {
            dp[0][0] = 1;
            mod[0] = origin[0];
        }
        for (int i = 1; i < n; i++) {
            // 如果不相同
            if (origin[i] != target[i]) {
                boolean swap = false;
                // 寻找时候可以交换
                for (int j = 0; j < i; j++) {
                    if (mod[j] != ' ' && mod[j] != origin[i]) {
                        dp[i][i] = dp[i - 1][i - 1];
                        // System.out.println("交换了");
                        mod[j] = ' ';
                        swap = true;
                        break;
                    }
                }
                // 没有交换，只能修改
                if (!swap) {
                    dp[i][i] = dp[i - 1][i - 1] + 1;
                    mod[i] = origin[i];
                    // System.out.println("修改");
                }
            } else {
                // 相等不用操作
                dp[i][i] = dp[i - 1][i - 1];
                // System.out.println("相等不用操作");
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String origin = scan.next();
        String target = scan.next();
        solution(origin.toCharArray(), target.toCharArray());
    }
}
