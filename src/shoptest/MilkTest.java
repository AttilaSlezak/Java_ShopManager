package shoptest;
import org.junit.After;
import org.junit.Before;
import shop.Milk;
import shop.MilkFactory;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Slezak Attila on 2016.09.13..
 */
public class MilkTest {

    private Milk testMilk;
    private Date testDate;

    @Before
    public void setUp() throws Exception {
        Calendar testCalender = Calendar.getInstance();
        testCalender.setTime(new Date());
        testCalender.add(Calendar.HOUR, 1);

        testDate = testCalender.getTime();
        testMilk = MilkFactory.newLongLifeMilk(101L, Milk.LITER, "Plain Milk inc.", testDate, Milk.WHOLE_MILK);
    }

    @After
    public void tearDown() throws Exception {
        testMilk = null;
        testDate = null;
    }

    @org.junit.Test
    public void getBarcode() throws Exception {
        assertEquals(101L, (long)testMilk.getBarcode());
    }

    @org.junit.Test
    public void getCubicCapacity() throws Exception {
        assertEquals(1000, testMilk.getCubicCapacity());
    }

    @org.junit.Test
    public void getProducer() throws Exception {
        assertEquals("Plain Milk inc.", testMilk.getProducer());
    }

    @org.junit.Test
    public void getBestBefore() throws Exception {
        assertEquals(testDate, testMilk.getBestBefore());
    }

    @org.junit.Test
    public void getFatContent() throws Exception {
        assertEquals(2.8, testMilk.getFatContent(), 0.1);
    }

    @org.junit.Test
    public void checkStillUnderGuarantee() throws Exception {
        assertEquals(true, testMilk.checkStillUnderGuarantee());
    }

    @org.junit.Test
    public void testToString() throws Exception {
        assertEquals("Milk{barcode: 101, cubic capacity: 1000 ml, producer: 'Plain Milk inc.', best before: " + testDate +
                ", fat content: 2.8%}", testMilk.toString());
    }
}