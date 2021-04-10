package softwareproject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class logoutSteps {
    String username,password;
    boolean flag;
    @Given("there is Administrator {string} logged in with {string}")
    public void there_is_administrator_logged_in(String username,String password) {
        Library.testloginUsers();
        this.username=username;
        this.password=password;
        Library.login(username,password);

    }

    @When("Administrator call logout function")
    public void administrator_call_logout_function() {
        System.out.println("calling logout function");
        flag = Library.logOut(username);
    }

    @Then("Administrator should get logged out to login page and Message printed on the console Logout successfully")
    public void administrator_should_get_logged_out_to_login_page_and_message_printed_on_the_console_logout_successfully() {
        assertTrue(flag);
    }
}