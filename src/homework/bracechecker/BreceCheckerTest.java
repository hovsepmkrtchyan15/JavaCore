package homework.bracechecker;


public class BreceCheckerTest {
    public static void main(String[] args) {
        String text = "[[[[[[[[[[[[[[[[[[[[[from {Java})(";
        BraceChecker bc = new BraceChecker (text);
        bc.check();

    }
}
