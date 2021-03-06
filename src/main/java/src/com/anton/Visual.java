package src.com.anton;

import src.com.anton.Inventory.Armor;
import src.com.anton.Inventory.Inventory;
import src.com.anton.Inventory.Weapon;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Visual extends JFrame{
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public static void visual() {
        System.out.println("-------------------------------------------");
    }

    public static void BattleVisual(List<Player> player) {

        player.sort(IDComparator);
        for (Player player1 : player) {
            if (player1.isLife()) {
                if (player1.isIDplayer()) {
                    System.out.print(GREEN);
                    System.out.print("\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                            "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557");
                    System.out.print(RESET);
                } else {
                    System.out.print(RED);
                    System.out.print("\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                            "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                            "\u2550\u2550\u2557");
                    System.out.print(RESET);
                }
            }
        }
        System.out.println("");
        for (Player element : player) {
            if (element.isLife()) {
                if (element.isIDplayer()) {
                    System.out.print(GREEN);
                    System.out.printf("\u2551 %-14s \u2551", element.getName());
                    System.out.print(RESET);
                } else {
                    System.out.print(RED);
                    System.out.printf("\u2551 %-20s\u2551", element.getName());
                    System.out.print(RESET);
                }
            }
        }
        System.out.println("");
        for (Player z:player) {
            if (z.isLife()) {
                if (z.isIDplayer()) {
                    System.out.print(GREEN);
                    System.out.print("\u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                            "\u2550\u2550\u2550\u2550\u2550\u2563");
                    System.out.print(RESET);
                } else {
                    System.out.print(RED);
                    System.out.print("\u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                            "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563");
                    System.out.print(RESET);
                }
            }
        }
        System.out.println("");
        for (Player item : player) {
            if (item.isLife()) {
                if (item.isIDplayer()) {
                    System.out.print(GREEN);
                    System.out.printf("\u2551 Health:%2d/%-4d \u2551", item.getHealth(), item.getHealthmax());
                    System.out.print(RESET);
                } else {
                    System.out.print(RED);
                    System.out.printf("\u2551 Health:%2d/%-10d\u2551", item.getHealth(), item.getHealthmax());
                    System.out.print(RESET);
                }
            }
        }
        System.out.println("");
        for (Player value : player) {
            if (value.isLife()) {
                if (value.isIDplayer()) {
                    System.out.print(GREEN);
                    System.out.printf("\u2551 ?????????? ????????:%-3d \u2551", value.getAttackmodificator
                            (value.getLvl()) + 20);
                    System.out.print(RESET);
                } else {
                    System.out.print(RED);
                    System.out.printf("\u2551 ?????????? ????????:%-9d\u2551", value.getAttackmodificator
                            (value.getBasicmodificatorattack()) + 20);
                    System.out.print(RESET);
                }
            }
        }
        System.out.println("");
        for (Player value : player) {
            if (value.isLife()) {
                if (value.isIDplayer()) {
                    System.out.print(GREEN);
                    System.out.printf("\u2551 ????????????:%-3d     \u2551", value.getDefense());
                    System.out.print(RESET);
                } else {
                    System.out.print(RED);
                    System.out.printf("\u2551 ????????????:%-8d     \u2551", value.getDefense());
                    System.out.print(RESET);
                }
            }
        }
        System.out.println("");
        for (Player z:player) {
            if (z.isLife()) {
                if (z.isIDplayer()) {
                    System.out.print(GREEN);
                    System.out.print("\u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                            "\u2550\u2550\u2550\u2550\u2550\u2563");
                    System.out.print(RESET);
                } else {
                    System.out.print(RED);
                    System.out.print("\u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                            "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563");
                    System.out.print(RESET);
                }
            }
        }
        System.out.println("");
        if (player.stream().noneMatch(x -> x.getAtackdescription()[0][0].equals("0")
                || x.getAtackdescription()[1][0].equals("0")
                || x.getAtackdescription()[2][0].equals("0"))) {
            for (int i = 0; i < 3; i++) {
                for (Player value : player) {
                    if (value.isLife()) {
                        if (!value.getAtackdescription()[i][0].equals("0")) {
                            if (value.isIDplayer()) {
                                System.out.print(GREEN);
                                System.out.printf("\u2551 %8s:%-3s \u2551", value.getAtackdescription()[i][0]
                                        , value.getAtackdescription()[i][1]);
                                System.out.print(RESET);
                            } else {
                                System.out.print(RED);
                                System.out.printf("\u2551 %8s:%-3s\u2551", value.getAtackdescription()[i][0]
                                        , value.getAtackdescription()[i][1]);
                                System.out.print(RESET);
                            }
                        } else {
                            if (value.isIDplayer()) {
                                System.out.print(GREEN);
                                System.out.printf("\u2551                \u2551");
                                System.out.print(RESET);
                            } else {
                                System.out.print(RED);
                                System.out.printf("\u2551                     \u2551");
                                System.out.print(RESET);
                            }
                        }
                    }
                }
                System.out.println("");
            }
        }
            for (int i = 0; i < 3; i++) {
                int finalI = i;
                boolean temp=player.stream().anyMatch(x -> x.getDefencedescription()[finalI][0].equals("0"));
                if (temp) {
                    for (Player value : player) {
                        if (value.isLife()) {
                            if (!value.getDefencedescription()[i][0].equals("0")) {
                                if (value.isIDplayer()) {
                                    System.out.print(GREEN);
                                    System.out.printf("\u2551 %10s:%-1s(%-1s)\u2551", value.getDefencedescription()[i][0]
                                            ,value.getDefencedescription()[i][1],value.getDefencedescription()[i][2]);
                                    System.out.print(RESET);
                                } else {
                                    System.out.print(RED);
                                    System.out.printf("\u2551 %10s:%-3s\u2551", value.getDefencedescription()[i][0]
                                            , value.getDefencedescription()[i][1]);
                                    System.out.print(RESET);
                                }
                            } else {
                                if (value.isIDplayer()) {
                                    System.out.print(GREEN);
                                    System.out.printf("\u2551                \u2551");
                                    System.out.print(RESET);
                                } else {
                                    System.out.print(RED);
                                    System.out.printf("\u2551                     \u2551");
                                    System.out.print(RESET);
                                }
                            }
                        }
                    }
                    System.out.println("");
                }
            }
        for (Player value : player) {
                if (value.isLife()) {
                    if (value.isIDplayer()) {
                        System.out.print(GREEN);
                        System.out.print("\u255A\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                                "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255D");
                        System.out.print(RESET);
                    } else {
                        System.out.print(RED);
                        System.out.print("\u255A\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                                "\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550" +
                                "\u2550\u2550\u255D");
                        System.out.print(RESET);
                    }
                }
            }
        System.out.println("");
    }
    public static void ShopWeaponVisual(HashMap<String, Weapon> weapon) {

        System.out.println("???????????? ???????????? ?????? ??????????????:");
        System.out.println(" ???|????????????????????????     | ?????? |  ????????  | ???????????????????????? ??????");
        System.out.println("=====================================================");
        for (HashMap.Entry<String, Weapon> entry : weapon.entrySet()) {
            System.out.printf("%2s|%-17s| %-4.1f| %-7d|%2d(????????-%2d)",
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
        System.out.println("???????????? ??????????>:");
        System.out.println(" ???|????????????????????????        | ??????  |  ????????  | ?????? ???????????????? | ?????????? ?? ????????????");
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
        System.out.println("????????????-"+inventar.getMoney());
        System.out.println("????????????");
        System.out.println("==============================================");
        System.out.println("????????????????????????   |??????         |????????  |????????  |??????");
        System.out.println("----------------------------------------------");
        for (Inventory x : inventar.getPersonthings().stream()
                .filter(x -> x.getType().equals("????????????????????")||x.getType().equals("????????????????????")
                ||x.getType().equals("??????????????????")).collect(Collectors.toCollection(ArrayList::new))) {
                System.out.printf("%-15s|%-12s|%-6d|%-6d|%-4.1f\n" , x.getName(), x.getType(), x.getDamage(),x.getCrit(),x.getWeight());
        }
        System.out.println("==============================================");
        System.out.println("??????????");
        System.out.println("=========================================================================");
        System.out.println("????????????????????????        |??????         |????????????  |????????. ??????|?????????? ?????? ?????? |??????  ");
        System.out.println("-------------------------------------------------------------------------");

        for (Inventory x : inventar.getPersonthings()) {
           if (x.getType().equalsIgnoreCase("????????????")|x.getType().equalsIgnoreCase("??????????????")|
                    x.getType().equalsIgnoreCase("??????????????")|x.getType().equalsIgnoreCase("??????")){
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

        System.out.println("?????????????? ?????????? ???????????????? ????????????????????");
        for (int i=0;i<list.size()-1;i++){
            if (list.get(i).isLife()){
                if (i==iterator){
                    System.out.print(GREEN + list.get(i).getName() + RESET + "-->");
                }else{
                    System.out.print(list.get(i).getName()+"-->");
                }
            }
        }
        System.out.print(list.get(list.size()-1).getName());
        System.out.println();
    }

    public static void ItemVisual(ArrayList<Inventory> inventory){
        int count;
        HashMap<String, Inventory> itemsort=new HashMap<>();
        for (Inventory x:inventory){
            itemsort.put(x.getName(),new Inventory(x.getName(), x.getCost(), x.getWeight(), x.getType(), 0));
        }

        System.out.println("????????????????:");
        for (Map.Entry<String,Inventory> x:itemsort.entrySet()){
            if (x.getValue().getType().equalsIgnoreCase("??????????????")){
                System.out.println(x.getKey() + "-" + x.getValue().getAmount() + "????/" + x.getValue());
            }
        }

    }

}
