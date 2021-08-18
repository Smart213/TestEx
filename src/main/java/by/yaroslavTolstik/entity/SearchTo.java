package by.yaroslavTolstik.entity;

import by.yaroslavTolstik.enums.Cities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SearchTo {

    private Cities from;
    private Cities to;
    private LocalDate dateFrom;
    private LocalDate dateBack;

    private int adults;
    private int children;
    private int babies;
}
