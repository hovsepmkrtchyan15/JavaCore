package homework.books.storage;

import homework.books.model.Author;

public class AuthorStorage {
    private Author[] array = new Author[10];
    private int size = 0;


    public void add(Author author) {
        if (size == array.length) {
            increaeArray();
        }
        array[size++] = author;

    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ". " + array[i]);
        }
    }

    private void increaeArray() {
        Author[] temp = new Author[array.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public void printBooksByAuthorName(String name) {
        for (int i = 0; i < size; i++) {
            if (array[i].getName().equals(name)) {
                System.out.println(array[i]);
            }
        }
    }

    public int getSize() {

        return size;
    }

    public void printBooksByGenre(String genre) {
        int genreMatch = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].getGender().equals(genre)) {
                System.out.println(array[i]);
                genreMatch++;
            }
        }
        if (genreMatch == 0) {
            System.out.println("Sorry, not book at this genre");
        }


    }

    public Author getAuthorByIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return array[index];
    }


}

