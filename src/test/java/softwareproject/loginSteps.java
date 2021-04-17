package softwareproject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static org.junit.Assert.*;

public class loginSteps {

    String username,pass,password;

    @Given("there is an admin in login page")
    public void there_is_an_admin_in_login_page() {
        System.out.println("there is an admin in login page");
    }

    @When("user logs in with valid username {string} And valid password {string}")
    public void user_logs_in_with_valid_username_and_valid_password(String username, String password) {
        Map<String,String> User = Library.testUsers();
        pass= User.get(username);
        this.password=password;
        this.username=username;
    }

    @Then("User should get logged in and Message {string} printed on the console Login Successfully")
    public void user_should_get_logged_in_and_message_printed_on_the_console_login_successfully(String Message) {
        assertEquals(pass, password);
//        Map<String,Boolean> User = Library.testloginUsers();
        Library.login(username,password);
        System.out.println(Message);

    }

    @Given("there is an user in login page")
    public void there_is_an_user_in_login_page() {
        System.out.println("there is an admin in login page");
    }

    @When("user logs in with valid username {string} And invalid password {string}")
    public void user_logs_in_with_valid_username_and_invalid_password(String username, String password) {
        Map<String,String> User = Library.testUsers();
        pass= User.get(username);
        this.password=password;
    }

    @Then("User should not log in And stay in the login page and Message {string} printed on the console Login failed")
    public void user_should_not_log_in_and_stay_in_the_login_page_and_message_printed_on_the_console_login_failed(String Message) {
        //assertEquals(pass, password);
        assertNotSame(pass, password);
        System.out.println(Message);
    }

}
