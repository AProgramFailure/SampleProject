package groupNumber.uno.client.model.table;

import groupNumber.uno.client.controller.table.TableController;
import groupNumber.uno.client.model.command.CommandRecord;
import groupNumber.uno.client.model.deck.Deck;
import groupNumber.uno.client.model.game.Game;
import groupNumber.uno.client.model.player.base.Player;
import groupNumber.uno.client.model.table.contract.PlayerQueue;
import groupNumber.uno.client.model.table.contract.TableActions;
import groupNumber.uno.client.view.tui.table.TableTUI;

import java.util.ArrayList;

public class Table implements PlayerQueue<ArrayList<Player>, Player>, TableActions<Player> {
    private TableTUI TUI;
    private TableController controller;
    private ArrayList<Player> players;
    private Player currentPlayer;
    private Integer DIRECTION;
    private Deck deck;
    private ArrayList<Player> spectators;

    private Game game;



    public Table(ArrayList<Player> players) {
        if(players == null) {
            return;
        }
        if(players.size() < 4){
            return;
        }
        try {
            this.TUI = new TableTUI();
            this.DIRECTION = 1;
            this.players = players;
            this.deck = new Deck();
            this.spectators = null;
            this.currentPlayer  = this.players.get(0);
            this.deck.draw(this);
            this.controller = new TableController(this);
        } catch (Exception e){
            System.out.println("Improper arguments for Table");
        }

    }

    /**
     * Moves the player up the move chain
     *
     * @param player the player to move
     * @return returns the new chain of turns
     */
    @Override
    public ArrayList<Player> moveUp(Player player) {
        return this.controller.moveUp(player);
    }

    /**
     * Moves the player down the move chain
     *
     * @param player the player to move
     * @return returns the new chain of turns
     */
    @Override
    public ArrayList<Player> moveDown(Player player) {
        return this.controller.moveDown(player);
    }

    /**
     * Reverses the chain of turns
     *
     * @return returns the new chain of turns
     */
    @Override
    public Player nextPlayer() {
        return this.controller.nextPlayer();
    }

    /**
     * Shuffle the chain of turns
     *
     * @param players chain of turns
     * @return returns the new chain of turns
     */
    @Override
    public ArrayList<Player> shuffle(ArrayList<Player> players) {
        return this.controller.shuffle(players);
    }

    /**
     * '
     * find the index of given player within the turn chain
     *
     * @param player player to find
     * @return returns the index of the found player
     */
    @Override
    public int find(Player player) {
        return this.controller.find(player);
    }

    /**
     * Validates whether the turn chain is valid
     *
     * @param players turn chain to validate
     * @return true or false depending on whether the chain is valid or not
     */
    @Override
    public boolean validate(ArrayList<Player> players) {
        return false;
    }

    public Deck getDeck() {
        return deck;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void reverse() {
        this.controller.reverse();
    }

    @Override
    public String toString(){
        String result = "The last card on the draw pile is : ";
        result += this.deck.getLastCardFromPlayingCards();

        return result;
    }

    /**
     * method is responsible for the initial dealing of the cards
     */
    @Override
    public void giveInitialCards() {
        this.controller.giveInitialCards();
    }

    /**
     * method is responsible for shuffling the deck of the game
     */
    @Override
    public void shuffleDeck() {
        this.controller.shuffleDeck();
    }

    /**
     * method is responsible for giving 2 cards to a given player
     *
     * @param player the player to give the cards to
     */
    @Override
    public void giveTwo(Player player) {
        this.controller.giveTwo(player);
    }

    /**
     * method is responsible for giving 4 cards to a given player
     *
     * @param player the player to give the cards to
     */
    @Override
    public void giveFour(Player player) {
        this.controller.giveFour(player);
    }

    /**
     * Method is responsible for updating the table based on user input
     *
     * @param commandRecord the record containing hte command that should be played
     */
    @Override
    public void handleInput(CommandRecord commandRecord) {
        this.controller.handleInput(commandRecord);
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Integer getDIRECTION() {
        return DIRECTION;
    }

    public void setDIRECTION(Integer DIRECTION) {
        this.DIRECTION = DIRECTION;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public ArrayList<Player> getSpectators() {
        return spectators;
    }

    public void setSpectators(ArrayList<Player> spectators) {
        this.spectators = spectators;
    }

    public TableTUI getTUI() {
        return TUI;
    }

    public void setTUI(TableTUI TUI) {
        this.TUI = TUI;
    }
}

