package 回溯.No131分割回文串;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<List<String>> result = new ArrayList<>(); // 最终结果集
    LinkedList<String> path = new LinkedList<>(); // 当前结果集，习惯命名path

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String s, int startIndex) {

        // 已经到达字符串尾
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 构造的回溯树横向是从startIndex开始向右递增改变切分的位置，纵向是切完一段后切下一段
        for (int i = startIndex; i < s.length(); i++) {
            // 切子字符串，注意因为substring函数最后一个字符是不包括的，所以要+1
            String substring = s.substring(startIndex, i + 1);
            if (isPalindrome(substring)) {
                // 如果为回文串就加入到当前的path集
                path.add(substring);
                // 回溯要i+1，切分下一段
                backtracking(s, i + 1);
                path.removeLast();
            }
            // 否则可以跳过当前这种切法，就没有做任何操作了
        }
    }

    // 判断是否回文 双指针法
    public boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
