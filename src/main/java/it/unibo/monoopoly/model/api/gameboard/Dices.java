package it.unibo.monoopoly.model.api.gameboard;

/**
 * This interface rapresents dices to be used from the player in the game.
 */
public interface Dices {

    /**
     * This inner class rapresent the effective couple of dices.
     */
    class Pair {
        private final Integer firstRoll;
        private final Integer secondRoll;

        /**
         * constructor of Pair.
         * @param firstRoll
         * @param secondRoll
         */
        public Pair(final Integer firstRoll, final Integer secondRoll) {
            this.firstRoll = firstRoll;
            this.secondRoll = secondRoll;
        }

        /**
         * @return the roll of first dice.
         */
        public Integer getFirstRoll() {
            return this.firstRoll;
        }

        /**
         * @return the roll of second dice.
         */
        public Integer getSecondRoll() {
            return this.secondRoll;
        }
    }

    /**
     * create a pair of Integer random from 1 to 6.
     */
    void rollDices();

    /**
     * 
     * @return dices rolled.
     */
    Pair getDices();

    /**
     * 
     * @return sum of two dices.
     */
    int getResult();

}
