public class Book {

    private String Title;
    private String Author;
    private String ISBN;
    private String Signature;

    public Book(String Title, String Author, String ISBN, String Signature) {
        this.Title = Title;
        this.Author = Author;
        this.ISBN = ISBN;
        this.Signature = Signature;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getSignature() {
        return Signature;
    }
}