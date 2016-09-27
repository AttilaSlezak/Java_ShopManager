package shoptest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import shop.Milk;
import shop.MilkFactory;
import shop.Shop;
import static auxiliary.testclasses.PrivateDataAccessor.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Slezak Attila on 2016.09.19..
 */
public class ShopRegisterTest {

    private Method[] methodsShopReg = Shop.class.getDeclaredClasses()[0].getDeclaredMethods();
    private Milk testMilk;
    private Object objShopReg;

    @Before
    public void setUp() throws Exception {
        Shop testShop = new Shop("Food Store", "101st Corner Street", "George Warren");
        testMilk = MilkFactory.newLongLifeMilk(101L, Milk.LITER, "Plain Milk inc.", new Date(), Milk.WHOLE_MILK);

        Class classShopReg = Shop.class.getDeclaredClasses()[0];
        Constructor constShopReg = classShopReg.getDeclaredConstructors()[0];
        constShopReg.setAccessible(true);
        objShopReg = constShopReg.newInstance(testShop, testMilk, 3L, 100L);
        constShopReg.setAccessible(false);
    }

    @After
    public void tearDown() throws Exception {
        objShopReg = null;
        testMilk = null;
    }

    @Test
    public void getFood() throws Exception {
        Milk milk = (Milk)getObjectFromCertainMethod("getFood", methodsShopReg, objShopReg);
        assertEquals(testMilk, milk);
    }

    @Test
    public void setFood() throws Exception {
        Milk milk = MilkFactory.newLongLifeMilk(201L, Milk.HALF_LITER, "Plain Milk inc.", new Date(), Milk.LOW_FAT_MILK);
        setObjectInCertainMethod("setFood", methodsShopReg, objShopReg, milk);
        Milk resultMilk = (Milk)getObjectFromCertainMethod("getFood", methodsShopReg, objShopReg);
        assertEquals(milk, resultMilk);
    }

    @Test
    public void getQuantity() throws Exception {
        long quantity = (long)getObjectFromCertainMethod("getQuantity", methodsShopReg, objShopReg);
        assertEquals(3L, quantity);
    }

    @Test
    public void setQuantity() throws Exception {
        setObjectInCertainMethod("setQuantity", methodsShopReg, objShopReg, 10L);
        long resultQuantity = (long)getObjectFromCertainMethod("getQuantity", methodsShopReg, objShopReg);
        assertEquals(10L, resultQuantity);
    }

    @Test
    public void addQuantity() throws Exception {
        long quantity = (long)getObjectFromCertainMethod("getQuantity", methodsShopReg, objShopReg);
        long difference = 5L;
        setObjectInCertainMethod("addQuantity", methodsShopReg, objShopReg, difference);
        long resultQuantity = (long)getObjectFromCertainMethod("getQuantity", methodsShopReg, objShopReg);
        assertEquals(quantity + difference, resultQuantity);
    }

    @Test
    public void subtractQuantity() throws Exception {
        long quantity = (long)getObjectFromCertainMethod("getQuantity", methodsShopReg, objShopReg);
        long difference = 2L;
        setObjectInCertainMethod("subtractQuantity", methodsShopReg, objShopReg, difference);
        long resultQuantity = (long)getObjectFromCertainMethod("getQuantity", methodsShopReg, objShopReg);
        assertEquals(quantity - difference, resultQuantity);
    }

    @Test
    public void getPrice() throws Exception {
        long resultPrice = (long)getObjectFromCertainMethod("getPrice", methodsShopReg, objShopReg);
        assertEquals(resultPrice, 100L);
    }

    @Test
    public void setPrice() throws Exception {
        setObjectInCertainMethod("setPrice", methodsShopReg, objShopReg, 200L);
        long resultPrice = (long)getObjectFromCertainMethod("getPrice", methodsShopReg, objShopReg);
        assertEquals(resultPrice, 200L);
    }
}