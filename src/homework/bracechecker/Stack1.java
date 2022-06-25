package homework.bracechecker;



public class Stack1 {
    private  char[] stck=new char[10];
    public int tos;

    Stack1() {
        tos = -1;

    }

    void push(char item) {

        if (tos == stck.length-1) {


            System.out.println("Cтeк заполнен.");
        } else {
            stck[++tos] = item;
        }

    }

    char pop() {
        if (tos < 0) {
            System.out.println("Cтeк не загружен.");
            return 0;
        } else return stck[tos--];
    }
}
