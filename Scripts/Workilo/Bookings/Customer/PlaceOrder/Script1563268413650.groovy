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
try{
driver.get('http://workilo.com')

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)

driver.findElement(By.linkText('Log In')).click()

Thread.sleep(2000)

driver.findElement(By.id('email_login')).sendKeys('shahbaz.dapl@gmail.com')

driver.findElement(By.id('password_login')).sendKeys('admin#123')

driver.findElement(By.xpath('.//*[@value=\'Log in\']')).click()

Thread.sleep(3000)

JavascriptExecutor js = ((driver) as JavascriptExecutor)

WebElement element = driver.findElement(By.id('img_334'))

js.executeScript('arguments[0].scrollIntoView();', element)

Thread.sleep(2000)

driver.findElement(By.id('img_335')).click()

Thread.sleep(2000)

//driver.findElement(By.xpath(".//*[@class='question-close hide-modal']")).click();
driver.findElement(By.xpath('/html/body/div[6]/i')).click()

WebElement element2 = driver.findElement(By.xpath('.//*[text()=\'book now\']'))

//js.executeScript("arguments[0].scrollIntoView();", element2);
js.executeScript('window.scrollBy(0,500)')

Thread.sleep(2000)

element2.click()

Thread.sleep(3000)

driver.findElement(By.id('step1')).click()

Thread.sleep(3000)

driver.findElement(By.id('billing_address1')).sendKeys('446 Plymouth St. Brooklyn')

driver.findElement(By.id('billing_city')).click()

Thread.sleep(2000)

WebElement element3 = driver.findElement(By.xpath('//*[@id=\'tab-2\']/div[2]/a[1]'))

js.executeScript('arguments[0].scrollIntoView();', element3)

element3.click()

Thread.sleep(2000)

driver.findElement(By.xpath('//*[@id=\'tab-3\']/div[2]/a[1]')).click()

Thread.sleep(2000)

driver.findElement(By.xpath('//*[@id=\'tab-4\']/div[1]/div[1]/span')).click()

Thread.sleep(2000)

driver.findElement(By.id("change_card")).click()

Thread.sleep(1000)

driver.findElement(By.id("card_number")).clear()

driver.findElement(By.id("card_number")).sendKeys("4563310021976554")

driver.findElement(By.id("card_month")).clear()

driver.findElement(By.id("card_month")).sendKeys("11")

driver.findElement(By.id("card_year")).clear()

driver.findElement(By.id("card_year")).sendKeys("21")

driver.findElement(By.id("card_name")).clear()

driver.findElement(By.id("card_name")).sendKeys("Pawel Walczuk")

driver.findElement(By.id("card_cvc")).clear()

driver.findElement(By.id("card_cvc")).sendKeys("792")

//driver.findElement(By.name("send")).click()

Thread.sleep(5000)

driver.quit()
}
catch (Exception e) {
	File src = ((driver) as TakesScreenshot).getScreenshotAs(OutputType.FILE)

	FileUtils.copyFile(src, new File((screenshots + System.currentTimeMillis()) + '.png'))

	System.out.println(e.getMessage())

	driver.quit()
}
