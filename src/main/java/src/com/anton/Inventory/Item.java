package src.com.anton.Inventory;

public class Item extends Inventory {
    public Item(String name, int cost, double weight) {
        super(name,cost,weight);
    }

    public Item(String name, int cost, double weight,String type,int amount) {
        super(name,cost,weight,type,amount);
    }

}
