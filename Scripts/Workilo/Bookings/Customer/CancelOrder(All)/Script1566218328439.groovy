import java.util.concurrent.TimeUnit as TimeUnit

import org.apache.commons.io.FileUtils as FileUtils
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.OutputType as OutputType
import org.openqa.selenium.TakesScreenshot as TakesScreenshot
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.interactions.Actions
System.setProperty('webdriver.chrome.driver', chromePath)

WebDriver driver = new ChromeDriver()

driver.manage().window().maximize()

driver.get('http://workilo.com')

try{
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)

driver.findElement(By.linkText('Log In')).click()

Thread.sleep(2000)

driver.findElement(By.id('email_login')).sendKeys('nabin@digitalaptech.com')

driver.findElement(By.id('password_login')).sendKeys('admin#123')

driver.findElement(By.xpath('.//*[@value=\'Log in\']')).click()

Thread.sleep(3000)

driver.findElement(By.xpath('/html/body/header/div/div[2]/ul/li[1]/a')).click()

Thread.sleep(1000)

driver.findElement(By.xpath('/html/body/div[4]/div/div[1]/ul/li[1]/a')).click()

Thread.sleep(1000)
Actions action = new Actions(driver)
JavascriptExecutor js = ((driver) as JavascriptExecutor)

driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/a[1]/div[1]")).click()


List<WebElement> element = driver.findElements(By.xpath('/html[1]/body[1]/div[6]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/a[1]'))

if (element.size() == 0) {
	js.executeScript('arguments[0].style.border=\'3px solid red\'', driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div[1]/span")))
	
    driver.findElement(By.xpath('/html/body/header/div/span[3]')).click()
	
	//Changes here
	
	//driver.findElement(By.xpath("/html/body/header/div/div[2]/ul/li[1]/a")).click()

	Thread.sleep(2000)

	driver.findElement(By.linkText('Sign Out')).click()

	Thread.sleep(1000)

	action.sendKeys(Keys.ESCAPE).build().perform()

	Thread.sleep(2000)

	driver.quit()
} else {
	Thread.sleep(2000)

    driver.findElement(By.xpath('/html[1]/body[1]/div[6]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/a[1]')).click()

    Thread.sleep(2000)
	
	driver.findElement(By.xpath("//*[@id='cancel_order_form']/div[2]/ul/li[1]/label/span")).click()
	
	Thread.sleep(1000)
	
	driver.findElement(By.xpath("/html[1]/body[1]/div[9]/form[1]/div[4]/input[2]")).click()

	Thread.sleep(2000)
	
	js.executeScript('arguments[0].style.border=\'3px solid red\'', driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/div[2]/div[1]/span[1]")))

    Thread.sleep(1000)

    driver.findElement(By.xpath('/html/body/header/div/span[3]')).click()
	
	//Changes here
	
	//driver.findElement(By.xpath("/html/body/header/div/div[2]/ul/li[1]/a")).click()

    Thread.sleep(2000)

    driver.findElement(By.linkText('Sign Out')).click()

    Thread.sleep(1000)

    action.sendKeys(Keys.ESCAPE).build().perform()

    Thread.sleep(2000)
	driver.quit()
}
}catch (Exception e) {
    File src = ((driver) as TakesScreenshot).getScreenshotAs(OutputType.FILE)

    FileUtils.copyFile(src, new File((screenshots + System.currentTimeMillis()) + '.png'))

    System.out.println(e.getMessage())

    driver.quit()
}