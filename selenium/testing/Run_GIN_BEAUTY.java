package testing;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.MobileBy.AndroidUIAutomator;

public class Run_GIN_BEAUTY {
    AppiumDriver driver;
    ChromeDriver driver_web;
    public static boolean is_login;

    @BeforeClass
    public void bf_Class() throws MalformedURLException, InterruptedException {
        /*create capabilities for android devices*/
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.UDID, "eacy5d8pxg6lijaa");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability("autoGrantPermissions", true);
        //capabilities.setCapability(MobileCapabilityType.APP,"/Users/foxlucius/IdeaProjects/untitled3/app/app-dev_20231214_release.apk");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability("appPackage", "jp.co.mybeauty");
        capabilities.setCapability("appActivity", "jp.co.mybeauty.MainActivity");
        //get localhost address and connect with appium server
        URL appiumurl = new URL("http://127.0.0.1:4723/wd/hub");

//        /*create capabilities for ios devices*/
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"16.7.2");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Bé Tường");
//        capabilities.setCapability(MobileCapabilityType.UDID, "4a0ac5a7e84be117ff0033c9e64ef711da61c78c");
//        capabilities.setCapability(MobileCapabilityType.APP,"/Users/foxlucius/IdeaProjects/untitled3/app/GiN Beauty.ipa");
//        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
//        capabilities.setCapability("bundleId","jp.co.mybeauty");
//        capabilities.setCapability("appActivity", "jp.co.mybeauty.MainActivity");
//        capabilities.setCapability("xcodeOrgId", "7N3H5WHLD7");
//        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
//        URL appiumurl = new URL("http://127.0.0.1:4723/wd/hub");


        driver = new AndroidDriver(appiumurl, capabilities);
//        Thread.sleep(3000);
//        driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
//        MobileElement accept_btn = (MobileElement) driver.findElementByXPath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
//        accept_btn.click();
    }


    @Test
    public void  TC_0000_check_not_login() throws InterruptedException {  //this test case
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        int number_element_toAssert = 0;    //this number is for assert that is user logged in or not.   Success = Not logged in/ Failes = Logged in
        List nav_menu = driver.findElementsByXPath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.Button");
        Assert.assertEquals(nav_menu.size(),number_element_toAssert);
    }


    @Test(dependsOnMethods = "TC_0000_check_not_login")
    public void LgG_0001() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
        action_with_element((MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"マイページ\"]"),"click",null,"0");
        action_with_element((MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"ログイン\"]"),"click",0,null);
        //action_with_element((MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]"),"xoa_chu",3,null);
        action_with_element((MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]"),"sendnumber",null,"0909000005");
        Thread.sleep(5000);
    }



//
//
//    @Test
//    public void TC_0001_switch_alltab_nav_menu() throws InterruptedException {   //this test case is for testing switching all the tab on the nav-menu after login
//        driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
//        for (int loop_time =0;loop_time <2; loop_time ++){
//            action_with_element((MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"予約\"]"),"click",null);
//            action_with_element((MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"お気に入り\"]"),"click",null);
//            action_with_element((MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"トップ\"]"),"click",null);
//            action_with_element((MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"マイページ\"]"),"click",null);
//        }
//        action_with_element((MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"トップ\"]"),"click",null);
//    }
//
//
//    @Test
//    public void TC_002() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
//        int number_of_tab = 2;// this number stand for double tab
//        action_with_element((MobileElement) driver.findElementByXPath("//android.view.View[@content-desc=\"Bản đồ trên Google\"]"),"double_click",number_of_tab);
//        Thread.sleep(2000);
//    }
//    @Test
//    public void TC_003() throws InterruptedException { //nav menu one element multiple touch at one time
//        driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
//        int number_of_tab = 5;// this number stand for number of tab for that element
//        action_with_element((MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"予約\"]"),"click",number_of_tab);
//        action_with_element((MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"トップ\"]"),"click",null);
//    }
//
//    @Test
//    public void TC_004() throws InterruptedException { //search shop and find shop on the horizon list
//        driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
//        action_with_element((MobileElement) driver.findElementByXPath("//android.widget.EditText[@text=\"検索する\"]"),"searchtext",null);
//        Thread.sleep(2000);
//        action_with_element(null,"scroll_ngang_thuan",4);
//        Thread.sleep(2000);
//        action_with_element(null,"scroll_ngang_nguoc",4);
//
//    }
//
//
//    @Test
//    public void TC_005() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
//        action_with_element((MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"みなコミ\"]"),"click",null);
//        Thread.sleep(5000);
//        action_with_element(null,"click_back_button",4);
//        driver_web = new ChromeDriver();
//        driver_web.get("https://selenium.dev");
//    }
//
//
//    public void logout_then_login_withcorrect_account() throws InterruptedException {
//        System.out.println(driver.getPageSource());
//    }
//
//
//
//
//
//    @AfterClass
//    public void At_class(){
//        driver.quit();
////        driver_web.quit();
//    }
//
//
//
//
    public void action_with_element(MobileElement element, String action, Integer time_loop, String input ) throws InterruptedException {
        if (action == "click" ){
            element.click();
        } else if (action == "double_click" || action == "2clicks" || action == "doubleclick") {
            for (int Start_loop = 0; Start_loop < 2; Start_loop++) {
                element.click();
            }
        } else if (action=="multipleclick"||action=="multiple_click") {
            for (int Start_loop = 0; Start_loop < time_loop; Start_loop++) {
                element.click();
            }
        } else if (action =="sendnumber") {
            element.click();
            for (char number: input.toCharArray()) {
                switch (number){
                    case '0':
                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_0));
                        break;
                    case '1':
                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_1));
                        break;
                    case '2':
                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_2));
                        break;
                    case '3':
                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_3));
                        break;
                    case '4':
                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_4));
                        break;
                    case '5':
                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_5));
                        break;
                    case '6':
                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_6));
                        break;
                    case '7':
                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_7));
                        break;
                    case '8':
                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_8));
                        break;
                    case '9':
                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_9));
                        break;
                }
            }
        }else if (action =="xoa_chu") {
            element.click();
            for (char number:input.toCharArray()) {
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DEL));
            }
        } else if (action=="sendtext") {
            element.click();
            String text_2send = input;//this test string stand for example shop
            element.sendKeys(text_2send);
        }else if (action == "searchtext"){
            element.click();
            String text_2find = input;//this test string stand for example shop
            element.sendKeys(text_2find);
            driver.getKeyboard().sendKeys(Keys.ENTER);
        } else if (action == "scroll_doc_thuan") {
            MobileElement scroll_item = (MobileElement) driver.findElement(AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward("+time_loop.intValue()+")"));
            scroll_item.click();
        } else if (action == "scroll_ngang_thuan") {
            MobileElement scroll_item = (MobileElement) driver.findElement(AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollForward("+time_loop.intValue()+")"));
            scroll_item.click();
        }else if (action == "scroll_ngang_nguoc") {
            MobileElement scroll_item = (MobileElement) driver.findElement(AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollBackward("+time_loop.intValue()+")"));
            scroll_item.click();
        } else if (action == "click_back_button") {
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.MENU));
            Thread.sleep(5000);
            driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"GiN,Đã mở khóa\"]").click();
            Thread.sleep(5000);
        }else if (action =="open"){
        }
    }







}
