package src.com.anton;

import src.com.anton.Adventure.PreparationForHike;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        List<Player> men = new ArrayList<>();
        PlayerInitialized.PartyInitial(men);
        PreparationForHike.Preparation(men);

    }
}
