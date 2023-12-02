package groupNumber.uno.client.model.deck.contract;

import groupNumber.uno.client.model.card.Card;
import groupNumber.uno.client.model.deck.constants.DeckConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public interface DeckActions<C extends Iterable<String>, V extends Iterable<String>> {

    /**
     *  Generates cards for the deck
     * @param colors the possible colors for the cards
     * @param values the possible values for the cards
     * @return a hashmap containing all cards with their possible values of difference
     */
    default HashMap<String, ArrayList<Card>> generateCardValues(C colors, V values){
        HashMap<String, ArrayList<Card>> result = new HashMap<>();

        for (String color: colors) {
            ArrayList<Card> cardsOfColor = new ArrayList<>();

            for(String value : values){
                Card card = new Card(color, value);
                if(value.equals("0")){
                    cardsOfColor.add(card);
                    continue;
                }
                cardsOfColor.add(card);
                cardsOfColor.add(card);
            }
            result.put(color, cardsOfColor);
        }

        for (int i = 0; i < 2; i++) {
            ArrayList<Card> wildCards = new ArrayList<>();

            for (String wild: DeckConstants.WILD_CARDS) {
                wildCards.add(new Card("black", wild));
                wildCards.add(new Card("black", wild));
                wildCards.add(new Card("black", wild));
                wildCards.add(new Card("black", wild));
            }
            result.put("black", wildCards);
        }

        return result;
    };

    /**
     * Method puts all generated card values into a ready ot use deck
     * @param cards possible variation of cards
     * @return returns a deck to be played
     */
    default ArrayList<Card> generatePlayingCard(HashMap<String, ArrayList<Card>> cards){
        ArrayList<Card> result = new ArrayList<>();

        for(String key: cards.keySet()){
            result.addAll(cards.get(key));

        }

        for (int i = 0; i < 2; i++) {
            Collections.shuffle(result);
        }

        return result;
    };

    /**
     * Draws a card from the top of deck
     * @return returns the top card from the deck
     */
    <T> Card draw(T t);

    /**
     * Swaps the played cards with the active cards
     * @return returns the new active cards
     */
    ArrayList<Card> swap();

    /**
     *  Gets the last card from the cards on the pile that had already been drawn
     * @return returns the last card from the playing cards;
     */
    Card getLastCardFromPlayingCards();

    /**
     * Method is responsible for shuffling the cards
     */
    void shuffle();

    /**
     *  Method is responsible for placing the card on top of the already played cards
     * @param card card to be placed
     */
    void placeCard(Card card);


}

