package 周赛.No306;


public class Three {

    // 标记数字是否被使用的数组
    boolean[] used = new boolean[9];

    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        char[] chars = pattern.toCharArray();
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == 'I') {
                // 统计连续的 I 的个数
                int charInum = 0;
                while (i < chars.length && chars[i] == 'I') {
                    charInum++;
                    i++;
                }
                // 如果刚好到末尾了，要多一位数，因为"DI"字符的数量要比实际生成的数字量少1
                if (i == chars.length) {
                    sb.append(increase(charInum + 1));
                    break;
                }
                // 拼接升序序列
                sb.append(increase(charInum));
            } else if (chars[i] == 'D') {
                // 统计连续的 D 的个数
                int charDnum = 0;
                while (i < chars.length && chars[i] == 'D') {
                    charDnum++;
                    i++;
                }
                // 如果刚好到末尾了，数量和上面一样要+1，而且由于后面没有了，所以不用考虑为降序而空一位，offset就为0
                if (i == chars.length) {
                    sb.append(decrease(charDnum + 1, 0));
                    break;
                }
                // 拼接降序序列
                sb.append(decrease(charDnum, 1));
            }
        }

        return sb.toString();
    }

    /**
     * 获取未使用的最小升序序列
     */
    public String increase(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (!used[i]) {
                sb.append(i + 1);
                used[i] = true;
                num--;
                if (num == 0) break;
            }
        }
        return sb.toString();
    }

    /**
     * 获取未使用的最小降序序列
     */
    public String decrease(int num, int offset) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (!used[i]) {
                // offset只有两种可能，为1或为0
                // 为1说明D后面有I，为后面升序准备，所以空出一个
                if (offset > 0) {
                    offset--;
                } else {
                    sb.append(i + 1);
                    used[i] = true;
                    num--;
                    if (num == 0) break;
                }
            }
        }
        // 从大到小，所以要翻转一下
        return sb.reverse().toString();
    }

}
