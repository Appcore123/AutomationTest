package testing;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("ALL")
public class Run_test {

//    Scanner scanner2 = new Scanner(System.in);
//    public String scanner = scanner2.nextLine();
    private AppiumDriver driver;
    static int is_Premium = 0  ;//0: no status, 1: gift require status, 2: gift not require status
    MobileElement ListElement;


    @BeforeSuite
    public void bf_Class() throws MalformedURLException, InterruptedException {
        /*create capabilities for android devices*/
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.UDID, "eacy5d8pxg6lijaa");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability("appPackage", "com.minakomiapp.dev");
        capabilities.setCapability("appActivity", "com.minakomi.MainActivity");
        //get localhost address and connect with appium server
        URL appiumurl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(appiumurl, capabilities);
//        ListElement.add((MobileElement) driver.findElements(AndroidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").index(5)")));


//        /*create capabilities for ios devices*/
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"16.7.2");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Bé Tường");
//        capabilities.setCapability(MobileCapabilityType.UDID, "4a0ac5a7e84be117ff0033c9e64ef711da61c78c");
//        capabilities.setCapability(MobileCapabilityType.APP,"/Users/foxlucius/IdeaProjects/untitled3/app/Minakomi-Dev.ipa");
//        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
//        capabilities.setCapability("bundleId","com.minakomiapp.dev");
//        capabilities.setCapability("appActivity", "com.minakomi.MainActivity");
//        capabilities.setCapability("xcodeOrgId", "7N3H5WHLD7");
//        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
//        URL appiumurl = new URL("http://127.0.0.1:4723/wd/hub");


//        is_Premium = isElementPresent();

    }



    @Test
    public void TC_0001_Scrollable_down() throws InterruptedException {
        int looptimes = 4; // this variable stand for time for scrolling screen
        for (int time_of_looop = 0; time_of_looop < looptimes; time_of_looop++) {
            scroll_screen("down");
        }
    }

    @Test
    public void TC_0001_Scrollable_up() throws  InterruptedException{
        int looptimes = 4; // this variable stand for time for scrolling screen
        for (int time_of_loop = 0; time_of_loop < looptimes; time_of_loop++) {
            scroll_screen("up");
        }
    }

    @Test
    public void TC_0001_Scrollable_mixed() throws  InterruptedException{
        int looptimes = 4; // this variable stand for time for scrolling screen
        for (int time_of_loop = 0; time_of_loop < looptimes*2; time_of_loop++) {
            if(time_of_loop%2==0){
                scroll_screen("down");
                scroll_screen("up");
            }else {
                scroll_screen("down");
                scroll_screen("up");
                scroll_screen("down");
            }
        }
    }



//    @Test
//    public void TC_002(){
//        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
//        System.out.println("Executed TC_002 that performed switch between all the tab of the bottom-menu");
//        MobileElement element_Home = (MobileElement) openapp.findElementsByXPath("");
//        MobileElement element_Hooray = (MobileElement) openapp.findElementsByXPath("");
//        MobileElement element_Noti = (MobileElement) openapp.findElementsByXPath("");
//        MobileElement element_Account = (MobileElement) openapp.findElementsByXPath("");
//        element_Home.click();
//        element_Hooray.click();
//        element_Noti.click();
//        element_Account.click();
//    }


//    public boolean isElementPresent() {
//        try {
//            driver.findElementByXPath(locator);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//        MobileElement Is_Premium = null;
//        driver.manage().timeouts().implicitlyWait(5L,TimeUnit.SECONDS);
//        Is_Premium = (MobileElement) driver.findElement(AndroidUIAutomator("new UiSelector().textContains(\"Cao cấp\")"));
//        if (Assert  driver.findElement(AndroidUIAutomator("new UiSelector().textContains(\"Cao cấp\")")) != null ){
//            return true;
//        } else if (Is_Premium != null) {
//            return false;
//        }else{
//            return false;
//     }

//    }
    public void Check_is_premium(){
        try{
            driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
            MobileElement Gift = (MobileElement) driver.findElementByAccessibilityId("Tặng quà");
            is_Premium=1;
        }catch (NoSuchElementException exception){
            is_Premium=2;
        }
        System.out.println(is_Premium);
    }

    public void scroll_screen(String scroll_direction){
        //The viewing size of the device
        Dimension size = driver.manage().window().getSize();
        //x position set to mid-screen horizontally
        int width = size.width / 2;
        //Starting y location set to 80% of the height (near bottom)
        int startPoint = (int) (size.getHeight() * 0.80);
        //Ending y location set to 20% of the height (near top)
        int endPoint = (int) (size.getHeight() * 0.20);
        if (scroll_direction == "down"){
            new TouchAction(driver).press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(0))).moveTo(PointOption.point(width, endPoint)).release().perform();
        }
        else if (scroll_direction == "up"){
            new TouchAction(driver).press(PointOption.point(width, endPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(0))).moveTo(PointOption.point(width, startPoint)).release().perform();
        }


    }

    @AfterSuite
    public void Aterclass() {
        driver.quit();
    }
}
