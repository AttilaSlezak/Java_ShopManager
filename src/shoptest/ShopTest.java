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
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getName() throws Exception {
        Shop testShop = new Shop("Food Store", "101st Corner Street", "George Werner");
        assertEquals("Food Store", testShop.getName());
    }

    @Test
    public void getAddress() throws Exception {
        Shop testShop = new Shop("Food Store", "101st Corner Street", "George Werner");
        assertEquals("101st Corner Street", testShop.getAddress());
    }

    @Test
    public void getOwner() throws Exception {
        Shop testShop = new Shop("Food Store", "101st Corner Street", "George Werner");
        assertEquals("George Werner", testShop.getOwner());
    }

    @Test
    public void isThereAnyMilkIfNot() throws Exception {
        Shop testShop = new Shop("Food Store", "101st Corner Street", "George Werner");
        assertFalse(testShop.isThereAnyMilk());
    }

    @Test
    public void isThereAnyMilkIfYes() throws Exception {
        Shop testShop = new Shop("Food Store", "101st Corner Street", "George Werner");
        Milk testMilk = new Milk(101l, 1000, "Plain Milk inc.", new Date(), 2.8);
        testShop.fillUpMilkCounter(testMilk);
        assertTrue(testShop.isThereAnyMilk());
    }

    @Test
    public void fillUpMilkCounter() throws Exception {
        Shop testShop = new Shop("Food Store", "101st Corner Street", "George Werner");
        Milk testMilk = new Milk(101l, 1000, "Plain Milk inc.", new Date(), 2.8);
        testShop.fillUpMilkCounter(testMilk);
        assertTrue(testShop.isThereAnyMilk());
    }

    @Test
    public void buyMilk() throws Exception {
        Shop testShop = new Shop("Food Store", "101st Corner Street", "George Werner");
        Milk testMilk = new Milk(101l, 1000, "Plain Milk inc.", new Date(), 2.8);
        testShop.fillUpMilkCounter(testMilk);
        assertEquals(testMilk, testShop.buyMilk(101l));
    }

}