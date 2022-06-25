package chapters.chapter3;

public class BooleanTest {
    public static void main(String[] args) {
        boolean b;
        b = false;
        System.out.println("b равно " + b);
        b = true;
        System.out.println("b равно " + b);
        //значение типа boolean может управлять оператором if
        if (b) {
            System.out.println("этот код выполняется");
        }
        b = false;
        if (b) {
            System.out.println("этот код не выполняутся");
        }
        System.out.println("10>9 равно " + (10 > 9));
    }
}
