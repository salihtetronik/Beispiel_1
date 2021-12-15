package base.pages;

import base.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TeilnehmerPage {

    public TeilnehmerPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//button[@name='MENU_BUTTON'])[10]")
    public WebElement teilnehmerButton;

    @FindBy(xpath = "//div[@class='WICTable_PAGINATORDIV GMDTable']/a[3]")
    public WebElement richtungstaste;

    @FindBy(xpath = "(//table)[3]//tr[197]/td[2]")
    public WebElement tableRufnummer197;

    @FindBy(xpath = "(//table)[3]//tr[198]/td[2]")
    public WebElement tableRufnummer198;

    @FindBy(xpath = "(//button[@class='WICButton ActionButton'])[1]")
    public WebElement bearbeitenButton;

    @FindBy(xpath = "(//button[@class='WICButton ActionButton'])[2]")
    public WebElement neuButton;

    @FindBy(xpath = "(//button[@class='WICButton ActionButton'])[3]")
    public WebElement kopierenButton;

    @FindBy(xpath = "(//button[@class='WICButton ActionButton'])[4]")
    public WebElement loschenButton;

    @FindBy(xpath = "(//input[@class='WICEdit SubsValue'])[1]")
    public WebElement nameOrt;

    @FindBy(xpath = "(//input[@class='WICEdit SubsValue'])[2]")
    public WebElement vornameQualifikation;

    @FindBy(xpath = "(//input[@class='WICEdit SubsValue'])[3]")
    public WebElement kurzbeschreibung;

    @FindBy(xpath = "(//input[@class='WICEdit SubsValue'])[4]")
    public WebElement benutzername;

    @FindBy(xpath = "(//input[@class='WICEdit SubsValue'])[5]")
    public WebElement passwort;

    @FindBy(xpath = "(//input[@class='WICEdit SubsValue'])[6]")
    public WebElement passwortWiederholung;

    @FindBy(xpath = "(//input[@class='WICEdit SubsValue'])[9]")
    public WebElement rufnummer;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement wirdUberwacht;


    @FindBy(xpath = "(//button[@class='WICButton ActionButton'])[1]")
    public WebElement sichernButton;

    @FindBy(xpath = "(//td[@align='left'])[15]")
    public WebElement td;
}
