package homework.books;

import java.util.Scanner;

public class BookDemo implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookstorage = new BookStorage();

    public static void main(String[] args) {

        int command;
        boolean run = true;

        while (run) {
            System.out.println("Please input " + EXIT + " for exit");
            System.out.println("Please input " + ADD_BOOK + " for add book");
            System.out.println("Please input " + PRINT_ALL_BOOKS + " for Print all books");
            System.out.println("Please input " + PRINT_BOOKS_BY_AUTHOR_NAME + " for print books by author name");
            System.out.println("Please input " + PRINT_BOOKS_BY_GENRE + " for print books by genre");
            System.out.println("Please input " + PRINT_BOOKS_BY_PRICE_RANGE + " for print books by price range");

            command = Integer.parseInt(scanner.nextLine());

            switch (command) {
                case EXIT:
                    run = false;
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_ALL_BOOKS:
                    bookstorage.print();
                    break;
                case PRINT_BOOKS_BY_AUTHOR_NAME:
                    System.out.println("Please input authorname");
                    bookstorage.printBooksByAuthorName(scanner.nextLine().trim());
                    break;
                case PRINT_BOOKS_BY_GENRE:
                    System.out.println("Please input genre");
                    bookstorage.printBooksByGenre(scanner.nextLine().trim());
                    break;
                case PRINT_BOOKS_BY_PRICE_RANGE:
                    System.out.println("Please input minimum price");
                    double min = (double) Integer.parseInt(scanner.nextLine());
                    System.out.println("Please input maximum price");
                    double max = (double) Integer.parseInt(scanner.nextLine());
                    bookstorage.printBooksByPriceRange(min, max);
                    break;
                default:
                    System.err.println("Invalid index");
                    break;

            }

        }

    }

    private static void addBook() {
        System.out.println("Please input book title");
        String title = scanner.nextLine().trim();
        System.out.println("Please input book authorName");
        String authorName = scanner.nextLine().trim();
        System.out.println("Please input book price");
        double price = Integer.parseInt (scanner.nextLine());
        System.out.println("Please input book genre");
        String genre = scanner.nextLine().trim();

        Book book = new Book(title, authorName, price, genre);
        bookstorage.add(book);
        System.out.println("Book created");
    }
}


