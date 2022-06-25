package chapters.chepter7;

public class Overload {
    void test() {
        System.out.println("Пapaмeтpы отсутствуют");
    }

    void test(int a) {
        System.out.println("a: " + a);
    }

    void test(int a, int b) {
        System.out.println("a + b :" + a + b);
    }
    double test(double a){
        System.out.println("doubol a: " + a);
        return a*a;
    }


}
