package src.com.anton.Inventory;

import java.util.HashMap;

public class Weapon extends Inventory {


    public Weapon(String name, int cost, double weight, String type,int amount, int damage, int crit,
                  int bonusdefencearmor, int dexteryboundarylimit, int finestrengthdextery) {
        super(name, cost, weight, type,amount,damage, crit,bonusdefencearmor,dexteryboundarylimit,finestrengthdextery);
    }

    public static HashMap<String, Weapon> weapon = new HashMap<>() {
        {
            put("1", new Weapon("Кинжал", 2000, 1, "Одноручное", 1,
                    4, 19,0,0,0));
            put("2", new Weapon("Серп", 6000, 2, "Одноручное", 1,
                    6, 20,0,0,0));
            put("3", new Weapon("Рапира", 20000, 2, "Полуторное", 1,
                    6, 18,0,0,0));
        }
    };

    @Override
    public String toString() {
        return "Оружие(" + getName() +
                ", вес-" + getWeight() +
                ", стоимость-" + getCost() +
                ", урон-" + getDamage() +
                ", критический-" + getCrit() +
                ", кол-во-" + getAmount() +
                ")";
    }
}


