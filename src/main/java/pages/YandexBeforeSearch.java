package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YandexBeforeSearch {
    private static final String SEARCH_FIELD_XPATH = "//input[@id=\"text\"]";
    private static final String SEARCH_BUTTON_XPATH = "//button[@role=\"button\" and @type = \"submit\"]";
    protected WebDriver geckoDriver;
    protected WebElement searchField;
    protected WebElement searchButton;

    public YandexBeforeSearch(WebDriver geckoDriver) {
        this.geckoDriver = geckoDriver;
        this.searchField = geckoDriver.findElement(By.xpath(SEARCH_FIELD_XPATH));
        this.searchButton = geckoDriver.findElement(By.xpath(SEARCH_BUTTON_XPATH));
    }

    public void find(String keysToSend) {
        searchField.click();
        searchField.sendKeys(keysToSend);
        searchButton.click();

    }
}
