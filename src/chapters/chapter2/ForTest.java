package chapters.chapter2;

public class ForTest {
    public static void main(String[] args) {
        int x, y;
        y = 20;
        for (x = 0; x < 10; x++) {
            System.out.println("значение равно " + x);
            System.out.println("значение равно " + y);
            y = y - 2;
        }

    }
}
