package com.httpdemo.zhulonglong.koitindemo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

//        ArrayList<String> stringArrayList = new ArrayList<>();
//        ArrayList<Object> objects = new ArrayList<>();
//        ArrayList<? extends Object> objects = new ArrayList<>();

//        objects = stringArrayList;
//        objects.addAll(stringArrayList);
//        stringArrayList.addAll(objects);

        assertEquals("com.httpdemo.zhulonglong.koitindemo", appContext.getPackageName());
    }
}
