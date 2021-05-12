package src.com.anton.ClassPlayer;

import src.com.anton.Inventory.Inventory;
import src.com.anton.Player;
import src.com.anton.PlayerInitialized;
import src.com.anton.Routine.DataInput;
import src.com.anton.TextBattle.HitSuccess;
import src.com.anton.Visual;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class Warior extends Player {

    public Warior(String name, String classPlayer, int strength, int dexterity, int costitution, int intellegence,
                  int wisdom, int charisma) {

        super(name, classPlayer, strength, dexterity, costitution, intellegence, wisdom, charisma);
        setTablemodificatorattack(new int[][]{{1}, {2}, {3}, {4}, {5}, {6, 1}, {7, 2}, {8, 3},
                {9, 4}, {10, 5}, {11, 6, 1}, {12, 7, 2}, {13, 8, 3}, {14, 9, 4}, {15, 10, 5}, {16, 11, 6, 1},
                {17, 12, 7, 2}, {18, 13, 8, 3}, {19, 14, 9, 4}, {20, 15, 10, 5}});
        setBasehealth(10);                                  //Базовое здоровье
        setHealth(getBasehealth() + getContitutionModify());  //ХП текущая
        setHealthmax(getHealth());                          //ХП максимальная
        setLvl(1);
        setBasicmodificatorattack(1);             //(БМА) Базовый модификатор атаки

        setWeapondamage(3);                       //максимальный урон оружием
        setLife(true);                            //состояние живой или мёртвый
        setIDplayer(true);                        //состояние свой-чужой
        setLvl(1);                                //начальный лвл
        setExptable(new ArrayList<>(Arrays.asList(0, 2000, 5000, 9000, 15000, 23000, 35000, 51000, 75000, 105000,
                155000, 220000, 315000, 445000, 635000, 895000, 1350000, 1800000,
                2550000, 3600000)));   //список опыта
        setExperience(getExptable().get(0));      //начальный опыт
        setExperiencemax(getExptable().get(1));   //опыт следующего уровня
        setInitiative(getDexterity());            //Инициатива;
        setMoney(175000);
        setPersonthings(new ArrayList<>());
        setWeaponequepleft(new Inventory("Пусто", 0, 0, "0", 0, 0, 0,0,0,0));
        setWeaponequepright(new Inventory("Пусто", 0, 0, "0", 0, 0, 0,0,0,0));
        setArmorequep(new Inventory("Пусто", 0, 0, "0", 0, 0, 0,0,0,0));
        setTypearmor(new ArrayList<>(Arrays.asList("Лёгкий", "Щит")));
        setTypeweapon(new ArrayList<>(Arrays.asList("Одноручное")));
        setShield(true);
    }

    public static Warior initialized(String name) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        boolean exit;
        do {
            exit = true;
            System.out.println("Выбрать созданного персонажа (1), с выбранными характеристиками (2) или сохранённого (3)");
            int start = scanner.nextInt();
            switch (start) {
                case 1:
                    break;
                case 2:
                    int[] character = PlayerInitialized.character();
                    Warior men = new Warior(name, "Воин", character[0], character[1], character[2], character[3], character[4],
                            character[5]);
                    return men;
                case 3:
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("PersonCharact.bin"));
                    int[] character2 = (int[]) ois.readObject();
                    Warior men2 = new Warior(name, "Воин", character2[0], character2[1], character2[2], character2[3], character2[4],
                            character2[5]);
                    ois.close();
                    return men2;
                default:
                    System.out.println("Неверное значение введите ещё раз");
            }
        } while (exit);
        return null;
    }

    public String Hit(List<Player> enemy, List<Player> all) throws FileNotFoundException {
        Random random = new Random();
        setDefenceonround(0);
        setAtackonround(0);
        String results = "";
        int x = 0;
        int choice=0;

        Visual.BattleVisual(all);

        if (enemy.size() > 1) {
            do {
                System.out.println(getName() + " " + getHealth() + "/" + getHealthmax() + " выберите противника:");
                for (int i = 0; i < enemy.size(); i++) {
                    System.out.println((i + 1) + "." + enemy.get(i).getName() + "-" + enemy.get(i).getHealth() + "/" + enemy.get(i).getHealthmax());
                }
                x = DataInput.InputInteger();
                if (x > enemy.size()) {
                    System.out.println("Невереное число, не более " + enemy.size());
                    continue;
                }
                x--;
                break;
            } while (true);
        } else {
            x = 0;
        }

        while (true) {
            System.out.println(getName()+"("+ getClassPlayer() +")"+" выберите действие в бою");
            System.out.println("1.Полная атака (атака одноручным оружием или двумя одноручными со штрафом в 50% при броске кубика для оружия в левой руке)");
            System.out.println("2.Осторожная атака(атака с одноручныv, +4 к защите, -4 к обороне при броске кубика)");
            System.out.println("3.Глухая оборона + отхил(20%) без атаки");
            choice = DataInput.InputInteger();
            if (choice == 1) {
                break;
            } else if (choice == 2) {
                setDefenceonround(4);
                setAtackonround(-4);
                break;
            } else if (choice == 3) {
                setDefenceonround(6);
                setHealth(getHealth() + (int) Math.round((double) getHealthmax() * 20 / 100));
                if (getHealth() > getHealthmax()) {
                    setHealth(getHealthmax());
                }
                return getName() + " стоит в глухой защите";
            } else {
                System.out.println("Цифра вне диапазона");
            }
        }
        for (int z = 0; z < getTablemodificatorattack()[getLvl() - 1].length; z++) {
            int atmodificator = getTablemodificatorattack()[getLvl() - 1][z];
            int damage = 0;
            int attack = random.nextInt(20) + 1;

            if (attack == 20) {
                damage = random.nextInt(getWeapondamage()) + 1 + getStrengthModify();
                int attackdop = random.nextInt(20) + 1;
                if (attackdop + getAttackmodificator(atmodificator) > enemy.get(x).getDefense()) {
                    damage += random.nextInt(getWeapondamage()) + getStrengthModify();
                }
                enemy.get(x).setHealth(enemy.get(x).getHealth() - damage);
                results = (getName() + " наносит критический урон " + enemy.get(x).getName().toLowerCase());
            } else if ((attack + getAttackmodificator(atmodificator)) > enemy.get(x).getDefense()) {
                damage += random.nextInt(getWeapondamage()) + 1 + getStrengthModify();
                enemy.get(x).setHealth(enemy.get(x).getHealth() - damage);
                results = (getName() + " " + HitSuccess.hit() + " на " + damage);
            } else {
                results = enemy.get(x).getName() + " " + HitSuccess.nohit();
            }

            if (choice==1&getWeaponequepleft().getDamage()!=0){
            damage = 0;
            attack = random.nextInt(20) + 1;
            if (attack == 20) {
                damage += random.nextInt(getWeapondamage()) + 1 + getStrengthModify();
                enemy.get(x).setHealth(enemy.get(x).getHealth() - damage);
                results = "\n" + getName() + " " + HitSuccess.hit() + " на " + damage;}
            } else if ((attack + getAttackmodificator(atmodificator)) > enemy.get(x).getDefense()) {
                damage += random.nextInt(getWeapondamage()) + 1 + getStrengthModify();
                enemy.get(x).setHealth(enemy.get(x).getHealth() - damage);
                results = "\n" + getName() + " " + HitSuccess.hit() + " на " + damage;
            } else {
                results = "\n" + enemy.get(x).getName() + " " + HitSuccess.nohit();
            }
            if (enemy.get(x).getHealth() <= 0) {
                enemy.get(x).setHealth(0);
                enemy.get(x).setLife(false);
                results += " и " + enemy.get(x).getName().toLowerCase() + " был убит";
            }
        }
        return results;
    }

    public void LvlUp(int x) {
        int remaningexp;
        for (int i = 0; i > x; i++) {
            if (getExperience() - getExperiencemax() > 0) {
                remaningexp = getExperience() - getExperiencemax();
            } else {
                remaningexp = 0;
            }
            setLvl(getLvl() + 1);
            setExperience(getExptable().get(getLvl() - 1) + remaningexp);
            setExperiencemax(getExptable().get(getLvl()));
            System.out.println("Какую из характеристик увеличить на + 1");
            charactresLvlUp(1);
        }
    }

    public void Heals(){
        setHealth(getHealth()+getHealthmax()*25/100);
        if (getHealth()>getHealthmax()){
            setHealth(getHealthmax());
        }
    }

}
