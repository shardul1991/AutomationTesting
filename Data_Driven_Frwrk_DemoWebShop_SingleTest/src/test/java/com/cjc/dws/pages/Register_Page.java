package com.cjc.dws.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Register_Page {

	WebDriver driver;
	
	static Logger log= Logger.getLogger(Register_Page.class.getName());
	
	@FindBy(how=How.ID,using="gender-male")
	WebElement gender;
	
	@FindBy(how=How.NAME,using="FirstName")
	WebElement first;
	
	@FindBy(how=How.NAME,using="LastName")
	WebElement last;
	
	
	@FindBy(how=How.NAME,using="Email")
	WebElement mail;
	
	@FindBy(how=How.NAME,using="Password")
	WebElement pass;
	
	@FindBy(how=How.NAME,using="ConfirmPassword")
	WebElement confirm;
	
	@FindBy(how=How.NAME,using="register-button")
	WebElement regbutton;
	
	public Register_Page(WebDriver driver)
	{
		this.driver=driver;
		log.info("This is constructor");
	}
	
	public void regData(String fname, String lname, String email, String pword, String cword)
	{
		
		
		System.out.println("gender clicked");
		first.sendKeys(fname);
		log.info("First Name Entered");
		last.sendKeys(lname);
		log.info("Last Name Entered");
		mail.sendKeys(email);
		log.info("Email Entered");
		pass.sendKeys(pword);
		log.info("Password Entered");
		confirm.sendKeys(cword);
		log.info("Confirm password Entered");
		
		log.info("Registered Succesfully");
		
	}
	
	public void gender()
	{
		gender.click();
		log.info("Gender click");
	}
	public void regisbutton()
	{
		regbutton.click();
	}

	
}
