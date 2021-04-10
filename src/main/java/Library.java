import jdk.nashorn.internal.objects.NativeMath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
public class Library {

    static Logger logger = Logger.getLogger(Library.class.getName());


    static HashMap<String, Boolean> loginUsers = new HashMap<>();
    static HashMap<String, String> Users = new HashMap<>();
    static ArrayList<Book> BooksList = new ArrayList<>();

    private Library() {
    }

    public static String s(){
        return "There is no book found";
    }
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
                logger.log(Level.WARNING,"You already Logged in!!");
            } else {
                loginUsers.replace(username, false, true);
                logger.log(Level.INFO,"Login Successfully");
            }
        } else logger.log(Level.WARNING,"Please check your password");
    }

    public static Boolean Logout(String username) {
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

    public static boolean Add_book(String username, String title, String author, String ISBN, String signature) {
        if (isLogin(username)) {
            boolean bool= onlyDigits(ISBN,ISBN.length());
            if(bool){
                for (Book value : BooksList) {
                    if (value.getISBN().equals(ISBN)) {
                        logger.log(Level.WARNING,"this book is already existing");
                        return false;
                    }
                }
                Book book = new Book(title, author, ISBN, signature);
                BooksList.add(book);
                logger.log(Level.INFO,"the book added successfully");
                return true;
            } else  logger.log(Level.WARNING,"the ISBN incorrect");
        } else {
            logger.log(Level.WARNING,"Please login to add book !");
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
            logger.log(Level.INFO,s());
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
            logger.log(Level.WARNING,"There is no book found");
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
            logger.log(Level.INFO,s());
            return false;
        }
        printfun(ByAuthor);
        return true;
    }
    public static void printfun(List<Book> printList){
        for(Book book: printList){
            logger.log(Level.INFO,("Search results:" +book.getTitle()+"   "+book.getAuthor()+ "   "+ book.getISBN()+ "   "+ book.getSignature()));
        }
    }
}