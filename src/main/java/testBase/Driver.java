package testBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

public class Driver {
    public static AppiumDriver<MobileElement> appium = null;
    public static WebDriver seleniumDriver = null;
    public static AndroidDriver androidDriver = null;
}
