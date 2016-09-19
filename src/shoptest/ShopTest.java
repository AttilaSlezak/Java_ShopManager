package shoptest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import shop.Milk;
import shop.Shop;

import java.util.Date;


import static org.junit.Assert.*;

/**
 * Created by Slezak Attila on 2016.09.18..
 */
public class ShopTest {

    private Shop testShop;
    private Milk testMilk;

    @Before
    public void setUp() throws Exception {
        testShop = new Shop("Food Store", "101st Corner Street", "George Werner");
        testMilk = new Milk(101l, Milk.LITER, "Plain Milk inc.", new Date(), 2.8);
    }

    @After
    public void tearDown() throws Exception {
        testShop = null;
        testMilk = null;
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Food Store", testShop.getName());
    }

    @Test
    public void getAddress() throws Exception {
        assertEquals("101st Corner Street", testShop.getAddress());
    }

    @Test
    public void getOwner() throws Exception {
        assertEquals("George Werner", testShop.getOwner());
    }

    @Test
    public void isThereAnyMilkIfNot() throws Exception {
        assertFalse(testShop.isThereAnyMilk());
    }

    @Test
    public void isThereAnyMilkIfYes() throws Exception {
        testShop.fillUpMilkCounter(testMilk);
        assertTrue(testShop.isThereAnyMilk());
    }

    @Test
    public void fillUpMilkCounter() throws Exception {
        testShop.fillUpMilkCounter(testMilk);
        assertTrue(testShop.isThereAnyMilk());
    }

    @Test
    public void buyMilk() throws Exception {
        testShop.fillUpMilkCounter(testMilk);
        assertEquals(testMilk, testShop.buyMilk(101l));
    }
}