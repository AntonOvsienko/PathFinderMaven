package src.com.anton.Inventory;

public class Inventory {
    private double weight;
    private String name;
    private int cost;

    private int damage;
    private String type;
    private int crit;
    private int amount;
    private int bonusdefencearmor;
    private int dexteryboundarylimit;
    private int finestrengthdextery;
    private int initiativeBonus;

    public Inventory() {

    }

    public Inventory(String name, int cost, double weight, String type,int amount, int damage,
                     int crit,int bonusdefencearmor, int dexteryboundarylimit, int finestrengthdextery) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
        this.damage = damage;
        this.type = type;
        this.crit = crit;
        this.amount = amount;
        this.bonusdefencearmor = bonusdefencearmor;
        this.dexteryboundarylimit = dexteryboundarylimit;
        this.finestrengthdextery = finestrengthdextery;
    }

    public Inventory(String name, int cost, double weight, String type,int amount, int damage,
                     int crit,int initiativeBonus) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
        this.damage = damage;
        this.type = type;
        this.crit = crit;
        this.amount = amount;
        this.initiativeBonus=initiativeBonus;
    }

    public Inventory(String name, int cost, double weight) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
    }

    public Inventory(String name, int cost, double weight, String type, int amount) {
        this.name = name;
        this.cost = cost;
        this.weight = weight;
        this.amount = amount;
        this.type = type;
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCrit() {
        return crit;
    }

    public void setCrit(int crit) {
        this.crit = crit;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBonusdefencearmor() {
        return bonusdefencearmor;
    }

    public void setBonusdefencearmor(int bonusdefencearmor) {
        this.bonusdefencearmor = bonusdefencearmor;
    }

    public int getDexteryboundarylimit() {
        return dexteryboundarylimit;
    }

    public void setDexteryboundarylimit(int dexteryboundarylimit) {
        this.dexteryboundarylimit = dexteryboundarylimit;
    }

    public int getFinestrengthdextery() {
        return finestrengthdextery;
    }

    public void setFinestrengthdextery(int finestrengthdextery) {
        this.finestrengthdextery = finestrengthdextery;
    }

    public int getInitiativeBonus() {
        return initiativeBonus;
    }

    public void setInitiativeBonus(int initiativeBonus) {
        this.initiativeBonus = initiativeBonus;
    }

    @Override
    public String toString() {
        return "(вес-" + weight
                + ", цена-" + cost + ")"
                ;
    }

    public void EquipmentLeftHand(){

    }

    public void EquipmentRightHand(){

    }

    public void FullEquipment(){

    }
}
