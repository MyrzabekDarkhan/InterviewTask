package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreativePage extends GooglePage {

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement menuHamburger;

    @FindBy(xpath = "//a[contains(text(),'контакты')]")
    private WebElement contactsList;

    public CreativePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnMenu() {
        menuHamburger.click();
    }

    public void clickOnContactList() {
        contactsList.click();
    }

}
