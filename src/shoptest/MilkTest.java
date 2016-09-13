package shoptest;
import shop.Milk;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Created by Slezak Attila on 2016.09.13..
 */
public class MilkTest {
    @org.junit.Test
    public void getCubicCapacity() throws Exception {
        Milk testMilk = new Milk(1000, "Plain Milk inc.", new Date(), 2.8, 210);
        assertEquals(1000, testMilk.getCubicCapacity());
    }

    @org.junit.Test
    public void getProducer() throws Exception {
        Milk testMilk = new Milk(1000, "Plain Milk inc.", new Date(), 2.8, 210);
        assertEquals("Plain Milk inc.", testMilk.getProducer());
    }

    @org.junit.Test
    public void getBestBefore() throws Exception {
        Date test_date = new Date();
        Milk testMilk = new Milk(1000, "Plain Milk inc.", test_date, 2.8, 210);
        assertEquals(test_date, testMilk.getBestBefore());
    }

    @org.junit.Test
    public void getFatContent() throws Exception {
        Milk testMilk = new Milk(1000, "Plain Milk inc.", new Date(), 2.8, 210);
        assertEquals(2.8, testMilk.getFatContent(), 0.1);
    }

    @org.junit.Test
    public void getPrice() throws Exception {
        Milk testMilk = new Milk(1000, "Plain Milk inc.", new Date(), 2.8, 210);
        assertEquals(210, testMilk.getPrice());
    }

    @org.junit.Test
    public void checkStillUnderGuarantee() throws Exception {
        Calendar testCalender = Calendar.getInstance();
        testCalender.setTime(new Date());
        testCalender.add(Calendar.HOUR, 1);
        Date testDate = testCalender.getTime();
        Milk testMilk = new Milk(1000, "Plain Milk inc.", testDate, 2.8, 210);
        assertEquals(true, testMilk.checkStillUnderGuarantee());
    }

    @org.junit.Test
    public void testToString() throws Exception {
        Date testDate = new Date();
        Milk testMilk = new Milk(1000, "Plain Milk inc.", testDate, 2.8, 210);
        assertEquals("Milk{cubic capacity: 1000 ml, producer: 'Plain Milk inc.', best before: " + testDate +
                ", fat content: 2.8, price: 210 forint(s)}", testMilk.toString());
    }
}