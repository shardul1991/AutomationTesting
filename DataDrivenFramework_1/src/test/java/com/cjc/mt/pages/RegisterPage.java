package com.cjc.mt.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

	WebDriver driver;
	static Logger log = Logger.getLogger(RegisterPage.class.getName());
	
	//Register page locators
			@FindBy(how=How.NAME,using ="firstName")
			WebElement first1;
			@FindBy(how=How.NAME,using="lastName")
			WebElement last1;
			@FindBy(how=How.NAME,using="phone")
			WebElement phone1;
			@FindBy(how=How.NAME,using="userName")
			WebElement mail1;
			@FindBy(how=How.NAME,using="address1")
			WebElement adress1;
			@FindBy(how=How.NAME,using="city")
			WebElement city1;
			@FindBy(how=How.NAME,using="state")
			WebElement state1;
			@FindBy(how=How.NAME,using="country")
			WebElement cou1;
			@FindBy(how=How.ID,using="email")
			WebElement user1;
			@FindBy(how=How.NAME,using="password")
			WebElement pass1;
			@FindBy(how=How.NAME,using="confirmPassword")
			WebElement confirm1;
			
			//Register Button locator
			@FindBy(how=How.NAME,using="submit")
			WebElement regbutton;
			
			//Sign off button locator
			@FindBy(how=How.XPATH,using="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")
			WebElement signoff;
			
			//Register link locator
			@FindBy(how=How.XPATH,using="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")
			WebElement reglink;
			
			//Home button
			@FindBy(how=How.XPATH,using="/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]/font/a")
			WebElement home;
			
			public RegisterPage(WebDriver driver)
			{
				this.driver=driver;
			}
			
			
			public void regData(String first,String last,String phone,String mail,String address, String city,
					String state, String country, String uname, String pass, String confirm) throws IOException
			{
//				Layout lay = new PatternLayout();
//				Appender ap = new FileAppender(lay,"abc.txt");
//				log.addAppender(ap);
				first1.sendKeys(first);
				last1.sendKeys(last);
				phone1.sendKeys(phone);
				mail1.sendKeys(mail);
				adress1.sendKeys(address);
				city1.sendKeys(city);
				state1.sendKeys(state);
				cou1.sendKeys(country);
				user1.sendKeys(uname);
				pass1.sendKeys(pass);
				confirm1.sendKeys(confirm);
				log.warn("Register Data Entered Successfully");
			}
			
			public void regButton()
			{
				regbutton.click();
				log.info("Register Button Pressed");
			}
			
			public void regLink()
			{
				reglink.click();
				log.info("Register Link Pressed");
			}
			public void homelink()
			{
				home.click();
				log.info("Home Button");
			}
	
}
