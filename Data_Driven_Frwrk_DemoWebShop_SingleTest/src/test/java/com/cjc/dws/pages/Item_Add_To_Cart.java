package com.cjc.dws.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Item_Add_To_Cart {

	WebDriver driver;
	static Logger log= Logger.getLogger(Register_Page.class.getName());
	
	
	@FindBy(how=How.XPATH,using="//li[@class=\"inactive\"]/child ::a[@href=\"/books\"]")
	WebElement books;
	
	@FindBy(how=How.CSS,using="div[class=\"picture\"] a[href=\"/computing-and-internet\"]")
	WebElement cominterbook;
	
	@FindBy(how=How.ID,using="add-to-cart-button-13")
	WebElement bookadd;
	
	@FindBy(how=How.XPATH,using="/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a")
	WebElement comclick ;
	
	@FindBy(how=How.XPATH,using="/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/a/img")
	WebElement deskclick ;
	
	@FindBy(how=How.XPATH,using="/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[1]/a/img")
	WebElement onedeskclick ;
	
	@FindBy(how=How.ID,using="add-to-cart-button-72")
	WebElement onedeskadd;
	
	@FindBy(how=How.XPATH,using="/html/body/div[4]/div[1]/div[2]/ul[1]/li[6]/a")
	WebElement jewelruclick;
	
	@FindBy(how=How.XPATH,using="/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[1]/a/img")
	WebElement createjewelclick;
	
	@FindBy(how=How.NAME,using="product_attribute_71_10_16")
	WebElement length;
	
	@FindBy(how=How.ID,using="add-to-cart-button-71")
	WebElement jeweladd;

	public Item_Add_To_Cart(WebDriver driver)
	{
		this.driver=driver;
		log.info("This is constructor");
	}
	
	public void clickBooks()
	{
		books.click();
		log.info("Books tab open");
	}
	public void clickSpecificBook()
	{
		cominterbook.click();
		log.info("Click on specific book which want to buy");
	}
	public void addBookToCart()
	{
		bookadd.click();
		log.info("Book add");
	}
	public void Clickcomputer()
	{
		comclick.click();
		log.info("Click on computer tab");
	}
	public void clickOnDesktop()
	{
		deskclick.click();
		log.info("Click on Desktop");
	}
	public void clickOnSpecificDeshtop()
	{
		onedeskclick.click();
		log.info("Click on specific Desktop which want to buy");
	}
	public void addDesktopToCart()
	{
		onedeskadd.click();
		log.info("Add Desktop to cart");
	}
	public void clickJewelry()
	{
		jewelruclick.click();
		log.info("Clicked on Jewelery");
	}
	public void clickOnSpecificJewelry(String cm)
	{
			createjewelclick.click();
			log.info("Clicked on Jewelery which want to buy");
			length.sendKeys(cm);
			log.info("chain lenth entered");
	}
		
	public void addJeweleryToCart()
	{
		jeweladd.click();
		log.info("Jewelery added to Cart");
		
	}
}
