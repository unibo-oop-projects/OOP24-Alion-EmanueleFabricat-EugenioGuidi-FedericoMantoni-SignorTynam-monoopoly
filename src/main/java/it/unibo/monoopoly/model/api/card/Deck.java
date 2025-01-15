package it.unibo.monoopoly.model.api.card;

public interface Deck {
    public void shuffleDeck();
    public Card draw(Player); 
}
