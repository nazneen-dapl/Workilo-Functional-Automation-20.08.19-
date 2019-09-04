import java.util.concurrent.TimeUnit as TimeUnit
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.apache.commons.io.FileUtils
System.setProperty('webdriver.chrome.driver', chromePath)

WebDriver driver = new ChromeDriver()

driver.manage().window().maximize()
try{
driver.get('http://workilo.com')

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)

driver.findElement(By.linkText('Sign Up')).click()

Thread.sleep(2000)

driver.findElement(By.xpath("//a[@class='account_type_switch service_provider_tag active']")).click()

Thread.sleep(2000)

driver.findElement(By.id('email')).sendKeys('testworkilo@gmail.com')

driver.findElement(By.id('firstName')).sendKeys('Workilo')

driver.findElement(By.id('lastName')).sendKeys('Test')

driver.findElement(By.id('password')).sendKeys('admin#123')

driver.findElement(By.id('contact_number')).sendKeys('8521036974')

driver.findElement(By.xpath('.//*[@value=\'Join Workilo!\']')).click()

Thread.sleep(5000)

}catch(Exception e){
	File src = ((driver) as TakesScreenshot).getScreenshotAs(OutputType.FILE)
	
	FileUtils.copyFile(src, new File((screenshots +	System.currentTimeMillis()) + '.png'))
	System.out.println(e.getMessage())
	
}
driver.quit()