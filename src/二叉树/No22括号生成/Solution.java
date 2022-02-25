package 二叉树.No22括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * 看成树的dfs，其实就是回溯+剪枝
 */
public class Solution {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, "", 0, 0);
        return res;
    }

    public void dfs(int n, String s, int open, int close) {
        // 如果开括号数量大于一半，或者闭括号数量大于开括号，那就说明无法匹配，剪枝
        if (open > n || close > open) return;

        // 括号数量一共到达2n（n对），加入结果集
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }

        // 递归下去，分别是加左括号和右括号
        dfs(n, s + "(", open + 1, close);
        dfs(n, s + ")", open, close + 1);
    }
}
