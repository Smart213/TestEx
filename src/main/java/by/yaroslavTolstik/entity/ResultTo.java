package by.yaroslavTolstik.entity;

import by.yaroslavTolstik.enums.Cities;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ResultTo implements Comparable<ResultTo> {

    private String fromForth;
    private String toForth;
    private String fromBack;
    private String toBack;

    private String dateFrom;
    private String dateBack;

    private Long sum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultTo resultTo = (ResultTo) o;
        return fromForth.equals(resultTo.fromForth) &&
                toForth.equals(resultTo.toForth) &&
                fromBack.equals(resultTo.fromBack) &&
                toBack.equals(resultTo.toBack) &&
                dateFrom.equals(resultTo.dateFrom) &&
                dateBack.equals(resultTo.dateBack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromForth, toForth, fromBack, toBack, dateFrom, dateBack);
    }

    @Override
    public int compareTo(ResultTo o) {
        return sum.compareTo(o.sum);
    }

    @Override
    public String toString() {
        return "ResultTo{" +
                "fromForth='" + fromForth + '\'' +
                ", toForth='" + toForth + '\'' +
                ", fromBack='" + fromBack + '\'' +
                ", toBack='" + toBack + '\'' +
                ", dateFrom='" + dateFrom + '\'' +
                ", dateBack='" + dateBack + '\'' +
                ", sum=" + sum +
                '}';
    }
}
