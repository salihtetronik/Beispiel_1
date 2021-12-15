package base.utilites;

import base.pages.DaksLoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {

public static void sleep(int miliseconds){

    try {
        Thread.sleep(miliseconds);
    }catch (InterruptedException e){
        e.printStackTrace();
    }
}

    public static void getLogin(){

        Driver.getDriver().get("http://127.0.0.1");

        DaksLoginPage login = new DaksLoginPage();

        if (ReusableMethods.isAlertReady()) {
            System.out.println("alert ok");
            Driver.getDriver().switchTo().alert().accept();
        } else {
            System.out.println("kein alert");
        }

        login.userName.sendKeys("sysadm");
        login.password.sendKeys("sysadm");
        login.loginButton.click();
    }


    public static WebElement getVisibilityOfWait(WebElement element){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }


    public static void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }


    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

// es ist Funktioniert
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

// ise yaramadi
    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if (y == 1)
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }


    public static boolean isAlertReady(){
        try {
            Driver.getDriver().switchTo().alert();
        }catch (Exception e){
            return false;
        }
        return true;


    }



public static WebElement getRowUndCol(int l,int c){

    return Driver.getDriver().findElement(By.xpath("(//table)[1]//tr["+l+"]/td["+c+"]"));
}

public static WebElement getBestimmteCol(){

    return Driver.getDriver().findElement(By.xpath("(//table)[3]//tr/td[3]"));
}

public static WebElement getAlleRow(){

    return Driver.getDriver().findElement(By.xpath("//table/tbody/tr"));
}

public static WebElement getAlleZellen(){

    return Driver.getDriver().findElement(By.xpath("//table/tbody//td"));
}

// das muss Algemein sein
    public static boolean istDisplay(String text, WebElement element){


        List<WebElement> defaultsprache = Driver.getDriver().findElements(By.xpath("(//select[@class='WICSelect ParameterEdit'])[3]"));

        ArrayList<String> spracheElement = new ArrayList<>(List.of(text));


        for (int i = 0; i < defaultsprache.size(); i++) {
            if (spracheElement.contains(defaultsprache.get(i))) return true;
            else return false;
        }
        return true;

    }

    // fur dieses Method; später fur jeder WwebElemen einen WebElemet assign sollen, momentan geht das nicht
    public static String teilnehmerMenu(WebElement element,String text){

        ReusableMethods.getVisibilityOfWait(element);

        element.click();
        ReusableMethods.getVisibilityOfWait(element);
        element.click();
        ReusableMethods.scrollToElement(element);

        Actions builder = new Actions(Driver.getDriver());
        Action build = builder.moveToElement(element).doubleClick().build();
        ReusableMethods.sleep(1000);
        build.perform();
        ReusableMethods.getVisibilityOfWait(element);

        element.clear();
        element.sendKeys("S");
        return text;
    }
}
