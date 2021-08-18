package by.yaroslavTolstik.resliv.unit;

import org.junit.Assert;
import org.junit.Test;

import static by.yaroslavTolstik.utils.ParseUtil.getLong;

public class ParseUnit {

    @Test
    public void date() {
        String val = "12345 dfghjk";
        long l = getLong(val);
        Assert.assertEquals(12345, l);
    }
}
