package src.com.anton.Routine;

import src.com.anton.Player;

import java.util.List;

public class ChoosePlayer {
    public static int Choose (List<Player> player){
            for (int i=0;i< player.size();i++){
                System.out.println((i+1) +"."+ player.get(i).getName()+ "/" + player.get(i).getClassPlayer());
            }
        return DataInput.InputInteger(player.size())-1;
    }
}
