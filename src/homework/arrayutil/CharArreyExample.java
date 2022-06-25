package homework.arrayutil;

public class CharArreyExample {
    public static void main(String[] args) {
        char[] chars = {'j', 'a', 'v', 'a', 'l', 'o', 'v', 'e'};
        char c = 'o';
        int quantityс = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                quantityс++;
            }
        }
        System.out.println("quantity c -> " + quantityс);

        char[] chars2 = {'j', 'a', 'v', 'a', 'l', 'o', 'v', 'e'};
        int i = chars2.length / 2;
        if (chars2.length % 2 == 0) {
            System.out.println(chars2[i - 1] + " " + chars2[i]);
        } else System.out.println(chars2[i]);


        char[] chars3 = {'j', 'a', 'v', 'a', 'l', 'o', 'l', 'y'};
        boolean lastsimbol;
        if (chars3[(chars3.length - 1)] == 'y' && chars3[(chars3.length-2)] == 'l'){
            lastsimbol = true;
        }
        else {
            lastsimbol = false;
        }
        System.out.println("lastsimbol -> " + lastsimbol);


        char[] bobArray = {'b', 'a', 'b', 'g', 'b', 'b'};
        boolean bob = false;
        for (int j = 0; j < bobArray.length - 2; j++) {
            if (bobArray[j] == 'b' && bobArray[j + 2] == 'b') {
                bob = true;
            }
        }
        System.out.println("bob -> " + bob);


        System.out.print("text -> ");
        char[] text = {' ', 'b', 'a', 'r', 'e', 'v', ' '};
        for (int j = 0; j < text.length; j++) {
            if (text[j] != ' ') {
                System.out.print(text[j]);


            }

        }

    }


}






