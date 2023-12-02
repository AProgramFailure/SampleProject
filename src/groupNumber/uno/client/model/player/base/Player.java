package groupNumber.uno.client.model.player.base;

import groupNumber.uno.client.model.hand.Hand;
import groupNumber.uno.client.model.player.contract.PlayerActions;

public abstract class Player implements PlayerActions {

    private String name;
    private String lastName;
    private Hand hand;
    private boolean active;

    public Player(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.hand = new Hand(this);
        this.active = true;
    }

    public Hand getHand() {
        return hand;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    @Override
    public String toString(){
        return name + " " + lastName;
    }
}
