package homework.students.storage;

import homework.students.model.User;

public class UserStorage {
    private User[] array = new User[10];
    private int size = 0;


    public void add(User user) {
        if (size == array.length) {
            increaeArray();
        }
        array[size++] = user;

    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ". " + array[i]);
        }
    }

    private void increaeArray() {
        User[] temp = new User[array.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("invalid index");
        } else {
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            size--;

        }
    }

    public int getSize() {

        return size;
    }


    public User getUserByIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return array[index];
    }

    public User getUserByEmail(String email) {
        for (int i = 0; i < size; i++) {
            if (array[i].getEmail().equals(email)) {
                return array[i];
            }


        }
        return null;
    }
}
