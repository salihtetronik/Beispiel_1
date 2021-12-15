package base.test;

import base.pages.BasiseinstellungenPage;
import base.pages.DaksLoginPage;
import base.utilites.Driver;
import base.utilites.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.util.List;

public class BasiseinstellungenTest {

    String url = "http://127.0.0.1";

    BasiseinstellungenPage basis = new BasiseinstellungenPage();

    @Test
    public void telefonieTest() {

        DaksLoginPage login = new DaksLoginPage();

        Driver.getDriver().get(url);

        login.userName.sendKeys("sysadm");

        login.password.sendKeys("sysadm");

        login.loginButton.click();

        //wenn oberfläche geöffnet wird, öffnet Basiseinstellungen Menu automatisch
        //  wait.until(ExpectedConditions.visibilityOf(basis.basisButton));
        //  basis.basisButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(basis.telefonie));

        basis.telefonie.click();
        ReusableMethods.sleep(1000);

        basis.callingName.sendKeys("Salih");
        ReusableMethods.sleep(1000);

        basis.callingNumber.sendKeys("2233");
        ReusableMethods.sleep(1000);
        basis.connectedNumber.sendKeys("11");
        ReusableMethods.sleep(1000);

        Select display = new Select(basis.autoBlätterDisplay);
        display.selectByValue("2000");
        ReusableMethods.sleep(1000);

        Select rundAus = new Select(basis.rundrufAusBasis);
        rundAus.selectByIndex((int) (Math.random() * rundAus.getOptions().size()));
        ReusableMethods.sleep(1000);

        basis.mlppVerwenden.click();
        ReusableMethods.sleep(1000);

        basis.sichern.click();
    }

    @Test
    @Parameters("kontrol") // bu testi birden fazla deger vererek ve parametre gonererek calistirabiliyoruz. bak:basiseinstellungenPrametersTest.xml
    public void nachwahlkennzahlenTest(String kontrol) {

        ReusableMethods.getLogin();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.visibilityOf(basis.nachwahlkennzahlen));

        basis.nachwahlkennzahlen.click();
        ReusableMethods.sleep(1000);
        basis.kontrolFunktion.clear();
        basis.kontrolFunktion.sendKeys(kontrol);
        ReusableMethods.sleep(1000);

        basis.sichern.click();

    }


    @Test
    public void zugangsdatenTest() {

        ReusableMethods.getLogin();

        if (ReusableMethods.isAlertReady()) {
            System.out.println("alert ok");
            Driver.getDriver().switchTo().alert().accept();
        } else {
            System.out.println("kein alert");
        }

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.visibilityOf(basis.zugangsdaten));


        basis.zugangsdaten.click();
        ReusableMethods.sleep(1000);

        basis.buchtabenZiffernErforderlich.click();
        ReusableMethods.sleep(1000);

        basis.sonderzeichenErforderlich.click();
        ReusableMethods.sleep(1000);

        basis.sichern.click();

        // Driver.closeDriver();
    }


    @Test
    public void defaultsprach() {

        ReusableMethods.getLogin();

        List<WebElement> defaultsprache = Driver.getDriver().findElements(By.xpath("(//select[@class='WICSelect ParameterEdit'])[3]"));

        // ArrayList <String> spracheElement = new ArrayList<>(List.of("Algemeines","telefonie","System-Display-/Audios","Nachwahlkennzahlen","Routing","Zugangsdaten"));

        for (WebElement element : defaultsprache) {

            System.out.println(element.getText());

            Assert.assertTrue(element.getText().contains("Algemeines,telefonie,System-Display-/Audios,Nachwahlkennzahlen,Routing,Zugangsdaten"));

        }
    }


    @Test
    public void tableTitelTest() {

        ReusableMethods.getLogin();

        if (ReusableMethods.isAlertReady()) {
            System.out.println("alert ok");
            Driver.getDriver().switchTo().alert().accept();
        } else {
            System.out.println("kein alert");
        }

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        wait.until(ExpectedConditions.visibilityOf(basis.telefonie));

        for (WebElement element : basis.tableTitel) {

            System.out.println(element.getText());
        }
    }
}
