package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import testBase.Driver;
import testBase.MobileTestBase;

public class ComplainPage extends MobileTestBase {
    //Locators
    @AndroidFindBy(id = "in.testdemo.map:id/front_img")
    public MobileElement FrontImgBtn;
    @AndroidFindBy(id = "in.testdemo.map:id/back_img")
    public MobileElement BackImgBtn;
    @AndroidFindBy(id = "in.testdemo.map:id/left_img")
    public MobileElement LeftImgBtn;
    @AndroidFindBy(id = "in.testdemo.map:id/right_img")
    public MobileElement RightImgBtn;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]")
    public MobileElement SelectFromGallery;
    @AndroidFindBy(xpath = "(//android.widget.FrameLayout[@content-desc=\"Button\"])[1]/android.widget.FrameLayout[1]/android.widget.ImageView")
    public MobileElement SelectedImage;
    @AndroidFindBy(xpath = "in.testdemo.map:id/cmd_txt")
    public WebElement TxtBox;
    @AndroidFindBy(id = "in.testdemo.map:id/next_btn")
    public MobileElement NxtButton;
    MobileElement TextBox = Driver.appium.findElementById("in.testdemo.map:id/cmd_txt");

    public ComplainPage(AppiumDriver<MobileElement> appium) {
        PageFactory.initElements(new AppiumFieldDecorator(appium), this);
    }

    //Functions
    public void UploadFrontImgBtn() {
        waitUntilElementDisplayed(FrontImgBtn, 10);
        FrontImgBtn.click();
    }

    public void UploadBackImgBtn() {
        waitUntilElementDisplayed(BackImgBtn, 10);
        BackImgBtn.click();
    }

    public void UploadLeftImgBtn() {
        waitUntilElementDisplayed(LeftImgBtn, 10);
        LeftImgBtn.click();
    }

    public void UploadRightImgBtn() {
        waitUntilElementDisplayed(RightImgBtn, 10);
        RightImgBtn.click();
    }

    public void SelectImageFromGallery() {
        waitUntilElementDisplayed(SelectFromGallery, 10);
        SelectFromGallery.click();
        waitUntilElementDisplayed(SelectedImage, 10);
        SelectedImage.click();
    }

    public void PressOnNextBtn() {
        swipeUntilElementDisplayed(NxtButton);
        waitUntilElementDisplayed(NxtButton, 10);
        NxtButton.click();
    }

    public void WriteInTextBox() throws InterruptedException {
        Thread.sleep(10000);
        swipeUntilElementDisplayed(NxtButton);
        TxtBox.isDisplayed();
        TxtBox.click();

    }

    public void sendTextToElement(String text) {
        MobileElement TextBox = Driver.appium.findElementById("in.testdemo.map:id/cmd_txt");
        TextBox.setValue(text);
    }
}
