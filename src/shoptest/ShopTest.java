package shoptest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import shop.Cheese;
import shop.Milk;
import shop.MilkFactory;
import shop.Shop;
import static shoptest.PrivateDataAccessor.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import static org.junit.Assert.*;

/**
 * Created by Slezak Attila on 2016.09.18..
 */
public class ShopTest {

    private Method[] methodsShopReg = Shop.class.getDeclaredClasses()[0].getDeclaredMethods();
    private Hashtable testShopFoodCounter;
    private Shop testShop;
    private Milk testMilk;
    private Cheese testCheese;

    @Before
    public void setUp() throws Exception {
        testShop = new Shop("Food Store", "101st Corner Street", "George Warren");
        testMilk = MilkFactory.newLongLifeMilk(101L, Milk.LITER, "Plain Milk inc.", new Date(), Milk.WHOLE_MILK);
        testCheese = new Cheese(120L, 700, "Normand Cheese inc.", new Date(), 40);
        Field fieldFoodCounter = Shop.class.getDeclaredField("foodCounter");
        fieldFoodCounter.setAccessible(true);
        testShopFoodCounter = (Hashtable)fieldFoodCounter.get(testShop);
        // fieldFoodCounter.setAccessible(false);
    }

    @After
    public void tearDown() throws Exception {
        testShop = null;
        testMilk = null;
        testCheese = null;
        testShopFoodCounter = null;
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
        assertEquals("George Warren", testShop.getOwner());
    }

    @Test
    public void isThereAnyMilkIfNot() throws Exception {
        assertFalse(testShop.isThereAnyMilk());
    }

    @Test
    public void isThereAnyMilkIfYes() throws Exception {
        testShop.addNewFoodToFoodCounter(testMilk, 3L, 100L);
        assertTrue(testShop.isThereAnyMilk());
    }

    @Test
    public void isThereAnyCheeseIfNot() throws Exception {
        assertFalse(testShop.isThereAnyCheese());
    }

    @Test
    public void isThereAnyCheeseIfYes() throws Exception {
        testShop.addNewFoodToFoodCounter(testCheese, 5L, 200L);
        assertTrue(testShop.isThereAnyCheese());
    }

    @Test
    public void isThereAnyCertainFoodIfNot() throws Exception {
        testShop.addNewFoodToFoodCounter(testMilk, 3L, 100L);
        boolean result = (boolean)getObjectFromCertainMethod("isThereAnyCertainFood", Shop.class.getDeclaredMethods(),
                testShop, Cheese.class);
        assertFalse(result);
    }

    @Test
    public void isThereAnyCertainFoodIfYes() throws Exception {
        testShop.addNewFoodToFoodCounter(testCheese, 5L, 200L);
        boolean result = (boolean)getObjectFromCertainMethod("isThereAnyCertainFood", Shop.class.getDeclaredMethods(),
                testShop, Cheese.class);
        assertTrue(result);
    }

    @Test
    public void addNewFoodToFoodCounter() throws Exception {
        testShop.addNewFoodToFoodCounter(testMilk, 3L, 100L);
        assertEquals(3L, getObjectFromCertainMethod("getQuantity", methodsShopReg, testShopFoodCounter.get(101L)));
    }

    @Test
    public void replenishFoodCounter() throws Exception {
        testShop.addNewFoodToFoodCounter(testMilk, 3L, 100L);
        testShop.replenishFoodCounter(testMilk.getBarcode(), 2L);
        assertEquals(5L, getObjectFromCertainMethod("getQuantity", methodsShopReg, testShopFoodCounter.get(101L)));
    }

    @Test
    public void removeFoodFromFoodCounter() throws  Exception {
        testShop.addNewFoodToFoodCounter(testMilk, 3L, 100L);
        testShop.removeFoodFromFoodCounter(101L);
        assertFalse(testShopFoodCounter.containsKey(101L));
    }

    @Test
    public void buyMilk() throws Exception {
        testShop.addNewFoodToFoodCounter(testMilk, 3L, 100L);
        testShop.buyFood(101L, 2L);
        assertEquals(1L, getObjectFromCertainMethod("getQuantity", methodsShopReg, testShopFoodCounter.get(101L)));
    }
}