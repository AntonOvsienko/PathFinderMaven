package src.com.anton.Inventory;

import src.com.anton.Player;
import src.com.anton.Routine.DataInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Weapon extends Inventory {

    public Weapon(String name, int cost, double weight, String type,int amount, int damage, int crit,
                  int initiativeBonus) {
        super(name, cost, weight, type,amount,damage, crit,initiativeBonus);
    }

    public static HashMap<String, Weapon> weapon = new HashMap<>() {
        {
            put("1", new Weapon("Кинжал", 2000, 1, "Одноручное", 1,
                    4, 19,0));
            put("2", new Weapon("Серп", 6000, 2, "Одноручное", 1,
                    6, 20,0));
            put("3", new Weapon("Лёгкая булава", 12000, 4, "Одноручное", 1,
                    6, 20,0));
            put("4", new Weapon("Рапира", 20000, 2, "Полуторное", 1,
                    6, 18,0));
            put("5", new Weapon("Тяжёлая булава", 12000, 8, "Полуторное", 1,
                    8, 20,0));
            put("6", new Weapon("Моргенштерн", 8000, 6, "Полуторное", 1,
                    8, 20,0));
            put("7", new Weapon("Длинное копье", 8000, 6, "Двуручное", 1,
                    8, 20,0));
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


