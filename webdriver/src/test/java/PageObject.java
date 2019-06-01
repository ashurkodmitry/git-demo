import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageObject {

    private WebDriver driver;


    @FindBy(id="paste_code")
    private WebElement textForm;

    @FindBy(name="paste_format")
    private WebElement highlightingDropdown;

    @FindBy(name="paste_expire_date")
    private WebElement expirationDropdown;

    @FindBy(name="paste_name")
    private WebElement titleText;

    @FindBy(id="submit")
    private WebElement submitButton;

    @FindBy(css="h1")
    private WebElement pageTitle;

    @FindBy(xpath="//*[@class='h_640']/a")
    private WebElement pasteHighlighter;

    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage (String url) {
        driver.get(url);
    }

    public void pasteText (String text) {
        WebDriverWait waitPage = new WebDriverWait(driver,10);
        waitPage.until(ExpectedConditions.presenceOfElementLocated(By.id("paste_code")));
        textForm.sendKeys(text);
    }


    public void selectHighlight (String text) {
        Select drpHighlighting = new Select(highlightingDropdown);
        drpHighlighting.selectByVisibleText(text);
    }

    public void selectExpiration (String text) {
        Select drpExpiration = new Select(expirationDropdown);
        drpExpiration.selectByVisibleText(text);
    }

    public void pasteTitle (String text) {
        titleText.sendKeys(text);
    }

    public void pasteSubmit () {
        submitButton.click();
    }

    public String getPageTitle (){
        return pageTitle.getText();
    }

    public String getHighlighter (){
        return pasteHighlighter.getText();
    }

    public String getPasteText (){
        return textForm.getText();
    }

}
