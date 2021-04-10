import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;
public class Library {

    static Logger logger = Logger.getLogger(Library.class.getName());
    static String s="There is no book found";

    static HashMap<String, Boolean> loginUsers = new HashMap<>();
    static HashMap<String, String> users = new HashMap<>();
    static ArrayList<Book> bookList = new ArrayList<>();

    private Library() {
    }


    public static void testBooks() {
        Book bok = new Book("The Midnight Library: A Novel", "Matt Haig ", "0525559477987", "Haig2020");
        Book bk = new Book("The Paris Library", "Janet Skeslien Charles", "9781982134198", "Charles2002");
        bookList.add(bok);
        bookList.add(bk);
    }


    public static Map<String, String> testUsers() {
        users.put("Aya_Abu3li", "123456");
        users.put("Waseem_ghazal", "12356");
        users.put("Roaa_Arafat", "123");
        users.put("Dana", "111");
        return users;
    }

    public static Map<String, Boolean> testloginUsers() {
        loginUsers.put("Aya_Abu3li", false);
        loginUsers.put("Waseem_ghazal", false);
        loginUsers.put("Roaa_Arafat", false);
        loginUsers.put("Dana", false);
        return loginUsers;
    }

    public static boolean isLogin(String username) {
        return loginUsers.get(username);
    }

    public static void login(String username, String password) {
        Map<String, String> user = Library.testUsers();
        String pass = user.get(username);
        if (password.equals(pass)) {

            if (isLogin(username)) {
                logger.log(Level.WARNING,"You already Logged in!!");
            } else {
                loginUsers.replace(username, false, true);
                logger.log(Level.INFO,"Login Successfully");
            }
        } else logger.log(Level.WARNING,"Please check your password");
    }

    public static Boolean logOut(String username) {
        if (isLogin(username)) {
            loginUsers.replace(username, true, false);
            logger.log(Level.INFO,"Logout Successfully");
            return true;
        } else {
            logger.log(Level.WARNING,"You are not logged in aslan !!");
            return false;
        }
    }

    public static boolean onlyDigits(String str, int n) {
        if(n!=10) return false;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int digit = str.charAt(i) - '0';
            if (0 > digit || 9 < digit)
                return false;
            sum += (digit * (10 - i));
        }
        return (sum % 11 == 0);
    }

    public static boolean addBook(String username, String title, String author, String isbn, String signature) {
        if (isLogin(username)) {
            boolean bool= onlyDigits(isbn,isbn.length());
            if(bool){
                for (Book value : bookList) {
                    if (value.getISBN().equals(isbn)) {
                        logger.log(Level.WARNING,"this book is already existing");
                        return false;
                    }
                }
                Book book = new Book(title, author, isbn, signature);
                bookList.add(book);
                logger.log(Level.INFO,"the book added successfully");
                return true;
            } else  logger.log(Level.WARNING,"the isbn incorrect");
        } else {
            logger.log(Level.WARNING,"Please login to add book !");
            return false;
        }
        return false;
    }

    public static Boolean searchByTitle(String title){
        ArrayList<Book> byTitle=new ArrayList<>();
        Library.testBooks();
        for (Book book : bookList)
            if (book.getTitle().toLowerCase().contains(title.toLowerCase()))
                byTitle.add(book);
        if(byTitle.isEmpty()){
            logger.log(Level.INFO,s);
            return false;
        }
        printfun(byTitle);
        return true;
    }
    public static Boolean searchByISBN(String isbn){
        ArrayList<Book> byISBN=new ArrayList<>();
        Library.testBooks();
        for (Book book : bookList)
            if (book.getISBN().equalsIgnoreCase(isbn.toLowerCase()))
                byISBN.add(book);
        if(byISBN.isEmpty()){
            logger.log(Level.WARNING,"There is no book found");
            return false;
        }
        printfun(byISBN);
        return true;
    }
    public static Boolean searchByAuthor(String author){
        ArrayList<Book> byAuthor=new ArrayList<>();
        Library.testBooks();
        for (Book book : bookList)
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase()))
                byAuthor.add(book);
        if(byAuthor.isEmpty()){
            logger.log(Level.INFO,s);
            return false;
        }
        printfun(byAuthor);
        return true;
    }
    public static void printfun(List<Book> printList){
        for(Book book: printList){
            logger.log(Level.INFO,("Search results:" +book.getTitle()+"   "+book.getAuthor()+ "   "+ book.getISBN()+ "   "+ book.getSignature()));
        }
    }
}