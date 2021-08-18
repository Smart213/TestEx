package by.yaroslavTolstik.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtil {

    public final static String DATE_PATTERN_SEARCH = "eee MMM dd yyyy";
    public final static String DATE_PATTERN_RESULT = "dd MMM yyyy, eee";

    public static String getDateToSearch(LocalDate date) {
        return getDate(date, Locale.ENGLISH, DATE_PATTERN_SEARCH);
    }

    public static String getDateToResult(LocalDate date) {
        return getDate(date, Locale.forLanguageTag("ru"), DATE_PATTERN_RESULT).toLowerCase();
    }

    private static String getDate(LocalDate date, Locale locale, String pattern) {
        return DateTimeFormatter.ofPattern(pattern, locale).format(date);
    }


}
