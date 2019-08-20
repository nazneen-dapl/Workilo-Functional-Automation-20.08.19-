import java.util.concurrent.TimeUnit as TimeUnit
import org.apache.commons.io.FileUtils
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.interactions.Actions as Actions

System.setProperty('webdriver.chrome.driver', chromePath)

WebDriver driver = new ChromeDriver()

driver.manage().window().maximize()

driver.get('http://workilo.com')

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)

try{
driver.findElement(By.linkText('Log In')).click()

Thread.sleep(2000)

driver.findElement(By.id('email_login')).sendKeys('shahbaz.dapl@gmail.com')

driver.findElement(By.id('password_login')).sendKeys('123')

driver.findElement(By.xpath('.//*[@value=\'Log in\']')).click()

//Thread.sleep(3000);
//driver.findElement(By.linkText("Log Out")).click();
Thread.sleep(2000)

Actions action = new Actions(driver)

action.sendKeys(Keys.ESCAPE).build().perform()

Thread.sleep(3000)
}catch(Exception e){
	File src = ((driver) as TakesScreenshot).getScreenshotAs(OutputType.FILE)
	
	FileUtils.copyFile(src, new File((screenshots +	System.currentTimeMillis()) + '.png'))
	System.out.println(e.getMessage())
	
}
driver.quit()