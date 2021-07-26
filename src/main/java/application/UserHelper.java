package application;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[.=' Log in ']"));

    }
    public void fillLoginForm(String email, String password){
        type(By.id("email"),email);
        type(By.id("password"),password);
    }
    public void fillLoginForm(User user){
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
    }
    public void submitForm(){
        click(By.xpath("//*[@type='submit']"));

        }

    public void clickOkButton() {

        click(By.xpath("//button[.='Ok']"));
    }
    public void openRegForm() {
        click(By.xpath("//a[@href='/registration?url=%2Fsearch']"));
    }
    public void fillRegForm(User user) {
       type(By.id("name"),user.getName());
       type(By.id("lastName"),user.getLastName());
       type(By.id("email"),user.getEmail());
       type(By.id("password"),user.getPassword());


    }


    public boolean isLogged() {
        return wd.findElements(By.xpath("//a[.=' Log in ']")).size()>0;
    }
    public void logout() {

        click(By.xpath("//a[.=' Logout ']"));
    }

    public void clickSubmitAgree() {
        click(By.cssSelector("label.checkbox-label.terms-label:last-child"));
    }

    public void acceptAlert() {
        new WebDriverWait(wd,10).until(ExpectedConditions.alertIsPresent());
        wd.switchTo().alert().accept();
    }


    public boolean isLogout() {
        return wd.findElements(By.xpath("//a[@href='/logout?url=%2Fsearch']")).size()>0;
    }

    public void clickButtonOk() {
        click(By.xpath("//*[.='Ok']"));
    }

    public void openRegistForm() {
        click(By.xpath("//a[.=' Sign up ']"));
    }

    public void fillregistrForm(User user) {
        type(By.id("name"),user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());

    }

    public void userPolicy() {
        click(By.cssSelector("label[for='terms-of-use']"));
    }


    public void loginUser() {
        click(By.xpath("//a[.=' Log in ']"));
        fillLoginForm("noa-18@gmail.com","Nnoa12345$");
        submitForm();

    }

    public boolean isLogin() {
        return wd.findElements(By.xpath("//a[.=' Log in ']")).size()>0;
    }
}

