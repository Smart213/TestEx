package by.yaroslavTolstik.pages;

import by.yaroslavTolstik.Tag;
import by.yaroslavTolstik.entity.SearchTo;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;

import static by.yaroslavTolstik.BaseElements.*;
import static by.yaroslavTolstik.utils.DateUtil.getDateToSearch;

@Log4j
public class StartPage {

    private final String HEADER = "Поиск дешёвых авиабилетов";

    private final String fromInp = "input[id$='origin']";
    private final String toInp = "input[id$='destination']";

    private final String departureField = "div[class$='departure']";
    private final String returnField = "div[class$='return']";

    private final String table = "div[class$='trip-duration__wrap']";

    private final String newWindowCheckBox = "label[for='clicktripz']";

    private final String old = "div[id='oldBrowserModal']";
    private final String oldCloseBtn = "button[id='obn_button_1']";

    private final String passengers = "div[class$='passengers']";
    private final String avia = "div[class$='avia']";
    private final String dropdown = "div[data-test-element='dropdown']";
    private final String passAdults = "div[class$='passenger-row']:nth-child(1) ";
    private final String passChildren = "div[class$='passenger-row']:nth-child(2) ";
    private final String passBabies = "div[class$='passenger-row']:nth-child(3) ";
    private final String incrButton = "a[class$='increment']";
    private final String countPpl = "div:nth-child(2)";

    private final String submit = "div[class$='submit'] button";

    /**
     * закрывает всплывающее окно устаревшего браузера
     */
    public StartPage oldBrowserCheck() {
        if (isVisible(old))
            getClickableElement(oldCloseBtn).click();
        return this;
    }

    /**
     * проверяет отображение страницы
     */
    public StartPage load() {
        Assert.assertEquals(getVisibilityElement(Tag.h1).getText(), HEADER, "Страница не загружена.");
        log.info("страница загружена");
        return this;
    }

    /**
     * заполняет страну вылета
     */
    public StartPage setFromField(SearchTo to) {
        setInput(fromInp, to.getFrom().getName());
        log.info("Поле 'Откуда' заполнено значением " + to.getFrom().getName());
        return this;
    }

    /**
     * заполняет страну прилета
     */
    public StartPage setToField(SearchTo to) {
        setInput(toInp, to.getTo().getName());
        log.info("Поле 'Куда' заполнено значением " + to.getTo().getName());
        return this;
    }

    /**
     * вводит значение в поля input
     */
    private void setInput(String locator, String value) {
        getClickableElement(locator).clear();
        getClickableElement(locator).sendKeys(value);
    }

    /**
     * устанавливает дату вылета
     */
    public StartPage setWhen(SearchTo to) {
        if (!isVisible(departureField + " " + table))
            getClickableElement(departureField).click();
        getClickableElement("div[aria-label='" + getDateToSearch(to.getDateFrom()) + "']").click();
        log.info("Поле 'Когда' заполнено значением " + getDateToSearch(to.getDateFrom()));
        return this;
    }

    /**
     * устанавливает дату возвращения
     */
    public StartPage setBack(SearchTo to) {
        if (!isVisible(returnField + " " + table))
            getClickableElement(returnField).click();
        getClickableElement("div[aria-label='" + getDateToSearch(to.getDateBack()) + "']").click();
        log.info("Поле 'Обратно' заполнено значением " + getDateToSearch(to.getDateBack()));
        return this;
    }

    /**
     * снимает чекбокс открытия нового окна
     */
    public StartPage newWindUncheck() {
        getVisibilityElement(newWindowCheckBox).click();
        return this;
    }

    /**
     * заполняет пассажиров
     */
    public StartPage fillPassengers(SearchTo to) {
        getClickableElement(passengers).click();
        waitDropdown();
        fillPass(passChildren, to.getChildren());
        fillPass(passAdults, to.getAdults());
        fillPass(passBabies, to.getBabies());
        log.info("пассажиры добавлены: " +
                "взрослые " + to.getAdults() +
                "; дети " + to.getChildren() +
                "; младенцы " + to.getBabies());
        return this;
    }

    /**
     * ожидает открытие вкладки
     */
    private void waitDropdown() {
        if (!isAttribute(avia, "class", "is-open") ||
                !isOpen(dropdown) ||
                !isDisplayed(passChildren + incrButton))
            waitDropdown();
    }

    /**
     * добавляет счетчик
     */
    private void fillPass(String loc, long val) {
        int count = Integer.parseInt(getVisibilityElement(loc + countPpl).getText());
        for (; count < val; count++) {
            getClickableElement(loc + incrButton).click();
        }
    }

    /**
     * Нажимает кнопку поиска
     */
    public StartPage search() {
        getClickableElement(submit).click();
        log.info("Нажата кнопка 'Найти билеты'");
        return this;
    }
}
