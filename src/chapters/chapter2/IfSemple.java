package chapters.chapter2;

public class IfSemple {

    public static void main(String[] args) {
        int x, y;
        x = 10;
        y = 20;
        if (x < y) {
            System.out.println("x менше y");
        }

        x = x * 2;
        if (x == y) {
            System.out.println("x равно y");
        }
        x = x * 2;
        if (x > y) {
            System.out.println("x больше y");
        }
        if (x == y) {
            System.out.println("нечего не будет");
        }

    }

}
