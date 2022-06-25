package homework.arrayutil;

public class ArraySort {
    public static void main(String[] args) {
        int[] numbers = {43, 55, 87, -9, 0, 12, 5, 65};
        int x = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    x = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = x;
                }
            }
        }
        for (int k : numbers) {
            System.out.print(k + " ");

        }
        System.out.println();

        int[] numbers2 = {43, 55, 87, -9, 0, 12, 5, 65};
        int y = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] < numbers[j + 1]) {
                    y = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = y;
                }
            }
        }
        for (int k : numbers) {
            System.out.print(k + " ");
        }
        System.out.println();

    }
}

