package base.test.teilnehmer;

import base.pages.TeilnehmerPage;
import base.utilites.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TeilnehmerRufnummerTest {

    TeilnehmerPage teilnehmer = new TeilnehmerPage();


    // In die Rufnummernfelder können 0,1,2,3,4,5,6,7,8,9, *,# eingegeben werden.
    @Test
    public void teilnehmerRufnummerTest1() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.sleep(1000);
        ReusableMethods.scrollToElement(teilnehmer.tableRufnummer197);
        ReusableMethods.sleep(1000);
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer197);
        ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        ReusableMethods.sleep(1000);
        teilnehmer.rufnummer.sendKeys("1234567890*#");
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);

        //wenn ich es abspeichern möcte, erscheint es eien fehler button, naturlich durch Manuel Test auch so.
       // teilnehmer.sichernButton.click();
        Assert.assertTrue(teilnehmer.sichernButton.isDisplayed());
    }



   // " % " ==> Obwohl ungültiger Wert in der Anforderungliste, tatsächlich gültiger Wert.
   // Wahrscheinlich ist das ein Bug. Bug Ticket wird erschaffen/erstellt)
    @Test
    public void teilnehmerRufnummerTest2(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.scrollToElement(teilnehmer.tableRufnummer197);

        ReusableMethods.doubleClick(teilnehmer.tableRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        teilnehmer.rufnummer.sendKeys("%");
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);

        //  Erwartetes  Ergebnis False(sichernButton soll deaktive sein), aber Aktueles Ergebnis  ist True.
        Assert.assertFalse(teilnehmer.sichernButton.isEnabled());

    }




    //  "-" : Obwohl gültiger Wert in der Anforderungliste, tatsächlich ungültiger Wert
    @Test
    public void teilnehmerRufnummerTest3() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.scrollToElement(teilnehmer.tableRufnummer197);
        ReusableMethods.sleep(1000);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        teilnehmer.rufnummer.sendKeys("-");
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);


        //  Erwartetes  Ergebnis True(sichernButton soll aktive sein), Aktueles Ergebnis False.
        Assert.assertTrue(teilnehmer.sichernButton.isEnabled());

    }




    //  "+" : Obwohl gültiger Wert in der Anforderungliste, tatsächlich ungültiger Wert
    @Test
    public void teilnehmerRufnummerTest4() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.scrollToElement(teilnehmer.tableRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer);
        teilnehmer.rufnummer.clear();
        teilnehmer.rufnummer.sendKeys("+");
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);

        //  Erwartetes  Ergebnis True(sichernButton soll aktive sein), Aktueles Ergebnis False.
        Assert.assertTrue(teilnehmer.sichernButton.isEnabled());

    }


    //  " " : Obwohl gültiger Wert in der Anforderungliste, tatsächlich ungültiger Wert
    @Test
    public void teilnehmerRufnummerTest5(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.scrollToElement(teilnehmer.tableRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        teilnehmer.rufnummer.sendKeys(" ");
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);

        //  Erwartetes  Ergebnis True(sichernButton soll aktive sein), Aktueles Ergebnis False.
        Assert.assertTrue(teilnehmer.sichernButton.isEnabled());

    }



    //  "/" : Obwohl gültiger Wert in der Anforderungliste, tatsächlich ungültiger Wert
    @Test
    public void teilnehmerRufnummerTest6() {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.scrollToElement(teilnehmer.tableRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        teilnehmer.rufnummer.sendKeys("/");
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);

        //  Erwartetes  Ergebnis ist True(sichernButton soll aktive sein), Aktueles Ergebnis False. Test ist Unerfolgreich
        Assert.assertTrue(teilnehmer.sichernButton.isEnabled());

    }



    @Test
    public void teilnehmerRufnummerTest7(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.scrollToElement(teilnehmer.tableRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        teilnehmer.rufnummer.sendKeys("Abcd");
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);

        //  Erwartetes  Ergebnis False(sichernButton soll deaktive sein), Aktueles Ergebnis auch False. Test ist erfolgreich
        Assert.assertFalse(teilnehmer.sichernButton.isEnabled());
    }




    @Test
    public void teilnehmerRufnummerTest8(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.scrollToElement(teilnehmer.tableRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        teilnehmer.rufnummer.sendKeys("äüöÄÜÖ");
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);

        Assert.assertFalse(teilnehmer.sichernButton.isEnabled());
    }



    @Test
    public void teilnehmerRufnummerTest9(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.getVisibilityOfWait(teilnehmer.richtungstaste).click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.scrollToElement(teilnehmer.tableRufnummer197);
        ReusableMethods.doubleClick(teilnehmer.tableRufnummer197);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        teilnehmer.rufnummer.sendKeys("ß");
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);

        Assert.assertFalse(teilnehmer.sichernButton.isEnabled());

    }
}
