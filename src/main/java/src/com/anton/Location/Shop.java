package src.com.anton.Location;

import src.com.anton.Inventory.*;
import src.com.anton.Player;
import src.com.anton.Routine.DataInput;
import src.com.anton.Routine.Equip;
import src.com.anton.Visual;

import java.util.HashMap;

import static src.com.anton.Inventory.Armor.armor;
import static src.com.anton.Inventory.Weapon.weapon;

public class Shop extends Inventory {
    public static void WeaponShop(Player player, HashMap<String, Weapon> weapon) {
        Visual.ShopWeaponVisual(weapon);
        while (true) {
            String x = DataInput.InputString().toLowerCase();
            int count = 0;
            for (HashMap.Entry<String, Weapon> entry : weapon.entrySet()) {
                if (x.equals(entry.getKey())) {
                        player.getPersonthings().add(new Weapon(weapon.get(x).getName(),
                                weapon.get(x).getCost(), weapon.get(x).getWeight(), weapon.get(x).getType(),
                                weapon.get(x).getAmount(),weapon.get(x).getDamage(), weapon.get(x).getCrit(),
                                weapon.get(x).getBonusdefencearmor(), weapon.get(x).getDexteryboundarylimit(),
                                weapon.get(x).getFinestrengthdextery()));
                    player.setMoney(player.getMoney() - weapon.get(x).getCost());
                } else {
                    count++;
                }
            }
            if (count != weapon.size()) {
                break;
            } else {
                System.out.println("Введено неверное значение");
            }
        }
    }

    public static void ArmorShop(Player player, HashMap<String, Armor> armor) {
        Visual.ShopArmorVisual(armor);
        while (true) {
            String x = DataInput.InputString().toLowerCase();
            int count = 0;
            for (HashMap.Entry<String, Armor> entry : armor.entrySet()) {
                if (x.equalsIgnoreCase(entry.getKey())) {
                        player.getPersonthings().add(new Armor(armor.get(x).getName(),
                                armor.get(x).getCost(), armor.get(x).getWeight(), armor.get(x).getType(),
                                armor.get(x).getAmount(),armor.get(x).getDamage(), armor.get(x).getCrit(),
                                armor.get(x).getBonusdefencearmor(), armor.get(x).getDexteryboundarylimit(),
                                armor.get(x).getFinestrengthdextery()));
                    player.setMoney(player.getMoney() - armor.get(x).getCost());
                } else {
                    count++;
                }
            }
            if (count != armor.size()) {
                break;
            } else {
                System.out.println("Введено неверное значение");
            }
        }
    }

    public static void Sale(Player player){
        int pointer=0;

        Visual.MyInventar(player);
        while(true){
            System.out.println("Выберите действие:");
            System.out.println("1.Продать предмет");
            System.out.println("2.Выход");
            pointer= DataInput.InputInteger();
            if (pointer==1){
                for (int i=0;i<player.getPersonthings().size();i++){
                    System.out.println((i+1)+"."+player.getPersonthings().get(i).getName()+"/"+player.getPersonthings().get(i).getCost());
                }
                System.out.println("Какой предмет продать");
                pointer=DataInput.InputInteger(player.getPersonthings().size());
                player.setMoney(player.getMoney()+player.getPersonthings().get(pointer-1).getCost());
                player.getPersonthings().remove(pointer-1);

            }else if (pointer==2){
                break;
            }
        }
    }

    public static void ShopChoice (Player player){
        int pointer=0;

        while(true){
            System.out.println("Выберите действие:");
            System.out.println("1.Купить оружие");
            System.out.println("2.Купить броню");
            System.out.println("3.Посмотреть инвентарь(снять/одеть экипировку)");
            System.out.println("4.Продать предмет из инвентаря");
            System.out.println("5.Выход");
            pointer= DataInput.InputInteger();
            if (pointer==1){
                Shop.WeaponShop(player,weapon);
            }else if (pointer==2){
                Shop.ArmorShop(player,armor);
            }else if (pointer==3){
                Visual.MyInventar(player);
                Equip.Equipment(player);
            }else if (pointer==4){
                Sale(player);
            }else if (pointer==5){
                break;
            }
        }
    }
}
