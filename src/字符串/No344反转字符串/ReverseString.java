package 字符串.No344反转字符串;

public class ReverseString {
    public void reverseString(char[] s) {
        // 双指针，两两交换，向中间逼近
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            s[l] ^= s[r]; // a^b的结果存放在l
            s[r] ^= s[l]; // r原本存的b，与a^b进行异或，得到a
            s[l] ^= s[r]; // l也就是a^b，与现在的r也就是存放的是a，相异或得到b，所以进行了交换
            l++;
            r--;
        }
    }
}
