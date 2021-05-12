import org.junit.Test;
import src.com.anton.Adventure.EnemyList;
import src.com.anton.ClassPlayer.Warior;
import src.com.anton.FightAlgorithm;
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
        party.add(new Warior("Лёша", "Воин",18,12,11,10,8,7));
        party.add(new Warior("Сергей", "Воин",16,12,15,10,8,7));

        Visual.SequenceOfMoves(party,0);
    }
}
