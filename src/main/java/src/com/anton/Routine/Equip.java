package src.com.anton.Routine;

import src.com.anton.Inventory.Armor;
import src.com.anton.Inventory.Inventory;
import src.com.anton.Inventory.Weapon;
import src.com.anton.Player;

import java.util.ArrayList;
import java.util.List;

public class Equip {

    public static void Equipment(Player player) {
        List<Inventory> lefthand = new ArrayList<>();
        List<Inventory> righthand = new ArrayList<>();
        List<Inventory> fullequpment = new ArrayList<>();
        Inventory tempweaponequepleft = new Inventory(player.getWeaponequepleft().getName(),player.getWeaponequepleft().getCost(),
                player.getWeaponequepleft().getWeight(),player.getWeaponequepleft().getType(),player.getWeaponequepleft().getAmount(),
                player.getWeaponequepleft().getDamage(),player.getWeaponequepleft().getCrit(),player.getWeaponequepleft().getBonusdefencearmor(),
                player.getWeaponequepleft().getDexteryboundarylimit(),player.getWeaponequepleft().getFinestrengthdextery());
        Inventory tempweaponequepright = new Inventory(player.getWeaponequepright().getName(),player.getWeaponequepright().getCost(),
                player.getWeaponequepright().getWeight(),player.getWeaponequepright().getType(),player.getWeaponequepright().getAmount(),
                player.getWeaponequepright().getDamage(),player.getWeaponequepright().getCrit(),player.getWeaponequepright().getBonusdefencearmor(),
                player.getWeaponequepright().getDexteryboundarylimit(),player.getWeaponequepright().getFinestrengthdextery());
        Inventory temparmorequep = new Inventory(player.getArmorequep().getName(),player.getArmorequep().getCost(),
                player.getArmorequep().getWeight(),player.getArmorequep().getType(),player.getArmorequep().getAmount(),
                player.getArmorequep().getDamage(),player.getArmorequep().getCrit(),player.getArmorequep().getBonusdefencearmor(),
                player.getArmorequep().getDexteryboundarylimit(),player.getArmorequep().getFinestrengthdextery());

        for (Inventory x : player.getPersonthings())
            for (int i = 0; i < player.getTypeweapon().size(); i++) {
                if (x.getType().equals(player.getTypeweapon().get(i)))
                    righthand.add(x);
            }

        for (Inventory x : player.getPersonthings())
            for (int i = 0; i < player.getTypearmor().size(); i++) {
                if (x.getType().equals(player.getTypearmor().get(i)) & !x.getType().equalsIgnoreCase("Щит"))
                    fullequpment.add(x);
            }
        for (Inventory x : player.getPersonthings()) {
            if ((player.isShield() & x.getType().equalsIgnoreCase("Щит"))||x.getType().equalsIgnoreCase("Одноручное"))
                lefthand.add(x);
        }
        while (true) {
            System.out.println("Экипировка:");
            System.out.println("1.Левая рука:" + player.getWeaponequepleft().getName());
            System.out.println("2.Правая рука:" + player.getWeaponequepright().getName());
            System.out.println("3.Туловище:" + player.getArmorequep().getName());
            System.out.println("4.Выход");
            System.out.println("Что выберем?");
            int count=DataInput.InputInteger();
            if (count == 1) {
                System.out.println("0.Освободить");
                for (int i = 0; i < lefthand.size(); i++) {
                    System.out.println((i + 1) + "." + lefthand.get(i).getName());
                }
                int choice=DataInput.InputInteger(lefthand.size());
                if (choice==0){
                    lefthand.add(player.getWeaponequepleft());
                    player.setWeaponequepleft(new Inventory("Пусто", 0, 0, "0", 0, 0, 0,0,0,0));
                } else{
                    player.setWeaponequepleft(lefthand.get(choice-1));
                    lefthand.remove(choice-1);
                }
            }else if (count == 2) {
                System.out.println("0.Освободить");
                for (int i = 0; i < righthand.size(); i++) {
                    System.out.println((i + 1) + "." + righthand.get(i).getName());
                }
                int choice=DataInput.InputInteger(righthand.size());
                if (choice==0){
                    righthand.add(player.getWeaponequepright());
                    player.setWeaponequepright(new Inventory("Пусто", 0, 0, "0", 0, 0, 0,0,0,0));
                } else{
                    player.setWeaponequepright(righthand.get(choice-1));
                    righthand.remove(choice-1);
                }
            } else if (count == 3) {
                System.out.println("0.Освободить");
                for (int i = 0; i < fullequpment.size(); i++) {
                    System.out.println((i + 1) + "." + fullequpment.get(i).getName());
                }
                int choice=DataInput.InputInteger(fullequpment.size());
                if (choice==0){
                    fullequpment.add(player.getArmorequep());
                    player.setArmorequep(new Inventory("Пусто", 0, 0, "0", 0, 0, 0,0,0,0));
                } else{
                    player.setArmorequep(fullequpment.get(choice-1));
                    fullequpment.remove(choice-1);
                }
            } else if (count ==4){
                break;
            }
        }
        if (!tempweaponequepleft.equals(player.getWeaponequepleft())){
            for (int i=0;i<player.getPersonthings().size();i++){
                if (player.getPersonthings().get(i).getName().equals(player.getWeaponequepleft().getName())){
                    if (!temparmorequep.getName().equals("Пусто")){
                        if (temparmorequep.getType().equals("Щит")){
                            player.getPersonthings().add((Armor)tempweaponequepleft);
                        }else {
                            player.getPersonthings().add((Weapon)tempweaponequepleft);
                        }
                    }
                    player.getPersonthings().remove(i);
                    break;
                }
            }
        }
        if (!tempweaponequepright.equals(player.getWeaponequepright())){
            for (int i=0;i<player.getPersonthings().size();i++){
                if (player.getPersonthings().get(i).getName().equals(player.getWeaponequepright().getName())){
                    if (!temparmorequep.getName().equals("Пусто")){
                        player.getPersonthings().add(tempweaponequepright);
                    }
                    player.getPersonthings().remove(i);
                    break;
                }
            }
        }
        if (!temparmorequep.equals(player.getArmorequep())) {
            for (int i = 0; i < player.getPersonthings().size(); i++) {
                if (player.getPersonthings().get(i).getName().equals(player.getArmorequep().getName())) {
                    if (!temparmorequep.getName().equals("Пусто")) {
                        player.getPersonthings().add(temparmorequep);
                    }
                    player.getPersonthings().remove(i);
                    break;
                }
            }
        }

    }
}
