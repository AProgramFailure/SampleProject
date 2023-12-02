package groupNumber.uno.client.model.game;

import groupNumber.uno.client.controller.game.base.PlayingMode;
import groupNumber.uno.client.model.player.base.Player;
import groupNumber.uno.client.model.table.Table;

import java.util.ArrayList;
import java.util.Scanner;

public class Game{

    private Table table;
    private PlayingMode mode;
    private boolean OVER;
    private Scanner scanner;
    /**
     *  Creates a game and starts it
     * @param e Mode for the game
     * @param players the players for the game
     * @param <E> An available extension of the playing mode abstract class
     */
    public <E extends PlayingMode> Game(E e, ArrayList<Player> players){
        this.mode = e;
        this.mode.setGame(this);
        this.table = new Table(players);
        this.table.setGame(this);
        this.OVER = false;
        this.scanner = new Scanner(System.in);
        this.mode.start();

    }

    public PlayingMode getMode() {
        return mode;
    }

    public void setMode(PlayingMode mode) {
        this.mode = mode;
    }

    public Table getTable() {
        return table;
    }
    public boolean isOver(){
        return this.OVER;
    }

    public void end(){
        this.OVER = true;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Scanner getScanner() {
        return scanner;
    }
}

