import java.util.concurrent.TimeUnit as TimeUnit

import org.apache.commons.io.FileUtils as FileUtils
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.OutputType as OutputType
import org.openqa.selenium.TakesScreenshot as TakesScreenshot
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
System.setProperty('webdriver.chrome.driver', chromePath)

WebDriver driver = new ChromeDriver()

driver.manage().window().maximize()

driver.get('http://workilo.com')
try{
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)

driver.findElement(By.linkText('Sign Up')).click()

Thread.sleep(2000)

driver.findElement(By.xpath('//*[text()=\'Client\']')).click()

Thread.sleep(2000)

driver.findElement(By.id('email')).sendKeys('shahbaz.dapl@gmail.com')

driver.findElement(By.id('firstName')).sendKeys('12@12#.')

driver.findElement(By.id('lastName')).sendKeys('12345')

driver.findElement(By.id('password')).sendKeys('admin#123')

driver.findElement(By.id('contact_number')).sendKeys('8520136974')

driver.findElement(By.xpath('.//*[@value=\'Join Workilo!\']')).click()

Thread.sleep(2000)

WebElement errorMessage = driver.findElement(By.id("fname_error"))

JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('arguments[0].style.border=\'3px solid red\'', errorMessage)
js.executeScript('arguments[0].style.border=\'3px solid red\'', driver.findElement(By.id("lname_error")))

Thread.sleep(5000)

}
catch (Exception e) {
	File src = ((driver) as TakesScreenshot).getScreenshotAs(OutputType.FILE)

	FileUtils.copyFile(src, new File((screenshots + System.currentTimeMillis()) + '.png'))

	System.out.println(e.getMessage())
	
}
driver.quit()