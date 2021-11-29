package 贪心.No860柠檬水找零;

/**
 * @author ccqstark
 * @description 这里需要注意的是有面值的，分别就是5元，10元，20元
 * @date 2021/11/29 20:57
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        // 因为找零只会用到5元和10元面值，20元就不用管了，这2个变量表示拥有这个面值的纸币的数量
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                // 5元的直接收下
                case 5:
                    five++;
                    break;
                // 10元的找5元
                case 10:
                    if (five > 0) {
                        five--;
                        ten++;
                    } else {
                        return false;
                    }
                    break;
                // 20元的优先还10+5，再看有没有5+5+5，因为10元只能用在这，所以要优先使用，这是一个贪心的点
                case 20:
                    if (ten > 0 && five > 0) {
                        ten--;
                        five--;
                    } else if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }
}
