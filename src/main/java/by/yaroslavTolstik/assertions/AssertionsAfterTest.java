package by.yaroslavTolstik.assertions;

import by.yaroslavTolstik.entity.ResultTo;
import by.yaroslavTolstik.entity.SearchTo;
import by.yaroslavTolstik.entity.factorys.ResultToFactory;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class AssertionsAfterTest {

    /**
     * проверяет отсортирован ли по цене результат поиска
     */
    public AssertionsAfterTest assertAmountSorted(List<ResultTo> actlist) {
        List<ResultTo> sortedList =
                actlist.stream()
                        .sorted()
                        .collect(Collectors.toList());
        Assert.assertEquals(actlist, sortedList, "Список цен не отсортирован");
        return this;
    }

    /**
     * проверяет соответствие результатов с исходными данными запроса
     */
    public AssertionsAfterTest assertFields(SearchTo expTo, List<ResultTo> actlist) {
        ResultTo exp = ResultToFactory.create(expTo);
        actlist.forEach(act ->
                Assert.assertEquals(act, exp, "Данные отображены не верно."));
        return this;
    }
}
