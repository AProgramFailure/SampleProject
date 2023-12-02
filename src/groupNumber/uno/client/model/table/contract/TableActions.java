package groupNumber.uno.client.model.table.contract;

import groupNumber.uno.client.model.command.CommandRecord;
import groupNumber.uno.client.model.player.base.Player;

public interface TableActions<U extends Player> {

    /**
     * method is responsible for the initial dealing of the cards
     */
    void giveInitialCards();

    /**
     * method is responsible for shuffling the deck of the game
     */
    void shuffleDeck();

    /**
     * method is responsible for giving 2 cards to a given player
     * @param u the player to give the cards to
     */
    void giveTwo(U u);

    /**
     *  method is responsible for giving 4 cards to a given player
     * @param u the player to give the cards to
     */
    void giveFour(U u);

    /**
     *  Method is responsible for updating the table based on user input
     * @param commandRecord the record containing hte command that should be played
     */
    void handleInput(CommandRecord commandRecord);
}
