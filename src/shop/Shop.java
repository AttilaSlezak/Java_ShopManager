package shop;

import java.util.Hashtable;
import java.util.Vector;

/**
 * Created by Slezak Attila on 2016.09.10..
 */
public class Shop {

    private String name;
    private String address;
    private String owner;
    private Hashtable milkCounter;

    public Shop(String name, String address, String owner, Hashtable milkCounter) {
        this.name = name;
        this.address = address;
        this.owner = owner;
        this.milkCounter = milkCounter;
    }

    public Shop(String name, String address, String owner) {
        this(name, address, owner, new Hashtable());
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getOwner() {
        return owner;
    }

    public boolean isThereAnyMilk() {
        return !milkCounter.isEmpty();
    }

    public void fillUpMilkCounter(Milk m) {
        milkCounter.put(new Long(m.getBarCode()), m);
    }

    public Milk buyMilk(long barCode) {
        return (Milk)milkCounter.remove(milkCounter.get(new Long(barCode)));
    }
}
