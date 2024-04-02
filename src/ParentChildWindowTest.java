import java.time.Duration;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentChildWindowTest {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();
		java.util.Iterator<String> it = windows.iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);
		String emailStr = driver.findElement(By.cssSelector(".im-para.red")).getText();
		String usernameStr = emailStr.split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(usernameStr);
	}

}
