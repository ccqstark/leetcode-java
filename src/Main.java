import java.util.*;

public class Main {

    static void solution(int n, int q, int[][] ranges) {
        boolean[] nums = new boolean[n];
        for (int i = 0; i < q; i++) {
            for (int j = ranges[i][0]; j <= ranges[i][1]; j++) {
                nums[j - 1] = !nums[j - 1];
            }
            int cnt = 0;
            for (int k = 0; k < n; k++) {
                if (!nums[k]) cnt++;
            }
            System.out.println(cnt);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int q = scan.nextInt();
        int[][] ranges = new int[q][2];
        for (int i = 0; i < q; i++) {
            ranges[i][0] = scan.nextInt();
            ranges[i][1] = scan.nextInt();
        }
        solution(n, q, ranges);
    }
}