/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliverable_1;

/**
 *
 * @author navro
 */
public enum Suit {
    DIAMONDS("Diamonds", "D"),
    SPADES("Spades", "S"),
    CLUBS("Clubs", "C"),
    HEARTS("Hearts", "H");

    private String suitName;
    private String symbol;

    Suit(String suitName, String symbol){
        this.suitName = suitName;
        this.symbol = symbol;
    }

    /**
     *example HEARTS = H
     * @return shortHand of suit
     */
    public String getSymbol(){
        return this.symbol;
    }

    /**
     *example Hearts = Hearts
     * @return longHand of suit
     */
    public String getSuitName() {
        return this.suitName;
    }

    /**
     *example HEARTS = H
     * @return shortHand of suit
     */
    @Override
    public String toString() {
        return this.getSymbol();
    }

}
