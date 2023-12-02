package groupNumber.uno.client.model.player.contract;


import groupNumber.uno.client.model.command.CommandRecord;

public interface PlayerActions {

    /**
     * Defines how the player can act
     */
    CommandRecord play();

    /**
     * Defines how the player draws a card
     */
    void draw();

    /**
     * Describes how a given message is printed from the name of the player
     * @param message the message ot be printed
     */
    void message(String message);
}
