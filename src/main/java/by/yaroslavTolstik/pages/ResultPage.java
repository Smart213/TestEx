package by.yaroslavTolstik.pages;

import by.yaroslavTolstik.entity.ResultTo;
import by.yaroslavTolstik.entity.SearchTo;
import by.yaroslavTolstik.entity.factorys.ResultToFactory;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static by.yaroslavTolstik.BaseElements.*;
import static java.util.stream.Collectors.toList;

@Log4j
public class ResultPage {

    private final String results = "div[data-testid$='ticket-desktop'] ";
    private final String timer = "div[class$='search-countdown__timer']";

    public final static String resultsForth = "div[data-testid$='forth'] ";
    public final static String resultsBack = "div[data-testid$='back'] ";

    public final static String destinationEndpoint = "div[data-testid='destination-endpoint'] ";
    public final static String originEndpoint = "div[data-testid='origin-endpoint'] ";

    public final static String city = "div[data-testid$='city']";
    public final static String date = "div[data-testid$='date']";

    public final static String amount = "span[class='buy-button__price'] span[data-test-element$='price']";


    /**
     * Создает лист тестовых объектов из результата
     */
    public List<ResultTo> getResults() {
        return $$(results)
                .stream()
                .map(ResultToFactory::create)
                .collect(toList());
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
