import org.junit.After;
import org.junit.Test;
import src.com.anton.Adventure.EnemyList;
import src.com.anton.ClassEnemy.Skelet;
import src.com.anton.ClassPlayer.Warior;
import src.com.anton.FightAlgorithm;
import src.com.anton.Inventory.Inventory;
import src.com.anton.Player;
import src.com.anton.Visual;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FightTest {

    @Test
    public void FightTestExample() throws FileNotFoundException {
        List<Player> party=new ArrayList<>();
        party.add(new Warior("Вася", "Воин",18,15,10,10,8,7));
        party.add(new Warior("Ваня", "Воин",18,13,12,10,8,7));

        List<Player> party2=new ArrayList<>();
        party2.add(new Skelet());
        party2.add(new Skelet());
        party2.add(new Skelet());
        party2.add(new Skelet());
        party2.add(new Skelet());

        FightAlgorithm.AfterWin(party,party2);

        System.out.println(party.get(0).getMoney());
        for (Player x:party){
            System.out.println(x.getName() + "/" + x.getExperience());
        }
        System.out.println(party.get(0).getPersonthings());
    }
}
