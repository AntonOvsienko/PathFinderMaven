package src.com.anton.ClassEnemy;

import src.com.anton.Inventory.Armor;
import src.com.anton.Inventory.Inventory;
import src.com.anton.Inventory.Item;
import src.com.anton.Inventory.Weapon;
import src.com.anton.Player;
import src.com.anton.TextBattle.HitSuccess;

import java.io.FileNotFoundException;
import java.util.*;

public class Skelet extends Player {
    Random random = new Random();
    int defence;

    public Skelet() {

        List<String> surname = Arrays.asList("Cтарый", "Ржавый", "Фиолетовый", "Зелёный", "Трухлявый");
        ArrayList<Inventory> trophies = new ArrayList<>();

        setClassPlayer("Скелет");
        setName(surname.get(random.nextInt(surname.size() - 1)) + " скелет");
        setInitiative(6 + random.nextInt(3) - 1);
        setStrength(15 + random.nextInt(3) - 1);
        setDexterity(14 + random.nextInt(3) - 1);
        setCostitution(0);
        setCharisma(12 + random.nextInt(3) - 1);
        setIntellegence(0);
        setWisdom(10 + random.nextInt(3) - 1);
        setBonusmoney(1000);
        setExperience(50);

        setHealth(4);
        setHealthmax(getHealth());
        setBasicmodificatorattack(1);
        setAttackmodificator(20 + 6);
        setDefense(16);
        setLife(true);
        setIDplayer(false);
        setLvl(1);
        setWeaponequepleft(new Weapon("Пусто",0,0,"0",0,0,0,
                0,0,0));
        setWeaponequepright(new Weapon("Сломанный скирт",0,0,"одноручное",0,6,20,0,0,0));
        setArmorequep(new Armor("Пусто",0,0,"0",0,0,0,0,0,0));

        HashMap<String, Integer[]> action = new HashMap<>();
        action.put(getWeaponequepright().getName(), new Integer[]{0, getWeaponequepright().getDamage(),getWeaponequepright().getCrit()});
        action.put("удар когтями", new Integer[]{1, 5,20});
        action.put("двойной удар когтями", new Integer[]{2, 6,20});
        setWeapon(action);

        int indextrophies=random.nextInt(10);
        if (indextrophies<5) {
            trophies.add(new Item("боттл",5,6,"предмет",1));
        } else if (indextrophies<8) {
            trophies.add(new Item("боттл",5,6,"предмет",1));
            trophies.add(new Item("медалька",5,6,"предмет",1));
        } else {
            trophies.add(new Item("боттл",5,6,"предмет",1));
            trophies.add(new Item("медалька",5,6,"предмет",1));
            trophies.add(new Item("меч",5,6,"предмет",1));
        }

        setTrophies(trophies);
    }

    public String Hit(List<Player> enemy, List<Player> all) throws FileNotFoundException {
        setDefenceonround(0);
        setAtackonround(0);
        int damage = 0;
        String results;
        int i = 0;
        int tableID = random.nextInt(getWeapon().size());
        String[] tableIDstring = new String[getWeapon().size()];
        Integer[][] tableIDinteger = new Integer[getWeapon().size()][3];

        if (!enemy.get(0).isLife()) {
            return "";
        }

        for (Map.Entry<String, Integer[]> x : getWeapon().entrySet()) {
            tableIDstring[i] = x.getKey();
            tableIDinteger[i] = x.getValue();
            i++;
        }
        int x;
        if (enemy.size() > 1) {
            x = random.nextInt(enemy.size());
        } else {
            x = 0;
        }
        int attacknominal = tableIDinteger[tableID][1] - tableIDinteger[tableID][0];
        int attack = random.nextInt(20) + 1;
        if (attack >= tableIDinteger[tableID][2]) {
            damage = random.nextInt(attacknominal) + 1 + tableIDinteger[tableID][0];
            int attackdop = random.nextInt(20) + 1;
            if (attackdop + getAttackmodificator(getBasicmodificatorattack()) > enemy.get(x).getDefense()) {
                damage += random.nextInt(attacknominal) + 1 + tableIDinteger[tableID][0];
            }
            enemy.get(x).setHealth(enemy.get(x).getHealth() - damage);
            results = (getName() + " наносит критический урон " + enemy.get(x).getName().toLowerCase() + " на " + damage);
        } else if ((attack + getAttackmodificator(getBasicmodificatorattack())) > enemy.get(x).getDefense()) {
            damage += random.nextInt(attacknominal) + 1 + tableIDinteger[tableID][0];
            enemy.get(x).setHealth(enemy.get(x).getHealth() - damage);
            results = (getName() + " " + tableIDstring[tableID] + " на " + damage);
        } else {
            results = enemy.get(x).getName() + " " + HitSuccess.nohit();
        }
        if (enemy.get(x).getHealth() <= 0) {
            enemy.get(x).setHealth(0);
            enemy.get(x).setLife(false);
            results += " и " + enemy.get(x).getName().toLowerCase() + " был убит";
        }
        return results;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
}
