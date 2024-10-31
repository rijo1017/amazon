package amazonpagepkg;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Amazonpage {
	
	WebDriver driver;
	
	
	By addressfield=By.xpath("//input [@class='GLUX_Full_Width a-declarative']");
	By applybutton=By.xpath("/html/body/div[4]/div/div/div/div/div[2]/div[3]/div[2]/div/div[2]/span/span/input");
     By searchbar=By.xpath("//*[@id=\"twotabsearchtextbox\"]");
    By delivery=By.xpath("//span[@id='glow-ingress-line1']");
    By apply=By.xpath("//*[@id=\"GLUXZipUpdate\"]/span/input");
     By iqneo9= By.xpath("//*[@id=\"12162a80-7509-470e-ab3f-642dbf28cb80\"]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span");
	 By addtocart=By.xpath("/html/body/div[2]/div/div[5]/div[3]/div[1]/div[4]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[38]/div[1]/span/span/span/input");
	By gotocart=By.xpath("//*[@id=\"a-autoid-24-announce\"]");
	By signin=By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]");
	By emailmobilefield=By.xpath("//*[@id=\"ap_email\"]");
	By continuebutton=By.xpath("//*[@id=\"continue\"]");
	By passwordfield=By.xpath("//*[@id=\"ap_password\"]");
	By signinbutton=By.xpath("//*[@id=\"signInSubmit\"]");
	By amazonbackbutton=By.xpath("//*[@id=\"a-page\"]/div[1]/div[1]/div/a");
	By invalidsearchbar=By.xpath("//*[@id=\"twotabsearchtextbox\"]");
	By macbook=By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span");
	By ratings=By.xpath("//*[@id=\"acrCustomerReviewText\"]");
	By cart=By.xpath("//*[@id=\"nav-cart\"]");
	By proceedtopayment=By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input");
	By ambh=By.xpath("//*[@id=\"a-page\"]/div[1]/div[1]/div/a");
	By fb=By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[3]/ul/li[1]/a");
	By qtydd=By.xpath("//*[@id=\"a-autoid-0-announce\"]");
	By starthere=By.xpath("//*[@id=\"nav-flyout-ya-newCust\"]/a");
	By fn=By.xpath("//*[@id=\"ap_customer_name\"]");
	By phn=By.xpath("//*[@id=\"ap_phone_number\"]");
	By vuid=By.xpath("//*[@id=\"mobileClaimDisclosureMessageRelaxed\"]");
	By amba=By.xpath("//*[@id=\"a-page\"]/div[1]/div[1]/div/a");
	By primeme=By.xpath("//*[@id=\"nav-link-amazonprime\"]");
	By prmelo=By.xpath("//*[@id=\"a-autoid-0\"]/span");
	By primeemm=By.xpath("//*[@id=\"ap_email\"]");
	By cob=By.xpath("//*[@id=\"continue\"]");
	
	public Amazonpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public void isd()//verify if the amazon logo is present
	{
		WebElement logo=driver.findElement(By.xpath("//*[@id=\"nav-logo-sprites\"]"));
		boolean b=logo.isDisplayed();
		
		if(b)
		{
			System.out.println("amazon logo is present");
		}
		else
		{
			System.out.println("amazon not visible");
		}
		
	}
	
	public void ise()//verify if the search field is interactable
	{
		WebElement searchfield=driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		boolean e=searchfield.isEnabled();
		if(e)
		{
			System.out.println("search field is enabled and interactive");
		}
		else
		{
			System.out.println("search field is not enabled");
		}
	}
	
	public void iss()//verify if the dropdown near the search field is present
	{
		WebElement languagedropdown=driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));
		Select dropdown=new Select(languagedropdown);
		 WebElement selectedOption = dropdown.getFirstSelectedOption();
		 if (selectedOption.isSelected()) {
	            System.out.println("The option is selected.");
	        } else {
	            System.out.println("The option is not selected.");
	        }
	}
	
	public void displaylinkelements()//verify all the link elements
	{
		List<WebElement> lid=driver.findElements(By.tagName("a"));
		for(WebElement ele:lid)
		{
			String link=ele.getAttribute("href");
			String text=ele.getText();
			System.out.println(link+"--------"+text);
		}
	}
	
	public void titleverification()//verify the title is correct
	{
		String actualtitle=driver.getTitle();
		String exptitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		System.out.println("title="+actualtitle);
		if(actualtitle.equals(exptitle))
		{
			System.out.println("title is verified");
		}
		else
		{   System.out.println(actualtitle);
			System.out.println("fail");
		}
	}
	
	public void homepagescreenshot() throws IOException//verify the screenshot of the page is  be captured and saved in the prescribed folder
	{
		File src=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./screenshot/pagescreenshot.png"));
		System.out.println("Screenshot saved at: file screenshot ");
	}
	
		
	
	public void searchmobilephones(String mb)//verify the search field shows correct values for the inputs given
	{  
		driver.findElement(searchbar).sendKeys(mb,Keys.ENTER);
		driver.navigate().back();
		driver.findElement(searchbar).clear();
	}
	
	public void deliveryaddresss(String pincode)// verify the deliver address can be updated
	{
		driver.findElement(delivery).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='GLUXZipUpdateInput']")));
		driver.findElement(By.xpath("//input[@id='GLUXZipUpdateInput']")).sendKeys(pincode);
		driver.findElement(apply).click();
		
		
	}
	
	public void addingtocart(String product)//verify wheather the products can be added to the cart
	{    
		 String parentwindow=driver.getWindowHandle();
		   driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys(product,Keys.ENTER);
		   driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
		  
		   
		   
			
			
			
			Set<String> allwindowhandles=driver.getWindowHandles();
			for(String handle:allwindowhandles)
			{
				if(!handle.equals(parentwindow))
				{
					driver.switchTo().window(handle);
					JavascriptExecutor js=(JavascriptExecutor) driver;
					
			        js.executeScript("window.scrollBy(0, 1000);");
			        driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div[3]/div[1]/div[4]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[38]/div[1]/span/span/span/input")).click();
					
				
			        for(String handle1:allwindowhandles)
					{
						if(handle1.equals(parentwindow))
						{
							driver.switchTo().window(handle1);
						}
					}
					
					
				}
				
	   }

	

}
	
	
	public void languageselector()//verify the language can be selected

	{
	
	   WebElement language =driver.findElement(By.xpath("//*[@id=\"icp-nav-flyout\"]/span/span[2]"));
	   Actions actions = new Actions(driver);

       
       actions.moveToElement(language).perform();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement menuItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nav-flyout-icp\"]/div[2]/a[1]/span/span[1]"))); 
       menuItem.click();
       
	}
	
	public void hamburger() throws InterruptedException//verify the hamburger option is interactable and options can be selected
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      //  WebElement hamburgerMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav-hamburger-menu\"]"))); 
      //  hamburgerMenu.click();
        driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]")).sendKeys(Keys.ENTER);
        driver.manage().window().maximize();
        Thread.sleep(2000); 
        try {
        WebElement electronicsOption = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/ul[1]/li[2]/a"));
        electronicsOption.click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

	}
  public void buttss() throws IOException//verify the add to cart button is present and its screenshot can be captured and saved
  {   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  WebElement menuItem2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-autoid-1-announce\"]"))); 
	  File src1=menuItem2.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src1, new File("./screenshot/buttonscreenshot.png"));
		System.out.println("Screenshot saved at: file screenshot " );
  }
  
  public void electronics()//verify the electronics link is present and interactable
  {
	  WebElement elec=driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[6]"));
	  if(elec.isEnabled()&&elec.isDisplayed())
	  {
		  System.out.println("electronics link is interactive ");
	  }
	  else
	  {
		  System.out.println("electroics link is not present");
	  }
  }
  
  public void todaysdeal()//verify the todays deal link is present and interactable
  {
	  WebElement td=driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]"));
	  if(td.isEnabled()&&td.isDisplayed())
	  {
		  System.out.println("todays deal link is interactive ");
	  }
	  else
	  {
		  System.out.println("todays deal link is not present");
	  }
  }
  
  public void mxplayer()//verify the mxplayer link is interactable and present
  {
	  WebElement mx=driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]"));
	  if(mx.isEnabled()&&mx.isDisplayed())
	  {
		  System.out.println("mx player link is interactive ");
	  }
	  else
	  {
		  System.out.println("mx player link is not present");
	  }
  }
  
  public void bestseller()//verify sell link is present and interactable
  {
	  WebElement bs=driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]"));
	  if(bs.isEnabled()&&bs.isDisplayed())
	  {
		  System.out.println("sell link is interactive ");
	  }
	  else
	  {
		  System.out.println("sell link is not present");
	  }
  }
  
  public void sell()//verify best seller link is present and interactable
  {
	  WebElement sl=driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[3]"));
	  if(sl.isEnabled()&&sl.isDisplayed())
	  {
		  System.out.println("best seller link is interactive ");
	  }
	  else
	  {
		  System.out.println("best seller link is not present");
	  }
  }
  
  
  public void homeandkitchen()// verify home and kitchen link is present and interactable
  {
	  WebElement hk=driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[7]"));
	  if(hk.isEnabled()&&hk.isDisplayed())
	  {
		  System.out.println("home and kitchen link is interactive ");
	  }
	  else
	  {
		  System.out.println("home and kitchen link is not present");
	  }
  }
  
  
  public void customerservices()// verify customer services link is present and interactable
  {
	  WebElement cs=driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[8]"));
	  if(cs.isEnabled()&&cs.isDisplayed())
	  {
		  System.out.println("customer service  link is interactive ");
	  }
	  else
	  {
		  System.out.println("customer service link is not present");
	  }
  }
  
  
  public void newreleases()// verify new releases link is present and interactable
  {
	  WebElement nr=driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[10]"));
	  if(nr.isEnabled()&&nr.isDisplayed())
	  {
		  System.out.println("new releases  link is interactive ");
	  }
	  else
	  {
		  System.out.println("new releases link is not present");
	  }
  }
  
  public void sortbydropdown()//verify the dropdown button for sorting the search results is fuctioning
  {
	  WebElement sortdropdown=driver.findElement(By.xpath("//*[@id=\"s-result-sort-select\"]"));
		 Select sort=new Select(sortdropdown);
		 sort.selectByValue("price-asc-rank");
  }
  
  public void nooflinks()//verify the total no.of links present
	{
		List<WebElement> linkno= driver.findElements(By.tagName("a"));
		System.out.println("total count="+linkno.size());
	}
  
  public void buttontextverification()//verify the text in the button is correct
  {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,300)");
	 try 
	 {  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  WebElement targetElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"a-autoid-31-announce\"]")));
	 
	   String text=targetElement.getText();
	   if(text.equals("Add to cart"))
	   {
		   System.out.println("button text is verified");
	   }
	   else
	   {  
		   System.out.println(text);
		   System.out.println("fail");
	   }
	 }
	 catch (org.openqa.selenium.NoSuchElementException e) {
         // Catch exception if element is not found
         System.out.println("Element not found: " + e.getMessage());
     }
  }
	 

  
  
  public void checkbox()
  {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("window.scrollBy(0,-200)");
      try {
     
    	  WebElement element3 = driver.findElement(By.xpath("//*[@id=\"ewc-compact-actions-container\"]/div/div[2]/span/span/a"));
    	    element3.click();
    
      WebElement checkb = driver.findElement(By.xpath("//*[@id=\"gutterCartViewForm\"]/div/div[3]/div[2]/span/div/label/i")); 
      checkb.click();
      }
      catch (org.openqa.selenium.NoSuchElementException e) {
          // Catch exception if element is not found
          System.out.println("Element not found: " + e.getMessage());
      }
      
      
  }
  
  public void loginfunctionality(String phno,String pass)//verify the user can enter the emailid and password
  {  
	driver.findElement(signin).click();
	driver.findElement(emailmobilefield).sendKeys(phno);
	driver.findElement(continuebutton).click();
	driver.findElement(passwordfield).sendKeys(pass);
	driver.findElement(signinbutton).click();
	driver.findElement(amazonbackbutton).click();
	
	
	
	
  }
  
  public void productreview (String mca)//verify the product review are displayed
  {
	  driver.findElement(invalidsearchbar).sendKeys(mca,Keys.ENTER);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,1000)");
	  String macbookWindow = driver.getWindowHandle();
       driver.findElement(macbook).click();
       Set<String> allWindows = driver.getWindowHandles();
       List<String> windowList = new ArrayList<>(allWindows);
       if (windowList.size() == 3) {
    	    
    	    driver.switchTo().window(windowList.get(2));
    	    System.out.println("Switched to second window with title: " + driver.getTitle());
    	    driver.findElement(ratings).click();
    	} else {
    	    System.out.println("The number of open windows is not exactly three.");
    	}
       driver.switchTo().window(macbookWindow);
	  
  }
  
  public void proceedtopayment()//verify the cart is working properly
  {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0, -1000)");
	  driver.findElement(cart).click();
	  driver.findElement(proceedtopayment).click();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  WebElement aelement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='a-page']/div[1]/div[1]/div/a")));
	  aelement.click();

	  
	  
	  
  }
  
  public void footerlinktest()//verify the facebook link is visible and interactive
  {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,4500)");
	  WebElement fb=driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[3]/ul/li[1]/a"));
	  if(fb.isEnabled()&&fb.isDisplayed())
	  {
		  System.out.println("facebook link is interactive ");
	  }
	  else
	  {
		  System.out.println("facebook link is not present");
	  }
	  
	  
  }
  
  
  public void footerlinktest2()//verify the twitter link is visible and interactive
  {
	  
	  WebElement tw=driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[3]/ul/li[2]/a"));
	  if(tw.isEnabled()&&tw.isDisplayed())
	  {
		  System.out.println("twitter link is interactive ");
	  }
	  else
	  {
		  System.out.println("twitter link is not present");
	  }
	  
	  
  }
  
  public void footerlinktest3()//verify the instagram link is visible and interactive
  {
	  
	  WebElement in=driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[3]/ul/li[3]/a"));
	  if(in.isEnabled()&&in.isDisplayed())
	  {
		  System.out.println("instagram link is interactive ");
	  }
	  else
	  {
		  System.out.println("instagram link is not present");
	  }
	  
	  
  }
  
  public void footerlogotest()//verify amazon logo is present in footer
  {
	 WebElement fotlogo=driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[3]/span[1]/div/a")) ;
	 if (fotlogo.isDisplayed()) {
         System.out.println("Logo is present on the page.");
     } else {
         System.out.println("Logo is NOT present on the page.");
     }
	  
  }
  
  public void increasethequanityoftheproduct()//verify the user can increase the number of quanity
  {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,-4500)"); 
	  driver.findElement(cart).click();
	  driver.findElement(qtydd).click();
	  WebElement qtydropdown = driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]"));
	 
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"a-popover-1\"]/div/div/ul/li[2]")));
      WebElement desiredOption = driver.findElement(By.xpath("//*[@id=\"a-popover-1\"]/div/div/ul/li[2]")); 
      desiredOption.click();

	  Actions actionsdd = new Actions(driver);
	  WebElement yy=driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]"));
	  actionsdd.moveToElement(yy).perform();
	  driver.findElement(starthere).click();
  }
  
  public void datadriventesting(String usn,String phnu)//verify different set of values can be inserted in the given field
  {
	  
	  
	  driver.findElement(fn).clear();
	  driver.findElement(fn).sendKeys(usn);
	  driver.findElement(phn).clear();
	  driver.findElement(phn).sendKeys(phnu);
	  driver.findElement(vuid).click();
	  
	  
	  
  }
	 public void primemembership(String emmm)
  
  {
	  driver.findElement(amba).click();
	  driver.findElement(primeme).click();
	  driver.findElement(prmelo).click();
	  driver.findElement(primeemm).sendKeys(emmm);
	  driver.findElement(cob).click();
	  WebElement gg=driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div[2]/div[1]/form/div/div/div"));
	 String ff= gg.getText();
	  if (ff.contains( "  Enter a valid email address or phone number"))
	  {
		  System.out.println("numbers  and alphabets cannot be inserted in email field");
	  }
	  else
	  {
		  System.out.println("numbers and characters can be  can beinserted in email field");
	  }
  }
	  
  
  
  
}
