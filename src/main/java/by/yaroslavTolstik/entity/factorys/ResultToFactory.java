package by.yaroslavTolstik.entity.factorys;

import by.yaroslavTolstik.entity.ResultTo;
import by.yaroslavTolstik.entity.SearchTo;
import by.yaroslavTolstik.utils.ParseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static by.yaroslavTolstik.pages.ResultPage.*;
import static by.yaroslavTolstik.utils.DateUtil.getDateToResult;

public class ResultToFactory {

    public static ResultTo create(SearchTo to) {
        return ResultTo.builder()
                .fromForth(to.getFrom().getName())
                .toForth(to.getTo().getName())
                .fromBack(to.getTo().getName())
                .toBack(to.getFrom().getName())
                .dateBack(getDateToResult(to.getDateBack()))
                .dateFrom(getDateToResult(to.getDateFrom()))
                .build();
    }

    public static ResultTo create(WebElement element) {
        return ResultTo.builder()
                .fromForth(element.findElements(By.cssSelector(resultsForth + originEndpoint + city)).get(0).getText())
                .toForth(element.findElements(By.cssSelector(resultsForth + destinationEndpoint + city)).get(0).getText())
                .fromBack(element.findElements(By.cssSelector(resultsBack + originEndpoint + city)).get(0).getText())
                .toBack(element.findElements(By.cssSelector(resultsBack + destinationEndpoint + city)).get(0).getText())
                .dateBack(element.findElements(By.cssSelector(resultsBack + originEndpoint + date)).get(0).getText())
                .dateFrom(element.findElements(By.cssSelector(resultsForth + originEndpoint + date)).get(0).getText())
                .sum(ParseUtil.getLong(element.findElements(By.cssSelector(amount)).get(0).getText()))
                .build();
    }
}
