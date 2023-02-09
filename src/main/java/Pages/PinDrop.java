package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import testBase.Driver;
import testBase.MobileTestBase;

public class PinDrop extends MobileTestBase {
    protected static AppiumDriver<?> driver;
    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Inuvik, Unorganized, NT, Canada. \"])[1]")
    public MobileElement pinDropButton;
    @AndroidFindBy(id = "in.testdemo.map:id/map")
    public MobileElement Map;

    public PinDrop(AppiumDriver<MobileElement> appium) {
        PageFactory.initElements(new AppiumFieldDecorator(appium), this);
    }

    public void CheckMapsIsDisplayed() {
        try {
            Map.isDisplayed();
            System.out.println("The Map is found");
        } catch (NoSuchElementException e) {
            System.out.println("The Map was not found");
        }
    }

    public void clickPinDropButton() throws InterruptedException {
        try {
            waitUntilElementDisplayed(pinDropButton, 10);
            pinDropButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("Pin drop button not found on the page");
        }
    }

    public void TestLocation(Location locationToTest) {
        this.SetLocation(locationToTest);
        this.CompareLocation(locationToTest);
    }

    private void SetLocation(Location locationObject) {
        Driver.appium.setLocation(locationObject);
        System.out.println("Location Manually Set Successfully");
    }

    private String getLocation() {
        return Driver.appium.location().toString();
    }

    private void CompareLocation(Location locationToCompare) {
        Assert.assertEquals(locationToCompare.toString(), this.getLocation());
        System.out.println("Assertion Completed");
    }

}
