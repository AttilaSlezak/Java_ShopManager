package shop;

import java.util.Date;

/**
 * Created by Slezak Attila on 2016.09.22..
 */
public abstract class MilkFactory {

    public static Milk newLongLifeMilk(Long barcode, int cubicCapacity, String producer, Date bestBefore,
                                       double fatContent) {
        return new LongLifeMilk(barcode, cubicCapacity, producer, bestBefore, fatContent);
    }

    public static Milk newSemiLongLifeMilk(Long barcode, int cubicCapacity, String producer, Date bestBefore,
                                       double fatContent) {
        return new SemiLongLifeMilk(barcode, cubicCapacity, producer, bestBefore, fatContent);
    }
}
