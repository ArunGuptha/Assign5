package com.automation.Amazon.MavenAmazon;

import org.testng.annotations.Test;

public class verify {

	@Test
	public void check(){
	Loginpage log = new Loginpage();
	log.intializeWebDriver();
	log.login();
	log.takeScreenShot();
	log.tearDown();
}
}