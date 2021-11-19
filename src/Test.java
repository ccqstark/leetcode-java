import com.sun.media.sound.SoftTuning;
import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.restoreIpAddresses("1111");
        test.print();
    }


    List<String> result = new ArrayList<>();
    int pointNum = 0;

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return result;
        }
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String s, int startIndex) {

        if (pointNum == 3) {
            if (isValid(s.substring(startIndex))) {
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length() - 1; i++) {
            if (isValid(s.substring(startIndex, i + 1))) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                pointNum++;
                backtracking(s, i + 2);
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }
        }

    }

    public boolean isValid(String s) {
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }
        if (Long.parseLong(s) > 255) {
            return false;
        }
        return true;
    }

    public void print() {
        for (String re : result) {
            System.out.println(re);
        }
    }

}
