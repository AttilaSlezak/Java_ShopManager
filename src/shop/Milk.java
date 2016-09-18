package shop;

import java.util.Date;

/**
 * Created by Slezak Attila on 2016.09.10..
 */
public class Milk {

    public static final int LITER = 1000;
    public static final int HALF_LITER = 500;
    public static final int GLASS = 200;
    public static final double WHOLE_MILK = 2.8;
    public static final double LOW_FAT_MILK = 1.5;

    private Long barCode;
    private int cubicCapacity;
    private String producer;
    private Date bestBefore;
    private double fatContent;

    public Milk(Long barCode, int cubicCapacity, String producer, Date bestBefore, double fatContent) {
        this.barCode = barCode;
        this.cubicCapacity = cubicCapacity;
        this.producer = producer;
        this.bestBefore = bestBefore;
        this.fatContent = fatContent;
    }

    public Long getBarCode() {
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

    public boolean checkStillUnderGuarantee() {
        return bestBefore.after(new Date());
    }

    @Override
    public String toString() {
        return "Milk{" +
                "cubic capacity: " + cubicCapacity + " ml" +
                ", producer: '" + producer + "'" +
                ", best before: " + bestBefore +
                ", fat content: " + fatContent + '}';
    }
}
