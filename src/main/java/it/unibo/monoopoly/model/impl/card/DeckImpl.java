package it.unibo.monoopoly.model.impl.card;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.unibo.monoopoly.model.api.card.Card;
import it.unibo.monoopoly.model.api.card.CardsFactory;
import it.unibo.monoopoly.model.api.card.Deck;
import it.unibo.monoopoly.model.api.player.Player;

public class DeckImpl implements Deck{
    private final CardsFactory factory = new CardsFactoryImpl();
    private List<Card> deck = new LinkedList<>();
    private Set<Card> discardPile = new HashSet<>();
    private Card actualCard;

    public DeckImpl() {
        this.deck.addAll(factory.createDeck());
        shuffleDeck();
    }
    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public void draw(Player player) {
        if (this.deck.isEmpty()) {
            this.shuffleDeck();
        }
        this.actualCard = this.deck.removeFirst();
        this.discardPile.add(actualCard);
    }

    private void shuffleDeck() {
        if (this.deck.isEmpty()) {
            this.deck.addAll(this.discardPile);
            this.discardPile.removeAll(this.discardPile);
        }        
        Collections.shuffle(this.deck);
    }
    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public Card getActualCard() {
        return this.actualCard;
    }

}
