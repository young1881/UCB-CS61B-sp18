package HW0;

public class BreakContinue {
    public static void windowPosSum(int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= 0) {
                continue;
            } else {
                for (int j = i + 1; j <= i + n; j++) {
                    if (j >= a.length) {
                        break;
                    }
                    a[i] += a[j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 1,-1,-1,10,5,-1 };
        int n = 2;
        windowPosSum(a, n);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
    }
}