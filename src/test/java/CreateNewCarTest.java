import models.Car;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewCarTest extends TestBase {
    @BeforeMethod
    public void preCondition(){
            if(app.userHelper().isLogin()){
            app.userHelper().loginUser();  }
        }

     @Test
    public void createNewCar(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
         System.out.println(i);
         Car car = Car.builder()
                 .address("Tel Aviv, Israel")
                 .make("BMW")
                 .model("MS")
                 .year("2020")
                 .engine("2.0")
                 .fuel("Petrol")
                 .gear("MT")
                 .wD("AWD")
                 .doors("5")
                 .seats("4")
                 .clasS("C")
                 .fuelConsumption("6.5")
                 .carRegNumber("12-"+i)
                 .price("65")
                 .distanceIncluded("500")
                 .typeFeature("type off")
                 .about("very good car")
                  .build();
         System.out.println("Car Number ---"+car.getCarRegNumber());
         app.carHelper().openCarForm();
         app.carHelper().fillCarForm(car);
         app.carHelper().attachPhoto();
         app.userHelper().pause(2000);
         app.carHelper().addCar();
         //assert
         String carAddS=app.userHelper().getText(By.xpath("//div//h1[.='Car added']"));
         Assert.assertTrue(carAddS.contains("added"));
         app.userHelper().pause(5000);



    }

}
