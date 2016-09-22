package shop;

import java.util.Date;

/**
 * Created by Slezak Attila on 2016.09.22..
 */
public class SemiLongLifeMilk extends Milk {

    public SemiLongLifeMilk(Long barcode, int cubicCapacity, String producer, Date bestBefore, double fatContent) {
        super(barcode, cubicCapacity, producer, bestBefore, fatContent);
    }
}
