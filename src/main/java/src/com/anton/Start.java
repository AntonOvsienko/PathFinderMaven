package src.com.anton;

import src.com.anton.Adventure.PreparationForHike;
import src.com.anton.ClassPlayer.*;
import src.com.anton.Inventory.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static src.com.anton.Inventory.Armor.*;
import static src.com.anton.Inventory.Weapon.*;


public class Start {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        List<Player> men = new ArrayList<>();
        PlayerInitialized.PartyInitial(men);
        PreparationForHike.Preparation(men);

    }
}
