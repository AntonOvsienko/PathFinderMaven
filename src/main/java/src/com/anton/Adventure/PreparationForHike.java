package src.com.anton.Adventure;

import src.com.anton.FightAlgorithm;
import src.com.anton.Location.Shop;
import src.com.anton.Player;
import src.com.anton.Routine.ChoosePlayer;
import src.com.anton.Routine.DataInput;
import src.com.anton.Routine.Equip;
import src.com.anton.Visual;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class PreparationForHike {
    Output output;
    Input input;

    public static void Preparation(List<Player> player) throws InterruptedException, FileNotFoundException {
        int pointer = 0;
        int choice=0;
        LinkedList<String> listAdventure=new LinkedList<String>();
        Output output;
        Input input;
        Thread thrd1;
        Thread thrd2;
        ReentrantLock locker=new ReentrantLock();


        while(true){
            System.out.println("Выберите действие:");
            System.out.println("1.Посмотреть инвентарь/Переодеть");
            System.out.println("2.Зайти в лавку");
            System.out.println("3.Посмотреть экипировку бойцов");
            System.out.println("4.В путь");

            pointer = DataInput.InputInteger();
            if (pointer == 1){
                System.out.println("Какого персонажа хотите посмотреть?");
                choice= ChoosePlayer.Choose(player);
                Visual.MyInventar(player.get(choice));
                Equip.Equipment(player.get(choice));
                }else if (pointer == 2){
                Shop.ShopChoice(player.get(0));
                }else if (pointer == 3){
                Visual.BattleVisual(player);
                }else if (pointer ==4){
                    break;
            }
        }

        while(true){
            System.out.println("Выберите сложность:");
            System.out.println("1.Легкая прогулка");
            System.out.println("2.Серьёзное превозмогание");
            System.out.println("3.Вернуться к подготовке");
            pointer = DataInput.InputInteger();
            if (pointer == 1){
                output=new Output(player,listAdventure,100);
                input=new Input(listAdventure,100);
                thrd1 = new Thread(input);
                thrd2 = new Thread(output);

                thrd1.start();
                thrd2.start();

                thrd1.join();
                thrd2.join();

                break;
            }else if (pointer == 2){
                output=new Output(player,listAdventure,150);
                input=new Input(listAdventure,150);
                thrd1 = new Thread(input);
                thrd2 = new Thread(output);

                thrd1.start();
                thrd2.start();

                thrd1.join();
                thrd2.join();

                break;
            }else if (pointer == 3){
                Preparation(player);
            }
        }
    }
}

class Output implements Runnable {
    List<Player> player;
    LinkedList<String> listAdventure;
    int way;

    Output(List<Player> player, LinkedList<String> listAdventure, int way) {
        this.player = player;
        this.listAdventure = listAdventure;
        this.way = way;
    }

    public void Output() throws FileNotFoundException {
        double dangerlabel = 10;
        String reflaction;

        synchronized (listAdventure){
        for (int i = 0; i < way; i++) {
            while (listAdventure.size() == 0) {
                try {
                    listAdventure.wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            reflaction = listAdventure.pollFirst();
            if (i % 10 == 0) {

            }
            if (reflaction.equalsIgnoreCase("Положительное")) {
                System.out.println((i + 1) + "/" + way);
                System.out.println("Положительное действо");
            } else if (reflaction.equalsIgnoreCase("Отрицательное")) {
                System.out.println((i + 1) + "/" + way);
                System.out.println("Отрицательное действо");
                FightAlgorithm.Fight(player,EnemyList.List(dangerlabel,player));
                dangerlabel *= 0.1;
            } else if (reflaction.equalsIgnoreCase("Босс")) {
                System.out.println((i + 1) + "/" + way);
                System.out.println("Босс");
//                scanner.nextLine();
            }
//            for (int с=0;с<30;с++){
//                System.out.println();
//            }
            System.out.println((i + 1) + "/" + way + " Уровень угрозы-" + dangerlabel);
            dangerlabel += (i * 0.05);
            listAdventure.notify();
        }
        }
    }

    @Override
    public void run() {
        try {
            Output();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Input implements Runnable{
    LinkedList<String> listAdventure;
    int way;
    Random random=new Random();
    int counter=0;
    double positive=5;
    double negative=10;
    double free=85;
    double tempcell=0;
    double modifikator=0;


    Input (LinkedList<String> listAdventure,int way){
    this.listAdventure=listAdventure;
    this.way=way;

    }

    public void Lvl() {
        synchronized (listAdventure) {
            for (int i = 0; i < way; i++) {
                while (listAdventure.size() > 5) {
                    try {
                        listAdventure.wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                counter = random.nextInt(100) + 1;
                if (i == 50) {
                    listAdventure.add("Отдых");
                } else if (i == 99) {
                    listAdventure.add("Босс");
                } else if (i == 149) {
                    listAdventure.add("Босс");
                } else {
                    if (counter <= positive) {
                        listAdventure.add("Положительное");
                        tempcell = (positive * 0.8);
                        positive -= tempcell;
                        negative += (tempcell / 2);
                        free += (tempcell / 2);
                    } else if (counter > positive && counter < (negative + positive)) {
                        listAdventure.add("Отрицательное");
                        tempcell = (negative * 0.4);
                        negative -= tempcell;
                        positive += (tempcell / 2);
                        free += (tempcell / 2);
                    } else if (counter >= (negative + positive)) {
                        listAdventure.add("Нейтральное");
                        tempcell = (free * 0.2);
                        free -= free;
                        negative += (tempcell / 2);
                        positive += (tempcell / 2);
                    }
                }
                listAdventure.notify();
            }
        }
    }
    @Override
    public void run() {
            Lvl();
    }
}

