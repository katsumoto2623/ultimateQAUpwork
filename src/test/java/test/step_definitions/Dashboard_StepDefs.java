package test.step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import test.pages.DashboardPage;
import test.utilities.Driver;

public class Dashboard_StepDefs {
    String companyName1;
    DashboardPage dashboardPage = new DashboardPage();
    Actions actions = new Actions(Driver.getDriver());

    @When("user goes to profile page")
    public void user_goes_to_profile_page() {
        dashboardPage.dropdownButton.click();
        dashboardPage.myAccountButton.click();

    }
    @When("user can update company name as {string}")
    public void user_can_update_company_name_as(String companyName) {

        companyName1=companyName;
        dashboardPage.companyTextBox.clear();
        dashboardPage.companyTextBox.sendKeys(companyName);

        //Actions is used to click the save button since it is not clickable as WebElement
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.moveToElement(dashboardPage.saveButton).perform();
        dashboardPage.saveButton.click();


    }
    @Then("company name should be same")
    public void company_name_should_be_same() {

        //Assertion to check whether the information updated correctly
        Assert.assertEquals(companyName1,dashboardPage.companyTextBox.getAttribute("value"));

    }

}
