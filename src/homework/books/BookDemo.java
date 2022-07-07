package homework.books;

import homework.books.command.Commands;
import homework.books.model.Author;
import homework.books.model.Book;
import homework.books.storage.AuthorStorage;
import homework.books.storage.BookStorage;
import homework.books.exception.AuthorNotFoundException;
import homework.books.bookEnum.Gender;

import java.util.Locale;
import java.util.Scanner;

public class BookDemo implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookstorage = new BookStorage();

    private static AuthorStorage authorStorage = new AuthorStorage();


    public static void main(String[] args) {

        logIn();

        int command;
        boolean run = true;

        while (run) {
            Commands.printCommands();
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please input correct commands");
                command = -1;
            }

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
                    authorStorage.printBooksByAuthorName(scanner.nextLine().trim());
                    break;
                case PRINT_BOOKS_BY_GENRE:
                    System.out.println("Please input genre");
                    bookstorage.printBooksByGenre(scanner.nextLine().trim());
                    break;
                case PRINT_BOOKS_BY_PRICE_RANGE:
                    printBooksByPriceRange();
                    break;
                case ADD_AUTHOR:
                    addAuthor();
                    break;
                case PRINT_ALL_AUTHOR:
                    authorStorage.print();
                    break;
                default:
                    System.err.println("Invalid index");
                    break;

            }

        }

    }

    private static void logIn() {
        final String USERNAME = "admin";
        final String PASSWORD = "12345";
        System.out.println("Please input your username");
        String name = scanner.nextLine();
        System.out.println("Please input password");
        String pass = scanner.nextLine();
        if (name.equals(USERNAME) && pass.equals(PASSWORD)) {
            addBook();
        } else {
            System.out.println("Invalid username or password!!!");
            logIn();
        }

    }

    private static void addAuthor() {
        System.out.println("Please input author name");
        String name = scanner.nextLine().trim();
        System.out.println("Please input author surname");
        String surname = scanner.nextLine().trim();
        System.out.println("Please input author email");
        String email = scanner.nextLine().trim();
        if (!email.contains("@")) {
            System.out.println("Please choose correct email!!!");
            addAuthor();
        } else {

            System.out.println("Please choose author gender");
            for (Gender g : Gender.values()) {
                System.out.print(g + ", ");
                System.out.println();
            }
            String gender = scanner.nextLine().trim();
            try {
                Gender g = Gender.valueOf(gender.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Please choose correct gender");
                addAuthor();
            }
            Author author = new Author(name, surname, email, gender);
            authorStorage.add(author);
            System.out.println("author created!");
        }
    }


    private static void addBook() {
        if (authorStorage.getSize() != 0) {
            authorStorage.print();
            System.out.println("Please choose author index");

            try {
                int authorIndex = Integer.parseInt(scanner.nextLine());
                Author author = authorStorage.getAuthorByIndex(authorIndex);
                System.out.println("Please input book title");
                String title = scanner.nextLine().trim();
                System.out.println("Please input book price");
                double price = Double.parseDouble(scanner.nextLine());
                System.out.println("Please input book genre");
                String gener = scanner.nextLine().trim();

                Book book = new Book(title, author, price, gener);
                bookstorage.add(book);
                System.out.println("Book created");

            } catch (AuthorNotFoundException | NumberFormatException e) {
                System.out.println("Please choose correct index");
                addBook();
            }


        } else {
            System.out.println("not author");
            addAuthor();
        }

    }

    private static void printBooksByPriceRange() {
        System.out.println("Please input minimum price");
        try {
            double min = Double.parseDouble(scanner.nextLine());
            System.out.println("Please input maximum price");
            double max = Double.parseDouble(scanner.nextLine());
            bookstorage.printBooksByPriceRange(min, max);
        } catch (NumberFormatException e) {
            System.out.println("Please input correct index");
            printBooksByPriceRange();
        }
    }
}



