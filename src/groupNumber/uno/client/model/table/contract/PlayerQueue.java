package groupNumber.uno.client.model.table.contract;

import groupNumber.uno.client.model.player.base.Player;

import java.util.Collection;

public interface PlayerQueue<T extends Collection<Player>, U >{

    /**
     * Moves the player up the move chain
     * @param u the player to move
     * @return returns the new chain of turns
     */
    T moveUp(U u);

    /**
     * Moves the player down the move chain
     * @param u the player to move
     * @return returns the new chain of turns
     */
    T moveDown(U u);

    /**
     * Reverses the chain of turns
     * @return returns the new chain of turns
     */
    U nextPlayer();

    /**
     * Shuffle the chain of turns
     * @param t chain of turns
     * @return returns the new chain of turns
     */
    T shuffle(T t);

    /**'
     *  find the index of given player within the turn chain
     * @param u player to find
     * @return returns the index of the found player
     */
    int find(U u);

    /**
     * Validates whether the turn chain is valid
     * @param t turn chain to validate
     * @return true or false depending on whether the chain is valid or not
     */
    boolean validate(T t);


}
