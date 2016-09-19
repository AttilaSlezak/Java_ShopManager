package shoptest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import shop.Milk;
import shop.Shop;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Slezak Attila on 2016.09.19..
 */
public class ShopRegistrationTest {

    private Method[] methodsShopReg = Shop.class.getDeclaredClasses()[0].getDeclaredMethods();
    private Milk testMilk;
    private Object objShopReg;

    @Before
    public void setUp() throws Exception {
        Shop testShop = new Shop("Food Store", "101st Corner Street", "George Werner");
        testMilk = new Milk(101l, Milk.LITER, "Plain Milk inc.", new Date(), 2.8);

        Class classShopReg = Shop.class.getDeclaredClasses()[0];
        Constructor constShopReg = classShopReg.getDeclaredConstructors()[0];
        constShopReg.setAccessible(true);
        objShopReg = constShopReg.newInstance(testShop, testMilk, 3, 100);
    }

    @After
    public void tearDown() throws Exception {
        objShopReg = null;
        testMilk = null;
    }

    private Object getObjectFromCertainMethod(String methodName)
            throws InvocationTargetException, IllegalAccessException {
        Object result = null;
        for (Method oneMethod : methodsShopReg) {
            if (oneMethod.getName().equals(methodName)) {
                oneMethod.setAccessible(true);
                result = oneMethod.invoke(objShopReg);
                oneMethod.setAccessible(false);
                break;
            }
        }
        return result;
    }

    private void setObjectInCertainMethod(String methodName, Object newObj)
            throws InvocationTargetException, IllegalAccessException {
        for (Method oneMethod : methodsShopReg) {
            if (oneMethod.getName().equals(methodName)) {
                oneMethod.setAccessible(true);
                oneMethod.invoke(objShopReg, newObj);
                oneMethod.setAccessible(false);
                break;
            }
        }
    }

    @Test
    public void getMilk() throws Exception {
        Milk milk = (Milk) getObjectFromCertainMethod("getMilk");
        assertEquals(testMilk, milk);
    }

    @Test
    public void setMilk() throws Exception {
        Milk milk = new Milk(201l, Milk.HALF_LITER, "Plain Milk inc.", new Date(), 1.5);
        setObjectInCertainMethod("setMilk", milk);
        Milk resultMilk = (Milk) getObjectFromCertainMethod("getMilk");
        assertEquals(milk, resultMilk);
    }

    @Test
    public void getQuantity() throws Exception {
        int quantity = (int) getObjectFromCertainMethod("getQuantity");
        assertEquals(3, quantity);
    }

    @Test
    public void setQuantity() throws Exception {
        setObjectInCertainMethod("setQuantity", 10);
        int resultQuantity = (int) getObjectFromCertainMethod("getQuantity");
        assertEquals(10, resultQuantity);
    }

    @Test
    public void addQuantity() throws Exception {
        setObjectInCertainMethod("addQuantity", 5);
        int resultQuantity = (int) getObjectFromCertainMethod("getQuantity");
        assertEquals(8, resultQuantity);
    }

    @Test
    public void subtractQuantity() throws Exception {
        setObjectInCertainMethod("subtractQuantity", 2);
        int resultQuantity = (int) getObjectFromCertainMethod("getQuantity");
        assertEquals(1, resultQuantity);
    }

    @Test
    public void getPrice() throws Exception {
        int resultPrice = (int)getObjectFromCertainMethod("getPrice");
        assertEquals(resultPrice, 100);
    }

    @Test
    public void setPrice() throws Exception {
        setObjectInCertainMethod("setPrice", 200);
        int resultPrice = (int)getObjectFromCertainMethod("getPrice");
        assertEquals(resultPrice, 200);
    }
}