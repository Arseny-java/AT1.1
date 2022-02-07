package ru.yandex;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTests {
    //Принято волевое решение использовать браузер Фаерфокс, так как версия вебдрайвера для Хрома
    // не совсем корректно отрабатывала с актуальной версией Хрома. Функция findElements отрабатывала через раз
    protected WebDriver geckoDriver;

    @BeforeEach
    public void before() {
        System.setProperty("webdriver.gecko.driver", System.getenv("GECKO_DRIVER"));
        geckoDriver = new FirefoxDriver();
        geckoDriver.manage().window().maximize();
    }

    @AfterEach
    public void after() {
        geckoDriver.quit();
    }

}
