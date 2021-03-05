import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;


import static org.junit.Assert.*;

public class addBookSteps {

    String username,password;
    boolean flag,flaag;
    ArrayList<Book> arr = new ArrayList<>();

    @Given("there is Administrator {string} loggedin with {string}")
    public void there_is_administrator_loggedin(String username,String password) {
        Library.testloginUsers(); // make them all logout "false"
        this.username=username;
        this.password=password;
        Library.Login(username,password);
    }

    @When("Administrator call add book function with valid parameters {string} , {string} , {string} and {string}")
    public void administrator_call_add_book_function_with_valid_parameters_and(String title, String author, String ISBN, String Signature) {
        System.out.println("calling function ADD BOOK");
        flaag = Library.Add_book(username,title, author, ISBN, Signature);
    }

    @Then("The book added and Message printed on the console the book added successfully")
    public void the_book_added_and_message_printed_on_the_console_the_book_added_successfully() {
        assertTrue(flaag);
    }

    @Given("there is no Administrator logged in with this {string} and {string}")
    public void there_is_no_administrator_logged_in_with_this_and(String username, String password) {
        Library.testloginUsers(); // make them all logout "false"
        flag = Library.isLogin(username);
        System.out.println("there is no Administrator logged in");
    }

    @When("Administrator can not call add book function")
    public void administrator_can_not_call_add_book_function() {
    }

    @Then("The book can not be added and Message printed on the console book can not be add because you are not logged in")
    public void the_book_can_not_be_added_and_message_printed_on_the_console_book_can_not_be_add_because_you_are_not_logged_in() {
        assertFalse(flag);
        System.out.println("you are not logged in");
    }
}