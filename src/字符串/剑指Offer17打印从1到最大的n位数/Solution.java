package 字符串.剑指Offer17打印从1到最大的n位数;

// 这题本来是来考大数的，可是力扣上却把它简单化了，返回居然是int[]
// 如果用简单做法的话这题就失去了意义了，面试中也不会让你那样做的，所以下面是大数做法，蛮难的
public class Solution {

    int[] res; // 用于存储答案
    // start表示该数字当前左边界，这个左边界意思是指当前数字最高位对应的char数组下标。如n=2时，1~9左边界为1，10~99左边界为0
    // nine表示当前数字中出现了多少个9，如果出现1个9，左边界就要向左移1位。例如第1次出现“9”是在9这个数字出现的时候，此时nine++变为1
    // 进入下次递归n为2，nine为1，start为1，此时start就要-1，以便统计二位数字
    // count用于计数当前添加到结果集中的元素个数，n只是把题目的输入提升为全局变量
    int nine = 0, count = 0, start, n;
    // num当前构造出来的数，loop是排好序的0-9的字符集合，用于循环递归来构造当前数，才能使得最后结果集中的元素是从小到大顺序的
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int) Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }

    void dfs(int x) {
        // x == n 结束并处理结果，因为num下标最大到n-1
        if (x == n) {
            // 得到当前数num的字符串形式，String.valueOf(num)是把char数组转为String，substring通过start去除前面的0
            String s = String.valueOf(num).substring(start);
            // 如果不为"0"（因为是从1开始的），那么放到结果集中，计数器++，因为力扣题目要求的是int[]，所以还需要转换一下
            if (!s.equals("0")) res[count++] = Integer.parseInt(s);
            // 需要进位，左边界左移，"n - start == nine"表示当前的数每一位都是9了
            if (n - start == nine) start--;
            return;
        }

        // 遍历数组，里面都是按顺序的0-9字符
        for (char i : loop) {
            if (i == '9') nine++; // 遇到9要计数
            num[x] = i; // 修改当前数num的x位（也就是当前递归层对应的位）
            dfs(x + 1); // 往下递归
        }
        nine--; // 回溯
    }
}
