package 拓扑排序.No210课程表II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ccqstark
 * @description 这题目其实可以转换为求该图的拓扑序列，课程就是图的节点，先修关系就是边，最后如果出现了环求不出拓扑序列就是无法修完课的情况
 * @date 2022/6/26 19:57
 */
class Solution {

    // 边集合，下标为节点值，对应列表为邻居节点值
    List<List<Integer>> edges;
    // 状态，0-未搜索；1-搜索中；3-已搜索
    int[] visited;
    // 是否有效（无效就是有环）
    boolean valid;
    // 拓扑序列（模拟栈）
    int[] result;
    // 用于模拟栈的栈顶
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 初始化
        edges = new ArrayList<>();
        visited = new int[numCourses];
        valid = true;
        result = new int[numCourses];
        index = numCourses - 1;
        // 构造边集合
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            edges.get(p[1]).add(p[0]);
        }

        // 开始dfs遍历，注意要从"未搜索"状态的节点开始
        for (int i = 0; i < numCourses && valid ==true; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        // 出现了环，返回空数组
        if (!valid) {
            return new int[0];
        }
        // 无环，则返回该图的拓扑序列
        return result;
    }

    // 深度优先搜索
    public void dfs(int u) {
        // 改变状态
        visited[u] = 1;
        // 获取邻居节点
        List<Integer> neighbor = edges.get(u);
        for (Integer v : neighbor) {
            // 如果为"未搜索"，则继续dfs
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                // 如果为"搜索中"，证明出现了环
                valid = false;
                return;
            }
        }
        visited[u] = 2;
        // 搜索完成后入栈，最终从栈顶到栈底就是拓扑序列
        result[index--] = u;
    }
}
