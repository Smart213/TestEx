package by.yaroslavTolstik.resliv.test;

import by.yaroslavTolstik.driver.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    private final String aviasales = "https://www.aviasales.by/";

    @BeforeClass
    public void start() {
        Driver.getDriver().get(aviasales);
    }

    @AfterClass
    public void end() {
        Driver.closeDriver();
    }
}
