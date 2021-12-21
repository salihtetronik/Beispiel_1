package base.pages;

import base.utilites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZeitenPage {

    public ZeitenPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//button[@name='MENU_BUTTON'])[3]")
    public WebElement zeitenButton;


    // Feiertage

    @FindBy(xpath = "(//table)[2]//tr/td[2] ")
    public WebElement feierTage;

    @FindBy(xpath = "(//table)[4]//tr[1]/td[1] ")
    public WebElement datumErsteRow;

    @FindBy(xpath = "//button[@class='WICButton BtShowCalendar']")
    public WebElement kalender;

    @FindBy(xpath = "(//table)[2]//tr[7]/td[1] ")
    public WebElement kalenderNovember29;

    @FindBy(xpath = "(//table)[2]//tr[1]/td[3]")
    public WebElement kalenderMonthButton;

    @FindBy(xpath = "//table//tr[6]/td[3]")
    public WebElement kalenderDezember22;

    @FindBy(xpath = "(//table)[2]//tr[8]/td/button")
    public WebElement kalenderSchließen;



    // Zeitenbereich

    @FindBy(xpath = "(//table)[4]//tr[1]/td[1]")
    public WebElement zeitbereiche1;

    @FindBy(xpath = "(//table)[4]//tr[2]/td[1]")
    public WebElement zeitbereiche2;

    @FindBy(xpath = "(//table)[4]//tr[3]/td[1]")
    public WebElement zeitbereiche3;

    @FindBy(xpath = "(//table)[4]//tr[4]/td[1]")
    public WebElement zeitbereiche4;

    // sadece tr no degistirerek digerleri bulunur
    @FindBy(xpath = "(//table)[4]//tr[5]/td[1]")
    public WebElement zeitbereiche5;

    @FindBy (xpath = "//input[@class='WICEdit HolidayName']")
    public WebElement bezeichnung;

    @FindBy(xpath = "(//button[@class='WICButton ActionButton'])[1]")
    public WebElement sichernButton;

}
