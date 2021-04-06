package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.WaiterUtil;


public class GooglePage extends WaiterUtil {
    private static final String HOMEPAGE_URL = "https://www.google.kz/";
    protected WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")
    private WebElement searchClickBtn;

    @FindBy(xpath = "//h3[normalize-space()='Creative']")
    private WebElement foundResult;

    public void openPage() {
        driver.get(HOMEPAGE_URL);
        driver.manage().window().maximize();
    }

    public void startSearchByKeyWords() {
        waitUntilBePresence(driver, 5, "//input[@type='text']");

        searchInput.click();

        searchInput.sendKeys("crtweb.ru");
        searchClickBtn.click();
    }

    public void chooseItemFromSearchResults() {
        waitUntilBePresence(driver, 5, "//h3[normalize-space()='Creative']");
        foundResult.click();
    }

    public void closePage() {
        driver.quit();
    }

}