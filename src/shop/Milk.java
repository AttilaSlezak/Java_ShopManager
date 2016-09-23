package shop;

import java.util.Date;

/**
 * Created by Slezak Attila on 2016.09.10..
 */
public abstract class Milk extends Food {

    public static final int LITER = 1000;
    public static final int HALF_LITER = 500;
    public static final int GLASS = 200;
    public static final double WHOLE_MILK = 2.8;
    public static final double LOW_FAT_MILK = 1.5;

    private int cubicCapacity;
    private double fatContent;

    public Milk(Long barcode, int cubicCapacity, String producer, Date bestBefore, double fatContent) {
        super(barcode, producer, bestBefore);
        this.cubicCapacity = cubicCapacity;
        this.fatContent = fatContent;
    }

    public int getCubicCapacity() {
        return cubicCapacity;
    }

    public double getFatContent() {
        return fatContent;
    }

    @Override
    public String toString() {
        return "Milk{" +
                "barcode: " + super.getBarcode() +
                ", cubic capacity: " + cubicCapacity + " ml" +
                ", producer: '" + super.getProducer() + "'" +
                ", best before: " + super.getBestBefore() +
                ", fat content: " + fatContent + "%}";
    }
}
