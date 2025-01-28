package it.unibo.monoopoly.model.api.gameboard;

import java.util.Optional;

public interface Dices {

    class Pair {
        private final Integer firstRoll;
        private final Integer secondRoll;

        public Pair(Integer firstRoll, Integer secondRoll) {
            this.firstRoll = firstRoll;
            this.secondRoll = secondRoll;
        }

        public Integer getFirstRoll() {
            return this.firstRoll;
        }

        public Integer getSecondRoll() {
            return this.secondRoll;
        }
    }

    /*
     * create a pair of Integer random from 1 to 6.
     */
    Void rollDices();

    /**
     * 
     * @return dices rolled.
     */
    Optional<Pair> getDices();

}