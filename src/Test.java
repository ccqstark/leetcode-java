import java.util.*;

public class Test {

    static void solution(String str) {
        int cnt = 0;
        boolean loop = true;
        int start = 0;
        while (loop) {
            for (int i = start; i < str.length() - 1; i++) {
                int j = i + 1;
                if (str.charAt(i) == 'a' && str.charAt(j) == 'b') {
                    str = str.substring(0, i) + "bba" + str.substring(j + 1);
                    cnt++;
                    start = i + 2;
                    System.out.println(str);
                    break;
                }
                if (j == str.length() - 1) {
                    System.out.println(cnt);
                    loop = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String str = sc.next();
        solution("aab");
    }
}