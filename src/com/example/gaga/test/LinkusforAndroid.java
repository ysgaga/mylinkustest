package com.example.gaga.test;

import com.robotium.solo.Solo;

import android.view.View;
import android.widget.EditText;

public class LinkusforAndroid {
	
	private Solo linkus;
	public void Init(Solo solo){
		linkus = solo;
	}
	
	/*
	 *�༭�򷽷�
	 */
	public void inputLoginUser(String str){
		inputTextbyId(PObject.Text_LoginUser_ID,str);
	}
	public void inputLoginPass(String str){
		inputTextbyId(PObject.Text_LoginPass_ID,str);
	}
	public void inputLocalIp(String str){
		inputTextbyId(PObject.Text_LocalIp_ID,str);
	}
	
	/*
	 *����ؼ����� 
	 */
	public void clickOK(){
		clickButtonbyId(PObject.Button_OK_ID);
	}
	public void clickLogin(){
		clickButtonbyId(PObject.Button_Login_ID);
	}
	public void clickSetServer(){
		clickButtonbyId(PObject.Button_SetServer_ID);
	}
	
	/*
	 *ͳһ���÷���
	 */
	public void inputTextbyId(String id,String text){
		EditText edittext = null;
		edittext = (EditText)linkus.getView(id);
		linkus.clearEditText(edittext);
		linkus.enterText(edittext, text);		
	}
	public void clickButtonbyId(String id){
		View view = null;
		view = linkus.getView(id);
		linkus.clickOnView(view);
	}
	
}
