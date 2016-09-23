package shoptest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import shop.Milk;
import shop.MilkFactory;
import shop.Shop;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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

    @Before
    public void setUp() throws Exception {
        testShop = new Shop("Food Store", "101st Corner Street", "George Warren");
        testMilk = MilkFactory.newLongLifeMilk(101l, Milk.LITER, "Plain Milk inc.", new Date(), Milk.WHOLE_MILK);
        Field fieldFoodCounter = Shop.class.getDeclaredField("foodCounter");
        fieldFoodCounter.setAccessible(true);
        testShopFoodCounter = (Hashtable)fieldFoodCounter.get(testShop);
    }

    @After
    public void tearDown() throws Exception {
        testShop = null;
        testMilk = null;
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
        testShop.addNewFoodToFoodCounter(testMilk, 2, 100);
        System.out.println(testShopFoodCounter.get(101l));
        System.out.println(PrivateDataAccessor.getObjectFromCertainMethod("getQuantity", methodsShopReg, testShopFoodCounter.get(101l)));
        assertTrue(testShop.isThereAnyMilk());
    }

    @Test
    public void replenishMilkCounter() throws Exception {
        testShop.addNewFoodToFoodCounter(testMilk, 2, 100);
        testShop.replenishFoodCounter(testMilk.getBarcode(), 2);
        //assertEquals(, );
    }

    @Test
    public void buyMilk() throws Exception {
        testShop.replenishFoodCounter(testMilk.getBarcode(), 2);

        //assertEquals(testMilk, testShop.buyFood(101l, 2));
    }
}