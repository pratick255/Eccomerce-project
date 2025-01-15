import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

	//	ChromeOptions options= new ChromeOptions();
		//options.setBinary("C:\\Download\\chrome-win64\\chrome.exe");
		
		//WebDriver driver=new ChromeDriver(options);
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		        driver.manage().window().maximize();
		        
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        
		        // Navigate to Amazon.in
		        driver.get("https://www.amazon.in/");
		        
		        
		     // Search for 'mouse'
		        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		        searchBox.sendKeys("mouse");
		       WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
		        searchButton.click();
		       // Thread.sleep(500);
		        
		     // Click on the first mouse product in the search results
		        WebElement firstProduct = driver.findElement(By.xpath("//h2[@aria-label='ZEBRONICS PHERO Wired Gaming Mouse with up to 1600 DPI, Rainbow LED Lights, DPI Switch, High Precision, Plug & Play, 4 Buttons']"));
		        firstProduct.click();
		        
		     // Switch to the product detail page tab
		        for (String winHandle : driver.getWindowHandles()) {
		            driver.switchTo().window(winHandle);
		        }
		        
		        // Change the quantity to 5
		        Select quantityDropdown = new Select(driver.findElement(By.id("quantity")));
		        quantityDropdown.selectByValue("5");

		        // Add the product to the cart
		        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
		        addToCartButton.click();

		        // Close the browser
		        driver.quit();
		        
	}

}
