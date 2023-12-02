package groupNumber.uno.client.model.player.constants;

import java.util.HashMap;

public final class PlayerConstants {

    private  PlayerConstants(){};

    public static final String DRAW = "d";

    public static final String PLAY = "p";

    public static final String SURRENDER = "ff";

    public static final String QUIT = "q";
    public static final HashMap<String, Double> CHANCES = generateChances();

    public static final String[] FIRST_NAMES = {"Alex", "Leon", "Anton", "Lina", "Asen", "Eva", "Mariela"};
    public static final String[] LAST_NAMES = {"Condu", "De Vries", "Tsankov", "Costea", "Pantov", "Stoica", "Banov"};

    private static HashMap<String, Double> generateChances(){
        HashMap<String, Double> result = new HashMap<>();

        result.put("p", 45.0);
        result.put("d", 45.0);
        result.put("ff", 9.0);
        result.put("q", 1.0);
        return result;
    }


}
