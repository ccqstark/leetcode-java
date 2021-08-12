package 字符串.剑指Offer05替换空格;

public class ReplaceSpace {
    public String replaceSpace(String s) {
        // 先新建一个扩容了3倍空间的字符数组
        char[] ch = new char[s.length() * 3];
        int new_size = 0;
        // 遍历原字符串，遇到空格就替换为%20
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                ch[new_size++] = '%';
                ch[new_size++] = '2';
                ch[new_size++] = '0';
            } else {
                ch[new_size++] = s.charAt(i);
            }
        }
        // 用新的字符数组新建字符串返回即可
        return new String(ch, 0, new_size);
    }
}
