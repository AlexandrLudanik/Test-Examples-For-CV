package junitCucumber;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SendLetterGroupSteps extends WebDriverSettings {

    @Given("^I am on main application page5$")
    public void loadMainPage()
    {
        driver.get(MAIN_URL);
    }

    @When("^I login as correct user5$")
    public void loginAsCorrectUser()
    {
        loginPage.register(LOGIN, PASSWORD);
    }

    @Then("^I click button write letter5$")
    public void clickButtonWriteMessage()
    {
        sendLetterPage.clickButtonWriteLetter();
    }

    @Then("^I click on receiver field5$")
    public void clickReceiverField(){
        sendLetterGroupPage.clickFieldReceiver();
    }

    @Then("^I write receivers5$")
    public void writeReceivers()
    {
        sendLetterGroupPage.setEmail("sysrq0884@gmail.com");
        sendLetterGroupPage.setEmail("sysrq08884@mail.ru");
    }

    @Then("^I write message5$")
    public void writeMessage()
    {
        sendLetterGroupPage.writeMessage("cucumber to group");
    }

    @Then("^I click button send5$")
    public void clickButtonSend()
    {
        sendLetterPage.clickButtonSendLetter();
    }

    @Then("^I see what message send5$")
    public void infoMessageSend()
    {
        Assert.assertTrue(sendLetterPage.infoMessageSend());
    }

    @Then("^close browser5$")
    public void close(){
        driver.quit();
    }
}
