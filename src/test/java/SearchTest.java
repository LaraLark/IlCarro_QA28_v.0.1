import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @Test(groups = {"web"})
    public void  positiveTestSendKey(){
        //with concantinate String
        logger.info("Haifa","08/10/2021","08/30/2021");
        app.searchHelper().typeSearchCurrentMonth("Haifa","08/03/2021","08/15/2021");
        logger.info("message");
        app.userHelper().submitForm();
        app.carHelper().pause(2000);
        Assert.assertTrue(app.searchHelper().isListOfCarAppeared());
    }
    @Test(groups = {"a","web"})
    public void  negativeTestSendKey(){
        //with concantinate String
        app.searchHelper().typeSearchCurrentMonth("Haifa","06/26/2021","06/30/2021");
        app.carHelper().pause(2000);
        Assert.assertTrue(app.searchHelper().isDataInPath());
        Assert.assertTrue(app.searchHelper().buttonYallaInactive());
    }
    @Test
    public void selectPeriodCurrentMonth(){
        app.searchHelper().fillSearchFormCurrentMonth("Haifa","08/10/2021","08/30/2021");
        app.userHelper().submitForm();
        app.carHelper().pause(2000);
        Assert.assertTrue(app.searchHelper().isListOfCarAppeared());

    }
    @Test
    public void selectedPeriodInFuture(){
        app.searchHelper().fillSearchFormInFuture("Haifa","09/26/2021","10/30/2021");
        app.userHelper().submitForm();
        app.carHelper().pause(2000);
        Assert.assertTrue(app.searchHelper().isListOfCarAppeared());
    }
    @AfterMethod
    public void postConditions(){
        app.searchHelper().backToHome();
    }
}
