package test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.utilities.Driver;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/enrollments']")
    public WebElement myDashboard;

    @FindBy(xpath = "//button[@class='dropdown__toggle-button']")
    public WebElement dropdownButton;
    @FindBy(xpath = "//a[@href='/account']")
    public WebElement myAccountButton;

    @FindBy(xpath = "//input[@id='user[profile_attributes][company]']")
    public WebElement companyTextBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement saveButton;


}
