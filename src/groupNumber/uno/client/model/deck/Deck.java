package groupNumber.uno.client.model.deck;

import groupNumber.uno.client.model.card.Card;
import groupNumber.uno.client.model.deck.constants.DeckConstants;
import groupNumber.uno.client.model.deck.contract.DeckActions;
import groupNumber.uno.client.model.player.base.Player;
import groupNumber.uno.client.model.table.Table;

import java.util.*;

public class Deck implements DeckActions<List<String>, List<String>> {

    private HashMap<String, ArrayList<Card>> cards;

    private ArrayList<Card> playingCards;

    private  ArrayList<Card> usedCards;

    private ArrayList<Card> cardsInPlayers;

    public Deck(){

        this.cards = new HashMap<>();
        this.playingCards = new ArrayList<>();
        this.usedCards = new ArrayList<>();
        this.cardsInPlayers = new ArrayList<>();
        this.cards = generateCardValues(
            Arrays.asList(DeckConstants.COLORS),
            Arrays.asList(DeckConstants.VALUES));
        this.playingCards = generatePlayingCard(this.cards);
        System.out.println(playingCards.size());
    }

    /**
     * Draws a card from the top of deck
     *
     * @return returns the top card from the deck
     */
    @Override
    public <T> Card draw(T t) {

        if(t instanceof Table){
            if(this.playingCards.size() > 4) {
                Card card = this.playingCards.get(this.playingCards.size() - 1);
                this.playingCards.remove(card);
                this.usedCards.add(card);
                return card;
            }
            else{
                this.swap();
                return  this.draw(this);
            }
        }
        else if ( t instanceof Player){
            if(this.playingCards.size() > 4) {
                Card card = this.playingCards.get(this.playingCards.size() - 1);
                this.playingCards.remove(card);
                this.cardsInPlayers.add(card);
                return card;
            }
            else{
                this.swap();
                return  this.draw(this);
            }
        }
        return null;
    }

    /**
     * Swaps the played cards with the active cards
     *
     * @return returns the new active cards
     */
    @Override
    public ArrayList<Card> swap() {
        ArrayList<Card> temp = this.usedCards;
        this.usedCards = playingCards;
        this.playingCards = temp;


        return this.playingCards;
    }

    /**
     * Gets the last card from the cards on the pile that had already been drawn
     *
     * @return returns the last card
     */
    @Override
    public Card getLastCardFromPlayingCards() {
        return this.usedCards.get(this.usedCards.size() -1);
    }

    /**
     * Method is responsible for shuffling the cards
     */
    @Override
    public void shuffle() {
        Collections.shuffle(this.playingCards);
    }

    /**
     * Method is responsible for placing the card on top of the already played cards
     *
     * @param card card to be placed
     */
    @Override
    public void placeCard(Card card) {
        this.cardsInPlayers.remove(card);
        this.usedCards.add(card);
    }

    @Override
    public String toString(){
        return this.playingCards.toString();
    }
}
