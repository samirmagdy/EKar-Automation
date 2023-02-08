package testBase;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.AppiumDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;


public class MobileTestBase extends PageObjects{
    private static AppiumDriverLocalService service;
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "13.0");
        desiredCapabilities.setCapability("deviceName", "Galaxy A51");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("app", "/Users/samirmagdy/eclipse-workspace/EkarDemoApp/src/test/resources/App/ekar-app-demo.apk");
        desiredCapabilities.setCapability("appPackage", "in.testdemo.map");
        desiredCapabilities.setCapability("appActivity", "in.testdemo.map.MainActivity");
        desiredCapabilities.setCapability("udid", "RZ8N1184NKD");
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        desiredCapabilities.setCapability("noReset", false);
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(4723).withCapabilities(desiredCapabilities));
        service.start();
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        Driver.appium = new AppiumDriver(url, desiredCapabilities);
    }
    @AfterSuite
    public static void stopAppiumServer() {
        service.stop();
    }
    //Common Used Functions
    public static void waitUntilElementDisplayed(MobileElement element, int timeoutInSeconds) {
        (new WebDriverWait(Driver.appium, timeoutInSeconds)).until(ExpectedConditions.visibilityOf(element));
    }
    public void swipeUntilElementDisplayed(MobileElement element) {
        TouchAction action = new TouchAction(Driver.appium);
        int startY = (int) (Driver.appium.manage().window().getSize().getHeight() * 0.8);
        int endY = (int) (Driver.appium.manage().window().getSize().getHeight() * 0.2);
        int centerX = Driver.appium.manage().window().getSize().getWidth() / 2;
        while (!element.isDisplayed()) {
            action.press(PointOption.point(centerX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(centerX, endY)).release().perform();
        }
    }

}
