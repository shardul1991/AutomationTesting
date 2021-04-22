package com.cjc.mt.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;
	static Logger log = Logger.getLogger(RegisterPage.class.getName());
		//Login page locators
		@FindBy(how=How.NAME,using="userName")
		WebElement username;
		@FindBy(how=How.NAME,using="password")
		WebElement password;
		@FindBy(how=How.XPATH,using="/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/font/a")
		WebElement home;
		
		//Login Button locator
		@FindBy(how=How.NAME,using="submit")
		WebElement logbutton;
		
		public LoginPage(WebDriver driver)
		{
			this.driver=driver;
			log.info("This is constructor");
		}
		
		public void loginData(String uname, String pass)
		{
			username.sendKeys(uname);
			password.sendKeys(pass);
			log.warn("Login Data Entered Successfully");
		}
		
		public void logButton()
		{
			logbutton.click();
			log.info("Login Buton Pressed");
		}
		
		public void homelink()
		{
			home.click();
			log.info("Home Button");
		}
}
