package by.yaroslavTolstik.resliv.test;

import by.yaroslavTolstik.entity.ResultTo;
import by.yaroslavTolstik.entity.SearchTo;
import by.yaroslavTolstik.entity.factorys.ResultToFactory;
import by.yaroslavTolstik.entity.factorys.SearchToFactory;
import by.yaroslavTolstik.enums.Cities;
import by.yaroslavTolstik.pages.ResultPage;
import by.yaroslavTolstik.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TestNew {

    private SearchTo to;


    @BeforeSuite
    void start() {
        to = SearchToFactory
                .create(Cities.MOSCOW,
                        Cities.SPB,
                        LocalDate.now().plusDays(1),
                        LocalDate.now().plusDays(2),
                        1,
                        1,
                        0);
    }

    private final StartPage startPage = new StartPage();
    private final ResultPage resultPage = new ResultPage();

    @Test(description = "тестовое задание")
    public void TestEx() {
        startPage
                .oldBrowserCheck()
                .load()
                .setFromField(to)
                .setToField(to)
                .setWhen(to)
                .setBack(to)
                .fillPassengers(to)
                .newWindUncheck()
                .search();

        List<ResultTo> results =
                resultPage
                        .isOpenPageResult()
                        .load()
                        .getResults();
        results.forEach(act ->
                Assert.assertEquals(act, ResultToFactory.create(to),
                        "Данные отображены не верно."));
        List<ResultTo> sortedList =
                results.stream()
                        .sorted()
                        .collect(Collectors.toList());
        Assert.assertEquals(results, sortedList,
                "Список цен не отсортирован");
    }
}
