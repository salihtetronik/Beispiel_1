package base.pages;

import base.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class BasiseinstellungenPage {

    public BasiseinstellungenPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//td[@align='left'])[2]")
    public WebElement basisButton;

    @FindBy(xpath = "(//table)[2]//tr/td")
    public List<WebElement> tableTitel;

    @FindBy(xpath = "((//table)[2]//tr/td)[2]")
    public WebElement telefonie;

    @FindBy(xpath = "(//input[@class='WICEdit ParameterEdit'])[10]")
    public WebElement callingName;

    @FindBy(xpath = "(//input[@class='WICEdit ParameterEdit'])[11]")
    public WebElement callingNumber;

    @FindBy(xpath = "(//input[@class='WICEdit ParameterEdit'])[14]")
    public WebElement connectedNumber;

    @FindBy(xpath = "(//input[@class='WICEdit ParameterEdit'])[15]")
    public WebElement resKanalEinwahl;

    //@FindAll({@FindBy(xpath = "//select[@class='WICSelect ParameterAutoScrollSelect']")})
    // public List<WebElement> autoBlätterDisplay;

    @FindBy(xpath = "//select[@class='WICSelect ParameterAutoScrollSelect']")
    public WebElement autoBlätterDisplay;

    @FindBy(xpath = "(//select[@class='WICSelect ParameterEdit'])[5]")
    public WebElement rundrufAusBasis;

    @FindBy(xpath = "(//input[@type='checkbox'])[7]")
    public WebElement mlppVerwenden;

    @FindBy(xpath = "(//button[@class='WICButton ActionButton'])[1]")
    public WebElement sichern;

    // Seite nachwahlkennzahlen

    @FindBy(xpath = "(//table)[2]//tr/td[4]")
    public WebElement nachwahlkennzahlen;

    @FindBy(xpath = "(//input[@maxlength='4'])[14]")
    public WebElement kontrolFunktion;

// Seite Zugangsdaten

    @FindBy(xpath = "(//table)[2]//tr/td[6]")
    public WebElement zugangsdaten;

    // Diese WebElemment wird  auf Zugangsdaten Seite nicht gelöscht. Wahrscheinlich kann sie andere Seite geändert wird.
    @FindBy(xpath = "(//input[@type='checkbox'])[8]")
    public WebElement hoherePaswortSicherheit;

    // Min Anzahl soll 4 sein, trotzdem kann man andere Nummer nicht schreiben
    @FindBy(xpath = "(//select[@class='WICSelect ParameterEdit'])[6]")
    public WebElement minAnzahlZeichen;

    @FindBy(xpath = "(//input[@type='checkbox'])[9]")
    public WebElement buchtabenZiffernErforderlich;

    @FindBy(xpath = "(//input[@type='checkbox'])[10]")
    public WebElement sonderzeichenErforderlich;

    // Seite Allgemein

    @FindBy(xpath = "(//select[@class='WICSelect ParameterEdit'])[1]")
    public WebElement zeitFormat;

    @FindBy(xpath = "(//select[@class='WICSelect ParameterEdit'])[2]")
    public WebElement datumsFormat;

    @FindBy(xpath = "(//select[@class='WICSelect ParameterEdit'])[3]")
    public WebElement defaultSprache;

    @FindBy(xpath = "(//select[@class='WICSelect ParameterEdit'])[4]")
    public WebElement anzahlHochpriorProsses;



}
