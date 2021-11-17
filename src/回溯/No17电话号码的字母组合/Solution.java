package 回溯.No17电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> result = new ArrayList<>();
    // 电话上数字与字母的对应map
    String[] letterMap = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz", // 9
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtracking(0, digits, "");
        }
        return result;
    }

    public void backtracking(int index, String digits, String combine) {
        // 给定字符串的数字都遍历完了，加入到结果集中
        if (index == digits.length()) {
            result.add(combine);
            return;
        }

        int number = digits.charAt(index) - '0'; // 拿到当前数字都int形式
        String nowLetterStr = letterMap[number]; // 拿到数字对应的字母集
        for (int i = 0; i < nowLetterStr.length(); i++) { // 遍历字母集
            // 隐式回溯
            backtracking(index + 1, digits, combine + nowLetterStr.charAt(i));
        }

    }

}
