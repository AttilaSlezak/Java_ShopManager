package shoptest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import shop.LongLifeMilk;
import shop.Milk;

import java.util.Date;

import static auxiliary.testclasses.TimeDelta.addOneHour;
import static org.junit.Assert.*;

/**
 * Created by Slezak Attila on 2016.09.24..
 */
public class LongLifeMilkTest {
    private LongLifeMilk testMilk;
    private Date testDate;

    @Before
    public void setUp() throws Exception {
        testDate = addOneHour(new Date());
        testMilk = new LongLifeMilk(101L, Milk.LITER, "Plain Milk inc.", testDate, Milk.WHOLE_MILK) {};
    }

    @After
    public void tearDown() throws Exception {
        testMilk = null;
        testDate = null;
    }

    @Test
    public void getBarcode() throws Exception {
        assertEquals(101L, (long)testMilk.getBarcode());
    }

    @Test
    public void getCubicCapacity() throws Exception {
        assertEquals(1000, testMilk.getCubicCapacity());
    }

    @Test
    public void getProducer() throws Exception {
        assertEquals("Plain Milk inc.", testMilk.getProducer());
    }

    @Test
    public void getBestBefore() throws Exception {
        assertEquals(testDate, testMilk.getBestBefore());
    }

    @Test
    public void getFatContent() throws Exception {
        assertEquals(2.8, testMilk.getFatContent(), 0.1);
    }

    @Test
    public void checkStillUnderGuarantee() throws Exception {
        assertTrue(testMilk.checkStillUnderGuarantee());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Milk{barcode: 101, cubic capacity: 1000 ml, producer: 'Plain Milk inc.', best before: " + testDate +
                ", fat content: 2.8%}", testMilk.toString());
    }
}