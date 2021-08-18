package by.yaroslavTolstik.pages;

import by.yaroslavTolstik.entity.SearchTo;
import by.yaroslavTolstik.utils.ParseUtil;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static by.yaroslavTolstik.BaseElements.*;
import static by.yaroslavTolstik.utils.DateUtil.getDateToResult;
import static java.util.stream.Collectors.toList;

@Log4j
public class ResultPage {

    private final String results = "div[data-testid$='ticket-desktop'] ";
    private final String timer = "div[class$='search-countdown__timer']";

    private final String resultsForth = "div[data-testid$='forth'] ";
    private final String resultsBack = "div[data-testid$='back'] ";

    private final String destinationEndpoint = "div[data-testid='destination-endpoint'] ";
    private final String originEndpoint = "div[data-testid='origin-endpoint'] ";

    private final String city = "div[data-testid$='city']";
    private final String date = "div[data-testid$='date']";

    private final String amount = "span[class='buy-button__price'] span[data-test-element$='price']";

    /**
     * проверка городов вылета туда
     */
    public ResultPage assertCitiesFromForth(SearchTo to) {
        $$(results + resultsForth + originEndpoint + city).forEach(el ->
                Assert.assertEquals(el.getText(), to.getFrom().getName(),
                        "Город вылета не соответствует " + to.getFrom().getName()));
        return this;
    }

    /**
     * проверка городов приземления туда
     */
    public ResultPage assertCitiesToForth(SearchTo to) {
        $$(results + resultsForth + destinationEndpoint + city).forEach(el ->
                Assert.assertEquals(el.getText(), to.getTo().getName(),
                        "Город прилета не соответствует " + to.getTo().getName()));
        return this;
    }

    /**
     * проверка городов вылета назад
     */
    public ResultPage assertCitiesFromBack(SearchTo to) {
        $$(results + resultsBack + originEndpoint + city).forEach(el ->
                Assert.assertEquals(el.getText(), to.getTo().getName(),
                        "Город вылета обратного рейса не соответствует " + to.getTo().getName()));
        return this;
    }

    /**
     * проверка городов приземления назад
     */
    public ResultPage assertCitiesToBack(SearchTo to) {
        $$(results + resultsBack + destinationEndpoint + city).forEach(el ->
                Assert.assertEquals(el.getText(), to.getFrom().getName(),
                        "Город прилета обратного рейса не соответствует " + to.getFrom().getName()));
        return this;
    }

    /**
     * проверка дат вылета туда
     */
    public ResultPage assertDateFromForth(SearchTo to) {
        $$(results + resultsForth + originEndpoint + date).forEach(el ->
                Assert.assertEquals(el.getText(), getDateToResult(to.getDateFrom()),
                        "Дата вылета не соответствует " + to.getFrom().getName()));
        return this;
    }


    /**
     * проверка всех дат вылета назад
     */
    public ResultPage assertDateFromBack(SearchTo to) {
        $$(results + resultsBack + originEndpoint + date).forEach(el ->
                Assert.assertEquals(el.getText(), getDateToResult(to.getDateBack()),
                        "Дата вылета обратного рейса не соответствует " + to.getTo().getName()));
        return this;
    }


    /**
     * проверяет отсортирован ли по цене результат поиска
     */
    public ResultPage assertAmountSorted() {
        final List<Long> actlist =
                $$(results + amount)
                        .stream()
                        .map(WebElement::getText)
                        .map(ParseUtil::getLong)
                        .collect(toList());
        List<Long> sortedList =
                actlist.stream()
                        .sorted()
                        .collect(Collectors.toList());

        Assert.assertEquals(actlist, sortedList, "Список цен не отсортирован");
        return this;
    }

    /**
     * ожидает открытие страницы
     */
    public ResultPage isOpenPageResult() {
        isOpen(timer);
        log.info("Страница отображенаю");
        return this;
    }

    /**
     * ожидает загрузку данных на странице
     */
    public ResultPage load() {
        if (isVisible(timer)) {
            load();
        } else
            log.info("Загрузка завершена.");
        return this;
    }
}
