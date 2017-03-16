package com.example.gaga.test;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class Pjsip {
	public String ip = null;
	public String caller = null;
	public String callee = null;
	public String caller_pass = null;
	public String username = null;
	public String password = null;
	public int RegistId = -1;
	public int CallerId = -1;
	public int CallId = -1;
	
	public interface first extends Library {
		first instance = (first)Native.loadLibrary("pjsipdll", first.class);
		public int dll_registerAccount(String uri, String reguri, String name, String username,
				 String password, String proxy, Boolean isdefault);
		public int dll_main();
		public int dll_makeCall(int accountId, String uri);
		public void dll_printlog();
		public int dll_init();
		public int dll_shutdown();
		public int dll_releaseCall(int accountId);
	    public int dll_removeAccounts();
	}
	
	public void ys_Init() {
		//first.instance.dll_printlog();
	  	first.instance.dll_init();
	  	first.instance.dll_main();
	}
	public int ys_Regist() {
		if (username != null && password != null & ip != null) {
			RegistId = first.instance.dll_registerAccount("sip:"+username+"@"+ip+"", "sip:"+ip, "YSAsterisk", username, password, "", true);
			return RegistId;
		} else { //还要判断是否已在通话中。
			return -100; //配置异常
		}
	}
	public int ys_Call() {
	  	if (caller != null && callee != null) 
	  	{
	  		CallerId = first.instance.dll_registerAccount("sip:"+caller+"@"+ip+"", "sip:"+ip, "YSAsterisk", caller, caller_pass, "", true);
	  		CallId = first.instance.dll_makeCall(CallerId, "sip:"+callee+"@"+ip);
	  		return CallId;
	  	} else {
			return -100; //配置异常
	  	}
	}
	public int ys_HandUp() {
		if (CallId == -1) {
			return -1;
		}
		first.instance.dll_releaseCall(CallId);
		CallId = -1;
		return 0;
	}
	public void ys_UnRegist() {
		first.instance.dll_removeAccounts();
	}
	public void ys_ShutDown() {
		first.instance.dll_shutdown();
	}
}
