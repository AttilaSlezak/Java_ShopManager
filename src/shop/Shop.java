package shop;

/**
 * Created by Slezak Attila on 2016.09.10..
 */
public class Shop {

    private String name;
    private String address;
    private String owner;
    private Milk[] milkCounter;
    private int flag;

    public Shop(String name, String address, String owner, Milk[] milkCounter) {
        this.name = name;
        this.address = address;
        this.owner = owner;
        this.milkCounter = milkCounter;
        flag = milkCounter.length - 1;
    }

    public Shop(String name, String address, String owner) {
        this.name = name;
        this.address = address;
        this.owner = owner;
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
        return flag >= 0;
    }

    public Milk buyMilk(Milk m) {
        return milkCounter[flag--];
    }

    public void fillUpMilkCounter(Milk m) {
        milkCounter[flag++] = m;
    }
}
