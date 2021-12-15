package base.test.teilnehmer;


import base.pages.TeilnehmerPage;
import base.utilites.Driver;
import base.utilites.ReusableMethods;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TeilnehmerNameTest {

    TeilnehmerPage teilnehmer = new TeilnehmerPage();


    // Die administerten Daten können abspeichern.
    @Test
    public void teilnehmerNameSpeichernTest1() {


        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.sleep(1000);
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.sleep(1000);
        ReusableMethods.scrollToElement(teilnehmer.tableRufnummer197);
        ReusableMethods.sleep(1000);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer197);
        ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt);
        ReusableMethods.sleep(1000);
        teilnehmer.nameOrt.clear();
        ReusableMethods.sleep(1000);
        teilnehmer.nameOrt.sendKeys("OM!-AXI$/Targät 5940_Ü'ÖÄ*öü#H"); // String length =30  und Buchstaben, Zahlen und Sondernzeichen
        ReusableMethods.sleep(2000);

        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);
        teilnehmer.sichernButton.click();
        ReusableMethods.sleep(1000);

        Assert.assertTrue(teilnehmer.bearbeitenButton.isDisplayed());

    }


    //Längenbegrenzungen wurden gemessen
    @Test
    public void teilnehmerNameSpeichernTest2() {

        ReusableMethods.getLogin();

        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.sleep(1000);
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.scrollToElement(teilnehmer.tableRufnummer197);
        ReusableMethods.sleep(1000);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer197);
        ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).clear();
        ReusableMethods.sleep(1000);
        teilnehmer.nameOrt.sendKeys("QWERTZUIOPÜASDFGHJKLÖÄYXCVBNM123456"); // String lengt = 35
        String value = teilnehmer.nameOrt.getAttribute("value");
        System.out.println(value);
        System.out.println(value.length());

    }


    @Test
    public void teilnehmerNameSpeichernTest3() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton);
        teilnehmer.teilnehmerButton.click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste);
        teilnehmer.richtungstaste.click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.scrollToElement(teilnehmer.tableRufnummer198);
        teilnehmer.tableRufnummer198.click();
        teilnehmer.bearbeitenButton.click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt);
        teilnehmer.nameOrt.clear();
        teilnehmer.nameOrt.sendKeys("S");
        String value = teilnehmer.nameOrt.getAttribute("value");
        System.out.println(value);
        System.out.println(value.length());
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);

        //  Erwartetes  Ergebnis ist True(sichernButton soll aktive sein), Aktueles Ergebnis  auch True. Test ist Erfolgreich
        Assert.assertTrue(teilnehmer.sichernButton.isEnabled());
    }


    @Test
    public void teilnehmerNameSpeichernTest4() {

        ReusableMethods.getLogin();



        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton);
        teilnehmer.teilnehmerButton.click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste);
        teilnehmer.richtungstaste.click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.scrollToElement(teilnehmer.tableRufnummer198);
        Actions builder = new Actions(Driver.getDriver());
        Action build = builder.moveToElement(teilnehmer.tableRufnummer198).doubleClick().build();
        ReusableMethods.sleep(1000);
        build.perform();
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt);
        teilnehmer.nameOrt.clear();
        teilnehmer.nameOrt.sendKeys("");
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);

        //  Erwartetes  Ergebnis ist False(sichernButton soll deaktive sein), Aktueles Ergebnis  auch False. Test ist Erfolgreich
        Assert.assertFalse(teilnehmer.sichernButton.isEnabled());


    }


}
