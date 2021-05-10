package src.com.anton;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FightAlgorithm {

    public static void Fight(List<Player> player, List<Player> enemy) throws FileNotFoundException {
        int isLifePlayer;
        int isLifeEnemy;
        int count = 0;
        List<Player> listParticipation = new ArrayList<>();
        listParticipation.addAll(enemy);
        listParticipation.addAll(player);
        listParticipation.sort((e1,e2) -> {
                if (e1.getInitiative() < e2.getInitiative()) {
                    return 1;
                } else if (e1.getInitiative() > e2.getInitiative()) {
                    return -1;
                } else {
                    return 0;
                }
        });
        while (true) {
            System.out.println("Раунд " + ++count);
            Visual.SequenceOfMoves(listParticipation,count);
            Visual.BattleVisual(listParticipation);
            String[] textotals = new String[listParticipation.size()];
            for (int i = 0; i < listParticipation.size(); i++) {
                if (!listParticipation.get(i).isLife()) {
                    textotals[i] = "";
                    continue;
                }
                textotals[i] = listParticipation.get(i).Hit(ListOpponent(listParticipation.get(i), listParticipation), listParticipation);
            }
            for (String x : textotals) {
                System.out.println(x);
            }
            for (int i = 0; i < listParticipation.size(); i++) {
                if (!listParticipation.get(i).isLife()) {
                    listParticipation.remove(i);
                }
            }
            isLifePlayer = 0;
            isLifeEnemy = 0;


            for (Player x : listParticipation) {
                if ((x.isIDplayer())) {
                    isLifePlayer++;
                } else {
                    isLifeEnemy++;
                }
            }
            if (isLifePlayer == 0) {
                System.out.println("Вы проиграли");
                break;
            }
            if (isLifeEnemy == 0) {
                System.out.println("Вы выиграли");
                break;
            }
        }
    }

    public static List<Player> ListOpponent(Player player, List<Player> list) {
        return list.stream().filter(s->s.isIDplayer()!=player.isIDplayer()).collect(Collectors.toList());
    }
}


