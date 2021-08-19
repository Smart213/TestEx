package by.yaroslavTolstik.resliv.test;

import by.yaroslavTolstik.entity.SearchTo;
import by.yaroslavTolstik.pages.ResultPage;
import by.yaroslavTolstik.pages.StartPage;
import by.yaroslavTolstik.resliv.data.AviasalesTestData;
import org.testng.annotations.Test;

public class Tests extends BaseTest {

    private final StartPage startPage = new StartPage();
    private final ResultPage resultPage = new ResultPage();

    @Test(dataProvider = "testData",
            dataProviderClass = AviasalesTestData.class,
            description = "тестовое задание")
    public void TestEx(SearchTo to) {
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
        resultPage
                .isOpenPageResult()
                .load()
                .assertFields(to)
                .assertAmountSorted();
    }
}
