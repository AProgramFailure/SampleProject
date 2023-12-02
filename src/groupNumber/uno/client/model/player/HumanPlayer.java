package groupNumber.uno.client.model.player;

import groupNumber.uno.client.model.card.Card;
import groupNumber.uno.client.model.command.CommandRecord;
import groupNumber.uno.client.model.player.base.Player;

import java.util.Scanner;

public class HumanPlayer extends Player {


    public HumanPlayer(String name, String lastName) {
        super(name, lastName);
    }

    /**
     * Defines how the player can act
     */
    @Override
    public CommandRecord play() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter command |>");
        String[] input = scanner.nextLine().split(" ");

        while((input[0].equals("p") && input.length < 2)) {
            System.out.println("please enter a valid command: ");
            input = scanner.nextLine().split(" ");
        }
        switch (input[0]){
            case "p": {
                Card card = getHand().getCards().get(Integer.parseInt(input[1]) -1);
                return new CommandRecord(input[0], card);
            }
            default: {
                return new CommandRecord(input[0]);
            }
        }
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
