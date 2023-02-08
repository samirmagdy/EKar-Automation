package testCases.PinDrop;

import Pages.PermissionsPopUp;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import testBase.Driver;
import testBase.MobileTestBase;

import java.net.MalformedURLException;
import java.net.URL;

public class TC001_CheckPermissionsPopUpIsDisplayed extends MobileTestBase {
    private DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    @Test
    public void Step01_VerifyThatPermissionsPopUpIsDisplayedAfterInstallationFirstRun() throws MalformedURLException {
        desiredCapabilities.setCapability("autoGrantPermissions", false);
        Driver.appium = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        PermissionsPopUpPageObject = new PermissionsPopUp(Driver.appium);
        PermissionsPopUpPageObject.CheckPermissionsPopUpIsDisplayed();
    }
}
