package 周赛.No305;

import java.util.*;

public class Two {
    int cnt = 0;
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    boolean[] visited;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        for (int[] edge : edges) {
            List<Integer> list = map.get(edge[0]);
            if (list == null) {
                list = new ArrayList<>();
                list.add(edge[1]);
                map.put(edge[0], list);
            } else {
                list.add(edge[1]);
            }

            List<Integer> list2 = map.get(edge[1]);
            if (list2 == null) {
                list2 = new ArrayList<>();
                list2.add(edge[0]);
                map.put(edge[1], list2);
            } else {
                list2.add(edge[0]);
            }
        }
        for (int r :  restricted) {
            set.add(r);
        }
        visited = new boolean[n];

        dfs(0);
        return cnt;
    }

    public void dfs(int node) {
        if (set.contains(node) || visited[node]) {
            return;
        }
        cnt++;
        visited[node] = true;

        List<Integer> subNodes = map.get(node);
        if (subNodes != null) {
            for (int subNode : subNodes) {
                dfs(subNode);
            }
        }
    }

    public static void main(String[] args) {
        Two two = new Two();
        int n = 7;
        int[][] edges = {{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}};
        int[] restricted = {4,5};
        int ans = two.reachableNodes(n, edges, restricted);
        System.out.println("ans:" + ans);
    }
}
