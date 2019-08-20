import org.apache.commons.io.FileUtils as FileUtils
import org.openqa.selenium.OutputType as OutputType
import org.openqa.selenium.TakesScreenshot as TakesScreenshot
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.testng.Assert as Assert
System.setProperty('webdriver.chrome.driver', chromePath)

WebDriver driver = new ChromeDriver()

driver.manage().window().maximize()
try{
driver.get('http://workilo.com')

String actualTitle = driver.getTitle()

String expectedTitle = 'Workilo :: Home Improvement And Renovation Services in Brooklyn by Workilo'

Assert.assertEquals(actualTitle, expectedTitle, 'Title didn\'t match.')

Thread.sleep(3000)

driver.quit()
}
catch (Exception e) {
	File src = ((driver) as TakesScreenshot).getScreenshotAs(OutputType.FILE)

	FileUtils.copyFile(src, new File((screenshots + System.currentTimeMillis()) + '.png'))

	System.out.println(e.getMessage())

	driver.quit()
}