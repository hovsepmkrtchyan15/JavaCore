package homework.books;

import homework.books.bookEnum.UserType;
import homework.books.command.Commands;
import homework.books.model.Author;
import homework.books.model.Book;
import homework.books.model.User;
import homework.books.storage.AuthorStorage;
import homework.books.storage.BookStorage;
import homework.books.exception.AuthorNotFoundException;
import homework.books.bookEnum.Gender;
import homework.books.storage.UserStorage;
import java.util.Scanner;

public class BookDemo implements  Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookstorage = new BookStorage();

    private static AuthorStorage authorStorage = new AuthorStorage();

    private static UserStorage userStorage = new UserStorage();

    private static User currentUser = null;


    public static void main(String[] args) {

        int command;
        boolean run = true;

        while (run) {
            Commands.printLoginCommands();
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
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;

                default:
                    System.err.println("Invalid index");
                    break;

            }

        }

    }

    private static void register() {
        System.out.println("Please input name,surname,email,password");
        String userDataStr = scanner.nextLine();
        String[] userData = userDataStr.split(",");
        if (userData.length < 4) {
            System.out.println("Invalid data");
        } else {
            if (userStorage.getUserByEmail(userData[2]) == null) {
                User user = new User();
                user.setName(userData[0]);
                user.setSurname(userData[1]);
                user.setEmail(userData[2]);
                user.setPassword(userData[3]);
                user.setUserType(UserType.USER);
                userStorage.add(user);
                System.out.println("User crated");
            } else {
                System.out.println("email " + userData[2] + " dose not exists!");
            }
        }

    }

    private static void login() {
        System.out.println("Please input email,password");
        String userDataStr = scanner.nextLine();
        String[] userData = userDataStr.split(",");
        User user = userStorage.getUserByEmail(userData[0]);
        if (user == null) {
            System.out.println("user wite " + userData[0] + " dose not exsists!");
        } else {
            if (user.getPassword().equals(userData[1])) {
                currentUser = user;
                if (user.getUserType() == UserType.ADMIN) {
                    logInAdmin();
                } else {
                    if (user.getUserType() == UserType.USER) {
                        logInUser();

                    }
                }
            }
        }
    }


    private static void logInUser() {
        int command;
        boolean run = true;

        while (run) {
            Commands.printUserCommands();
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please input correct commands");
                command = -1;
            }

            switch (command) {
                case LOGOUT:
                    run = false;
                    break;
                case PRINT_ALL_BOOKS:
                    bookstorage.print();
                    break;
                case PRINT_BOOKS_BY_AUTHOR_NAME:
                    System.out.println("Please input author name");
                    authorStorage.printBooksByAuthorName(scanner.nextLine().trim());
                    break;
                case PRINT_BOOKS_BY_GENRE:
                    System.out.println("Please input genre");
                    bookstorage.printBooksByGenre(scanner.nextLine().trim());
                    break;
                case PRINT_BOOKS_BY_PRICE_RANGE:
                    printBooksByPriceRange();
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

    private static void logInAdmin() {
        int command;
        boolean run = true;

        while (run) {
            Commands.printAdminCommands();
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
                    System.out.println("Please input author name");
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

                Book book = new Book(title, author, price, gener, currentUser);
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



