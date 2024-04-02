import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMultipleWindowsTabsTest {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles = driver.getWindowHandles();
		java.util.Iterator<String> it = handles.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElement(By.xpath("//*[@id='courses-block']/div[1]/div/div[2]/div/h2/a")).getText();
		driver.switchTo().window(parentId);
		driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);		
		driver.quit();
	}

}
