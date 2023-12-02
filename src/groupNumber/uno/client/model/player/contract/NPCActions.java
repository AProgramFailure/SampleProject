package groupNumber.uno.client.model.player.contract;

import java.util.Map;
import java.util.Random;

public interface NPCActions {
    default <T> T getRandomItem(Map<T, Double> chances) {
        Random rand = new Random();

        double chance = rand.nextDouble() * 100.0;
        double cumulative = 0.0;
        for (T item: chances.keySet()) {
            cumulative += chances.get(item);
            if (chance < cumulative)
                return item;
        }
        throw new IllegalStateException("chances don't sum to 100");
    }
}