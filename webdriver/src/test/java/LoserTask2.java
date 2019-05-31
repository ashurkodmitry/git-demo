import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoserTask2 {

    public static void main(String[] args) {

        //открываем страницу

        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");

        //вносим данные

        WebDriverWait waitPage = new WebDriverWait(driver,10);
        waitPage.until(ExpectedConditions.presenceOfElementLocated(By.id("paste_code")));
        WebElement pasteText = driver.findElement(By.id("paste_code"));
        pasteText.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");


        Select drpHighlighting = new Select(driver.findElement(By.name("paste_format")));
        drpHighlighting.selectByVisibleText("Bash");


        Select drpExpiration = new Select(driver.findElement(By.name("paste_expire_date")));
        drpExpiration.selectByVisibleText("10 Minutes");


        WebElement pasteTitle = driver.findElement(By.name("paste_name"));
        pasteTitle.sendKeys("how to gain dominance among developers");


        WebElement clickSubmit = driver.findElement(By.id("submit"));
        clickSubmit.click();

        //ждем загрузки первого элемента для сравнения

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));

        //сравнение заголовков

        String actualTitle = driver.findElement(By.cssSelector("h1")).getText();
        String expectedTitle = "how to gain dominance among developers";

        if(actualTitle.equals(expectedTitle)) {
            System.out.println("Titles match");
        }
        else {
            System.out.println("Titles do not match");
        }

        //сравнение типов подсветки

        String actualHighlight = driver.findElement(By.xpath("//*[@class='h_640']/a")).getText();
        String expectedHighlight = "Bash";

        if(actualHighlight.equals(expectedHighlight)) {
            System.out.println("Highlight types match");
        }
        else {
            System.out.println("Highlight types do not match");
        }

        //сравнение текстов

        String actualText = driver.findElement(By.id("paste_code")).getText();
        String expectedText = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";

        if(actualText.equals(expectedText)) {
            System.out.println("Texts match");
        }
        else {
            System.out.println("Texts do not match");
        }

        //закрытие браузера

        driver.quit();
    }
}
