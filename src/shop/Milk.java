package shop;

import java.util.Date;

/**
 * Created by Slezak Attila on 2016.09.10..
 */
public class Milk {

    private int cubicCapacity;
    private String producer;
    private Date bestBefore;
    private double fatContent;
    private long price;

    public Milk(int cubicCapacity, String producer, Date bestBefore, double fatContent, long price) {
        this.cubicCapacity = cubicCapacity;
        this.producer = producer;
        this.bestBefore = bestBefore;
        this.fatContent = fatContent;
        this.price = price;
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
