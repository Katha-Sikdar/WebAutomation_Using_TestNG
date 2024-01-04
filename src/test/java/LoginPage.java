import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    @FindBy(name= "username")
    WebElement txtUserName;
    @FindBy(name = "password")
    WebElement txtPassword;
    @FindBy(className = "oxd-button")
    WebElement BtnLogin;
    @FindBy(className = "oxd-userdropdown-name")
    WebElement lblUsername;
    @FindBy(className = "oxd-userdropdown-link")
    List<WebElement> cbUserMenu;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void doLogin(String username, String password){
        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
        BtnLogin.click();

    }

    public void doLogout(){
        lblUsername.click();
        cbUserMenu.get(3).click();
    }
}
