import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {

    public static void main(String[] args) throws InterruptedException {

        //Original version of the code

        WebDriver driver = new ChromeDriver();
        driver.get("https://cloud.google.com/");

        //risky point

        WebElement clickProducts = driver.findElement(By.xpath("//*[@data-label='Footer See all products']"));
        clickProducts.click();
        Thread.sleep(10000); //заменить вейтом

        //risky point

        WebElement clickPricing = driver.findElement(By.xpath("//*[@data-label='Footer GCP pricing']")); //заглушка. решение неверно!
        clickPricing.click();
        Thread.sleep(10000); //заменить вейтом

        //risky point

        WebElement openList = driver.findElement(By.xpath("//*[@class='cloud-jump-menu__toggle']"));
        openList.click();
        Thread.sleep(10000); //заменить вейтом

        //risky point

        WebElement clickCalculator = driver.findElement(By.xpath("//a[text()='Calculators']"));
        clickCalculator.click();
        Thread.sleep(10000); //заменить вейтом

        //risky point

        //WebElement clickComputeEngine = driver.findElement(By.linkText("Compute Engine")); // попробую обойтись без этого. Мб сделать проверку, что выбран этот тип
        //clickComputeEngine.click();

        //risky point

        WebElement instancesNum = driver.findElement(By.xpath("//*[@id='input_51']")); //не сработал
        instancesNum.sendKeys("4");
        Thread.sleep(10000);

        //risky point

        WebElement selectOS = driver.findElement(By.xpath("//*[@id='select_value_label_44']"));
        selectOS.click();

        Thread.sleep(2000);
        driver.quit();


        //Завтра попробовать полностью заполнить списки в Калькуляторе, устранить проблему с See Pricing, Compute Engine


    }
}


