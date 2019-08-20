import java.util.concurrent.TimeUnit as TimeUnit
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import java.util.concurrent.TimeUnit as TimeUnit

import org.apache.commons.io.FileUtils as FileUtils
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.OutputType as OutputType
import org.openqa.selenium.TakesScreenshot as TakesScreenshot
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.interactions.Actions as Actions
System.setProperty('webdriver.chrome.driver',chromePath)

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

driver.findElement(By.id('firstName')).sendKeys('Shahbaz')

driver.findElement(By.id('lastName')).sendKeys('Farooque')

driver.findElement(By.id('password')).sendKeys('admin#123')

driver.findElement(By.id('contact_number')).sendKeys('9663326168')

driver.findElement(By.xpath('.//*[@value=\'Join Workilo!\']')).click()

Thread.sleep(5000)

}
catch (Exception e) {
	File src = ((driver) as TakesScreenshot).getScreenshotAs(OutputType.FILE)

	FileUtils.copyFile(src, new File((screenshots + System.currentTimeMillis()) + '.png'))

	System.out.println(e.getMessage())

	}
driver.quit()