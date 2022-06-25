package homework.dinamicarray;

public class DinamicArray {
    private int[] array = new int[10];
    private int size = 0;

    void add(int value) {
        if (size == array.length) {
            increaeArray();
        }
        array[size++] = value;

    }

    void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

    }

    private void increaeArray() {
        int[] temp = new int[array.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    boolean isEmpty() {
        return size == 0;

    }

    int getByIndex(int index) {
        if (size > index) {
            return array[index];
        }
        return 0;
    }

    int getFirstIndexByValue(int value) {
        int i;
        for (i = 0; i < array.length; i++) {
            if (value == array[i]) {
                return i;

            }

        }
        return 0;

    }

    void set(int index, int value) {
        if (index >= size) {
            System.out.println("no element an index " + index);
        } else {
            array[index] = value;
        }
    }

    void add(int index, int value) {
        int endIndex = size;
        if (size == array.length) {
            increaeArray();
        }
        if (endIndex > index) {
            for (int i = endIndex; i >= index; i--) {
                array[endIndex] = array[endIndex - 1];
                endIndex--;

            }
            array[index] = value;
            size++;
        } else {
            System.out.println("Error: no element an index  " + index);
        }
    }

    void delete(int index) {
        if (index <= size) {
            for (int i = index; i < size; i++) {
                array[index] = array[++index];

            }
            size--;
        } else {
            System.out.println("Error: no element an index  " + index);
        }
    }
}