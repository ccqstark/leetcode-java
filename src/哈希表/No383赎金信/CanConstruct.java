package 哈希表.No383赎金信;

import java.util.HashMap;

public class CanConstruct {

    public boolean canConstruct1(String ransomNote, String magazine) {

        // hash解法
        // 遍历magazine获得字母集map
        HashMap<Character, Integer> map = new HashMap<>();
        char[] magazineChar = magazine.toCharArray();
        for (char c : magazineChar) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        // 遍历ransomNote查看map中是否有足够数量的字母
        char[] ransomNoteChar = ransomNote.toCharArray();
        for (char c : ransomNoteChar) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }

        return true;
    }


    public boolean canConstruct2(String ransomNote, String magazine) {

        // 数组解法
        int[] arr = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            int letter = magazine.charAt(i) - 'a';
            arr[letter]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int letter = ransomNote.charAt(i) - 'a';
            if (--arr[letter] < 0) {
                return false;
            }
        }

        return true;
    }

}
