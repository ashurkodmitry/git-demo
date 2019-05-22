import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoserTask {

    public static void main(String[] args) throws InterruptedException {

        //Original version of the code

        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");

        WebElement pasteText = driver.findElement(By.xpath("//*[@id='paste_code']"));
        pasteText.sendKeys("Hello from WebDriver");
        Thread.sleep(2000);

        Select drpExpiration = new Select(driver.findElement(By.xpath("//*[@id='select2-paste_expire_date-z8-container']")));
        drpExpiration.selectByVisibleText("10 Minutes");
        Thread.sleep(2000);
        driver.quit();

    }
}
