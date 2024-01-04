import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class PIMTestRunner extends Setup {
@BeforeTest
    public  void doLogin(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin("admin", "admin123");
    }
@Test(priority = 1)
    public void createUser(){
        PIMPage pimPage=new PIMPage(driver);
        pimPage.createUser( "Katha", "Sikdar", "KathaSikdar1", "Katha123@");
        WebElement headerElement= driver.findElement(By.xpath("//h6[text()=\"personal Details\"]"));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf((WebElement) headerElement));

        String textActual = headerElement.getText();
        String textExpected="Personal Details";
        //WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
       // wait.until(ExpectedConditions.visibilityOf((WebElement) headerElement));
        Assert.assertEquals(textActual, textExpected);
    }
}
