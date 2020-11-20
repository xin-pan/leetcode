public class Solution7ReverseInteger {
    public static int reverse(int x) {
        long negativeReverse = x < 0 ? -1 : 1;
        long absX = Math.abs(x);
        long result = 0;
        while (absX > 0) {
            result = result * 10 + absX % 10;
            absX = absX / 10;
            System.out.println(result);
        }
        result *= negativeReverse;

        return result > (long) Integer.MAX_VALUE || result < (long) Integer.MIN_VALUE ? 0 : Math.toIntExact(result);
    }
}
