package homework.bracechecker;


public class BraceChecker {
    String text;

    BraceChecker(String text) {

        this.text = text;
    }
    void check() {
        Stack1 myStack = new Stack1();
        for (int i = 0; i < text.length(); i++) {
            char breceOpen = text.charAt(i);
            char z;
            switch (breceOpen) {
                case '(':
                case '[':
                case '{':
                    myStack.push(breceOpen);
                    break;
                case ')':
                    if (myStack.tos != -1) {
                        z = myStack.pop();
                        if (z != '(') {
                            System.out.println("Error: opened " + z + " but closed " + breceOpen + " at " + i);
                        }

                    } else System.out.println("Error: closs " + breceOpen + " at " + i + "  dont open");
                    break;
                case ']':
                    if (myStack.tos != -1) {
                        z = myStack.pop();
                        if (z != '[') {
                            System.out.println("Error: opened " + z + " but closed " + breceOpen + " at " + i);
                        }

                    } else System.out.println("Error: closs " + breceOpen + " at " + i + "  dont open");
                    break;
                case '}':
                    if (myStack.tos != -1) {
                        z = myStack.pop();
                        if (z != '{') {
                            System.out.println("Error: opened " + z + " but closed " + breceOpen + " at " + i);
                        }

                    } else System.out.println("Error: closs " + breceOpen + " at " + i + "  dont open");
                    break;
            }
        }
        if (myStack.tos != -1) {
            for (int i = myStack.tos; i > -1; i--) {
                System.out.println("Error: aut of " + myStack.pop() + " at " +  " and dont closs");
            }

        }

    }
}








