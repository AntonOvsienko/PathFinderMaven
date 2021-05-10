package src.com.anton;

import src.com.anton.Inventory.Armor;
import src.com.anton.Inventory.Inventory;
import src.com.anton.Inventory.Weapon;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Visual {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public static void visual() {
        System.out.println("-------------------------------------------");
    }

    public static void BattleVisual(List<Player> player) {

        Collections.sort(player, IDComparator);
        for (int i = 0; i < player.size(); i++) {
            if (player.get(i).isIDplayer()) {
                System.out.print(GREEN);
                System.out.print("\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557");
                System.out.print(RESET);
            } else {
                System.out.print(RED);
                System.out.print("    \u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                        "\u2550\u2550\u2557");
                System.out.print(RESET);
            }
        }
        System.out.println("");
        for (int i = 0; i < player.size(); i++) {
            if (player.get(i).isIDplayer()) {
                System.out.print(GREEN);
                System.out.printf("\u2551 %-14s \u2551", player.get(i).getName());
                System.out.print(RESET);
            } else {
                System.out.print(RED);
                System.out.printf("    \u2551 %-20s\u2551", player.get(i).getName());
                System.out.print(RESET);
            }
        }
        System.out.println("");
        for (int i = 0; i < player.size(); i++) {
            if (player.get(i).isIDplayer()) {
                System.out.print(GREEN);
                System.out.print("\u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                        "\u2550\u2550\u2550\u2550\u2550\u2563");
                System.out.print(RESET);
            } else {
                System.out.print(RED);
                System.out.print("    \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563");
                System.out.print(RESET);
            }
        }
        System.out.println("");
        for (int i = 0; i < player.size(); i++) {
            if (player.get(i).isIDplayer()) {
                System.out.print(GREEN);
                System.out.printf("\u2551 Health:%2d/%-4d \u2551", player.get(i).getHealth(), player.get(i).getHealthmax());
                System.out.print(RESET);
            } else {
                System.out.print(RED);
                System.out.printf("    \u2551 Health:%2d/%-10d\u2551", player.get(i).getHealth(), player.get(i).getHealthmax());
                System.out.print(RESET);
            }
        }
        System.out.println("");
        for (int i = 0; i < player.size(); i++) {
            if (player.get(i).isIDplayer()) {
                System.out.print(GREEN);
                System.out.printf("\u2551 Атака макс:%-3d \u2551", player.get(i).getAttackmodificator
                        (player.get(i).getLvl()) + 20);
                System.out.print(RESET);
            } else {
                System.out.print(RED);
                System.out.printf("    \u2551 Атака макс:%-9d\u2551", player.get(i).getAttackmodificator
                        (player.get(i).getBasicmodificatorattack()) + 20);
                System.out.print(RESET);
            }
        }
        System.out.println("");
        for (int i = 0; i < player.size(); i++) {
            if (player.get(i).isIDplayer()) {
                System.out.print(GREEN);
                System.out.printf("\u2551 Защита:%-3d     \u2551", player.get(i).getDefense());
                System.out.print(RESET);
            } else {
                System.out.print(RED);
                System.out.printf("    \u2551 Защита:%-8d     \u2551", player.get(i).getDefense());
                System.out.print(RESET);
            }
        }
        System.out.println("");
        for (int i = 0; i < player.size(); i++) {
            if (player.get(i).isIDplayer()) {
                System.out.print(GREEN);
                System.out.print("\u255A\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255D");
                System.out.print(RESET);
            } else {
                System.out.print(RED);
                System.out.print("    \u255A\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                        "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                        "\u2550\u2550\u255D");
                System.out.print(RESET);
            }
        }
        System.out.println();
    }

    public static void ShopWeaponVisual(HashMap<String, Weapon> weapon) {

        System.out.println("Купить оружие под номером:");
        System.out.println(" №|Наименование     | Вес |  Цена  | Максимальный дмг");
        System.out.println("=====================================================");
        for (HashMap.Entry<String, Weapon> entry : weapon.entrySet()) {
            System.out.printf("%2s|%-17s| %-4.1f| %-7d|%2d(крит-%2d)",
                    entry.getKey(),
                    entry.getValue().getName(),
                    entry.getValue().getWeight(),
                    entry.getValue().getCost(),
                    entry.getValue().getDamage(),
                    entry.getValue().getCrit());
            System.out.println();
        }
    }

    public static void ShopArmorVisual(HashMap<String, Armor> armor) {
        System.out.println("Купить броню>:");
        System.out.println(" №|Наименование        | Вес  |  Цена  | Тип доспехов | Бонус к защите");
        System.out.println("======================================================================");
        for (HashMap.Entry<String, Armor> entry : armor.entrySet()) {
            System.out.printf("%2s|%-20s| %-5.1f| %-7d| %-13s| %-10d",
                    entry.getKey(),
                    entry.getValue().getName(),
                    entry.getValue().getWeight(),
                    entry.getValue().getCost(),
                    entry.getValue().getType(),
                    entry.getValue().getBonusdefencearmor());
            System.out.println();
        }
    }

    public static void MyInventar(Player inventar) {
        System.out.println("Деньги-"+inventar.getMoney());
        System.out.println("Оружие");
        System.out.println("==============================================");
        System.out.println("Наименование   |Тип         |Урон  |Крит  |Вес");
        System.out.println("----------------------------------------------");
        for (Inventory x : inventar.getPersonthings()) {
            if (x.getType().equalsIgnoreCase("одноручное")|x.getType().equalsIgnoreCase("полуторное")){
                System.out.printf("%-15s|%-12s|%-6d|%-6d|%-4.1f\n" , x.getName(), x.getType(), x.getDamage(),x.getCrit(),x.getWeight());
            }
        }
        System.out.println("==============================================");
        System.out.println("Броня");
        System.out.println("=========================================================================");
        System.out.println("Наименование        |Тип         |Защита  |Макс. Лов|Штраф Лов Сил |Вес  ");
        System.out.println("-------------------------------------------------------------------------");
        for (Inventory x : inventar.getPersonthings()) {
           if (x.getType().equalsIgnoreCase("лёгкий")|x.getType().equalsIgnoreCase("средний")|
                    x.getType().equalsIgnoreCase("тяжёлый")|x.getType().equalsIgnoreCase("щит")){
                System.out.printf("%-20s|%-12s|%-8d|%-9d|%-14d|%-4.1f\n" , x.getName(), x.getType(), x.getBonusdefencearmor(),
                        x.getDexteryboundarylimit(),x.getFinestrengthdextery(),x.getWeight());
            }
        }

        System.out.println("=========================================================================");
    }

    public static Comparator<Player> IDComparator = new Comparator<Player>() {
        @Override
        public int compare(Player e1, Player e2) {
            if (e2.isIDplayer()) {
                return 1;
            } else if (e1.isIDplayer()) {
                return -1;
            } else {
                return 0;
            }
        }
    };

    public static void SequenceOfMoves(List<Player> list,int iterator){
        for (Player x:list){
            System.out.println(x.getName()+"-->");
        }

    }
}
