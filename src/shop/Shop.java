package shop;

import java.util.Vector;

/**
 * Created by Slezak Attila on 2016.09.10..
 */
public class Shop {

    private String name;
    private String address;
    private String owner;
    private Vector milkCounter;

    public Shop(String name, String address, String owner, Vector milkCounter) {
        this.name = name;
        this.address = address;
        this.owner = owner;
        this.milkCounter = milkCounter;
    }

    public Shop(String name, String address, String owner) {
        this(name, address, owner, new Vector());
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
        milkCounter.add(m);
    }

    public Milk buyMilk(Milk m) {
        return (Milk)milkCounter.remove(milkCounter.indexOf(m));
    }
}
