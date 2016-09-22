package shop;

import java.util.Date;

/**
 * Created by Slezak Attila on 2016.09.23..
 */
public abstract class Food {

    private Long barcode;
    private String producer;
    private Date bestBefore;

    public Food(Long barcode, String producer, Date bestBefore) {
        this.barcode = barcode;
        this.producer = producer;
        this.bestBefore = bestBefore;
    }

    public Long getBarcode() {
        return barcode;
    }

    public String getProducer() {
        return producer;
    }

    public Date getBestBefore() {
        return bestBefore;
    }

    public boolean checkStillUnderGuarantee() {
        return bestBefore.after(new Date());
    }

    @Override
    public String toString() {
        return "Food{" +
                "barcode: " + barcode +
                ", producer: '" + producer + "'" +
                ", best before: " + bestBefore + '}';
    }
}
