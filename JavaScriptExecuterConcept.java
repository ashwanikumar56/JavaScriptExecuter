package JSExecuter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



/* 
 * 
 * here we are hightlight the button through javascript
 * 
 * 
 * */
public class JavaScriptExecuterConcept 
{
	
	private static final String JavascriptExecuter = null;


	public static void main(String[] args)
	{
		
		
		System.getProperty("webdriver.chrome.driver", "/home/qainfotech/Downloads//home/qainfotech/Downloads");
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		//dynamic waits 
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://ui.freecrm.com/");
		
		driver.findElement(By.name("email")).sendKeys("ashwaniupadhyay29@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Ash@9968");
		
		 WebElement loginbtn =driver.findElement((By.cssSelector("div[class^='ui fluid']")));
		 
		 flash(loginbtn,driver);
		 
		 drawBorder(loginbtn, driver);// draw a border
		 
		 Click(loginbtn, driver);
		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 
		 //refresh page:
		 // 1. by using selenium
		 
		 driver.navigate().refresh();
		 
		 //2. by using JS executor
		 //refereshBrowserByJS(driver);
		 
		 // get title of the page 
		String title= getTitleByJS(driver);
		System.out.println(title);
		
		
		//get page text
		
		String pagetext=getPageInnerTextByJS(driver);
		System.out.println(pagetext);
		
		//scroll page down
		
		scrollpageDownByJS(driver);
		
		//scroll intoview
		
		WebElement link = driver.findElement(By.linkText("Sign Up"));
		scrollpageIntoJS(link, driver);
		
		 //for show alert
	        //js.executeScript("arguments[0].click();",loginbtn);
	        //js.executeScript("alert('Welcome to CRM')");   
		
		
	}
	
	
	public static void flash(WebElement element, WebDriver driver)
	{
		
		
		String bgColor=element.getCssValue("backgroundColor");
		for(int i=0;i<10;i++)
		{
			changeColor("rgb(0,200,0)", element,driver);
			changeColor(bgColor,element,driver);
		}
		
	}


	// executeScript use to esecute javascript code
	
	private static void changeColor(String color, WebElement element, WebDriver driver)
	{
		
	
		JavascriptExecutor js=(JavascriptExecutor) driver ;
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
		
		try
		{
			Thread.sleep(20);
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void drawBorder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		
   }
	
	
	public static void Click(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
		System.out.println("Not working");
		
	}
	
	
	public static void refereshBrowserByJS(WebDriver driver)
	{
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
		
	}
	
	public static String getTitleByJS(WebDriver driver)
	{
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		String title= js.executeScript("return document.title").toString();
		return title;
		
	}
	
	public static String getPageInnerTextByJS(WebDriver driver)
	{
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		String Pagetext= js.executeScript("return document.documentElement.innerText").toString();
		return Pagetext;
		
	}
	
	// important
	
	public static void scrollpageDownByJS(WebDriver driver)
	{
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		//js.executeScript("windows.scrollTo(0,document.body.scrollheight)");
		((JavascriptExecutor) driver).executeScript("scroll(0,80);");
		
	}
	
	public static void scrollpageIntoJS(WebElement elements ,WebDriver driver)
	{
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);" ,elements);
		
		
	}

}
