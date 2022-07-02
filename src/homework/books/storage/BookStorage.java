package homework.books.storage;

import homework.books.model.Book;

public class BookStorage {
    private Book[] array = new Book[10];
    private int size = 0;


    public void add(Book book) {
        if (size == array.length) {
            increaeArray();
        }
        array[size++] = book;

    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ". " + array[i]);
        }
    }

    private void increaeArray() {
        Book[] temp = new Book[array.length + 10];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public void printBooksByAuthorName(String authorName) {
        for (int i = 0; i < size; i++) {
            if (array[i].getAuthor().equals(authorName)) {
                System.out.println(array[i]);
            }
        }
    }

    public void printBooksByGenre(String genre) {
        int genreMatch = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].getGenre().equals(genre)) {
                System.out.println(array[i]);
                genreMatch++;
            }
        }
        if (genreMatch == 0) {
            System.out.println("Sorry, not book at this genre");
        }
    }

    public void printBooksByPriceRange(double min, double max) {
        int priceMatch = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].getPrice() >= min && array[i].getPrice() <= max) {
                System.out.println(array[i]);
                priceMatch++;
            }
        }
        if (priceMatch == 0) {
            System.out.println("Sorry, not book at this price");
        }


    }
}
