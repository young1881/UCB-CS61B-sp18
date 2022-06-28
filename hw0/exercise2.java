package HW0;

public class exercise2 {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int max_number = m[0];
        int i = 1;
        while (i < m.length) {
            if (m[i] > max_number) {
                max_number = m[i];
            }
            i++;
        }
        return max_number;
    }
    public static void main(String[] args) {
        int[] numbers = new int[] { 9, 2, 15, 2, 22, 10, 6 };
        System.out.println(max(numbers));     
    }
}
