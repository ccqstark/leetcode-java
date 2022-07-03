package 周赛.No300;

import java.util.HashMap;
import java.util.Map;

public class One {
    public String decodeMessage(String key, String message) {
        char[] letter = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Map<Character, Character> map = new HashMap<>();
        int index = 0;
        for (Character c : key.toCharArray()) {
            if (!map.containsKey(c) && c != ' ') {
                map.put(c, letter[index]);
                index++;
            }
        }
        StringBuilder plaintext = new StringBuilder();
        for (Character c : message.toCharArray()) {
            if (c == ' ') {
                plaintext.append(' ');
            } else {
                plaintext.append(map.get(c));
            }
        }
        return plaintext.toString();
    }

    public static void main(String[] args) {
        One one = new One();
        String ans = one.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
        System.out.println(ans);
    }
}
