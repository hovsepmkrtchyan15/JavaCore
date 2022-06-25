package chapters.chepter7;

public class PassArray {
    static void vaTest(String msg, int...v) {
        System.out.print(msg + v.length
                + " Содержимое: ");
        for (int x : v) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        vaTest("Один параметр переменной длины: ", 10);
        vaTest("Три параметрa переменной длины: ", 2, 37, 63);
        vaTest("Без параметров переменной длины: ");

    }
}
