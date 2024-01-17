package testing;

import Constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Testcase_trang_login_Mobile_Gin_Beauty extends tuong{

    AppiumDriver driver;
    public String text_on_textfield ;
    static Testcase_trang_login_Mobile_Gin_Beauty tc = new Testcase_trang_login_Mobile_Gin_Beauty();


    ChromeDriver driver_web;

    @BeforeSuite
    public void bf_Class() throws MalformedURLException, InterruptedException {
        /*create capabilities for android devices*/
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.UDID, "eacy5d8pxg6lijaa");
//        capabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability("autoGrantPermissions", true);
        //capabilities.setCapability(MobileCapabilityType.APP,"/Users/foxlucius/IdeaProjects/untitled3/app/app-dev_20231214_release.apk");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability("appPackage", "jp.co.mybeauty");
        capabilities.setCapability("appActivity", "jp.co.mybeauty.MainActivity");
        //get localhost address and connect with appium server
        URL appiumurl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(appiumurl, capabilities);
//        Thread.sleep(3000);
//        driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
//        MobileElement accept_btn = (MobileElement) driver.findElementByXPath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
//        accept_btn.click();
//        return driver;
    }

    @Test
    public void LG_0000(){
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        int number_element_toAssert = 0;    //this number is for assert that is user logged in or not.   Success = Not logged in/ Failes = Logged in
        List nav_menu = driver.findElementsByXPath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.Button");
        Assert.assertEquals(nav_menu.size(),number_element_toAssert);
    }

    @Test (dependsOnMethods = "LG_0000")
    public void LG_0001() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
        MobileElement HomeElement = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"マイページ\"]");
        action_with_element(driver,HomeElement,Constants.Click_Element,null,null);
        MobileElement Login = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"ログイン\"]");
        action_with_element(driver,Login,Constants.Click_Element,null,null);
        MobileElement text_field = (MobileElement) driver.findElementByClassName("android.widget.EditText");
        text_field.click();
       text_on_textfield = text_field.getText().toString();
//        if(text_on_textfield != null){
//
//        }
//        else {
//
//
//        }


//
//
////        action_with_element(driver,(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"ログイン\"]"),"xoa_chu",null,null);
////        System.out.println("1");
//        action_with_element(driver,(MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]"),"xoa_chu",null,text_on_textfield);
//        action_with_element(driver,(MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]"),"sendnumber",null,text_on_textfield);
    }






//
//    @Test (dependsOnMethods = "LG_0000")
//    public void LG_0002() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
//        action_with_element(driver,(MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]"),"xoa_chu",null,"0909000005");
//        action_with_element(driver,(MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]"),"sendnumber",null,"0909000005");
//    }
//
//    @Test (dependsOnMethods = "LG_0000")
//    public void LG_0003() throws InterruptedException{
//        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
//        action_with_element(driver, (MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]"),"xoa_chu",null,"0909000005");
//    }
//
//    @Test (dependsOnMethods = "LG_0000")
//    public void LG_0004() throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(10L,TimeUnit.SECONDS);
//        action_with_element(driver,(MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]"),"sendtext",null,"090900005-_ + ");
//    }
//






//    public void action_with_element(MobileElement element, String action, Integer time_loop, String input ) throws InterruptedException {
//        if (action == "click" ){
//            element.click();
//        } else if (action == "double_click" || action == "2clicks" || action == "doubleclick") {
//            for (int Start_loop = 0; Start_loop < 2; Start_loop++) {
//                element.click();
//            }
//        } else if (action=="multipleclick"||action=="multiple_click") {
//            for (int Start_loop = 0; Start_loop < time_loop; Start_loop++) {
//                element.click();
//            }
//        } else if (action =="sendnumber") {
//            element.click();
//            for (char number: input.toCharArray()) {
//                switch (number){
//                    case '0':
//                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_0));
//                        break;
//                    case '1':
//                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_1));
//                        break;
//                    case '2':
//                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_2));
//                        break;
//                    case '3':
//                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_3));
//                        break;
//                    case '4':
//                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_4));
//                        break;
//                    case '5':
//                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_5));
//                        break;
//                    case '6':
//                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_6));
//                        break;
//                    case '7':
//                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_7));
//                        break;
//                    case '8':
//                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_8));
//                        break;
//                    case '9':
//                        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_9));
//                        break;
//                }
//            }
//        }else if (action =="xoa_chu") {
//            element.click();
//            for (char number:input.toCharArray()) {
//                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DEL));
//            }
//        } else if (action=="sendtext") {
//            element.click();
//            String text_2send = input;//this test string stand for example shop
//            element.sendKeys(text_2send);
//        }else if (action == "searchtext"){
//            element.click();
//            String text_2find = input;//this test string stand for example shop
//            element.sendKeys(text_2find);
//            driver.getKeyboard().sendKeys(Keys.ENTER);
//        } else if (action == "scroll_doc_thuan") {
//            MobileElement scroll_item = (MobileElement) driver.findElement(AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward("+time_loop.intValue()+")"));
//            scroll_item.click();
//        } else if (action == "scroll_ngang_thuan") {
//            MobileElement scroll_item = (MobileElement) driver.findElement(AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollForward("+time_loop.intValue()+")"));
//            scroll_item.click();
//        }else if (action == "scroll_ngang_nguoc") {
//            MobileElement scroll_item = (MobileElement) driver.findElement(AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList().scrollBackward("+time_loop.intValue()+")"));
//            scroll_item.click();
//        } else if (action == "click_back_button") {
//            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.MENU));
//            Thread.sleep(5000);
//            driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"GiN,Đã mở khóa\"]").click();
//            Thread.sleep(5000);
//        }else if (action =="open"){
//        }
//    }


}
