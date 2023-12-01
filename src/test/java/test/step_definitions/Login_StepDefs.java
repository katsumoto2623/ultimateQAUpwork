package test.step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import test.pages.DashboardPage;
import test.pages.LoginPage;
import test.utilities.BrowserUtils;
import test.utilities.ConfigurationReader;
import test.utilities.Driver;

public class Login_StepDefs {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("base.url"));

    }

    @When("user enters username")
    public void userEntersUsername() {
        //I used the configuration.properties file to get the username to avoid hardcoding
        loginPage.username.sendKeys(ConfigurationReader.getProperty("username"));
    }

    @And("user enters password")
    public void userEntersPassword() {

        //I used the configuration.properties file to get the password
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.signInButton.click();

        //I gave 15 seconds to manually pass the captcha
        BrowserUtils.waitFor(15);
    }

    @Then("user should see the dashboard")
    public void userShouldSeeTheDashboard() {
        //Assertion to check whether user on the Dashboard page
        Assert.assertTrue(dashboardPage.myDashboard.getText().contains("My Dashboard"));
    }



  }
