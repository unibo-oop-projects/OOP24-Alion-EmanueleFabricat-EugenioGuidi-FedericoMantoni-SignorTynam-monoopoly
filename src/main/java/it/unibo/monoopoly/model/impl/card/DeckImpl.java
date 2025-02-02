package it.unibo.monoopoly.model.impl.card;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import it.unibo.monoopoly.model.api.card.Card;
import it.unibo.monoopoly.model.api.card.Deck;
import it.unibo.monoopoly.model.api.player.Player;

public class DeckImpl  implements Deck{
    List<Card> deck = new LinkedList<>();
    Set<Card> discardPile = new HashSet<>();

    @Override
    public void shuffleDeck() {
        this.deck.addAll(this.discardPile);
        this.discardPile.removeAll(this.discardPile);
        Collections.shuffle(this.deck);
    }

    @Override
    public void draw(Player player) {
        /*if (this.deck.isEmpty()) {
            this.shuffleDeck();
        }*/
        this.deck.removeFirst();
    }

}
