package 数组.No59螺旋矩阵II;

public class GenerateMatrix {

    // 推荐：由螺旋矩阵I演变而来的更好懂版本，也就是上下左右收缩边界法
    public int[][] generateMatrix1(int n) {
        int cnt = 1;
        int[][] matrix = new int[n][n];
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            for (int i = left; i <= right; i++) matrix[up][i] = cnt++;
            if (++up > down) break;
            for (int i = up; i <= down; i++) matrix[i][right] = cnt++;
            if (--right < left) break;
            for (int i = right; i >= left; i--) matrix[down][i] = cnt++;
            if (--down < up) break;
            for (int i = down; i >= up; i--) matrix[i][left] = cnt++;
            if (++left > right) break;
        }
        return matrix;
    }

    public int[][] generateMatrix2(int n) {
        // 矩阵本体
        int[][] matrix = new int[n][n];
        // 横行和纵向开始填充的起始点
        int startx = 0, starty = 0;
        // 循环次数
        int loop = n / 2;
        // n为奇数时矩阵的中间格
        int mid = n / 2;
        // 用来填充的数字，从1开始
        int count = 1;
        // 每列或每行在循环一次后，下一次循环时要填充的元素个数会减少2，用这个变量来记录当前减少的大小
        int offset = 1;
        // 填充时用的指针，i为行，j为列
        int i, j;

        while (loop-- != 0) {
            // 指针置于起始位置
            i = startx;
            j = starty;

            // 上行，从左到右
            for (j = starty; j < starty + n - offset; j++) {
                matrix[i][j] = count++;
            }

            // 右列，从上到下
            for (i = startx; i < startx + n - offset; i++) {
                matrix[i][j] = count++;
            }

            // 下行，从右到左
            for (; j > starty; j--) {
                matrix[i][j] = count++;
            }

            // 左列，从下到上
            for (; i > startx; i--) {
                matrix[i][j] = count++;
            }

            // 循环一次后，下一次起始位置+1
            startx++;
            starty++;
            // 下一次循环时，每行/列填充的个数要-2
            offset += 2;
        }

        // n为奇数要填中间一格
        if (n % 2 == 1) {
            matrix[mid][mid] = count;
        }

        return matrix;
    }

}
