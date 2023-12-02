package groupNumber.uno.client.model.hand;

import groupNumber.uno.client.model.card.Card;
import groupNumber.uno.client.model.player.base.Player;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;
    private Player player;

    private Hand(){}

    public Hand(Player player){
        this.player = player;
        this.cards = new ArrayList<>();

    }
    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card c){
        this.cards.add(c);
    }

    public void addCard(ArrayList<Card> c){
        this.cards.addAll(c);
    }

    public void removeCard(Card c){
        this.cards.remove(c);
    }

    public void removeCard(ArrayList<Card>c){
        this.cards.removeAll(c);
    }

    public Player getPlayer() {
        return player;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return this.cards.toString();
    }
}
