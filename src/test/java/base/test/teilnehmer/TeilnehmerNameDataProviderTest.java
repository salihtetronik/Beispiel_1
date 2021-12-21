package base.test.teilnehmer;

import base.pages.TeilnehmerPage;
import base.utilites.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TeilnehmerNameDataProviderTest {

    TeilnehmerPage teilnehmer=new TeilnehmerPage();

    @Test(dataProvider = "getData")
    public void teilnehmerNameSpeichernTest(String name) {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(TeilnehmerPage.teilnehmerButton);
        TeilnehmerPage.teilnehmerButton.click();
        ReusableMethods.getVisibilityOfWait(TeilnehmerPage.richtungstaste);
        TeilnehmerPage.richtungstaste.click();
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.scrollToElement(TeilnehmerPage.tableRufnummer198);
        TeilnehmerPage.tableRufnummer198.click();
        teilnehmer.bearbeitenButton.click();
        ReusableMethods.getVisibilityOfWait(TeilnehmerPage.nameOrt);
        TeilnehmerPage.nameOrt.clear();
        TeilnehmerPage.nameOrt.sendKeys(name);
        String value = TeilnehmerPage.nameOrt.getAttribute("value");
        System.out.println(value);
        System.out.println(value.length());
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);

        //  Erwartetes  Ergebnis ist True(sichernButton soll aktive sein), Aktueles Ergebnis  auch True. Test ist Erfolgreich
        Assert.assertTrue(teilnehmer.sichernButton.isEnabled());
    }


    @DataProvider
    public Object[] getData(){

        Object[] data={
                "qwertzuiopüasdfghjklöäyxcvbnmö",
                "qwertzuiopüasdfghjklöäyxcvbnm123456",
                "s",
                ""
        };
        return data;
    }
}
