import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    static HashMap<String, Boolean> loginUsers = new HashMap<>();
    static HashMap<String, String> Users = new HashMap<>();
    static ArrayList<Book> BooksList = new ArrayList<>();

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

    public static boolean Add_book(String username, String title, String author, String ISBN, String signature) {
        if (isLogin(username)) {
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
        } else {
            System.out.println("Please login to add book !");
            return false;
        }
    }
}