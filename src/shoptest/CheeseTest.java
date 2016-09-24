package shoptest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import shop.Cheese;

import java.util.Date;

import static shoptest.TimeDelta.addOneHour;
import static org.junit.Assert.*;

/**
 * Created by Slezak Attila on 2016.09.24..
 */
public class CheeseTest {

    private Cheese testCheese;
    private Date testDate;

    @Before
    public void setUp() throws Exception {
        testDate = addOneHour(new Date());
        testCheese = new Cheese(120L, 700.0, "Normand Cheese inc.", testDate, 40.0);
    }

    @After
    public void tearDown() throws Exception {
        testDate = null;
        testCheese = null;
    }

    @Test
    public void getBarcode() throws Exception {
        assertEquals(120L, (long)testCheese.getBarcode());
    }

    @Test
    public void getWeight() throws Exception {
        assertEquals(700.0, testCheese.getWeight(), 0.1);
    }

    @Test
    public void getProducer() throws Exception {
        assertEquals("Normand Cheese inc.", testCheese.getProducer());
    }

    @Test
    public void getBestBefore() throws Exception {
        assertEquals(testDate, testCheese.getBestBefore());
    }

    @Test
    public void getFatContent() throws Exception {
        assertEquals(40.0, testCheese.getFatContent(), 0.1);
    }

    @Test
    public void checkStillUnderGuarantee() throws Exception {
        assertTrue(testCheese.checkStillUnderGuarantee());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Cheese{barcode: 120, weight: " + testCheese.getWeight() + " kg" +
                ", producer: 'Normand Cheese inc.', best before: " + testDate +
                ", fat content: " + testCheese.getFatContent() + "%}", testCheese.toString());
    }

}