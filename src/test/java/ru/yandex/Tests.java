package ru.yandex;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.YandexAfterSearch;
import pages.YandexBeforeSearch;

public class Tests extends BaseTests {
    //Принято решение тестировать через Яндекс, так как Гугл выставлял капчу

    @Feature("Проверка наличия Википедии в результатах поиска")
    @DisplayName("Поиск Википедии на первой странице поиска")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @CsvSource({"https://www.yandex.ru, Гладиолус, ru.wikipedia.org"})
    public void testPageObject(String site, String keyword, String result) {
        String negativeMessage = result + " в результатах поиска на первой странице не обнаружена";

        geckoDriver.get(site);
        YandexBeforeSearch yandexBeforeSearch = new YandexBeforeSearch(geckoDriver);
        YandexAfterSearch yandexAfterSearch = new YandexAfterSearch(geckoDriver);

        yandexBeforeSearch.find(keyword);
        Assertions.assertTrue(yandexAfterSearch
                .getResults()
                .stream()
                .anyMatch(x -> x.getText()
                        .contains(result)), negativeMessage);

    }
}
