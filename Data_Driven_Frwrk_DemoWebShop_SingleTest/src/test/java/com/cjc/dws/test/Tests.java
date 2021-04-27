package com.cjc.dws.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.cjc.dws.pages.Item_Add_To_Cart;
import com.cjc.dws.pages.Payment_Gateway;
import com.cjc.dws.pages.Register_Page;
import com.cjc.dws.pages.Shopping_Cart;


@Listeners(com.cjc.dws.test.ISuite_ITestListeners.class)
public class Tests {

	WebDriver driver;
	static Logger log= Logger.getLogger(Tests.class.getName());
	Properties pro = new Properties();
	
	
	@BeforeSuite
	public void openBrowser() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Londhe\\eclipse-workspace\\Data_Driven_Frwrk_DemoWebShop\\src\\test\\java\\com\\cjc\\dws\\utility\\parameter.properties");
		pro.load(fis);
		System.setProperty("webdriver.chrome.driver","F:\\Testing\\Automation Testing\\Software\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("Open Chrome");
		
	}
	@BeforeTest
	public void openURL()
	{
		driver.get(pro.getProperty("url"));
		log.info("Open URL");
	}
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void cookies()
	{ 
		log.info("Cookies addedd successfully");
	}
	
	@Test
	(priority=-3)
	public void regPage() throws IOException
	{
		Register_Page rp = PageFactory.initElements(driver, Register_Page.class);
		
		FileInputStream fls= new FileInputStream("C:\\Users\\Londhe\\eclipse-workspace\\Data_Driven_Frwrk_DemoWebShop\\src\\test\\java\\com\\cjc\\dws\\utility\\Data_dws.xlsx");
	
		XSSFWorkbook xsw = new XSSFWorkbook(fls);
		XSSFSheet sheet = xsw.getSheet("Sheet1");
		int rowcount = sheet.getPhysicalNumberOfRows();
		log.info("Row count: "+rowcount);
		for(int i=1;i<rowcount;i++)
		{	
			XSSFRow row = sheet.getRow(i);
			XSSFCell col0 =row.getCell(0);
			XSSFCell col1 =row.getCell(1);
			XSSFCell col2 =row.getCell(2);
			XSSFCell col3 =row.getCell(3);
			XSSFCell col4 =row.getCell(4);
			
			String fname= col0.getStringCellValue();
			log.info("first Name: "+fname);
			String lname= col1.getStringCellValue();
			log.info("Last Name: "+lname);
			String email= col2.getStringCellValue();
			log.info("Email: "+email);
			String pword= col3.getStringCellValue();
			log.info("Password: "+pword);
			String cword= col4.getStringCellValue();
			log.info("Confirm Password: "+cword);
			
			rp.gender();
			rp.regData(fname, lname, email, pword, cword);
			rp.regisbutton();
		
		}
	}
	
	@Test
	(priority=-2)
	public void addtocart() throws IOException
	{
		Item_Add_To_Cart ac= PageFactory.initElements(driver, Item_Add_To_Cart.class);
		FileInputStream fis = new FileInputStream("C:\\Users\\Londhe\\eclipse-workspace\\Data_Driven_Frwrk_DemoWebShop\\src\\test\\java\\com\\cjc\\dws\\utility\\parameter.properties");
		pro.load(fis);
		ac.clickBooks();
		ac.clickSpecificBook();
		ac.addBookToCart();
		ac.Clickcomputer();
		ac.clickOnDesktop();
		ac.clickOnSpecificDeshtop();
		ac.addDesktopToCart();
		ac.clickJewelry();
		ac.clickOnSpecificJewelry(pro.getProperty("cm"));
		ac.addJeweleryToCart();
	}
	
	@Test
	(priority=-1)
	public void shopcart()
	{
		Shopping_Cart sc = PageFactory.initElements(driver, Shopping_Cart.class);
		sc.shopingCartLink();
		sc.shopingdata();
	}
	
	@Test
	(priority=1)
	public void paymentGateway() throws IOException, InterruptedException
	{
		Payment_Gateway pg = PageFactory.initElements(driver, Payment_Gateway.class);
		
		FileInputStream fls= new FileInputStream("C:\\Users\\Londhe\\eclipse-workspace\\Data_Driven_Frwrk_DemoWebShop\\src\\test\\java\\com\\cjc\\dws\\utility\\Data_dws.xlsx");
		
		XSSFWorkbook xsw = new XSSFWorkbook(fls);
		XSSFSheet sheet = xsw.getSheet("Sheet2");
		int rowcount = sheet.getPhysicalNumberOfRows();
		log.info("Row count: "+rowcount);
		for(int i=1;i<rowcount;i++)
		{	
			XSSFRow row = sheet.getRow(i);
			XSSFCell col0 =row.getCell(0);
			XSSFCell col1 =row.getCell(1);
			XSSFCell col2 =row.getCell(2);
			XSSFCell col3 =row.getCell(3);
			XSSFCell col4 =row.getCell(4);
			XSSFCell col5 =row.getCell(5);
			
			String country= col0.getStringCellValue();
			String city= col1.getStringCellValue();
			String address1= col2.getStringCellValue();
			String address2= col3.getStringCellValue();
			String zip= col4.getStringCellValue();
			String phone= col5.getStringCellValue();
			
			pg.addressDetails(country, city, address1, address2, zip, phone);
					
			pg.billingAndPayment();
			Thread.sleep(3000);
			pg.orderno();
		}
}
}
