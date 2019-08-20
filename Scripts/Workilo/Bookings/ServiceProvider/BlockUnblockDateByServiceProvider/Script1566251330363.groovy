import java.util.concurrent.TimeUnit as TimeUnit

import org.apache.commons.io.FileUtils
import org.openqa.selenium.Alert
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
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

driver.findElement(By.id('email_login')).sendKeys('testworkilo@gmail.com')

driver.findElement(By.id('password_login')).sendKeys('admin#123')

driver.findElement(By.xpath('.//*[@value=\'Log in\']')).click()

Thread.sleep(3000)

//driver.findElement(By.xpath('/html/body/header/div/div[3]/ul/li[1]/a')).click()
driver.findElement(By.xpath('/html/body/header/div/span[3]')).click()
Thread.sleep(1000)

driver.findElement(By.xpath('/html/body/div[4]/div/div[1]/ul/li[2]/a')).click()

Thread.sleep(1000)

driver.findElement(By.xpath('/html/body/div[6]/div/div/div[1]/div/div/ul/li[2]/a')).click()

Thread.sleep(1000)

String message = driver.findElement(By.xpath('/html/body/div[6]/div/div/div[1]/div/div/ul/li[2]/a')).getText()

if (message.contains('(0)')) {
//driver.findElement(By.xpath('/html/body/header/div/span[1]')).click()
//Changes here

driver.findElement(By.xpath("/html/body/header/div/div[2]/ul/li[1]/a")).click()

Thread.sleep(2000)

driver.findElement(By.linkText('Sign Out')).click()

Thread.sleep(1000)

Actions action = new Actions(driver)

action.sendKeys(Keys.ESCAPE).build().perform()

Thread.sleep(2000)

driver.quit()

} else {
JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

Thread.sleep(3000)

driver.findElement(By.xpath("//*[@id='Calendar']/div[1]/div[2]/table/tbody/tr[5]/td[6]/a")).click()

Thread.sleep(3000)

List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/ul[1]/li"))

System.out.println("Total Rows = "+rows.size())

if(rows.size()>0){
for(int i = 0;i<rows.size();i++){
WebElement element1 = driver.findElement(By.xpath(('/html/body/div[6]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/ul[1]/li[' + (i + 1)) + ']'))
js.executeScript('arguments[0].style.border=\'3px solid red\'', element1)
}

}

Thread.sleep(3000)
js.executeScript("window.scrollBy(0,-100)")
Thread.sleep(2000)
driver.findElement(By.xpath("//*[@id='2019-08-31']")).click()

Alert alert = driver.switchTo().alert()

Thread.sleep(2000)

alert.accept()

Thread.sleep(3000)

//driver.findElement(By.xpath('/html/body/header/div/span[1]')).click()

//Changes here

driver.findElement(By.xpath("/html/body/header/div/div[3]/ul/li[1]/a")).click()

Thread.sleep(2000)

driver.findElement(By.linkText('Sign Out')).click()

Thread.sleep(1000)

Actions action = new Actions(driver)

action.sendKeys(Keys.ESCAPE).build().perform()

Thread.sleep(2000)

driver.quit()
}
}catch(Exception e){
File src = ((driver) as TakesScreenshot).getScreenshotAs(OutputType.FILE)

FileUtils.copyFile(src, new File((screenshots +System.currentTimeMillis()) + '.png'))
System.out.println(e.getMessage())

}
driver.quit()