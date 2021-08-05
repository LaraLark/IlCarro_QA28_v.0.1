import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{
 @BeforeMethod(alwaysRun = true)
 public void preCondition(){
  if(!app.userHelper().isLogged()){
   app.userHelper().logout();
  }

 }

  @Test(groups = {"web"})
 public void regUser(){
  int i =(int) ((System.currentTimeMillis()/1000)*3600);
  User user = new User().withName("Mona").withLastName("Dow").withEmail("mona"+i+"@gmail.com").withPassword("Mm123"+i+"$");
  logger.info("Registration with -->Name:"+user.getName()+"LastName--->"+user.getLastName()+"Email--->"+user.getEmail()+"Password--->"+user.getPassword());

  app.userHelper().openRegistForm();
  app.userHelper().fillregistrForm(user);
   app.userHelper().pause(7000);
  app.userHelper().userPolicy();
  app.userHelper().submitForm();
  app.userHelper().pause(7000);
   String regS=app.userHelper().getText(By.xpath("//div[@class='dialog-container']//h2"));
   Assert.assertTrue(regS.contains("success"));
   logger.info("Test passed");


 }
   @AfterMethod

    public void postCondition(){
        app.userHelper().clickOkButton();
    }

}
