package base.test;

import base.pages.DaksLoginPage;
import base.utilites.Driver;
import base.utilites.ReusableMethods;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginDataProviderTest {

    DaksLoginPage login = new DaksLoginPage();

    String url = "http://127.0.0.1";

    @Test(dataProvider = "getData")
    public void daksLoginTest(String username,String password) {

        Driver.getDriver().get(url);

        if (ReusableMethods.isAlertReady()) {
            System.out.println("alert ok");
            Driver.getDriver().switchTo().alert().accept();
        } else {
            System.out.println("kein alert");
        }

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        login.userName.sendKeys(username);
        ReusableMethods.sleep(1000);

        login.password.sendKeys(password);
        ReusableMethods.sleep(1000);

        login.loginButton.click();
        ReusableMethods.sleep(1000);

        wait.until(ExpectedConditions.visibilityOf(login.abmelden));

        Assert.assertTrue(login.abmelden.isDisplayed(), "AbmeldenButton hat keine");

        System.out.println(login.abmelden.getText());

        ReusableMethods.sleep(1000);
       // Driver.closeDriver();
    }






    @DataProvider
    public Object[][] getData() {

        Object[][] data = {
                {"sysadm", "sysadm"},
                {"sys", "adm"},
                {"qwertzuiopü12345667778899","123456987"},
                {" "," "}


        };
return data;
    }
    /*
    @Test
    public void daksLoginNegativeTest1() {

        Driver.getDriver().get(url);

        login.userName.sendKeys("sysadm");
        ReusableMethods.sleep(2000);

        login.password.sendKeys("SYSADM");

        login.loginButton.click();

        Assert.assertEquals(login.errorMesage.getText(), "Sie haben die falschen Logindaten eingegeben. Bitte melden Sie sich erneut an.");

        System.out.println(login.errorMesage.getText());
    }

    @Test
    public void daksLoginNegativeTest2(){

        Driver.getDriver().get(url);

        login.userName.sendKeys("SYSADM");
        ReusableMethods.sleep(1000);
        login.password.sendKeys("sysadm");
        ReusableMethods.sleep(1000);
        login.loginButton.click();

        Assert.assertTrue(login.errorMesage.getText().contains("falschen"));
    }

    @Test
    public void daksLoginNegativeTest3(){

       Driver.getDriver().get(url);
ReusableMethods.getVisibilityOfWait(login.password);
        login.userName.sendKeys("Daks123asdfghjklweerrtzuiioolpyxcvbnm");
        ReusableMethods.sleep(1000);
        login.password.sendKeys("12345678910.11223456987_456789LLLNNNNKKKKKKbbmm!123456789");
        ReusableMethods.sleep(1000);
        login.loginButton.click();

        Assert.assertTrue(login.errorMesage.getText().contains("fehlerhafte"));

    }
*/

}
