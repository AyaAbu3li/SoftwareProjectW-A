import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {

    static HashMap<String, Boolean> loginUsers = new HashMap<>();
    static HashMap<String, String> Users = new HashMap<>();
    static ArrayList<Book> BooksList = new ArrayList<>();

    public static void testBooks() {
        Book bok = new Book("The Midnight Library: A Novel", "Matt Haig ", "0525559477987", "Haig2020");
        Book bk = new Book("The Paris Library", "Janet Skeslien Charles", "9781982134198", "Charles2002");
        BooksList.add(bok);
        BooksList.add(bk);
    }


    public static HashMap<String, String> testUsers() {
        Users.put("Aya_Abu3li", "123456");
        Users.put("Waseem_ghazal", "12356");
        Users.put("Roaa_Arafat", "123");
        Users.put("Dana", "111");
        return Users;
    }

    public static HashMap<String, Boolean> testloginUsers() {
        loginUsers.put("Aya_Abu3li", false);
        loginUsers.put("Waseem_ghazal", false);
        loginUsers.put("Roaa_Arafat", false);
        loginUsers.put("Dana", false);
        return loginUsers;
    }

    public static boolean isLogin(String username) {
        return loginUsers.get(username);
    }

    public static void Login(String username, String password) {
        HashMap<String, String> User = Library.testUsers();
        String pass = User.get(username);
        if (password.equals(pass)) {

            if (isLogin(username)) {
                System.out.println("You already Logged in!!");
            } else {
                loginUsers.replace(username, false, true);
                System.out.println("Login Successfully");
            }
        } else System.out.println("Please check your password");
    }

    public static Boolean Logout(String username) {
        if (isLogin(username)) {
            loginUsers.replace(username, true, false);
            System.out.println("Logout Successfully");
            return true;
        } else {
            System.out.println("You are not login aslan !!");
            return false;
        }
    }

    public static boolean onlyDigits(String str, int n)
    {
        if(n!=10) return false;
        // Traverse the string from
        // start to end
        for (int i = 0; i < n; i++) {

            // Check if character is
            // digit from 0-9
            // then return true
            // else false
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
                return true;

            else return false;
        }
        return false;
    }

    public static boolean Add_book(String username, String title, String author, String ISBN, String signature) {
        if (isLogin(username)) {
           boolean bool= onlyDigits(ISBN,ISBN.length());
           if(bool){
            for (Book value : BooksList) {
                if (value.getISBN().equals(ISBN)) {
                    System.out.println("this book is already existing");
                    return false;
                }
            }
            Book book = new Book(title, author, ISBN, signature);
            BooksList.add(book);
            System.out.println("the book added successfully");
            return true;
        } else  System.out.println("the ISBN incorrect");
        } else {
            System.out.println("Please login to add book !");
            return false;
        }
        return false;
    }

    public static Boolean SearchByTitle(String Title){
        ArrayList<Book> ByTitle=new ArrayList<>();
        Library.testBooks();
        for (Book book : BooksList)
            if (book.getTitle().toLowerCase().contains(Title.toLowerCase()))
                ByTitle.add(book);
            if(ByTitle.isEmpty()){
                System.out.println("There is no book found");
                return false;
            }
        printfun(ByTitle);
        return true;

    }
    public static Boolean SearchByISBN(String ISBN){
        ArrayList<Book> ByISBN=new ArrayList<>();
        Library.testBooks();
        for (Book book : BooksList)
            if (book.getISBN().toLowerCase().equals(ISBN.toLowerCase()))
                ByISBN.add(book);
        if(ByISBN.isEmpty()){
            System.out.println("There is no book found");
            return false;
        }
        printfun(ByISBN);
        return true;

    }
    public static Boolean SearchByAuthor(String Author){
        ArrayList<Book> ByAuthor=new ArrayList<>();
        Library.testBooks();
        for (Book book : BooksList)
            if (book.getAuthor().toLowerCase().contains(Author.toLowerCase()))
                ByAuthor.add(book);
        if(ByAuthor.isEmpty()){
            System.out.println("There is no book found");
            return false;
        }
            printfun(ByAuthor);
        return true;

    }
    public static void printfun(List<Book> printList){

        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%10s %40s %40s %30s", "Book Title", "Book Author", "Book ISBN", "Book Signature");
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        for(Book book: printList){
            System.out.format("%10s %30s %35s %25s",
                    book.getTitle(), book.getAuthor(), book.getISBN(), book.getSignature());
            System.out.println();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------");

    }
}