import java.util.concurrent.TimeUnit as TimeUnit
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.interactions.Actions as Actions
import org.openqa.selenium.support.ui.Select as Select
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.apache.commons.io.FileUtils

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

Thread.sleep(2000)

driver.findElement(By.xpath('/html/body/div[4]/div/div[1]/ul/li[4]/a')).click()

driver.findElement(By.name('title')).sendKeys('Home Appliances123')

Select category = new Select(driver.findElement(By.id('category')))

category.selectByValue('80')

driver.findElement(By.xpath('//*[@id=\'tags\']/input[1]')).sendKeys('Repairing')

Actions action = new Actions(driver)

action.sendKeys(Keys.ENTER).build().perform()

driver.findElement(By.xpath('//*[@id=\'tags\']/input[1]')).sendKeys('Installing')

action.sendKeys(Keys.ENTER).build().perform()

String description = 'We delivered our service at very low cost. We provide home renovation repairing and installing new things.'

driver.findElement(By.id('description')).sendKeys(description)

driver.findElement(By.id('total_price')).sendKeys('1')

driver.findElement(By.id('editor2')).sendKeys('We provide all the materials which is needed at the time of installation or repairing.')

Select travel = new Select(driver.findElement(By.id('miles_travel')))

travel.selectByValue('5')

driver.findElement(By.id('where_located')).sendKeys('Brooklyn')

driver.findElement(By.id('manyhours')).sendKeys('8')

driver.findElement(By.name('about_listing')).sendKeys('test@gmail.com')

driver.findElement(By.id('img_up_1')).sendKeys(imagePath)

Thread.sleep(5000)

JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('window.scrollBy(0,500)')

driver.findElement(By.xpath('//*[@id=\'addlist\']/div[2]/input[2]')).click()

js.executeScript('window.scrollBy(0,500)')

driver.findElement(By.xpath('/html/body/header/div/span[1]')).click()

//Changes here

//driver.findElement(By.xpath("/html/body/header/div/div[2]/ul/li[1]/a")).click()

Thread.sleep(2000)

driver.findElement(By.linkText('Sign Out')).click()

Thread.sleep(2000)

action.sendKeys(Keys.ESCAPE).build().perform()

Thread.sleep(2000)

}catch(Exception e){
	File src = ((driver) as TakesScreenshot).getScreenshotAs(OutputType.FILE)
	
	FileUtils.copyFile(src, new File((screenshots +	System.currentTimeMillis()) + '.png'))
	System.out.println(e.getMessage())
	
}
driver.quit()