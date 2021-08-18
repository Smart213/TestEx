package by.yaroslavTolstik.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Cities {

    MOSCOW("Москва"),
    SPB("Санкт-Петербург");

    private final String name;
}
