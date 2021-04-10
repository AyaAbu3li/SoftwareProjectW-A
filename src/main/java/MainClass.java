public class MainClass {

    public static void main(String[] args) {
        Library.testloginUsers();
        String a="Aya_Abu3li";
        String w="Waseem_ghazal";
        String r="Roaa_Arafat";
        String title="Test-Drivenest Driven Development";
        String author="Kent Beck";
        String sign="Beck2002";
        Library.login(a,"123456");
        Library.login(w,"123");
        Library.login(r,"123");
        Library.login(r,"123");
        Library.addBook(a,title,author,"1476765995",sign);
        Library.addBook(w,title,author,"9780321146533",sign);
        Library.addBook(r,title,author,"9780321146533",sign);
        Library.searchByTitle("test");
        Library.logOut(a);
        Library.logOut(w);
    }
}
