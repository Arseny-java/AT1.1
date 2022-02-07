package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class YandexAfterSearch extends YandexBeforeSearch {
    private static final String SEARCH_ELEMENTS = "//*[@class=\"Path Organic-Path path organic__path\"]//*[contains(local-name(), \"b\")]";
    WebDriverWait wait = new WebDriverWait(geckoDriver, 120);

    public YandexAfterSearch(WebDriver geckoDriver) {
        super(geckoDriver);
    }

    public List<WebElement> getResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SEARCH_ELEMENTS)));
        return geckoDriver.findElements(By.xpath(SEARCH_ELEMENTS));
    }
}
