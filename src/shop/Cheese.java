package shop;

import java.util.Date;

/**
 * Created by Slezak Attila on 2016.09.23..
 */
public class Cheese {

    private Long barcode;
    private double weight;
    private String producer;
    private Date bestBefore;
    private double fatContent;

    public Cheese(Long barcode, double weight, String producer, Date bestBefore, double fatContent) {
        this.barcode = barcode;
        this.weight = weight;
        this.producer = producer;
        this.bestBefore = bestBefore;
        this.fatContent = fatContent;
    }

    public Long getBarcode() {
        return barcode;
    }

    public double getWeight() {
        return weight;
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
        return "Cheese{" +
                "barcode: " + barcode +
                ", weight: " + weight + " ml" +
                ", producer: '" + producer + "'" +
                ", best before: " + bestBefore +
                ", fat content: " + fatContent + '}';
    }
}
