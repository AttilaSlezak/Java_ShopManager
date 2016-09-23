package shoptest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import shop.Food;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Slezak Attila on 2016.09.24..
 */
public class FoodTest {

    private Food testFood;
    private Date testDate;

    @Before
    public void setUp() throws Exception {
        Calendar testCalender = Calendar.getInstance();
        testCalender.setTime(new Date());
        testCalender.add(Calendar.HOUR, 1);

        testDate = testCalender.getTime();
        testFood = new Food(100L, "Food Producer inc.", testDate) {};
    }

    @After
    public void tearDown() throws Exception {
        testFood = null;
        testDate = null;
    }

    @Test
    public void getBarcode() throws Exception {
        assertEquals(100L, (long)testFood.getBarcode());
    }

    @Test
    public void getProducer() throws Exception {
        assertEquals("Food Producer inc.", testFood.getProducer());
    }

    @Test
    public void getBestBefore() throws Exception {
        assertEquals(testDate, testFood.getBestBefore());
    }

    @Test
    public void checkStillUnderGuarantee() throws Exception {
        assertTrue(testFood.checkStillUnderGuarantee());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Food{barcode: 100, producer: 'Food Producer inc.', best before: " + testDate +
                "}", testFood.toString());
    }

}