package 二叉树.完全二叉树的层序遍历;

public class Main {

    int idx = 0; // 指针，当前遍历到的 zx 数组的位置
    int n; // 数组长度
    int[] zx; // 中序遍历
    int[] ans; // 结果存放的数组，层序遍历

    // 初始化
    Main(int[] zx) {
        this.zx = zx;
        this.n = zx.length;
        this.ans = new int[n];
    }

    /**
     * 其实思路就是，我们的结果数组是按层序遍历存放树节点的，那就满足：
     * 当前节点在数组的下标为 t，其左子树下标就为 2t， 右子树下标就为 2t+1
     * 利用这个存储下标规律我们写出 dfs 的递归中序遍历代码（类似普通的用root.left和root.right进行中序遍历的那种写法）
     * 那么此时遍历的节点顺序就是按照 zx 数组来的，我们用个 idx 指针来指向当前遍历到那个节点了
     * 然后我们又可以拿到了当前节点的「层序遍历编号」—— t，也就是其在 ans 数组中应该存放的下标（因为我们就是用 2t，2t+1 这个规律进行遍历的）
     * 那么每次遍历就按层序遍历编号作为下标，把当前在 zx 的 idx 下标对应的节点，写入对应的 ans 的 t 下标的位置
     * 就可以还原出层序遍历数组了！
     * 如果是后序遍历同理，调整下递归代码的顺序就行了
     */
    public void dfs(int t) {
        if (t >= n) return;
        dfs(2 * t);
        idx++;
        ans[t] = zx[idx];
        dfs(2 * t + 1);
    }

    public void printAns() {
        for (int i = 1; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] zx = new int[]{-1, 8, 4, 9, 2, 10, 5, 11, 1, 6, 3, 7};
        Main main = new Main(zx);
        main.dfs(1);
        main.printAns();
    }
}
