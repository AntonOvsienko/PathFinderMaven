package src.com.anton.Adventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreatingAdventure {
    static List<String> adventure=new ArrayList<>();
    public static List<String> Lvl(int way){
        adventure.clear();
        Random random=new Random();
        int counter=0;
        double positive=5;
        double negative=10;
        double free=85;
        double tempcell=0;
        double modifikator=0;

        for (int i=0;i<way;i++) {
            counter = random.nextInt(100) + 1;
            if (i==50){
                adventure.add("Отдых");
            } else if(i==99) {
               adventure.add("Босс");
            } else if(i==149) {
                 adventure.add("Босс");
            }else if (i < 33) {
                if (counter <= positive) {
                    adventure.add("Положительное");
                    tempcell = (positive * 0.8);
                    positive -= tempcell;
                    negative += (tempcell / 2);
                    free += (tempcell / 2);
                } else if (counter > positive && counter < (negative + positive)) {
                    adventure.add("Отрицательное");
                    tempcell = (negative * 0.4);
                    negative -= tempcell;
                    positive += (tempcell / 2);
                    free += (tempcell / 2);
                } else if (counter >= (negative + positive)) {
                    adventure.add("Нейтральное");
                    tempcell = (free * 0.2);
                    free -= free;
                    negative += (tempcell / 2);
                    positive += (tempcell / 2);
                }
            } else if (i >= 33 & i < 67) {
                if (counter <= positive) {
                    adventure.add("Положительное");
                    tempcell = (positive * 0.9);
                    positive -= tempcell;
                    negative += (tempcell / 2);
                    free += (tempcell / 2);
                } else if (counter > positive && counter < (negative + positive)) {
                    adventure.add("Отрицательное");
                    tempcell = (negative * 0.3);
                    negative -= tempcell;
                    positive += (tempcell / 2);
                    free += (tempcell / 2);
                } else if (counter >= (negative + positive)) {
                    adventure.add("Нейтральное");
                    tempcell = (free * 0.4);
                    free -= free;
                    negative += (tempcell / 2);
                    positive += (tempcell / 2);
                }
            }else if(i>=67&i<149) {
                if (counter <= positive) {
                    adventure.add("Положительное");
                    tempcell = positive;
                    positive -= tempcell;
                    negative += (tempcell / 2);
                    free += (tempcell / 2);
                } else if (counter > positive && counter < (negative + positive)) {
                    adventure.add("Отрицательное");
                    tempcell = (negative * 0.15);
                    negative -= tempcell;
                    positive += (tempcell / 2);
                    free += (tempcell / 2);
                } else if (counter >= (negative + positive)) {
                    adventure.add("Нейтральное");
                    tempcell = (free * 0.6);
                    free -= free;
                    negative += (tempcell / 2);
                    positive += (tempcell / 2);
                }
            }
        }
        return adventure;
    }
}
