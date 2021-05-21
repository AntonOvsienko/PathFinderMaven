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
import java.util.stream.Collectors;

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
        setInitiative(getDexterity());            //Инициатива
        setMoney(getMoney()+75000);               //Общие деньги
        setPersonthings(new ArrayList<>());       //Общие предметы
        setWeaponequepleft(new Inventory("Пусто", 0, 0, "0", 0, 0, 0,0));
        setWeaponequepright(new Inventory("Пусто", 0, 0, "0", 0, 0, 0,0));
        setArmorequep(new Inventory("Пусто", 0, 0, "0", 0, 0, 0,0));
        setTypearmor(new ArrayList<>(Arrays.asList("Лёгкий","Средний","Тяжёлый", "Щит")));
        setTypeweapon(new ArrayList<>(Arrays.asList("Одноручное","Полуторное","Двуручное")));
        setShield(true);
        setRange("Ближний");
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

    public void EquopmentPosition(){

        while (true){
        System.out.println("Выберите вашу роль в бою (по умолчанию) - её можно изменить");
        System.out.println("0.Выход");
        System.out.println("1.Боец первой линии-меч(одноручный или полуторный)+щит");
        System.out.println("2.Боец первой линии-меч(одноручный)+меч(одноручный)");
        System.out.println("3.Боец первой линии-меч(полуторный или двуручный)");
        System.out.println("4.Боец второй линии-метательное");
        int x=DataInput.InputInteger(4);
            if (x==0){
                break;
            } else if (x==1){
                this.setRange("Ближний");
                this.EquipmentRightHand(getPersonthings().stream()
                        .filter(y -> y.getType().equals("Одноручное")||y.getType().equals("Полуторное"))
                        .collect(Collectors.toCollection(ArrayList::new)));
                this.EquipmentArmor(getPersonthings().stream()
                        .filter(y -> y.getType().equals("Лёгкий")||y.getType().equals("Средний")||y.getType().equals("Тяжёлый"))
                        .collect(Collectors.toCollection(ArrayList::new)));
                this.EquipmentShield(getPersonthings().stream()
                        .filter(y -> y.getType().equals("Щит"))
                        .collect(Collectors.toCollection(ArrayList::new)));
            } else if (x==2){
                this.setRange("Ближний");
                this.EquipmentRightHand(getPersonthings().stream()
                        .filter(y -> y.getType().equals("Одноручное"))
                        .collect(Collectors.toCollection(ArrayList::new)));
                this.EquipmentLeftHand(getPersonthings().stream()
                        .filter(y -> y.getType().equals("Одноручное"))
                        .collect(Collectors.toCollection(ArrayList::new)));
                this.EquipmentArmor(getPersonthings().stream()
                        .filter(y -> y.getType().equals("Лёгкий")||y.getType().equals("Средний")||y.getType().equals("Тяжёлый"))
                        .collect(Collectors.toCollection(ArrayList::new)));
            } else if (x==3){
                this.setRange("Ближний");
                this.EquipmentRightHand(getPersonthings().stream()
                        .filter(y -> y.getType().equals("Полуторное")||y.getType().equals("Двуручное"))
                        .collect(Collectors.toCollection(ArrayList::new)));
                this.EquipmentArmor(getPersonthings().stream()
                        .filter(y -> y.getType().equals("Лёгкий")||y.getType().equals("Средний")||y.getType().equals("Тяжёлый"))
                        .collect(Collectors.toCollection(ArrayList::new)));
            } else if (x==4){
                this.setRange("Дальний");
            }
        }
    }

    public void EquipmentLeftHand(ArrayList<Inventory> lefthand){
        Inventory tempweaponequepleft = new Inventory(getWeaponequepleft().getName(),getWeaponequepleft().getCost(),
                getWeaponequepleft().getWeight(),getWeaponequepleft().getType(),getWeaponequepleft().getAmount(),
                getWeaponequepleft().getDamage(),getWeaponequepleft().getCrit(),getWeaponequepleft().getInitiativeBonus());

        System.out.println("0.Освободить");
        for (int i = 0; i < lefthand.size(); i++) {
            System.out.println((i + 1) + "." + lefthand.get(i).getName());
        }
        int choice = DataInput.InputInteger(lefthand.size());
        if (choice==0){
            lefthand.add(getWeaponequepleft());
            setWeaponequepleft(new Inventory("Пусто", 0, 0, "0", 0, 0, 0,0));
        } else{
            setWeaponequepleft(lefthand.get(choice-1));
            lefthand.remove(choice-1);
        }

        if (!tempweaponequepleft.equals(getWeaponequepleft())){
            for (int i=0;i<getPersonthings().size();i++){
                if (getPersonthings().get(i).getName().equals(getWeaponequepleft().getName())){
                    if (!tempweaponequepleft.getName().equals("Пусто")){
                        getPersonthings().add(tempweaponequepleft);
                    }
                }
                getPersonthings().remove(i);
                break;
            }
        }
    }

    public void EquipmentRightHand(ArrayList<Inventory> righthand){
        Inventory tempweaponequepright = new Inventory(getWeaponequepright().getName(),getWeaponequepright().getCost(),
                getWeaponequepright().getWeight(),getWeaponequepright().getType(),getWeaponequepright().getAmount(),
                getWeaponequepright().getDamage(),getWeaponequepright().getCrit(),getWeaponequepright().getInitiativeBonus());

        System.out.println("0.Освободить");
        for (int i = 0; i < righthand.size(); i++) {
            System.out.println((i + 1) + "." + righthand.get(i).getName());
        }
        int choice = DataInput.InputInteger(righthand.size());
        if (choice==0){
            righthand.add(getWeaponequepright());
            setWeaponequepright(new Inventory("Пусто", 0, 0, "0", 0, 0, 0,0));
        } else{
            setWeaponequepright(righthand.get(choice-1));
            righthand.remove(choice-1);
        }

        if (!tempweaponequepright.equals(getWeaponequepright())){
            for (int i=0;i<getPersonthings().size();i++){
                if (getPersonthings().get(i).getName().equals(getWeaponequepright().getName())){
                    if (!tempweaponequepright.getName().equals("Пусто")){
                        getPersonthings().add(tempweaponequepright);
                    }
                }
                getPersonthings().remove(i);
                break;
            }
        }
    }

    public void EquipmentShield(ArrayList<Inventory> shield){
        Inventory tempweaponequepleft = new Inventory(getWeaponequepleft().getName(),getWeaponequepleft().getCost(),
                getWeaponequepleft().getWeight(),getWeaponequepleft().getType(),getWeaponequepleft().getAmount(),
                getWeaponequepleft().getDamage(),getWeaponequepleft().getCrit(),getWeaponequepleft().getInitiativeBonus());

        System.out.println("0.Освободить");
        for (int i = 0; i < shield.size(); i++) {
            System.out.println((i + 1) + "." + shield.get(i).getName());
        }
        int choice = DataInput.InputInteger(shield.size());
        if (choice==0){
            shield.add(getWeaponequepleft());
            setWeaponequepleft(new Inventory("Пусто", 0, 0, "0", 0, 0, 0,0));
        } else{
            setWeaponequepleft(shield.get(choice-1));
            shield.remove(choice-1);
        }

        if (!tempweaponequepleft.equals(getWeaponequepleft())){
            for (int i=0;i<getPersonthings().size();i++){
                if (getPersonthings().get(i).getName().equals(getWeaponequepleft().getName())){
                    if (!tempweaponequepleft.getName().equals("Пусто")){
                        getPersonthings().add(tempweaponequepleft);
                    }
                }
                getPersonthings().remove(i);
                break;
            }
        }
    }

    public void EquipmentArmor(ArrayList<Inventory> fullequpment){
        Inventory temparmorequep = new Inventory(getArmorequep().getName(),getArmorequep().getCost(),
                getArmorequep().getWeight(),getArmorequep().getType(),getArmorequep().getAmount(),
                getArmorequep().getDamage(),getArmorequep().getCrit(),getArmorequep().getBonusdefencearmor(),
                getArmorequep().getDexteryboundarylimit(),getArmorequep().getFinestrengthdextery());

        System.out.println("0.Освободить");
        for (int i = 0; i < fullequpment.size(); i++) {
            System.out.println((i + 1) + "." + fullequpment.get(i).getName());
        }
        int choice=DataInput.InputInteger(fullequpment.size());
        if (choice==0){
            fullequpment.add(getArmorequep());
            setArmorequep(new Inventory("Пусто", 0, 0, "0", 0, 0, 0,0,0,0));
        } else{
            setArmorequep(fullequpment.get(choice-1));
            fullequpment.remove(choice-1);
        }

        if (!temparmorequep.equals(getArmorequep())) {
            for (int i = 0; i < getPersonthings().size(); i++) {
                if (getPersonthings().get(i).getName().equals(getArmorequep().getName())) {
                    if (!temparmorequep.getName().equals("Пусто")) {
                        getPersonthings().add(temparmorequep);
                    }
                    getPersonthings().remove(i);
                    break;
                }
            }
    }
    }

    public String Hit(List<Player> enemy, List<Player> all) throws FileNotFoundException {
        Random random = new Random();
        String results = "";
        int x = 0;
        int choice=0;
        List<Player> listOnlyPlayer=new ArrayList<>();
        if (getRange().equals("Ближний")){
            if (enemy.stream().anyMatch(t->t.getRange().equals("Ближний"))){
            listOnlyPlayer=enemy.stream()
                    .filter(t->t.getRange().equals("Ближний"))
                    .collect(Collectors.toList());
            } else {
                listOnlyPlayer=enemy;
            }
        } else {
            listOnlyPlayer=enemy;
        }
        Visual.BattleVisual(all);

        while (true) {
            System.out.println(getName()+"("+ getClassPlayer() +")"+" выберите действие в бою");
            System.out.println("1.Полная атака (атака одноручным оружием или двумя одноручными со штрафом в 50% при броске кубика для оружия в левой руке)");
            System.out.println("2.Осторожная атака(атака с одноручныv, +4 к защите, -4 к обороне при броске кубика)");
            System.out.println("3.Глухая оборона + отхил(20%) без атаки");
            choice = DataInput.InputInteger();
            if (choice == 1) {
                break;
            } else if (choice == 2) {
                setDefenceonround("Осторожная атака","4","1");
                setAtackonround("Осторожная атака","-4","1");
                break;
            } else if (choice == 3) {
                setDefenceonround("Гл.оборона","6","1");
                setHealth(getHealth() + (int) Math.round((double) getHealthmax() * 20 / 100));
                if (getHealth() > getHealthmax()) {
                    setHealth(getHealthmax());
                }
                return getName() + " стоит в глухой защите";
            } else {
                System.out.println("Цифра вне диапазона");
            }
        }

        if (listOnlyPlayer.size() > 1) {
            System.out.println(getName() + " " + getHealth() + "/" + getHealthmax() + " выберите противника:");
            for (int i = 0; i < listOnlyPlayer.size(); i++) {
                if (listOnlyPlayer.get(i).isLife()){
                    System.out.println((i + 1) + "." + listOnlyPlayer.get(i).getName() + "-"
                        + listOnlyPlayer.get(i).getHealth() + "/" + listOnlyPlayer.get(i).getHealthmax()
                        + "(" + (100-enemy.get(i).getDefense()*100/(this.getAttackmodificator
                            (this.getLvl()) + 20))+ "%)");
                }
            }
                x = DataInput.InputInteger(listOnlyPlayer.size());
                x--;
        } else {
            x = 0;
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
