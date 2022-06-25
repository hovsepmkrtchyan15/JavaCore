package chapters.chepter7;

public class UseStatic {
    static int a = 3;
    static int b;

    static void meht(int x) {
        System.out.println("x = " + x);
        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }
    static {
        System.out.println("Статический блок инициализирован.");
        b = a*3;
    }

    public static void main(String[] args) {
        meht(42);
    }
}
