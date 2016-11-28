package com.automation.Amazon.MavenAmazon;

import org.openqa.selenium.By;



public class Loginpage extends Webdriver {
	
	public void login(){
		getDriver().findElement(By.id("email")).sendKeys("dasa");
	}

}
