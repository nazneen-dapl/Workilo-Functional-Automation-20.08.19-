import java.util.concurrent.TimeUnit as TimeUnit

import org.apache.commons.io.FileUtils
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.interactions.Actions as Actions
import org.testng.Assert

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

driver.findElement(By.xpath('/html/body/header/div/span[1]')).click()

//Changes here

//driver.findElement(By.xpath("/html/body/header/div/div[2]/ul/li[1]/a")).click()

Thread.sleep(1000)

driver.findElement(By.xpath('/html/body/div[4]/div/div[1]/ul/li[2]/a')).click()

Thread.sleep(1000)

driver.findElement(By.xpath('/html/body/div[6]/div/div[1]/div[1]/div/div/ul/li[4]/a')).click()

String message = driver.findElement(By.xpath('/html/body/div[6]/div/div[1]/div[1]/div/div/ul/li[4]/a')).getText()

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

//js.executeScript('window.scrollTo(0, document.body.scrollHeight)')

List<WebElement> rows = driver.findElements(By.xpath('//*[@id=\'tab-4\']/table/tbody/tr'))

System.out.println('Total Rows Size == ' + rows.size())

for (int i = 0; i < 1; i++) {
System.out.println('Items == ' + (i + 1))

String orderValue = driver.findElement(By.xpath(('//*[@id=\'tab-4\']/table/tbody/tr[' + (i + 1)) + ']/td[1]')).getText()

String addressValue = driver.findElement(By.xpath(('//*[@id=\'tab-4\']/table/tbody/tr[' + (i + 1)) + ']/td[2]')).getText()

String listingValue = driver.findElement(By.xpath(('//*[@id=\'tab-4\']/table/tbody/tr[' + (i + 1)) + ']/td[3]')).getText()

String bookingDateValue = driver.findElement(By.xpath(('//*[@id=\'tab-4\']/table/tbody/tr[' + (i + 1)) + ']/td[4]')).getText()

String statusValue = driver.findElement(By.xpath(('//*[@id=\'tab-4\']/table/tbody/tr[' + (i + 1)) + ']/td[5]')).getText()

String paymentValue = driver.findElement(By.xpath(('//*[@id=\'tab-4\']/table/tbody/tr[' + (i + 1)) + ']/td[6]')).getText()

WebElement order = driver.findElement(By.xpath(('//*[@id=\'tab-4\']/table/tbody/tr[' + (i + 1)) + ']/td[1]'))

WebElement address = driver.findElement(By.xpath(('//*[@id=\'tab-4\']/table/tbody/tr[' + (i + 1)) + ']/td[2]'))

WebElement listing = driver.findElement(By.xpath(('//*[@id=\'tab-4\']/table/tbody/tr[' + (i + 1)) + ']/td[3]'))

WebElement bookingDate = driver.findElement(By.xpath(('//*[@id=\'tab-4\']/table/tbody/tr[' + (i + 1)) + ']/td[4]'))

WebElement status = driver.findElement(By.xpath(('//*[@id=\'tab-4\']/table/tbody/tr[' + (i + 1)) + ']/td[5]'))

WebElement paymentStatus = driver.findElement(By.xpath(('//*[@id=\'tab-4\']/table/tbody/tr[' + (i + 1)) + ']/td[6]'))

js.executeScript('arguments[0].style.border=\'3px solid red\'', order)

js.executeScript('arguments[0].style.border=\'3px solid red\'', address)

js.executeScript('arguments[0].style.border=\'3px solid red\'', listing)

js.executeScript('arguments[0].style.border=\'3px solid red\'', bookingDate)

js.executeScript('arguments[0].style.border=\'3px solid red\'', status)

js.executeScript('arguments[0].style.border=\'3px solid red\'', paymentStatus)

System.out.println('OrderValues == ' + orderValue)

System.out.println('AddressValues == ' + addressValue)

System.out.println('ListingValues == ' + listingValue)

System.out.println('BookinDateValues == ' + bookingDateValue)

System.out.println('StatusValues == ' + statusValue)

System.out.println('PaymentStatusValues == ' + paymentValue)

Assert.assertNotEquals(orderValue, null,"Order number is null")

Assert.assertNotEquals(addressValue, null,"Address is null")

Assert.assertNotEquals(listingValue, null,"Listing is null")

Assert.assertNotEquals(bookingDateValue, null,"Booking date is null")

Assert.assertNotEquals(statusValue, null,"Status is null")

Assert.assertNotEquals(paymentValue, null,"Payment status is null")
}

Thread.sleep(2000)

driver.findElement(By.xpath('/html/body/header/div/span[1]')).click()

//Changes here

//driver.findElement(By.xpath("/html/body/header/div/div[2]/ul/li[1]/a")).click()

Thread.sleep(2000)

driver.findElement(By.linkText('Sign Out')).click()

Thread.sleep(1000)

Actions action = new Actions(driver)

action.sendKeys(Keys.ESCAPE).build().perform()

Thread.sleep(2000)

}
}catch(Exception e){
File src = ((driver) as TakesScreenshot).getScreenshotAs(OutputType.FILE)

FileUtils.copyFile(src, new File((screenshots +System.currentTimeMillis()) + '.png'))
System.out.println(e.getMessage())

}
driver.quit()