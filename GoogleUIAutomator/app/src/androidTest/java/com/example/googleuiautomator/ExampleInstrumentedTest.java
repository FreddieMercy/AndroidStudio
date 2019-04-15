package com.example.googleuiautomator;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.icu.util.Output;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.widget.TextView;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import androidx.test.uiautomator.BySelector;
import androidx.test.uiautomator.UiCollection;
import androidx.test.uiautomator.UiDevice;

import static androidx.test.platform.app.InstrumentationRegistry.getArguments;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static androidx.test.platform.app.InstrumentationRegistry.registerInstance;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.UiWatcher;
import androidx.test.uiautomator.Until;
/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    // private static final String BASIC_SAMPLE_PACKAGE = "com.example.android.testing.uiautomator.BasicSample";
    private static final int LAUNCH_TIMEOUT = 5000;
    //  private static final String STRING_TO_BE_TYPED = "UiAutomator";
    private UiDevice mDevice;
    private Instrumentation instrumentation;

    @Before
    public void setUp_Method(){
        instrumentation = getInstrumentation();
        mDevice = UiDevice.getInstance(instrumentation);
    }

    @After
    public void afterEachTest(){
        UiObject cur = new UiObject(new UiSelector().resourceId("com.google.android.googlequicksearchbox:id/workspace"));

        while (!cur.exists()){
            mDevice.pressBack();
        }

        mDevice.pressHome();
    }
    //@Test
    public void testFTU() {
        // Initialize UiDevice instance
        //mDevice = UiDevice.getInstance(getInstrumentation());
        mDevice.wait(Until.hasObject(By.pkg("com.android.settings").depth(0)), LAUNCH_TIMEOUT);

        mDevice.findObject(By.text("Your Phone Companion")).click();
        mDevice.findObject(By.text("Allow")).click();
    }

    //@Test
    public void testPressHome() {
        // Initialize UiDevice instance
        //mDevice = UiDevice.getInstance(getInstrumentation());
        mDevice.pressHome();
        //mDevice.wait(Until.hasObject(By.pkg("com.android.settings").depth(0)), LAUNCH_TIMEOUT);

        //mDevice.findObject(By.text("Your Phone Companion")).click();
        //mDevice.findObject(By.text("Allow")).click();

    }

    //@Test
    public void testDevice() {
        // Initialize UiDevice instance
        //mDevice = UiDevice.getInstance(getInstrumentation());
        mDevice.pressHome();
        mDevice.pressKeyCode(KeyEvent.KEYCODE_A);
        //mDevice.wait(Until.hasObject(By.pkg("com.android.settings").depth(0)), LAUNCH_TIMEOUT);

        //mDevice.findObject(By.text("Your Phone Companion")).click();
        //mDevice.findObject(By.text("Allow")).click();

    }

    //@Test
    public void testUISelector() throws UiObjectNotFoundException {
        // Initialize UiDevice instance
        //mDevice = UiDevice.getInstance(getInstrumentation());
        UiSelector l = new UiSelector().text("Chrome");
        //UiObject c = mDevice.findObject(l);
        UiObject c = new UiObject(l);
        c.dragTo(c.getBounds().centerX(),c.getBounds().centerY()-500,300);
        ///c.swipeUp(300);
        c.click();
    }

    //@Test
    public void testUIObject() throws UiObjectNotFoundException {
        //UiDevice.getInstance(getInstrumentation());
        UiObject tv = new UiObject(new UiSelector().resourceId("com.google.android.apps.messaging:id/recipient_text_view"));
        tv.clearTextField();
        //if (tv.exists()) {
        tv.setText(tv.getText()+"abc");
        //}

        //tv.clearTextField();
    }

    //@Test
    public void testUIObjectGesture() throws UiObjectNotFoundException {
        //mDevice = UiDevice.getInstance(getInstrumentation());

        UiObject chrome = mDevice.findObject(new UiSelector().className("android.widget.FrameLayout"));
        chrome.pinchOut(80, 20);
        chrome.pinchIn(80, 20);
        chrome.performTwoPointerGesture(new Point(200,200), new Point(400, 200),new Point(200,400), new Point(400, 400), 30);
        //chrome.performMultiPointerGesture(new MotionEvent.PointerCoords[]{new MotionEvent.PointerCoords(200,400)});//https://www.programcreek.com/java-api-examples/index.php?api=android.view.MotionEvent.PointerCoords
    }

    //@Test
    public void testUIObjectExists() throws UiObjectNotFoundException {
        //mDevice = UiDevice.getInstance(getInstrumentation());
        UiObject chrome = new UiObject(new UiSelector().text("Chrome"));

        //chrome.waitForExists(3000); //no exception thrown
        if(!chrome.waitForExists(3000)){
            throw  new UiObjectNotFoundException("Time out");
        }
        if(!chrome.waitUntilGone(3000)){
            throw  new UiObjectNotFoundException("Time in");
        }
    }

    //@Test
    public void testUICollection() throws UiObjectNotFoundException {
        //mDevice = UiDevice.getInstance(getInstrumentation());
        UiCollection collection = new UiCollection(new UiSelector().classNameMatches(".*"));

        collection.getChildByText(new UiSelector().text("123"), "Chrome").click();
    }

    //@Test
    public void testUIScrollable() throws UiObjectNotFoundException {
        //mDevice = UiDevice.getInstance(getInstrumentation());
        mDevice.pressHome();
        //mDevice.pressMenu();
        (new UiObject(new UiSelector().description("Apps"))).click();
        UiScrollable appList = new UiScrollable(new UiSelector().className("android.support.v7.widget.RecyclerView"));
        //appList.flingToEnd(Integer.MAX_VALUE);
        appList.getChildByText(new UiSelector().className("android.widget.TextView"), "Slides", true).click();

        mDevice.pressHome();
        (new UiObject(new UiSelector().description("Apps"))).click();
        appList = new UiScrollable(new UiSelector().className("android.support.v7.widget.RecyclerView"));
        appList.flingToBeginning(Integer.MAX_VALUE);
        UiObject YouTube = new UiObject(new UiSelector().text("YouTube"));
        appList.scrollIntoView(YouTube);
        YouTube.click();

        mDevice.pressHome();
        UiObject chrome = new UiObject( new UiSelector().text("Chrome"));
        chrome.click();
        appList = new UiScrollable(new UiSelector().className("android.widget.FrameLayout"));
        appList.setAsHorizontalList();
        appList.flingBackward();
        appList.flingForward();
    }

    //@Test
    public void testRunApp(){
        Context context = getInstrumentation().getContext(); //gets the context based on the instrumentation
        Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.google.android.gm");  //sets the intent to start your app
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);  //clear out any previous task, i.e., make sure it starts on the initial screen
        context.startActivity(intent);  //starts the app
    }

    //@Test
    public void testWatcher() throws UiObjectNotFoundException{
        //mDevice = UiDevice.getInstance(getInstrumentation());
        mDevice.registerWatcher("watcher", new UiWatcher() {
            @Override
            public boolean checkForCondition() {
                mDevice.pressHome();
                return true;
            }
        });

        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();






        mDevice.removeWatcher("watcher");

        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();
        (new UiObject( new UiSelector().text("Chrome"))).click();


    }

    //@Test
    public void testInstrument(){
        instrumentation.sendStatus(888, getArguments());

        Context cur_context = instrumentation.getContext();
        Context tar_context = instrumentation.getTargetContext();

        PackageManager pm = cur_context.getPackageManager();

        Bundle bundle = new Bundle();
        bundle.putString("CUR_CONTEXT", pm.getInstalledPackages(0).get(0).toString());
        bundle.putString("CUR_CONTEXT", pm.getInstalledPackages(0).get(1).toString());

        registerInstance(instrumentation, bundle);

        instrumentation.sendStatus(889, getArguments());
    }

    //@Test
    public void test_dumpWindowHierarchy() throws IOException {
        //1. dumpWindowHierarchy
        File file =new File(Environment.getExternalStorageDirectory()+File.separator+"uidump.xml");//phone SD card + "/" +uidump.xml

        if(file.exists()){
            file.delete();//need permission to write in SD card, add in Manifest.xml
        }

        file.createNewFile();//need permission to write in SD card, add in Manifest.xml

        OutputStream output = new FileOutputStream(file, true);
        mDevice.dumpWindowHierarchy(output);
    }

    //@Test
    public void test_executeShellCommand() throws IOException {
        //2. executeShellCommand
        mDevice.executeShellCommand("am start -n com.android.settings/.Settings");
    }

    //@Test
    public void test_UIObject2() throws IOException {
        //3. UIObject2
        //UiObject2 obj = mDevice.findObject(new BySelector().text("Chrome"));
        UiObject2 obj = mDevice.findObject(By.text("Chrome"));

        mDevice.wait(Until.findObject(By.text("Chrome")), 200);
        obj.click();
    }

    @Test
    public void test_findObjects_BySelector() throws IOException {
        //4. findObjects(BySelector)
        Bundle b = new Bundle();
        for(UiObject2 o : mDevice.findObjects(By.clazz(TextView.class))){
            b.putString("Class: ", o.getText());
            System.out.println("Found is: "+o.getText());
        }
        registerInstance(instrumentation, b);
        instrumentation.sendStatus(123, getArguments());
    }
}
