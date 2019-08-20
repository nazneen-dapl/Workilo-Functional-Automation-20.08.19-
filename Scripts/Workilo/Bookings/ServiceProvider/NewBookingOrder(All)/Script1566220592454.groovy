import java.util.concurrent.TimeUnit as TimeUnit

import org.apache.commons.io.FileUtils as FileUtils
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.OutputType as OutputType
import org.openqa.selenium.TakesScreenshot as TakesScreenshot
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.interactions.Actions as Actions
import org.testng.Assert

System.setProperty('webdriver.chrome.driver', chromePath)

WebDriver driver = new ChromeDriver()

driver.manage().window().maximize()
try{
driver.get('http://workilo.com')

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)

driver.findElement(By.linkText('Log In')).click()

Thread.sleep(2000)

driver.findElement(By.id('email_login')).sendKeys('testworkilo@gmail.com')

driver.findElement(By.id('password_login')).sendKeys('admin#123')

driver.findElement(By.xpath('.//*[@value=\'Log in\']')).click()

Thread.sleep(3000)

driver.findElement(By.xpath('/html/body/header/div/span[1]')).click()

//Changes here

//driver.findElement(By.xpath("/html/body/header/div/div[2]/ul/li[1]/a")).click()

Thread.sleep(1000)

driver.findElement(By.xpath('/html/body/div[4]/div/div[1]/ul/li[2]/a')).click()

Thread.sleep(1000)

String message = driver.findElement(By.xpath('/html/body/div[6]/div/div[1]/div[1]/div/div/ul/li[1]/a')).getText()

if (message.contains('(0)')) {
    driver.findElement(By.xpath('/html/body/header/div/span[1]')).click()
	
	//Changes here
	
	//driver.findElement(By.xpath("/html/body/header/div/div[2]/ul/li[1]/a")).click()

    Thread.sleep(2000)

    driver.findElement(By.linkText('Sign Out')).click()

    Thread.sleep(1000)

    Actions action = new Actions(driver)

    action.sendKeys(Keys.ESCAPE).build().perform()

    Thread.sleep(2000)

    driver.quit()
} else {
    JavascriptExecutor js = ((driver) as JavascriptExecutor)

    List<WebElement> itemList = driver.findElements(By.xpath('//*[@id=\'tab-1\']/table/tbody/tr'))

    System.out.println('ItemList == ' + itemList.size())

    for (int i = 0; i < itemList.size(); i++) {
        js.executeScript('arguments[0].style.border=\'3px solid red\'', driver.findElement(By.xpath(('//*[@id=\'tab-1\']/table/tbody/tr[' + 
                    (i + 1)) + ']/td[1]')))
		String orderValue = driver.findElement(By.xpath(('//*[@id=\'tab-1\']/table/tbody/tr[' + (i + 1)) + ']/td[1]'))

        js.executeScript('arguments[0].style.border=\'3px solid red\'', driver.findElement(By.xpath(('//*[@id=\'tab-1\']/table/tbody/tr[' + 
                    (i + 1)) + ']/td[2]')))
		
		String addressValue = driver.findElement(By.xpath(('//*[@id=\'tab-1\']/table/tbody/tr[' + (i + 1)) + ']/td[2]'))

        js.executeScript('arguments[0].style.border=\'3px solid red\'', driver.findElement(By.xpath(('//*[@id=\'tab-1\']/table/tbody/tr[' + 
                    (i + 1)) + ']/td[3]')))
		
		String listingValue = driver.findElement(By.xpath(('//*[@id=\'tab-1\']/table/tbody/tr[' + (i + 1)) + ']/td[3]'))

        js.executeScript('arguments[0].style.border=\'3px solid red\'', driver.findElement(By.xpath(('//*[@id=\'tab-1\']/table/tbody/tr[' + 
                    (i + 1)) + ']/td[4]')))
		
		String bookingDate = driver.findElement(By.xpath(('//*[@id=\'tab-1\']/table/tbody/tr[' + (i + 1)) + ']/td[4]'))

        js.executeScript('arguments[0].style.border=\'3px solid red\'', driver.findElement(By.xpath(('//*[@id=\'tab-1\']/table/tbody/tr[' + 
                    (i + 1)) + ']/td[5]')))
		
		String statusValue = driver.findElement(By.xpath(('//*[@id=\'tab-1\']/table/tbody/tr[' + (i + 1)) + ']/td[5]'))

        js.executeScript('arguments[0].style.border=\'3px solid red\'', driver.findElement(By.xpath(('//*[@id=\'tab-1\']/table/tbody/tr[' + 
                    (i + 1)) + ']/td[6]')))
		
		String paymentStatus = driver.findElement(By.xpath(('//*[@id=\'tab-1\']/table/tbody/tr[' + (i + 1)) + ']/td[6]'))

        js.executeScript('arguments[0].style.border=\'3px solid red\'', driver.findElement(By.xpath(('//*[@id=\'tab-1\']/table/tbody/tr[' + 
                    (i + 1)) + ']/td[7]')))
		
		Assert.assertNotEquals(orderValue, null,"Order number is null")
		
		Assert.assertNotEquals(addressValue, null,"Address is null")
		
		Assert.assertNotEquals(listingValue, null,"Listing is null")
		
		Assert.assertNotEquals(bookingDate, null,"Booking date is null")
		
		Assert.assertNotEquals(statusValue, null,"Status is null")
		
		Assert.assertNotEquals(paymentStatus, null,"Payment status is null")
    }
    
    driver.findElement(By.xpath('/html/body/header/div/span[1]')).click()
	
	//Changes here
	
	//driver.findElement(By.xpath("/html/body/header/div/div[2]/ul/li[1]/a")).click()

    Thread.sleep(2000)

    driver.findElement(By.linkText('Sign Out')).click()

    Thread.sleep(1000)

    Actions action = new Actions(driver)

    action.sendKeys(Keys.ESCAPE).build().perform()

    Thread.sleep(2000)

    driver.quit()
}
}
catch (Exception e) {
	File src = ((driver) as TakesScreenshot).getScreenshotAs(OutputType.FILE)

	FileUtils.copyFile(src, new File((screenshots + System.currentTimeMillis()) + '.png'))

	System.out.println(e.getMessage())

	driver.quit()
}