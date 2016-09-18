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

    public void fillUpMilkCounter(Milk milk) {
        ShopRegistration shopReg = (ShopRegistration) milkCounter.get(milk.getBarCode());
        if (shopReg == null) {
            shopReg = new ShopRegistration(milk, 1, 100);
            milkCounter.put(milk.getBarCode(), shopReg);
        }
        else {
            shopReg.addQuantity(1);
        }
    }

    public Milk buyMilk(Long barCode) {
        ShopRegistration shopReg = (ShopRegistration) milkCounter.get(barCode);
        if (shopReg != null) {
            shopReg.subtractQuantity(1);
            return shopReg.getMilk();
        }
        return null;
    }

    class ShopRegistration {
        private Milk milk;
        private int quantity;
        private int price;

        public ShopRegistration(Milk milk, int quantity, int price) {
            this.milk = milk;
            this.quantity = quantity;
            this.price = price;
        }

        public Milk getMilk() {
            return milk;
        }

        public void setMilk(Milk milk) {
            this.milk = milk;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void addQuantity(int quantity) {
            this.quantity += quantity;
        }

        public void subtractQuantity(int quantity) {
            this.quantity -= quantity;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
