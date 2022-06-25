package homework.arrayutil;

public class ArrayUtil {
    int max(int[] array) {
        int big = array[0];
        for (int i = 0; i < array.length; i++) {
            big = big > array[i] ? big : array[i];
        }
        return big;
    }

    int min(int[] array) {
        int smoll = array[0];
        for (int i = 0; i < array.length; i++) {
            smoll = smoll < array[i] ? smoll : array[i];
        }
        return smoll;
    }

    void even(int[] array) {
        int evenNum;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenNum = array[i];
                System.out.print(evenNum + " ");
            }
        }
        System.out.println();
    }

    int evenCount(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    void odd(int[] array) {
        int oddNum;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                oddNum = array[i];
                System.out.print(oddNum + " ");
            }
        }
        System.out.println();
    }

    int oddCount(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    void ollElements(int[] array) {
        int element;
        for (int i = 0; i < array.length; i++) {
            element = array[i];
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    int average(int[] array) {
        int sum = 0, count = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            count++;
        }
        return sum / count;
    }

    char[] space(char[] spaceArray) {

        int startIndex = 0;
        int endIndex = spaceArray.length - 1;
        for (int i = 0; i < spaceArray.length; i++) {
            if (spaceArray[startIndex] == ' ') {
                startIndex++;
            } else {
                break;
            }

        }
        for (int i = endIndex; i > 0; i--) {
            if (spaceArray[endIndex] == ' ') {
                endIndex--;
            } else {
                break;

            }
        }
        char[] result = new char[endIndex - startIndex + 1];
        int index = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            result[index++] = spaceArray[i];
        }
        return result;
    }

    void arraySort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int x = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = x;
                }

            }
        }

    }
}