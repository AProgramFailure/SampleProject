package groupNumber.uno.client.controller.game.mode;

import groupNumber.uno.client.controller.game.base.PlayingMode;
import groupNumber.uno.client.model.command.CommandRecord;
import groupNumber.uno.client.model.game.contract.Quick;
import groupNumber.uno.client.view.tui.game.GameTUI;
import groupNumber.uno.client.view.tui.player.PlayerTUI;
import groupNumber.uno.client.view.tui.table.TableTUI;

public class QuickUnoMode extends PlayingMode implements Quick {


    public QuickUnoMode(){
        this.tableTUI = new TableTUI();
        this.gameTUI = new GameTUI();
        this.personTUI = new PlayerTUI();
    }
    /**
     * Method starts the game
     */
    @Override
    public void start() {
        this.gameTUI.log("Let the Game Begin");
        super
            .getGame()
            .getTable()
            .giveInitialCards();


        this.gameTUI
            .log(
                super
                    .getGame()
                    .getTable()
                    .getDeck()
                    .toString());

        while(!super.getGame().isOver()){
            this.printCurrentGameState();

            CommandRecord commandRecord = super
                .getGame()
                .getTable()
                .getCurrentPlayer()
                .play();

            super
                .getGame()
                .getTable()
                .handleInput(commandRecord);
        }
    }
    /**
     * Method finishes the game
     */
    @Override
    public void finish() {

    }

    /**
     * Method updates the game
     */
    @Override
    public void update() {

    }

    /**
     * Method aborts the game for all players
     */
    @Override
    public void abort() {

    }
}
