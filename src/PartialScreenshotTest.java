import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartialScreenshotTest {

	public static void main(String[] args) throws IOException 
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
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);		
		//Targeted element partial screenshot
		File src = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D://Pooja//screenshot.png"));
	}

}
