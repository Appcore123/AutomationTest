package testing;

import Constants.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class tuong {


    public void action_with_element(AppiumDriver driver,MobileElement element, String action, Integer time_loop, String input ) throws InterruptedException {
        switch (action){
            case Constants.Click_Element:{

            }
            case Constants.Multiple_Click_Ele:{
                for (int Start_loop = 0; Start_loop < time_loop; Start_loop++) {
                    element.click();
                }//test nè
            }
            case Constants.Send_Number:{
//                element.click();
//                for (char number: input.toCharArray()) {
//                    switch (number){
//                        case '0':
//                            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_0));
//                            break;
//                        case '1':
//                            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_1));
//                            break;
//                        case '2':
//                            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_2));
//                            break;
//                        case '3':
//                            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_3));
//                            break;
//                        case '4':
//                            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_4));
//                            break;
//                        case '5':
//                            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_5));
//                            break;
//                        case '6':
//                            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_6));
//                            break;
//                        case '7':
//                            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_7));
//                            break;
//                        case '8':
//                            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_8));
//                            break;
//                        case '9':
//                            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DIGIT_9));
//                            break;
//                    }
//                }
                element.click();
                Map<Character, AndroidKey> keyMapping = getKeyMapping();


                for (char number : input.toCharArray()) {
                    if (keyMapping.containsKey(number)) {
                        ((AndroidDriver) driver).pressKey(new KeyEvent(keyMapping.get(number)));
                    }
                }

            }
            case Constants.Delete_Text:{
                element.click();
                for (char number:input.toCharArray()) {
                    ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DEL));
                }
            }
            case Constants.ScrollDown_Screen:{
                Dimension size = driver.manage().window().getSize();
                //x position set to mid-screen horizontally
                int width = size.width / 2;
                //Starting y location set to 80% of the height (near bottom)
                int startPoint = (int) (size.getHeight() * 0.80);
                //Ending y location set to 20% of the height (near top)
                int endPoint = (int) (size.getHeight() * 0.20);

                new TouchAction(driver).press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(0))).moveTo(PointOption.point(width, endPoint)).release().perform();



            }
            case Constants.ScrollUp_Screen:{
                Dimension size = driver.manage().window().getSize();
                //x position set to mid-screen horizontally
                int width = size.width / 2;
                //Starting y location set to 80% of the height (near bottom)
                int startPoint = (int) (size.getHeight() * 0.80);
                //Ending y location set to 20% of the height (near top)
                int endPoint = (int) (size.getHeight() * 0.20);

                new TouchAction(driver).press(PointOption.point(width, endPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(0))).moveTo(PointOption.point(width, startPoint)).release().perform();
            }
            case Constants.ScrollLeft_Screen:{

            }
            case Constants.ScrollRight_Screen:{

            }
            case Constants.TurnBack:{
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.MENU));
//            Thread.sleep(5000);
//            driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"GiN,Đã mở khóa\"]").click();
//            Thread.sleep(5000);
            }
        }
    }

    private static Map<Character, AndroidKey> getKeyMapping() {
        Map<Character, AndroidKey> keyMapping = new HashMap<>();
        keyMapping.put('0', AndroidKey.DIGIT_0);
        keyMapping.put('1', AndroidKey.DIGIT_1);
        keyMapping.put('2', AndroidKey.DIGIT_2);
        keyMapping.put('3', AndroidKey.DIGIT_3);
        keyMapping.put('4', AndroidKey.DIGIT_4);
        keyMapping.put('5', AndroidKey.DIGIT_5);
        keyMapping.put('6', AndroidKey.DIGIT_6);
        keyMapping.put('7', AndroidKey.DIGIT_7);
        keyMapping.put('8', AndroidKey.DIGIT_8);
        keyMapping.put('9', AndroidKey.DIGIT_9);
        return keyMapping;
    }

}
