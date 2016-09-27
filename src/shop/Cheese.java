package shop;

import java.util.Date;

/**
 * Created by Slezak Attila on 2016.09.23..
 */
public class Cheese extends Food {

    private double weight;
    private double fatContent;

    public Cheese(Long barcode, double weight, String producer, Date bestBefore, double fatContent) {
        super(barcode, producer, bestBefore);
        this.weight = weight;
        this.fatContent = fatContent;
    }

    public double getWeight() {
        return weight;
    }

    public double getFatContent() {
        return fatContent;
    }

    @Override
    public String toString() {
        return "Cheese{" +
                "barcode: " + super.getBarcode() +
                ", weight: " + weight + " g" +
                ", producer: '" + super.getProducer() + "'" +
                ", best before: " + super.getBestBefore() +
                ", fat content: " + fatContent + "%}";
    }
}
