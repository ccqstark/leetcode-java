package 哈希表.No242有效的字母异位词;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        // 数组下标是字母的相对顺序，数组的值为字母出现的次数
        int[] record = new int[26];
        // 统计各字母在s的出现次数
        for (char c : s.toCharArray()) {
            record[c - 'a'] += 1;
        }
        // 若字母也在t出现，每出现一个，对应位置的数量-1
        for (char c : t.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        // 如果有不为0的出现次数，说明有字母在两个字符串之间的出现次数不同，因此也不是异位词
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
