import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        Library.testloginUsers();

        Library.Login("Aya_Abu3li","123456");
        Library.Login("Waseem_ghazal","123");
        Library.Login("Roaa_Arafat","123");
        Library.Login("Roaa_Arafat","123");

        Library.Add_book("Aya_Abu3li","Test-Drivenest Driven Development","Kent Beck","9780321146533","Beck2002");
        Library.Add_book("Waseem_ghazal","Test-Drivenest Driven Development","Kent Beck","9780321146533","Beck2002");
        Library.Add_book("Roaa_Arafat","Test-Drivenest Driven Development","Kent Beck","9780321146533","Beck2002");

        Library.SearchByTitle("test");

        Library.Logout("Aya_Abu3li");
        Library.Logout("Waseem_ghazal");


    }
}
