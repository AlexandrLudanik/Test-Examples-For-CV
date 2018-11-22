package junitCucumber;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SendLetterSteps extends WebDriverSettings {

    @Given("^I am on main application page4$")
    public void loadMainPage()
    {
        driver.get(MAIN_URL);
    }

    @When("^I login as correct user4$")
    public void loginAsCorrectUser()
    {
        loginPage.register(LOGIN, PASSWORD);
    }

    @Then("^I click button write letter4$")
    public void clickButtonWriteLetter()
    {
        sendLetterPage.clickButtonWriteLetter();
    }

    @Then("^I write address and message4$")
    public void writeAddressAndText()
    {
        sendLetterPage.writeEmailAndMessage("sysrq0884@gmail.com", "cucumber");
    }

    @Then("^I click button send letter4$")
    public void clickButtonSend()
    {
        sendLetterPage.clickButtonSendLetter();
    }

    @Then("^I see message what message send4$")
    public void infoMessageSend()
    {
        Assert.assertTrue(sendLetterPage.infoMessageSend());
    }

    @Then("^close browser4$")
    public void close(){
        driver.quit();
    }
}
