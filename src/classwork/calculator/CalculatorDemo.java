package classwork.calculator;

public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator myCalculator1 = new Calculator();
        System.out.println(myCalculator1.plus(10, 20));
        System.out.println(myCalculator1.minus(10, 20));
        System.out.println(myCalculator1.multiply(10, 20));
        System.out.println(myCalculator1.divide(10, 20));
    }
}
