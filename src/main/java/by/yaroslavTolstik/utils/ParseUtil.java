package by.yaroslavTolstik.utils;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseUtil {

    public static Long getLong(String line) {
        String res = "0";
        final String PATTERN = "[0-9]+";
        Matcher matcher = Pattern.compile(PATTERN).matcher(line);
        while (matcher.find()) {
            res = line.substring(matcher.start(), matcher.end());
        }
        return Long.parseLong(res);
    }
}
