package com.example.gaga.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

@SuppressWarnings("rawtypes")
public class linkustest extends ActivityInstrumentationTestCase2{

	private Solo solo;
	LinkusforAndroid linkus = new LinkusforAndroid();
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME ="com.linkus.activity.WelcomeActivity" ;
	private static Class launcherActivityClass;
	static{
		try{
			launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		}catch(ClassNotFoundException e){
			Log.i("gaga",e.toString());
			throw new RuntimeException(e);
		}
	}
	@SuppressWarnings("unchecked")
	public linkustest() {
		super(launcherActivityClass);
	}

	@Before
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(),getActivity());
		linkus.Init(solo);
	}

	@After
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

	@Test
	public void test() {
		solo.waitForActivity("WelcomeActivity", 30000);
		linkus.clickSetServer();
		linkus.inputLocalIp("192.168.3.223");
		linkus.clickOK();
		
		linkus.inputLoginUser("5005");
		linkus.inputLoginPass("123456");
		linkus.clickLogin();
		solo.sleep(10000);
	}
}
