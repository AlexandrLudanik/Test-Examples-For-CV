package junitCucumber;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CleanBasketSteps extends WebDriverSettings{

    @Given("^I am on main application page1$")
    public void loadMainPage()
    {
        driver.get(MAIN_URL);
    }

    @When("^I login as correct user1$")
    public void loginAsCorrectUser()
    {
        loginPage.register(LOGIN, PASSWORD);
    }

    @Then("^I click basket link1$")
    public void clickBasketLink()
    {
        cleanBasketPage.clickBasketLink();
    }

    @Then("^I click button clear folder1$")
    public void clickButtonClearFolder()
    {
        try {
            cleanBasketPage.clickButtonClearFolder();
        } catch (Exception e) {
            Assert.assertTrue(cleanBasketPage.basketImagePresent());

        }
    }

    @Then("^I click button confirm1$")
    public void clickButtonConfirm()
    {
        try {
            cleanBasketPage.clickButtonConfirm();
        } catch (Exception e) {
            Assert.assertTrue(cleanBasketPage.basketImagePresent());

        }
    }

    @Then("^I see what basket is empty1$")
    public void fclickButtonClearFolder()
    {
        Assert.assertTrue(cleanBasketPage.basketImagePresent());
    }

    @Then("^close browser1$")
    public void close(){
        driver.quit();
    }
}
