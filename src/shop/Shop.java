package shop;

import java.util.Hashtable;

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

    public void replenishMilkCounter(Milk milk) {
        ShopRegister shopReg = (ShopRegister) milkCounter.get(milk.getBarcode());
        if (shopReg == null) {
            shopReg = new ShopRegister(milk, 1, 100);
            milkCounter.put(milk.getBarcode(), shopReg);
        }
        else {
            shopReg.addQuantity(1);
        }
    }

    public Milk buyMilk(Long barcode) {
        ShopRegister shopReg = (ShopRegister) milkCounter.get(barcode);
        if (shopReg != null) {
            shopReg.subtractQuantity(1);
            return shopReg.getMilk();
        }
        return null;
    }

    class ShopRegister {
        private Food food;
        private long quantity;
        private long price;

        public ShopRegister(Food food, long quantity, long price) {
            this.food = food;
            this.quantity = quantity;
            this.price = price;
        }

        public Food getFood() {
            return food;
        }

        public void setFood(Food food) {
            this.food = food;
        }

        public long getQuantity() {
            return quantity;
        }

        public void setQuantity(long quantity) {
            this.quantity = quantity;
        }

        public void addQuantity(long quantity) {
            this.quantity += quantity;
        }

        public void subtractQuantity(long quantity) {
            this.quantity -= quantity;
        }

        public long getPrice() {
            return price;
        }

        public void setPrice(long price) {
            this.price = price;
        }
    }
}
