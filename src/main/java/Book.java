public class Book {

    private String title;
    private String author;
    private String isbn;
    private String signature;

    public Book(String title, String author, String isbn, String signature) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.signature = signature;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return isbn;
    }

    public String getSignature() {
        return signature;
    }
}