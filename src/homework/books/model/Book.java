package homework.books.model;

public class Book {

    private String title;
    private Author author;
    private double price;
    private int count;
    private String genre;

    private User registeredUser;

    public Book(String title, Author author, double price, String genre, User registeredUser) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.genre = genre;
        this.registeredUser = registeredUser;

    }

    Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", price=" + price +
                ", count=" + count +
                ", genre='" + genre + '\'' +
                ", registeredUser=" + registeredUser.getName() +
                '}';
    }

    public User getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(User registeredUser) {
        this.registeredUser = registeredUser;
    }
}
