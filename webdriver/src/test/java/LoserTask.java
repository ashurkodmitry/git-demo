import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoserTask {

    public static void main(String[] args) throws InterruptedException {

        //Original version of the code

        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");

        WebDriverWait waitPage = new WebDriverWait(driver,10);
        waitPage.until(ExpectedConditions.presenceOfElementLocated(By.id("paste_code")));
        WebElement pasteText = driver.findElement(By.id("paste_code"));
        pasteText.sendKeys("Hello from WebDriver");


        //WebDriverWait waitExpiration = new WebDriverWait(driver,10);
        //waitExpiration.until(ExpectedConditions.presenceOfElementLocated(By.name("paste_expire_date")));
        Select drpExpiration = new Select(driver.findElement(By.name("paste_expire_date")));
        drpExpiration.selectByVisibleText("10 Minutes");

        //WebDriverWait waitTitle = new WebDriverWait(driver,10);
        //waitTitle.until(ExpectedConditions.presenceOfElementLocated(By.name("paste_expire_date")));
        WebElement pasteTitle = driver.findElement(By.name("paste_name"));
        pasteTitle.sendKeys("helloweb");

        WebElement clickSubmit = driver.findElement(By.id("submit"));
        clickSubmit.click();
        //driver.quit();

    }
}
