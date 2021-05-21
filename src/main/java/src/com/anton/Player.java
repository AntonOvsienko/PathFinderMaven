package src.com.anton;

import src.com.anton.Inventory.Inventory;
import src.com.anton.Routine.DataInput;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Player {

    private boolean life;
    private String name;
    private String classPlayer;          //Класс игрока
    private int strength;                //Сила
    private int strengthModify;          //Модификтор силы
    private int dexterity;              //Ловкость
    private int dexterityModify;         //Модификатор ловкости
    private int costitution;             //Вынословисть
    private int contitutionModify;       //Модификатор выносливости
    private int intellegence;            //Интеллект
    private int intellegenceModify;      //Модификатор интеллекта
    private int wisdom;                  //Мудрость
    private int wisdomModify;            //Модификатор Мудрости
    private int charisma;                //Харизма
    private int charismaModify;          //Модификатор харизмы
    private int basehealth;              //Базовое здоровье
    private int health;                  //Здоровье
    private int healthmax;               //Здоровье максимальное
    private int weapondamage;            //максимальный урон оружием
    private int attackmodificator;       //модификатор урон
    private int basicmodificatorattack;  //базовый модификатор атаки
    private int[][] tablemodificatorattack;  //Базовый модификатор в зависимости от уровня
    private int defense;                 //параметр защиты
    private boolean IDplayer;                 //состояние игрок(true)-враг(false)
    private HashMap<String, Integer[]> weapon;  //виды действий атаки
    private int experience;              //текущий опыт (персонажа и противника который можно получить после его убийства)
    private int experiencemax;           //максимальный опыт на текущем уровне
    private int lvl;                     //текущий лвл игрока или партии
    private ArrayList<Integer> exptable;   //таблица получения опыта
    private Inventory weaponequepleft;         //экипированное оружие вспомогательная рука
    private Inventory weaponequepright;         //экипированное оружие ведущая рука
    private Inventory armorequep;          //экипированная броня
    private static int money=0;                    //стартовые деньги
    private int bonusmoney;               //деньги падающие с мобов
    private static ArrayList<Inventory> personthings; //личные вещи
    private ArrayList<Inventory> trophies;     //вещи падающие с мобов
    private ArrayList<String> typearmor;       //тип носимой брони
    private ArrayList<String> typeweapon;     //тип носимого оружия
    private boolean shield;                 //носит ли щит
    private String range;                   //Ближний или дальний бой

    private int initiative;              //Инициатива противника

    private int defenceonround;          //доп защита на раунд
    private int atackonround;            //доп атака на раунд
    private int damageround;             //доп дамаг на раунд
    private String[][] defencedescription=new String[][]{{"0","0","0"},
            {"0","0","0"},{"0","0","0"}}; //таблица эффектов игрока: защита [описание][значение][кол-во ходов]
    private String[][] atackdescription=new String[][]{{"0","0","0"},
            {"0","0","0"},{"0","0","0"}}; //таблица эффектов игрока: атака [описание][значение][кол-во ходов]
    private String[][] damagedescription=new String[][]{{"0","0","0"},
            {"0","0","0"},{"0","0","0"}}; //таблица эффектов игрока: дамаг [описание][значение][кол-во ходов]


    public Player(){
    }

    public Player(String name, String classPlayer, int strength, int dexterity, int costitution, int intellegence,
                  int wisdom, int charisma) {
        this.name = name;
        this.classPlayer = classPlayer;
        this.strength = strength;
        this.dexterity = dexterity;
        this.costitution = costitution;
        this.intellegence = intellegence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public void EquopmentPosition() {
    }

    public void EquipmentLeftHand(){

    }

    public void EquipmentRightHand(){

    }

    public void EquipmentShield(){

    }

    public void EquipmentArmor(){

    }

    public int getDefenceonround() {
        int sumdeffence=0;
         for (int i=0;i<3;i++){
             sumdeffence+=Integer.valueOf(getDefencedescription()[i][1]);
         }
         return sumdeffence;
    }

    public void setDefenceonround(String descritopn,String defenceonround,String count) {
        for (int i=0;i<3;i++){
            if (descritopn.equals(getDefencedescription()[i][0])){
                String temp=String.valueOf(Integer.valueOf(count)+Integer.valueOf(getDefencedescription()[i][2]));
                getDefencedescription()[i][2]=temp;
                return;
            }
        }
        for (int i=0;i<3;i++){
            if (getDefencedescription()[i][0].equals("0")){
                getDefencedescription()[i][0]=descritopn;
                getDefencedescription()[i][1]=defenceonround;
                getDefencedescription()[i][2]=count;
                return;
            }
        }
    }

    public int getAtackonround() {
        int sumatack=0;
        for (int i=0;i<3;i++){
            sumatack+=Integer.valueOf(getAtackdescription()[i][1]);
        }
        return sumatack;
    }

    public void setAtackonround(String descritopn,String atackonround,String count) {
        for (int i=0;i<3;i++){
            if (descritopn.equals(getAtackdescription()[i][0])){
                String temp=String.valueOf(Integer.valueOf(count)+Integer.valueOf(getAtackdescription()[i][2]));
                getAtackdescription()[i][2]=temp;
                return;
            }
        }
        for (int i=0;i<3;i++){
            if (getAtackdescription()[i][0].equals("0")){
                getAtackdescription()[i][0]=descritopn;
                getAtackdescription()[i][1]=atackonround;
                getAtackdescription()[i][2]=count;
                return;
            }
        }
    }

    public int getDamageround() {
        int sumdamage=0;
        for (int i=0;i<3;i++){
            sumdamage+=Integer.valueOf(getDamagedescription()[i][1]);
        }
        return sumdamage;
    }

    public void setDamageround(int damageround) {
        this.damageround = damageround;
    }

    public String[][] getDefencedescription() {
        return defencedescription;
    }

    public void setDefencedescription(String[][] defencedescription) {
        this.defencedescription = defencedescription;
    }

    public String[][] getAtackdescription() {
        return atackdescription;
    }

    public void setAtackdescription(String[][] atackdescription) {
        this.atackdescription = atackdescription;
    }

    public String[][] getDamagedescription() {
        return damagedescription;
    }

    public void setDamagedescription(String[][] damagedescription) {
        this.damagedescription = damagedescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrengthModify() {
        if (strength > 6) {                                //Модификаторы
            return (strength - 10) / 2;
        } else {
            return 0;
        }
    }

    public int getDexterity() {

        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getDexterityModify() {
        if (dexterity > 6) {
            return (dexterity - 10) / 2;
        } else {
            return 0;
        }
    }

    public int getCostitution() {
        return costitution;
    }

    public void setCostitution(int costitution) {
        this.costitution = costitution;
    }

    public int getContitutionModify() {
        if (costitution > 6) {
            return (costitution - 10) / 2;
        } else {
            return 0;
        }
    }

    public int getIntellegence() {
        return intellegence;
    }

    public void setIntellegence(int intellegence) {
        this.intellegence = intellegence;
    }

    public int getIntellegenceModify() {
        if (intellegence > 6) {
            return (intellegence - 10) / 2;
        } else {
            return 0;
        }
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getWisdomModify() {
        if (wisdom > 6) {
            return (wisdom - 10) / 2;
        } else {
            return 0;
        }
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getCharismaModify() {
        if (charisma > 6) {
            return (charisma - 10) / 2;
        } else {
            return 0;
        }
    }

    public String getClassPlayer() {
        return classPlayer;
    }

    public void setClassPlayer(String classPlayer) {
        this.classPlayer = classPlayer;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackmodificator(int atmodificator) {
        return getStrengthModify() + atmodificator + getAtackonround();
    }

    public void setAttackmodificator(int attackmodificator) {
        this.attackmodificator = attackmodificator;
    }

    public int getDefense() {
        return 10 + getDexterityModify() + getDefenceonround() + weaponequepleft.getBonusdefencearmor()+
                weaponequepright.getBonusdefencearmor() + armorequep.getBonusdefencearmor();
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealthmax() {
        return healthmax;
    }

    public void setHealthmax(int healthmax) {
        this.healthmax = healthmax;
    }

    public int getWeapondamage() {
        return weapondamage;
    }

    public void setWeapondamage(int weapondamage) {
        this.weapondamage = weapondamage;
    }

    public int getBasicmodificatorattack() {
        return basicmodificatorattack;
    }

    public void setBasicmodificatorattack(int basicmodificatorattack) {
        this.basicmodificatorattack = basicmodificatorattack;
    }

    public boolean isIDplayer() {
        return IDplayer;
    }

    public void setIDplayer(boolean IDplayer) {
        this.IDplayer = IDplayer;
    }

    public boolean isLife() {
        return life;
    }

    public void setLife(boolean life) {
        this.life = life;
    }

    public HashMap<String, Integer[]> getWeapon() {
        return weapon;
    }

    public void setWeapon(HashMap<String, Integer[]> weapon) {
        this.weapon = weapon;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperiencemax() {
        return experiencemax;
    }

    public void setExperiencemax(int experiencemax) {
        this.experiencemax = experiencemax;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public ArrayList<Integer> getExptable() {
        return exptable;
    }

    public void setExptable(ArrayList<Integer> exptable) {
        this.exptable = exptable;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public String Hit(List<Player> players, List<Player> enemy) throws FileNotFoundException {
        return null;
    }

    public int getBasehealth() {
        return basehealth;
    }

    public void setBasehealth(int basehealth) {
        this.basehealth = basehealth;
    }

    public int[][] getTablemodificatorattack() {
        return tablemodificatorattack;
    }

    public void setTablemodificatorattack(int[][] tablemodificatorattack) {
        this.tablemodificatorattack = tablemodificatorattack;
    }

    public ArrayList<Inventory> getPersonthings() {
        return personthings;
    }

    public void setPersonthings(ArrayList<Inventory> personthings) {
        this.personthings = personthings;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getArmorequep() {
        return armorequep;
    }

    public void setArmorequep(Inventory armorequep) {
        this.armorequep = armorequep;
    }

    public Inventory getWeaponequepleft() {
        return weaponequepleft;
    }

    public void setWeaponequepleft(Inventory weaponequepleft) {
        this.weaponequepleft = weaponequepleft;
    }

    public Inventory getWeaponequepright() {
        return weaponequepright;
    }

    public void setWeaponequepright(Inventory weaponequepright) {
        this.weaponequepright = weaponequepright;
    }

    public ArrayList<String> getTypearmor() {
        return typearmor;
    }

    public void setTypearmor(ArrayList<String> typearmor) {
        this.typearmor = typearmor;
    }

    public boolean isShield() {
        return shield;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }

    public ArrayList<String> getTypeweapon() {
        return typeweapon;
    }

    public void setTypeweapon(ArrayList<String> typeweapon) {
        this.typeweapon = typeweapon;
    }

    public int getBonusmoney() {
        return bonusmoney;
    }

    public void setBonusmoney(int bonusmoney) {
        this.bonusmoney = bonusmoney;
    }

    public ArrayList<Inventory> getTrophies() {
        return trophies;
    }

    public void setTrophies(ArrayList<Inventory> trophies) {
        this.trophies = trophies;
    }


    public void charactresLvlUp(int x) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("1.Сила:          %-2d\n" +
                        "2.Ловкость:      %-2d\n" +
                        "3.Выносливость:  %-2d\n" +
                        "4.Интеллект:     %-2d\n" +
                        "5.Мудрость:      %-2d\n" +
                        "6.Харизма:       %-2d\n", strength, dexterity, costitution, intellegence,
                wisdom, charisma);
        int y = scanner.nextInt();
    }

    @Override
    public String toString() {
        return "";
    }

    public void Heals(){

    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }


}
