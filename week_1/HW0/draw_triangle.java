package HW0;

public class draw_triangle {
    public static void make_triangle(int length){
        int stars = 0;
        while (stars < length) {
            int i = 0;
            while (i <= stars) {
                System.out.print("*");
                i++;
            }
            System.out.print("\n");
            stars++;
        }
    }
    
    public static void main(String[] args) {
        make_triangle(10);
    }
}
