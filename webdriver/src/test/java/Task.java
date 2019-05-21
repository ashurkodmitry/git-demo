import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://cloud.google.com/");
        //risky point
        WebElement clickProducts = driver.findElement(By.xpath("//*[@data-label='Footer GCP pricing'][@track-name='productsAndPricing']"));
        clickProducts.click();
        //risky point
        WebElement clickPricing = driver.findElement(By.xpath("//*[@track-name='seePricing']"));
        clickPricing.click();
        //risky point
        Thread.sleep(2000);
        driver.quit();

    }
}


