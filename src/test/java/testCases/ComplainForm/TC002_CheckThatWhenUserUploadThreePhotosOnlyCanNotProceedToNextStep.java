package testCases.ComplainForm;

import Pages.ComplainPage;
import Pages.PinDrop;
import org.openqa.selenium.html5.Location;
import org.testng.annotations.Test;
import testBase.Driver;
import testBase.MobileTestBase;

public class TC002_CheckThatWhenUserUploadThreePhotosOnlyCanNotProceedToNextStep extends MobileTestBase {

    @Test
    public void Step01_PressOnPinDrop() throws InterruptedException {
        PinDropPageObject = new PinDrop(Driver.appium);
        Location location = new Location(77.7749, -122.4194, 0);
        PinDropPageObject.TestLocation(location);
        PinDropPageObject.clickPinDropButton();
    }
    @Test(dependsOnMethods = "Step01_PressOnPinDrop")
    public void Step02_AddComment() throws InterruptedException {
        Thread.sleep(7000);
        ComplainPageObject = new ComplainPage(Driver.appium);
        ComplainPageObject.sendTextToElement("Text To Be AE");
    }
    @Test(dependsOnMethods = "Step02_AddComment")
    public void Step03_UploadFrontImage(){
        ComplainPageObject.UploadFrontImgBtn();
        ComplainPageObject.SelectImageFromGallery();
    }
    @Test(dependsOnMethods = "Step03_UploadFrontImage")
    public void Step04_UploadBackImage(){
        ComplainPageObject.UploadBackImgBtn();
        ComplainPageObject.SelectImageFromGallery();
    }
    @Test(dependsOnMethods = "Step04_UploadBackImage")
    public void Step05_UploadLeftImage() {
        ComplainPageObject.UploadLeftImgBtn();
        ComplainPageObject.SelectImageFromGallery();
    }

    @Test(dependsOnMethods = "Step05_UploadLeftImage")
    public void Step06_PressNextButton(){
        ComplainPageObject = new ComplainPage(Driver.appium);
        ComplainPageObject.PressOnNextBtn();
    }
}
