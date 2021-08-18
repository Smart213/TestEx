package by.yaroslavTolstik.entity.factorys;

import by.yaroslavTolstik.entity.SearchTo;
import by.yaroslavTolstik.enums.Cities;

import java.time.LocalDate;

public class SearchToFactory {

    public static SearchTo create(Cities from,
                                  Cities to,
                                  LocalDate dateFrom,
                                  LocalDate dateBack,
                                  int adults,
                                  int children,
                                  int babies) {
        return SearchTo.builder()
                .from(from)
                .to(to)
                .dateFrom(dateFrom)
                .dateBack(dateBack)
                .adults(adults)
                .children(children)
                .babies(babies)
                .build();
    }
}
