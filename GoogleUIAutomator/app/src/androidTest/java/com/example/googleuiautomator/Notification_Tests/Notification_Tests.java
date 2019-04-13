package com.example.googleuiautomator.Notification_Tests;


import android.graphics.Point;
import android.view.KeyEvent;
import android.view.MotionEvent;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.runner.RunWith;
import androidx.test.uiautomator.UiDevice;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;
/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
//@RunWith(AndroidJUnit4.class)
public class Notification_Tests {

    // private static final String BASIC_SAMPLE_PACKAGE = "com.example.android.testing.uiautomator.BasicSample";
    private static final int LAUNCH_TIMEOUT = 5000;
    //  private static final String STRING_TO_BE_TYPED = "UiAutomator";
    private UiDevice mDevice;

    //@Test
    public void testPressHome() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(getInstrumentation());
        mDevice.pressHome();
        //mDevice.wait(Until.hasObject(By.pkg("com.android.settings").depth(0)), LAUNCH_TIMEOUT);

        //mDevice.findObject(By.text("Your Phone Companion")).click();
        //mDevice.findObject(By.text("Allow")).click();

    }

    //@Test
    public void testDevice() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(getInstrumentation());
        mDevice.pressHome();
        mDevice.pressKeyCode(KeyEvent.KEYCODE_A);
        //mDevice.wait(Until.hasObject(By.pkg("com.android.settings").depth(0)), LAUNCH_TIMEOUT);

        //mDevice.findObject(By.text("Your Phone Companion")).click();
        //mDevice.findObject(By.text("Allow")).click();

    }

    //@Test
    public void testUISelector() throws UiObjectNotFoundException {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(getInstrumentation());
        UiSelector l = new UiSelector().text("Chrome");
        //UiObject c = mDevice.findObject(l);
        UiObject c = new UiObject(l);
        c.dragTo(c.getBounds().centerX(),c.getBounds().centerY()-500,300);
        ///c.swipeUp(300);
        c.click();
    }

    //@Test
    public void testUIObject() throws UiObjectNotFoundException {
        UiDevice.getInstance(getInstrumentation());
        UiObject tv = new UiObject(new UiSelector().resourceId("com.google.android.apps.messaging:id/recipient_text_view"));
        tv.clearTextField();
        //if (tv.exists()) {
            tv.setText(tv.getText()+"abc");
        //}

        //tv.clearTextField();
    }

    //@Test
    public void testUIObjectGesture() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject chrome = mDevice.findObject(new UiSelector().className("android.widget.FrameLayout"));
        chrome.pinchOut(80, 20);
        chrome.pinchIn(80, 20);
        chrome.performTwoPointerGesture(new Point(200,200), new Point(400, 200),new Point(200,400), new Point(400, 400), 30);
        //chrome.performMultiPointerGesture(new MotionEvent.PointerCoords[]{new MotionEvent.PointerCoords(200,400)});//https://www.programcreek.com/java-api-examples/index.php?api=android.view.MotionEvent.PointerCoords
    }

    @Test
    public void testUIObjectExists() throws UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(getInstrumentation());
        UiObject chrome = new UiObject(new UiSelector().text("Chrome"));

        //chrome.waitForExists(3000); //no exception thrown
        if(!chrome.waitForExists(3000)){
            throw  new UiObjectNotFoundException("Time out");
        }
        if(!chrome.waitUntilGone(3000)){
            throw  new UiObjectNotFoundException("Time in");
        }
    }
}
