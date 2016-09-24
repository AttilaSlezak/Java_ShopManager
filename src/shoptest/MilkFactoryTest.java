package shoptest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import shop.LongLifeMilk;
import shop.Milk;
import shop.MilkFactory;
import shop.SemiLongLifeMilk;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Slezak Attila on 2016.09.24..
 */
public class MilkFactoryTest {

    @Test
    public void newLongLifeMilk() throws Exception {
        Milk milk = MilkFactory.newLongLifeMilk(101L, Milk.LITER, "Plain Milk inc.", new Date(), Milk.WHOLE_MILK);
        assertEquals(milk.getClass(), LongLifeMilk.class);
    }

    @Test
    public void newSemiLongLifeMilk() throws Exception {
        Milk milk = MilkFactory.newSemiLongLifeMilk(101L, Milk.LITER, "Plain Milk inc.", new Date(), Milk.WHOLE_MILK);
        assertEquals(milk.getClass(), SemiLongLifeMilk.class);
    }

}