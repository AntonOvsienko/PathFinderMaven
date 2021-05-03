package src.com.anton.Adventure;

import src.com.anton.ClassEnemy.Skelet;
import src.com.anton.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EnemyList {
    public static List<Player> List(double danger,List<Player> player){
        Random random=new Random();
        int playerlvl=0;

        for(Player x:player){
            playerlvl+=x.getLvl();
        }

        playerlvl/=(int)player.size();

        int KO= (int) (playerlvl+danger*0.1);
        List<Player> enemy=new ArrayList<>();
        List<Player> enemylvl1=new ArrayList<Player>(Arrays.asList(new Skelet()));
        while (true){
            if (playerlvl==1){
                while (true){
                    int i= random.nextInt(enemylvl1.size())+1;
                    if (KO==0){
                        return enemy;
                    } else if (playerlvl>KO){
                        continue;
                    }else{
                    enemy.add(new Skelet());
                    KO-=enemylvl1.get(i-1).getLvl();
                    }
                }
            }
        }
    }
}
