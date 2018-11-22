package junitCucumber;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class LoginSteps extends WebDriverSettings{


    @Given("^I am on main application page$")
    public void loadMainPage()
    {
        driver.get(MAIN_URL);
    }

    @When("^I login as correct user$")
    public void loginAsCorrectUser()
    {
        loginPage.register(LOGIN, PASSWORD);
    }

    @When("^I login as user with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void loginAsUserWithCredentials(String name, String password)
    {
        loginPage.register(name, password);
    }

    @Then("^I see logout link$")
    public void seeLogoutLink()
    {
        Assert.assertTrue(loginPage.logoutLinkPresents(driver));
    }

    @Then("^I see error message$")
    public void seeErrorMessage()
    {
        Assert.assertTrue(loginPage.logoutLinkErrorPresents(driver));
    }

    @Then("^close browser$")
    public void close(){
        driver.quit();
    }
}