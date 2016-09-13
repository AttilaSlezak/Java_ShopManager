package shop;

import java.util.Date;

/**
 * Created by Slezak Attila on 2016.09.10..
 */
public class Milk {

    private long barCode;
    public static final int LITER = 1000;
    public static final int HALF_LITER = 500;
    public static final int GLASS = 200;
    public static final double WHOLE_MILK = 2.8;
    public static final double LOW_FAT_MILK = 1.5;

    private int cubicCapacity;
    private String producer;
    private Date bestBefore;
    private double fatContent;
    private long price;

    public Milk(long barCode, int cubicCapacity, String producer, Date bestBefore, double fatContent, long price) {
        this.barCode = barCode;
        this.cubicCapacity = cubicCapacity;
        this.producer = producer;
        this.bestBefore = bestBefore;
        this.fatContent = fatContent;
        this.price = price;
    }

    public long getBarCode() {
        return barCode;
    }

    public int getCubicCapacity() {
        return cubicCapacity;
    }

    public String getProducer() {
        return producer;
    }

    public Date getBestBefore() {
        return bestBefore;
    }

    public double getFatContent() {
        return fatContent;
    }

    public long getPrice() {
        return price;
    }

    public boolean checkStillUnderGuarantee() {
        return bestBefore.after(new Date());
    }

    @Override
    public String toString() {
        return "Milk{" +
                "cubic capacity: " + cubicCapacity + " ml" +
                ", producer: '" + producer + "'" +
                ", best before: " + bestBefore +
                ", fat content: " + fatContent +
                ", price: " + price + " forint(s)" +
                '}';
    }
}
