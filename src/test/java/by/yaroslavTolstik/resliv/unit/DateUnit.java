package by.yaroslavTolstik.resliv.unit;

import org.junit.Test;

import java.time.LocalDate;

import static by.yaroslavTolstik.utils.DateUtil.getDateToResult;
import static by.yaroslavTolstik.utils.DateUtil.getDateToSearch;

public class DateUnit {

    @Test
    public void date() {
        //Wed Aug 18 2021
        System.out.println(getDateToSearch(LocalDate.now()));
    }

    @Test
    public void date2() {
        //18 авг 2021, ср
        System.out.println(getDateToResult(LocalDate.now().plusDays(1)));
    }
}
