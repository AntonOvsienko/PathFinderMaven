package src.com.anton.TextBattle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class HitSuccess {
    public static String hit() throws FileNotFoundException {
        Random random = new Random();
        File file = new File("D:\\Java\\PathFinderMaven\\src\\main\\resources\\hitSuccess");
        Scanner scanner = new Scanner(file);
        List<String> hitSuc = new ArrayList<>();
        while (scanner.hasNextLine()) {
            hitSuc.add(scanner.nextLine());
        }
        return hitSuc.get(random.nextInt(hitSuc.size()));
    }

    public static String nohit() throws FileNotFoundException {
        Random random = new Random();
        File file = new File("D:\\Java\\PathFinderMaven\\src\\main\\resources\\hitlose");
        Scanner scanner = new Scanner(file);
        List<String> hitSuc = new ArrayList<>();
        while (scanner.hasNextLine()) {
            hitSuc.add(scanner.nextLine());
        }
        return hitSuc.get(random.nextInt(hitSuc.size()));
    }
}

