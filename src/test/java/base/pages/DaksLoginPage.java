package base.pages;

import base.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DaksLoginPage {

    public DaksLoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath ="//input[@name='user']")
public WebElement userName;


    @FindBy(xpath = "//input[@name='password']")

    public WebElement password;

    @FindBy(xpath = "//div[@class='loginButton de_DE']")

    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='WICButton_TEXT ']")

    public WebElement abmelden;

    @FindBy(xpath = "//div[@class='errorMesage']")

    public WebElement errorMesage;





}
