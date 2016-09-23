package shop;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by Slezak Attila on 2016.09.10..
 */
public class Shop {

    private String name;
    private String address;
    private String owner;
    private Hashtable foodCounter;

    public Shop(String name, String address, String owner, Hashtable foodCounter) {
        this.name = name;
        this.address = address;
        this.owner = owner;
        this.foodCounter = foodCounter;
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

    private boolean isThereAnyCertainFood(Class foodSubClass) {
        for (Enumeration oneFoodType = foodCounter.elements(); oneFoodType.hasMoreElements();) {
            ShopRegister shopReg = (ShopRegister)oneFoodType.nextElement();
            if (foodSubClass.isInstance(shopReg.getFood()) && shopReg.getQuantity() > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isThereAnyMilk() {
        return isThereAnyCertainFood(Milk.class);
    }

    public boolean isThereAnyCheese() {
        return isThereAnyCertainFood(Cheese.class);
    }

    public void replenishFoodCounter(Long barcode, long quantity) {
        ShopRegister shopReg = (ShopRegister) foodCounter.get(barcode);
        shopReg.addQuantity(quantity);
    }

    public void addNewFoodToFoodCounter(Food food, long quantity, long price) {
        ShopRegister shopReg = new ShopRegister(food, quantity, price);
        foodCounter.put(food.getBarcode(), shopReg);
    }

    public void removeFoodFromFoodCounter(Long barcode) {
        foodCounter.remove(barcode);
    }

    public void buyFood(Long barcode, long quantity) {
        ShopRegister shopReg = (ShopRegister) foodCounter.get(barcode);
        if (shopReg != null) {
            shopReg.subtractQuantity(quantity);
        }
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
