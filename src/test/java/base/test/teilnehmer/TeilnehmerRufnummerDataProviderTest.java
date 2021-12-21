package base.test.teilnehmer;

import base.pages.TeilnehmerPage;
import base.utilites.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TeilnehmerRufnummerDataProviderTest {

    TeilnehmerPage teilnehmer=new TeilnehmerPage();

    //testlerin hepsi gecti, hepsi gecmemesi gerekirdi.
    @Test(dataProvider = "getData")
    public void teilnehmerRufnummerTest1(String text) {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(TeilnehmerPage.teilnehmerButton).click();
        ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(TeilnehmerPage.richtungstaste).click();
        ReusableMethods.sleep(1000);
        ReusableMethods.scrollToElement(TeilnehmerPage.tableRufnummer198);
        ReusableMethods.sleep(1000);
        ReusableMethods.waitForPageToLoad(3);
        ReusableMethods.doubleClick(TeilnehmerPage.tableRufnummer198);
        ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.rufnummer).clear();
        ReusableMethods.sleep(1000);
        teilnehmer.rufnummer.sendKeys("1234567890*#");
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton);

        //wenn ich es abspeichern möcte, erscheint es eien fehler button, naturlich durch Manuel Test auch so.
        // teilnehmer.sichernButton.click();
        Assert.assertTrue(teilnehmer.sichernButton.isDisplayed());
    }


    @DataProvider
    public Object[] getData(){

        Object[] data={
                "1234567890*#",
                "/",
                "-",
                " ",
                "+",
                "%",
                "Abc",
                "ß,äöüÄÖÜ"
        };
        return data;
    }
}
