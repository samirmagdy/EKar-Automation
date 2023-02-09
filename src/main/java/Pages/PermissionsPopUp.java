package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import testBase.MobileTestBase;

public class PermissionsPopUp extends MobileTestBase {

    //Locators
    @AndroidFindBy(id = "com.android.permissioncontroller:id/content_container")
    public MobileElement PermissionsPopUp;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public MobileElement WhileUsingThisAppBtn;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    public MobileElement OnlyThisTimeBtn;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    public MobileElement DontAllowBtn;

    public PermissionsPopUp(AppiumDriver<MobileElement> appium) {
        PageFactory.initElements(new AppiumFieldDecorator(appium), this);
    }

    //Functions
    public void CheckPermissionsPopUpIsDisplayed() {
        waitUntilElementDisplayed(PermissionsPopUp, 10);
        PermissionsPopUp.isDisplayed();
        System.out.println("Permission Pop-Up Displayed");
    }

    public void AllowPermissions() throws InterruptedException {
        WhileUsingThisAppBtn.isDisplayed();
        WhileUsingThisAppBtn.click();
        System.out.println("Location Permission Allowed");
    }

    public void PressOnOnlyThisTimeBtn() throws InterruptedException {
        OnlyThisTimeBtn.isDisplayed();
        OnlyThisTimeBtn.click();
        System.out.println("Location Permission Allowed Only For One Time");
    }

    public void PressOnDontAllowBtn() throws InterruptedException {
        DontAllowBtn.isDisplayed();
        DontAllowBtn.click();
        System.out.println("Location Permission Denied");
    }


}
