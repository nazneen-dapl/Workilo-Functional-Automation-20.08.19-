import java.util.concurrent.TimeUnit

import org.apache.commons.io.FileUtils
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions
System.setProperty('webdriver.chrome.driver', chromePath)

WebDriver driver = new ChromeDriver()

driver.manage().window().maximize()

driver.get('http://workilo.com')

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)

try{
	driver.findElement(By.linkText('Log In')).click()
	
	Thread.sleep(2000)
	
	driver.findElement(By.id('email_login')).sendKeys('testworkilo@gmail.com')
	
	driver.findElement(By.id('password_login')).sendKeys('admin#123')
	
	driver.findElement(By.xpath('.//*[@value=\'Log in\']')).click()
	
	Thread.sleep(3000)
	
	driver.findElement(By.xpath('/html/body/header/div/span[3]')).click()
	
	//Changes here
	Thread.sleep(2000)
	driver.findElement(By.xpath("/html/body/header/div/div[2]/ul/li[1]/a")).click()
	
	//driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/ul[1]/li")).click()
	
	Thread.sleep(1000)
	
	driver.findElement(By.xpath(".//*[text()='Transaction History']")).click()
	
	Thread.sleep(3000)
	
	/ Latest Transaction /
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	WebElement favourite = driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div/div/div/div/table/tbody/tr[1]"))
	
	js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[1]")));
	
	js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[2]")));
	
	js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[3]")));
	js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[4]")));
	js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[5]")));
	js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[6]")));
	js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/div/div/div/div/table/tbody/tr[1]/td[7]")));
	
	Thread.sleep(1000)
	
	driver.findElement(By.xpath('/html/body/header/div/span[3]')).click()
	//Changes here
	
	//driver.findElement(By.xpath("/html/body/header/div/div[2]/ul/li[1]/a")).click()
	
	Thread.sleep(2000)
	
	driver.findElement(By.linkText('Sign Out')).click()
	
	Thread.sleep(1000)
	Actions action = new Actions(driver)
	action.sendKeys(Keys.ESCAPE).build().perform()
	
	Thread.sleep(2000)
	
	driver.quit()
}catch(Exception e){
	File src = ((driver) as TakesScreenshot).getScreenshotAs(OutputType.FILE)
	
	FileUtils.copyFile(src, new File((screenshots +		System.currentTimeMillis()) + '.png'))
	System.out.println(e.getMessage())
	
}
driver.quit()
