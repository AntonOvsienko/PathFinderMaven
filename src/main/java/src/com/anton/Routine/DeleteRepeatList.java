package src.com.anton.Routine;

import src.com.anton.Player;

public class DeleteRepeatList {
    public static boolean MergeList(Player player, String x) {
        for (int i = 0; i < player.getPersonthings().size(); i++) {
            if (player.getPersonthings().get(i).getName().equals(x)) {
                player.getPersonthings().get(i).setAmount(player.getPersonthings().get(i).getAmount() + 1);
                return true;
            }
        }
        return false;
    }
}