package groupNumber.uno.client.controller.game.base;

import groupNumber.uno.client.model.game.Game;
import groupNumber.uno.client.view.tui.game.GameTUI;
import groupNumber.uno.client.view.tui.player.PlayerTUI;
import groupNumber.uno.client.view.tui.table.TableTUI;

import java.util.Scanner;

public abstract class PlayingMode {
    private Game game;

    protected TableTUI tableTUI;
    protected GameTUI gameTUI;
    protected PlayerTUI personTUI;
    /**
     * Method starts the game
     */
    public abstract void start();

    /**
     * Method finishes the game
     */
    public abstract void finish();

    /**
     * Method updates the game
     */
    public abstract void update();

    /**
     * Method aborts the game for all players
     */
    public abstract void abort();

    /**
     * Method is responsible for printing the overall UI of the game
     */
    public void printCurrentGameState(){
        Scanner scanner = new Scanner(System.in);
        gameTUI.log("Player: <" + getGame().getTable().getCurrentPlayer().toString() + "> plays :] \n");
        tableTUI.printState(getGame().getTable().toString()+ "\n\n");
        gameTUI.log("What would be your choice? ");
        tableTUI.warn("Current Last colour of card is " + this.game.getTable().getDeck().getLastCardFromPlayingCards().getCurrentColor().toUpperCase());
        personTUI.log(getGame().getTable().getCurrentPlayer().getHand().toString());
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
