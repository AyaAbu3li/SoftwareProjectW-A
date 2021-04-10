package softwareproject;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class searchBookSteps {

    ArrayList<Book> arr = new ArrayList<>();
    String password,username;
    String searchString;
    boolean flag;

    @Given("the following book is a data in the system")
    public void the_following_book_is_a_data_in_the_system(DataTable table) {
        List<String> list = table.column(1);
        Book book = new Book(list.get(1), list.get(2), list.get(3), list.get(4));
        arr.add(book);
    }

    @When("user OR administrator search about book by ISBN {string}")
    public void user_OR_administrator_search_about_book_by_isbn(String ISBN) {
        Library.testBooks();
        flag= Library.searchByISBN(ISBN);
    }

    @When("user OR administrator search about book by title {string}")
    public void user_OR_administrator_search_about_book_by_title(String title) {
        Library.testBooks();
        flag= Library.searchByTitle(title);
    }

    @When("user OR administrator search about book by author {string}")
    public void user_OR_administrator_search_about_book_by_author(String author) {
        Library.testBooks();
        flag= Library.searchByAuthor(author);
    }



    @Then("A list of books that matches specifications {string} should be returned and printed on the console")
    public void a_list_of_books_that_matches_specifications_should_be_returned_and_printed_on_the_console(String result) {
        if(flag){
            searchString="found";
        }
        else searchString="not found";
        assertEquals(searchString, result);
    }

    @Given("there is an user logged in with {string} and {string}")
    public void there_is_an_user_logged_in_with_and(String username, String password) {
        this.username=username;
        this.password=password;
        Library.testloginUsers();
        Library.login(username,password);

    }

}
