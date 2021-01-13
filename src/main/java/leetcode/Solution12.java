package leetcode;

public class Solution12 {
    public static String intToRoman(int num) {
        String[][] a1 = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "DM"},
                {"", "M", "MM", "MMM"}
        };
        int shang = num, digit = 0;
        String result = "";
        while (shang > 0) {
            result = a1[digit++][shang % 10] + result;
            shang = shang / 10;
        }
        return result;
    }
}
