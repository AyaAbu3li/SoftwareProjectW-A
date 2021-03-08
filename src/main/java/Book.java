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

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getSignature() {
        return Signature;
    }

    public void setSignature(String Signature) {
        this.Signature = Signature;
    }

}
