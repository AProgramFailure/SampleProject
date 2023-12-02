package groupNumber.uno.client.model.player;

import groupNumber.uno.client.model.command.CommandRecord;
import groupNumber.uno.client.model.hand.Hand;
import groupNumber.uno.client.model.player.base.Player;
import groupNumber.uno.client.model.player.constants.PlayerConstants;
import groupNumber.uno.client.model.player.contract.NPCActions;

import java.util.Random;

public class ComputerPlayer extends Player implements NPCActions {
    private static final Random random = new Random();
    public ComputerPlayer() {
        super(
            PlayerConstants.FIRST_NAMES[random.nextInt(7)],
            PlayerConstants.LAST_NAMES[random.nextInt(7)]);
    }

    /**
     * Defines how the player can act
     */
    @Override
    public CommandRecord play() {
        Hand hand_of_player = super.getHand();
        int card_to_play = (int)(Math.random() * hand_of_player.getCards().size());
        String move = getRandomItem(PlayerConstants.CHANCES);

        if(move.equals("p")){
            return new CommandRecord("p", hand_of_player.getCards().get(card_to_play));
        }
        return new CommandRecord(move);
    }

    /**
     * Defines how the player draws a card
     */
    @Override
    public void draw() {

    }

    /**
     * Describes how a given message is printed from the name of the player
     *
     * @param message the message ot be printed
     */
    @Override
    public void message(String message) {

    }
}
