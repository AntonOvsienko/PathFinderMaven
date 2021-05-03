package src.com.anton.Inventory;

import java.util.HashMap;

public class Armor extends Inventory {

    public Armor(String name, int cost, double weight, String type,int amount, int damage, int crit,
                 int bonusdefencearmor, int dexteryboundarylimit, int finestrengthdextery) {
        super(name, cost, weight, type,amount,damage, crit,bonusdefencearmor,dexteryboundarylimit,finestrengthdextery);
    }

    public static HashMap<String, Armor> armor = new HashMap<>() {
        {
            put("1", new Armor("Стёганный доспех", 500, 10, "Лёгкий", 1,
                    0, 0, 1,8,0));
            put("2", new Armor("Кожанный доспех", 1000, 15, "Лёгкий", 1,
                    2, 6, 2,4,6));
            put("3", new Armor("Кл. кожанный доспех", 2500, 20, "Лёгкий", 1,
                    0, 0, 3,5,-1));
            put("4", new Armor("Кольчужная рубаха", 10000, 25, "Лёгкий", 1,
                    0, 0, 4,4,-2));
            put("5", new Armor("Сыромятный доспех", 15000, 25, "Средний", 1,
                    0, 0, 4,4,-3));
            put("6", new Armor("Баклер", 500, 5, "Щит", 1,
                    0, 0, 1,0,-1));
        }
    };

    @Override
    public String toString() {
        return "Доспехи(" + getName() +
                ", вес-" + getWeight() +
                ", стоимость-" + getCost() +
                ", бонус к защите-" + getBonusdefencearmor() +
                ", кол-во-" + getAmount() +
                ")";
    }
}