package com.cjc.mt.tests;

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
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import com.cjc.mt.pages.LoginPage;
import com.cjc.mt.pages.RegisterPage;

@Listeners(com.cjc.mt.tests.Isuite_Itest_Listeners.class)
public class Test {

	WebDriver driver;
	SoftAssert sAssert;
	
	Properties pro= new Properties();
	
	static Logger log = Logger.getLogger(Test.class.getName());
	
	@BeforeSuite
	public void openDriver() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Londhe\\eclipse-workspace\\DataDrivenFramework\\src\\test\\resources\\parameter.properties");
		pro.load(fis);
		System.setProperty("webdriver.chrome.driver", "F:\\Testing\\Automation Testing\\Software\\chromedriver.exe");
		driver = new ChromeDriver();
		log.debug("Chrome Started Successfully");
	}
	@BeforeTest
	public void openUrl()
	{
		driver.get(pro.getProperty("url"));
		
		sAssert= new SoftAssert();
		String actualurl=driver.getCurrentUrl();
		log.info("Actual URL: "+actualurl);
		String expectedurl= "http://demo.guru99.com/test/newtours/register.php";
		sAssert.assertEquals(expectedurl,actualurl);
		log.info("URL entered sucessfully");
		
		String actualtitle=driver.getTitle();
		log.info("ActualTitle: "+actualtitle);
		String expectedtitle= "Register: Mercury Tours";
		Assert.assertEquals(expectedtitle,actualtitle);
		log.info("Title Assert Successful");
		
		
		sAssert.assertAll();
	}
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
		log.info("Window maximized");
	}
	@BeforeMethod
	public void createCookies()
	{
		log.info("Cookies created Successfully");
	}
	
	
	@org.testng.annotations.Test
	(priority=-1)
	public void registerTest() throws IOException
	{
		RegisterPage rp = PageFactory.initElements(driver, RegisterPage.class);
	
		FileInputStream fis = new FileInputStream("C:\\Users\\Londhe\\eclipse-workspace\\DataDrivenFramework\\src\\test\\resources\\Login_Reg_data_MercuryTours_PageFactory.xlsx");
		XSSFWorkbook xsw = new XSSFWorkbook(fis); 
		XSSFSheet sheet = xsw.getSheet("Sheet1");
		int rowcount = sheet.getPhysicalNumberOfRows();
		log.info("Row count: "+rowcount);
		for(int i =1; i<rowcount;i++)
		{
			XSSFRow row= sheet.getRow(i);
			XSSFCell col0 = row.getCell(0);
			XSSFCell col1 = row.getCell(1);
			XSSFCell col2 = row.getCell(2);
			XSSFCell col3 = row.getCell(3);
			XSSFCell col4 = row.getCell(4);
			XSSFCell col5 = row.getCell(5);
			XSSFCell col6 = row.getCell(6);
			XSSFCell col7 = row.getCell(7);
			XSSFCell col8 = row.getCell(8);
			XSSFCell col9 = row.getCell(9);
			XSSFCell col10 = row.getCell(10);
			
			String first = col0.getStringCellValue();
			log.info("First name: "+first);
			String last = col1.getStringCellValue();
			log.info("Last name: "+last);
			String phone = col2.getStringCellValue();
			log.info("Phone number: "+phone);
			String mail = col3.getStringCellValue();
			log.info("Email: "+mail);
			String address = col4.getStringCellValue();
			log.info("Address: "+address);
			String city = col5.getStringCellValue();
			log.info("City: "+city);
			String state = col6.getStringCellValue();
			log.info("State: "+state);
			String country = col7.getStringCellValue();
			log.info("Country: "+country);
			String uname = col8.getStringCellValue();
			log.info("Username: "+uname);
			String pass = col9.getStringCellValue();
			log.info("Password: "+pass);
			String confirm = col10.getStringCellValue();
			log.info("Comfirm Password: "+confirm);
			
			rp.regData(first, last, phone, mail, address, city, state, country, uname, pass, confirm);
			rp.regLink();
		}	
	}
			@org.testng.annotations.Test
			(priority=1)
			private void loginTest() throws IOException
			{
				LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
				lp.homelink();
				FileInputStream fis = new FileInputStream("C:\\Users\\Londhe\\eclipse-workspace\\DataDrivenFramework\\src\\test\\resources\\Login_Reg_data_MercuryTours_PageFactory.xlsx");
				XSSFWorkbook xsw = new XSSFWorkbook(fis); 
				XSSFSheet sheet = xsw.getSheet("Sheet1");
				int rowcount = sheet.getPhysicalNumberOfRows();
				log.info("Row count: "+rowcount);
				
				for(int i =1; i<rowcount;i++)
				{
					XSSFRow row= sheet.getRow(i);
					XSSFCell col8 = row.getCell(8);
					XSSFCell col9 = row.getCell(9);
					String uname = col8.getStringCellValue();
					log.info("Username: "+uname);
					String pass = col9.getStringCellValue();
					log.info("Password: "+pass);
					
					lp.loginData(uname, pass);
					lp.logButton();
				}
				
			}
//	@AferMethod
//	@AfterClass
//	@AfterTest
//	@AfterSuite
}
