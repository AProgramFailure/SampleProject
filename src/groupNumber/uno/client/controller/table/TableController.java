package groupNumber.uno.client.controller.table;

import groupNumber.uno.client.model.card.Card;
import groupNumber.uno.client.model.command.CommandRecord;
import groupNumber.uno.client.model.deck.constants.DeckConstants;
import groupNumber.uno.client.model.hand.Hand;
import groupNumber.uno.client.model.player.HumanPlayer;
import groupNumber.uno.client.model.player.base.Player;
import groupNumber.uno.client.model.table.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TableController {


    private Table table;

    public TableController(Table table){
        this.table = table;
    };

    public ArrayList<Player> moveUp(Player player) {
        try{
            ArrayList<Player> result = this.table.getPlayers();
            int lastPlayerIndex = result.indexOf(player) + 1;
            if(lastPlayerIndex + 1 == result.size() ){
                lastPlayerIndex = 0;
            }
            Collections
                .swap(
                    result,
                    result.indexOf(player),
                    lastPlayerIndex
                );
            return result;
        } catch (IndexOutOfBoundsException e){
            System.out.println("Player position is going out of bounds");
        }
        return null;
    }

    /**
     * Moves the player down the move chain
     *
     * @param player the player to move
     * @return returns the new chain of turns
     */
    public ArrayList<Player> moveDown(Player player) {
        try{
            ArrayList<Player> result = this.table.getPlayers();
            int lastPlayerIndex = result.indexOf(player) - 1;
            if(lastPlayerIndex - 1 < 0 ){
                lastPlayerIndex = result.size() -1;
            }
            Collections
                .swap(
                    result,
                    result.indexOf(player),
                    lastPlayerIndex
                );
            return result;
        } catch (IndexOutOfBoundsException e){
            System.out.println("Player position is going out of bounds");
        }
        return null;
    }

    /**
     * Reverses the chain of turns
     *
     * @return returns the new chain of turns
     */

    public Player nextPlayer() {
        Player player = this.table.getCurrentPlayer();
        if(this.table.getDIRECTION() == 1){
            // current = 0 => 1 => 3
            // current = 1 => 2 => 2
            // current = 2 => 3 => 1
            this.table
                .setCurrentPlayer(
                    this.table
                        .getPlayers()
                        .get(
                            ((this.table
                                .getPlayers()
                                .indexOf(this.table
                                    .getCurrentPlayer()))+ 1) % this.table.getPlayers().size()));
        }
        else{
            // current = 3 => 2 => 2
            // current = 2 => 1 => 3
            if((this.table.getPlayers().indexOf(player) - 1) >= 0) {
                this.table
                    .setCurrentPlayer(this.table.getPlayers()
                        .get((this.table
                            .getPlayers().indexOf(player) - 1) % this.table.getPlayers().size()));
            }
            else {
                this.getTable()
                    .setCurrentPlayer(this.table
                        .getPlayers().get(this.table.getPlayers().size()-1));
            }
        }

        return player;
    }

    /**
     * Shuffle the chain of turns
     *
     * @param players chain of turns
     * @return returns the new chain of turns
     */
    public ArrayList<Player> shuffle(ArrayList<Player> players) {
        Collections.shuffle(players);
        return players;
    }

    /**
     * '
     * find the index of given player within the turn chain
     *
     * @param player player to find
     * @return returns the index of the found player
     */
    public int find(Player player) {
        return this.table.getPlayers().indexOf(player);
    }

    /**
     * Validates whether the turn chain is valid
     *
     * @param players turn chain to validate
     * @return true or false depending on whether the chain is valid or not
     */
    public boolean validate(ArrayList<Player> players) {
        return false;
    }

    public void reverse() {
        if(this.table.getDIRECTION() == 1){
            this.table.setDIRECTION(-1);
        }
        else {
            this.getTable().setDIRECTION(1);
        }

    }

    /**
     * method is responsible for the initial dealing of the cards
     */
    public void giveInitialCards() {
        for (Player player : this.table.getPlayers()){
            Hand handOfPlayer = player.getHand();
            for (int i = 0; i < 7; i++) {
                this.table.getDeck().draw(player);
                handOfPlayer.addCard(this.table.getDeck().draw(player));
            }
            player.setHand(handOfPlayer);
        }
    }

    /**
     * method is responsible for shuffling the deck of the game
     */
    public void shuffleDeck() {
        this.table.getDeck().shuffle();
    }

    /**
     * method is responsible for giving 2 cards to a given player
     *
     * @param player the player to give the cards to
     */
    public void giveTwo(Player player) {
        for (int i = 0; i < 2; i++) {
            System.out.println("hello");
            player.getHand().addCard(this.table.getDeck().draw(player));
        }
    }

    /**
     * method is responsible for giving 4 cards to a given player
     *
     * @param player the player to give the cards to
     */
    public void giveFour(Player player) {
        for (int i = 0; i < 2; i++) {
            player.getHand().addCard(this.table.getDeck().draw(player));
        }
    }

    /**
     * Method is responsible for updating the table based on user input
     *
     * @param commandRecord the record containing hte command that should be played
     */
    public void handleInput(CommandRecord commandRecord) {
        Boolean proper = false;
        switch(commandRecord.getCommand()) {
            case "d": {
                Card card = this.table.getDeck().draw(this.table.getCurrentPlayer());
                this.table.getCurrentPlayer().getHand().addCard(card);
                this.nextPlayer();
                break;
            }
            case"p": {
                Card playedCard = commandRecord.getRecord();
                Card lastCard = this.table.getDeck().getLastCardFromPlayingCards();
                if(playedCard.getColor().equals("black")){
                    String newColor = "";
                    while(!Arrays.asList(DeckConstants.COLORS).contains(newColor)) {
                        this.table.getTUI().warn("Available colors: blue, red, yellow, green");
                        this.table.getTUI().log("Choose a color: ");
                        newColor = this.table.getGame().getScanner().nextLine();
                    }

                    if(playedCard.getValue().contains("4")) {
                        playedCard.setCurrentColor(newColor);
                        this.table.getDeck().placeCard(playedCard);
                        this.table.getCurrentPlayer().getHand().removeCard(playedCard);
                        this.nextPlayer();
                        this.giveFour(this.getTable().getCurrentPlayer());
                    }
                    else{
                        playedCard.setCurrentColor(newColor);
                        this.table.getDeck().placeCard(playedCard);
                        this.table.getCurrentPlayer().getHand().removeCard(playedCard);
                        this.nextPlayer();

                    }
                    break;
                }

                if(lastCard.getCurrentColor().equals(playedCard.getColor()) || lastCard.getValue().equals(playedCard.getValue())){
                    if(playedCard.getValue().equals("reverse")){
                        this.reverse();
                        this.table.getDeck().placeCard(playedCard);
                        this.table.getCurrentPlayer().getHand().removeCard(playedCard);
                        this.nextPlayer();
                        break;
                    }
                    if(playedCard.getValue().equals("plus_two")){
                        this.table.getDeck().placeCard(playedCard);
                        this.table.getCurrentPlayer().getHand().removeCard(playedCard);
                        this.nextPlayer();
                        this.giveTwo(this.table.getCurrentPlayer());
                        break;
                    }
                    if(playedCard.getValue().equals("skip")){
                        this.table.getDeck().placeCard(playedCard);
                        this.table.getCurrentPlayer().getHand().removeCard(playedCard);
                        this.nextPlayer();
                        this.nextPlayer();
                        break;
                    }

                    this.table.getDeck().placeCard(playedCard);
                    this.table.getCurrentPlayer().getHand().removeCard(playedCard);
                    this.nextPlayer();

                } else {
                    if (this.table.getCurrentPlayer() instanceof HumanPlayer) {
                        System.out.println("You cannot place that card as either the color or the value do not match");
                        this.table.getTUI().log("Please enter a proper card:");
                    }
                    CommandRecord commandRecord1 = table.getCurrentPlayer().play();
                    handleInput(commandRecord1);

                }

            }
            case "ff": {
                this.table.getCurrentPlayer().setActive(false);
                this.nextPlayer();
                break;
            }

            case "q": {
                this.table.getGame().end();
                break;
            }
            default: {
                System.out.println("wrong command:");
                break;
            }
        }

    }
    public Table getTable() {
        return table;
    }
    public void setTable(Table table) {
        this.table = table;
    }
}
