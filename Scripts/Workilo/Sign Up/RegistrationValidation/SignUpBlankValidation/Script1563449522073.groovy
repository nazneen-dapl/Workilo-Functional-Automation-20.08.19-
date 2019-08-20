import java.util.concurrent.TimeUnit as TimeUnit

import org.apache.commons.io.FileUtils
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
System.setProperty('webdriver.chrome.driver', chromePath)

WebDriver driver = new ChromeDriver()

driver.manage().window().maximize()
try{
driver.get('http://workilo.com')

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)

driver.findElement(By.linkText('Sign Up')).click()

Thread.sleep(2000)

driver.findElement(By.xpath('//*[text()=\'Client\']')).click()

Thread.sleep(1000)

JavascriptExecutor js = ((driver) as JavascriptExecutor)

//js.executeScript('window.scrollBy(0,600)')
//js.executeScript('arguments[0].scrollIntoView();', driver.findElement(By.xpath('.//*[@value=\'Sign Up\']')))

driver.findElement(By.xpath('.//*[@value=\'Join Workilo!\']')).click()

WebElement email = driver.findElement(By.xpath('//*[@id=\'signup-form\']/div[1]/label[2]'))

WebElement firstname = driver.findElement(By.xpath('//*[@id=\'signup-form\']/div[2]/div[1]/label[2]'))

WebElement lastname = driver.findElement(By.xpath('//*[@id=\'signup-form\']/div[2]/div[2]/label[2]'))

WebElement pwd = driver.findElement(By.xpath('//*[@id=\'signup-form\']/div[3]/label[2]'))

WebElement contact = driver.findElement(By.xpath('//*[@id=\'signup-form\']/div[4]/label[2]'))

js.executeScript('arguments[0].style.border=\'3px solid red\'', email)

js.executeScript('arguments[0].style.border=\'3px solid red\'', firstname)

js.executeScript('arguments[0].style.border=\'3px solid red\'', lastname)

js.executeScript('arguments[0].style.border=\'3px solid red\'', pwd)

js.executeScript('arguments[0].style.border=\'3px solid red\'', contact)

Thread.sleep(5000)

}catch(Exception e){
	File src = ((driver) as TakesScreenshot).getScreenshotAs(OutputType.FILE)
	
	FileUtils.copyFile(src, new File((screenshots +	System.currentTimeMillis()) + '.png'))
	System.out.println(e.getMessage())
	
}
driver.quit()