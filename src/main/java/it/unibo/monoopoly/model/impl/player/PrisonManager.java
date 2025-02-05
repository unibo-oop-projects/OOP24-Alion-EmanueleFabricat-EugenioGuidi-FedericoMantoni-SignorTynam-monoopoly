package it.unibo.monoopoly.model.impl.player;

import it.unibo.monoopoly.model.api.player.Player;

/**
 * Il giocatore può uscire:
 * 1. Usando una carta "Esci Gratis di Prigione" se ne possiede almeno una.
 * 2. Pagando una multa fissa (ad esempio 50) se ha sufficiente denaro.
 */
public class PrisonManager {

    public static final int FINE_AMOUNT = 50;

    /**
     * Tenta di far uscire il giocatore dalla prigione.
     *
     * @param player il giocatore in prigione.
     * @return true se il giocatore esce dalla prigione, false altrimenti.
     */
    public boolean attemptExitPrison(Player player) {
        // Se il giocatore non è in prigione, non c'è nulla da fare.
        if (!player.isPrisoned()) {
            return true;
        }

        // 1. Se il giocatore possiede la carta "Esci Gratis", la usa ed esce.
        if (player.getFreeJailCards() > 0) {
            player.useGetOutOfJailCard();
            player.releaseFromPrison();
            return true;
        }

        // 2. Se il giocatore può pagare la multa, la paga ed esce.
        if (player.isPayable(FINE_AMOUNT)) {
            player.pay(FINE_AMOUNT);
            player.releaseFromPrison();
            return true;
        }

        // Altrimenti, il giocatore non riesce a uscire dalla prigione.
        return false;
    }
}
