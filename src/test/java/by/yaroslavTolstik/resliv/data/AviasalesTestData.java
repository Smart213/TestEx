package by.yaroslavTolstik.resliv.data;

import by.yaroslavTolstik.entity.SearchTo;
import by.yaroslavTolstik.entity.factorys.SearchToFactory;
import by.yaroslavTolstik.enums.Cities;
import org.testng.annotations.DataProvider;

import java.time.LocalDate;

public class AviasalesTestData {

    @DataProvider
    public static Object[][] testData() {
        SearchTo to = SearchToFactory
                .create(Cities.MOSCOW,
                        Cities.SPB,
                        LocalDate.now().plusDays(1),
                        LocalDate.now().plusDays(2),
                        1,
                        1,
                        0);
        return new Object[][]{{
                to
        }};
    }
}
