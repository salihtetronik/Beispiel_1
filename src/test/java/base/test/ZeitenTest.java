package base.test;

import base.pages.ZeitenPage;
import base.utilites.ParameterDriver;
import base.utilites.ReusableMethods;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ZeitenTest extends ParameterDriver {

    ZeitenPage zeiten=new ZeitenPage();

    @Test
    @Parameters("kalender")
    public void feierTageTest(String text){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(zeiten.zeitenButton).click();
        ReusableMethods.getVisibilityOfWait(zeiten.feierTage).click();
        ReusableMethods.doubleClick(zeiten.datumErsteRow);
        ReusableMethods.getVisibilityOfWait(zeiten.bezeichnung).clear();
        zeiten.bezeichnung.sendKeys(text);
        zeiten.kalender.click();
      //  ReusableMethods.getVisibilityOfWait(zeiten.kalenderMonthButton).click();
        zeiten.kalenderDezember22.click();
        zeiten.sichernButton.click();
    }
}
