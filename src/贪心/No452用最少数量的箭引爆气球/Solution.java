package 贪心.No452用最少数量的箭引爆气球;

import java.util.Arrays;

public class Solution {
    public int findMinArrowShots(int[][] points) {

        if (points.length == 0){
            return 0;
        }

        // 注意这里要排序的数可能接近int上下限，如果直接 return a[0]-b[0] 会出错
        Arrays.sort(points, (a, b)->{
            return Integer.compare(a[0], b[0]);
        });

        int arrowNum = 1;
        for (int i = 1; i < points.length ; i++) {
            // 当前的左边界大于上一个的右边界，重新起一组，所用箭数+1
            if (points[i][0] > points[i-1][1]){
                arrowNum++;
            }else {
                // 每次要更新为当前组的最小右边界
                points[i][1] = Math.min(points[i][1], points[i-1][1]);
            }
        }

        return arrowNum;
    }
}
