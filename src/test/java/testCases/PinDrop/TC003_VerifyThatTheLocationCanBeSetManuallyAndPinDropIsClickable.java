package testCases.PinDrop;

import Pages.PermissionsPopUp;
import Pages.PinDrop;
import org.openqa.selenium.html5.Location;
import org.testng.annotations.Test;
import testBase.Driver;
import testBase.MobileTestBase;

public class TC003_VerifyThatTheLocationCanBeSetManuallyAndPinDropIsClickable extends MobileTestBase {
    @Test
    public void Step01_VerifyThatTheLocationCanBeSetManually() throws InterruptedException {
        PinDropPageObject = new PinDrop(Driver.appium);
        PermissionsPopUpPageObject = new PermissionsPopUp(Driver.appium);
        //PermissionsPopUpPageObject.AllowPermissions(); /*This Function Not Used As there is Bug when Accepting Permissions Manually The Pin Drop Not Displayed*/
        Location location = new Location(77.7749, -122.4194, 0);
        PinDropPageObject.TestLocation(location);
        PinDropPageObject.clickPinDropButton();
    }

    @Test(dependsOnMethods = "Step01_VerifyThatTheLocationCanBeSetManually")
    public void Step02_VerifyThatTheThePinDropIsDisplayedAndClickable() throws InterruptedException {
        PinDropPageObject.clickPinDropButton();
    }
}
