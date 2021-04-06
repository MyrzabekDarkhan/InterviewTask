package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CreativePage;
import utility.FirefoxDriverSet;

public class TestActions {
    WebDriver driver = FirefoxDriverSet.getDriver();

    @Test
    public void checkForContentInWebSite() {
        CreativePage page = new CreativePage(driver);
        page.openPage();
        page.startSearchByKeyWords();
        page.chooseItemFromSearchResults();
        page.clickOnMenu();
        page.clickOnContactList();
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Головной офис')]")).getText(), "Головной офис");
        Assert.assertEquals(driver.findElement(By.xpath("//a[contains(text(),'Москва, Пресненская набережная, 12')]")).getText(), "Москва, Пресненская набережная, 12");
        Assert.assertEquals(driver.findElement(By.xpath("//a[contains(text(),'Тюмень, ул. Малыгина 84 к1, 7 этаж')]")).getText(), "Тюмень, ул. Малыгина 84 к1, 7 этаж");
        Assert.assertEquals(driver.findElement(By.xpath("//a[normalize-space()='+7 (499) 113-68-89']")).getText(), "+7 (499) 113-68-89");
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='tn-atom'][normalize-space()='mail@crtweb.ru']")).getText(), "mail@crtweb.ru");
        page.closePage();
    }
}