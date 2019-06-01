import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Tests {

    protected static WebDriver driver;

    String formText = ("git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force");
    String textHighlight = ("Bash");
    String textExpiration = ("10 Minutes");
    String textTitle = "how to gain dominance among developers";

    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void pasteTest(){
        PageObject pageObject = new PageObject(this.driver);
        pageObject.openPage("https://pastebin.com");
        pageObject.pasteText(formText);
        pageObject.selectHighlight(textHighlight);
        pageObject.selectExpiration(textExpiration);
        pageObject.pasteTitle(textTitle);
        pageObject.pasteSubmit();
        Assert.assertEquals("Titles do not match", textTitle, pageObject.getPageTitle());
        Assert.assertEquals("Highlight types do not match", textHighlight, pageObject.getHighlighter());
        Assert.assertEquals("Paste texts do not match", formText, pageObject.getPasteText());
    }

    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
