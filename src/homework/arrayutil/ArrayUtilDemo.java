package homework.arrayutil;

public class ArrayUtilDemo {
    public static void main(String[] args) {
        int[] numbers = {12, 23, 44, 2, 78, 48};
        char[] spaceArray = {' ', ' ', ' ', 't', ' ', 'b', 'i', ' ', 'k', ' ', ' '};
        ArrayUtil au = new ArrayUtil();

        System.out.println("max = " + au.max(numbers));
        System.out.println("min = " + au.min(numbers));
        au.even(numbers);
        au.odd(numbers);
        System.out.println(au.evenCount(numbers));
        System.out.println(au.oddCount(numbers));
        au.ollElements(numbers);
        System.out.println(au.sum(numbers));
        System.out.println(au.average(numbers));
        System.out.println(au.space(spaceArray));
        au.arraySort(numbers);
        for (int c : numbers) {
            System.out.print(c + " ");
        }


    }

}
