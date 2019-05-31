import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Task {

    public static void main(String[] args) throws InterruptedException {

        //Original version of the code

        WebDriver driver = new ChromeDriver();
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();


        WebDriverWait waitProducts = new WebDriverWait(driver,10);
        waitProducts.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-label='Footer See all products']")));
        WebElement clickProducts = driver.findElement(By.xpath("//*[@data-label='Footer See all products']"));
        clickProducts.click();


        WebDriverWait waitPricing = new WebDriverWait(driver,10);
        waitPricing.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@track-name='seePricing']")));
        WebElement clickPricing = driver.findElement(By.xpath("//*[@track-name='seePricing']"));
        clickPricing.click();


        WebDriverWait waitCalculator = new WebDriverWait(driver,10);
        waitCalculator.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Calculators']")));
        WebElement clickCalculator = driver.findElement(By.xpath("//a[text()='Calculators']"));
        clickCalculator.click();

        WebElement outerFrame = driver.findElement(By.xpath("//*[@ng-controller='ListingCtrl as listingCtrl']"));
        driver.switchTo().frame(outerFrame);
        Thread.sleep(2000);

        WebElement midFrame = driver.findElement(By.id("mainForm"));
        driver.switchTo().frame(midFrame);
        Thread.sleep(2000);

        WebElement innerFrame = driver.findElement(By.xpath("//*[@class='compute-engine-block']"));
        driver.switchTo().frame(innerFrame);
        Thread.sleep(2000);

        //risky point

        //WebElement clickComputeEngine = driver.findElement(By.linkText("Compute Engine")); // попробую обойтись без этого. Мб сделать проверку, что выбран этот тип
        //clickComputeEngine.click();

        //risky point
        //driver.switchTo().window("ComputeEngineForm"); посмотреть название формы
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input_51")));
        WebElement instancesNum = driver.findElement(By.id("input_51")); //не сработал
        instancesNum.sendKeys("4");
        //Thread.sleep(10000);

        //risky point

        //WebElement selectOS = driver.findElement(By.xpath("//*[@id='select_value_label_44']"));
        //selectOS.click();

        Thread.sleep(2000);
        //driver.quit();


        //Завтра попробовать полностью заполнить списки в Калькуляторе, Compute Engine

        //получаем id окна
        String winHandleBefore = driver.getWindowHandle();
        //открываем новое
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        //в новом окне
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window((String) tabs.get(0));
        driver.get("https://10minutemail.com");
        //возвращаемся в предыдущее окно
        driver.switchTo().window(winHandleBefore);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
        driver.switchTo().defaultContent();
    }
}


