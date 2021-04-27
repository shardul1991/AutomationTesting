package com.cjc.dws.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Shopping_Cart {

	WebDriver driver;
	static Logger log= Logger.getLogger(Register_Page.class.getName());

	@FindBy(how=How.CSS,using="#topcartlink > a > span.cart-label")
	WebElement shopcartLink;
	
	@FindBy(how=How.ID,using="termsofservice")
	WebElement tickonterms;
	
	@FindBy(how=How.NAME,using="checkout")
	WebElement checkout;
	
	
	public Shopping_Cart(WebDriver driver)
	{
		this.driver=driver;
		log.info("This is constructor");
	}
	
	public void shopingCartLink()
	{
		shopcartLink.click();
		log.info("Shopping link pressed");
	}
	public void shopingdata()
	{
		 tickonterms.click();
		 checkout.click();
		 log.warn("Shpping details entered");
	}
	
	
	
}
