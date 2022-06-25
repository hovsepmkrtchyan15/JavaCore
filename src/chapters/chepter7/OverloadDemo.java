package chapters.chepter7;

public class OverloadDemo {
    public static void main(String[] args) {
        Overload ob = new Overload();
        double result;
        ob.test();
        ob.test(10);
        ob.test(12,56);
        result = ob.test(124.25);
        System.out.println("Результат вызова ob.test(124.25): " + result);

    }
}
