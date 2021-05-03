package src.com.anton;

import src.com.anton.Inventory.Inventory;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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
    private static int lvl;                     //текущий лвл игрока или партии
    private ArrayList<Integer> exptable;   //таблица получения опыта
    private Inventory weaponequepleft;         //экипированное оружие ведущая рука
    private Inventory weaponequepright;         //экипированное оружие вспомогательная рука
    private Inventory armorequep;          //экипированная броня
    private int money;                    //стартовые деньги
    private ArrayList<Inventory> personthings; //личные вещи
    private ArrayList<String> typearmor; //тип носимой брони
    private ArrayList<String> typeweapon; //тип носимого оружия
    private boolean shield;                 //носит ли щит

    private int KO;                      //Коэффициент опасности
    private int initiative;              //Инициатива противника

    private int defenceonround;          //доп защита на раунд
    private int atackonround;            //доп атака на раунд

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

    public int getKO() {
        return KO;
    }

    public void setKO(int KO) {
        this.KO = KO;
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

    public int getDefenceonround() {
        return defenceonround;
    }

    public void setDefenceonround(int defenceonround) {
        this.defenceonround = defenceonround;
    }

    public int getAtackonround() {
        return atackonround;
    }

    public void setAtackonround(int atackonround) {
        this.atackonround = atackonround;
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
}
