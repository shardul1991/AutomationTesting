package com.cjc.dws.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Payment_Gateway {

	WebDriver driver;
	static Logger log= Logger.getLogger(Register_Page.class.getName());

	@FindBy(how=How.CSS,using="select[id=\"BillingNewAddress_CountryId\"]")
	WebElement coun;
	
	@FindBy(how=How.ID,using="BillingNewAddress_City")
	WebElement city;
	
	@FindBy(how=How.ID,using="BillingNewAddress_Address1")
	WebElement address1;
	
	@FindBy(how=How.NAME,using="BillingNewAddress.Address2")
	WebElement address2;
	
	@FindBy(how=How.NAME,using="BillingNewAddress.ZipPostalCode")
	WebElement zip;
	
	@FindBy(how=How.NAME,using="BillingNewAddress.PhoneNumber")
	WebElement phone;
	
	@FindBy(how=How.CSS,using="#billing-buttons-container > input")
	WebElement biladdcontinueclick;
	
	@FindBy(how=How.CSS,using="input[onclick='Shipping.save()']")
	WebElement shipaddcontinueclick;
	
	@FindBy(how=How.CSS,using="#shipping-method-buttons-container > input")
	WebElement mthdshipcontinueclick;
	
	@FindBy(how=How.CSS,using="input[onclick=\"PaymentMethod.save()\"]")
	WebElement paymthdcontinueclick;
	
	@FindBy(how=How.CSS,using="#payment-info-buttons-container > input")
	WebElement payinfocontinueclick;
	
	@FindBy(how=How.CSS,using="#confirm-order-buttons-container > input")
	WebElement confirmbutton;
	
	@FindBy(how=How.XPATH,using ="/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[1]")
	WebElement OrderNo;
	@FindBy(how=How.XPATH,using ="/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[2]/input")
	WebElement Continuebutton4;
	
	public Payment_Gateway(WebDriver driver)
	{
		this.driver=driver;
		log.info("This is constructor");
	}
	
	public void addressDetails(String count1,String city1, String addrs1, String addrs2, String zip1, String phn1) 
	{
		coun.sendKeys(count1);
		log.info("Country added");
		city.sendKeys(city1);
		log.info("City added");
		address1.sendKeys(addrs1);
		log.info("Address 1 added");
		address2.sendKeys(addrs2);
		log.info("Address 2 added");
		zip.sendKeys(zip1);
		log.info("Zip code added");
		phone.sendKeys(phn1);
		log.info("Phone Number added");
		
		log.info("Address Details added Succuessfully");
	}
	
	public void billingAndPayment() throws InterruptedException
	{
		biladdcontinueclick.click();
		log.info("Bill Add continue Clicked");
		Thread.sleep(2000);
		shipaddcontinueclick.click();
		log.info("Ship Add continue Clicked");
		Thread.sleep(2000);
		mthdshipcontinueclick.click();
		log.info("Ship Method Add continue Clicked");
		Thread.sleep(3000);
		paymthdcontinueclick.click();
		log.info("Payment Method continue Clicked");
		Thread.sleep(2000);
		payinfocontinueclick.click();
		log.info("Paymenet Information continue Clicked");
		Thread.sleep(2000);
		confirmbutton.click();
		log.info("Confirm Pressed");
		log.info("Payment process complete");
		
	}
	
	public void orderno() throws InterruptedException
	{
		Thread.sleep(2000);
		String Ordno=OrderNo.getText();
		log.info(Ordno);
		
		Continuebutton4.click();
	}
}
