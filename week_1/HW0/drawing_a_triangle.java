package HW0;

public class drawing_a_triangle {
    public static void main(String[] args) {
        int stars = 0;
        while (stars < 5) {
            int i = 0;
            while (i <= stars) {
                System.out.print("*");
                i++;
            }
            System.out.print("\n");
            stars++;
        }
    }

}
