import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumActionClassTest {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.com/");
		//Actions class for mouseover, keyboard-mouse interactions,context/double click,drag n drop
		Actions a = new Actions(driver);
		WebElement accountLinkBtn = driver.findElement(By.cssSelector("#nav-link-accountList"));
		a.moveToElement(accountLinkBtn).contextClick().build().perform();
		WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
	}

}
