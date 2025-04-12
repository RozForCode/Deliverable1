/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliverable_1;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author navro
 */
public class WarGame extends Game{
    
    private GamePlayer player1;
    private GamePlayer player2;
    private static final PrintUtil printUtil = new PrintUtil();
    private Deck deck;
    public WarGame(String name1, String name2){
        super("WarGame");
        this.player1 = new GamePlayer(name1, new Hand());
        this.player2 = new GamePlayer(name2, new Hand());
    }
    @Override
    public void play(){
        printUtil.openingMessage();
        printUtil.symbolMeaning();
        deck = new Deck();
        deck.shuffleDeck();
        dealCards(player1.getHand());
        dealCards(player2.getHand());
        
        int maxRounds = 24;
        Player winner = null;
        Scanner round = new Scanner(System.in);
        
        int i = 2;
        while (battle(player1, player2, null)) {
            maxRounds--;
            // check hands for winner
            if (player1.getHand().handSize() == 0) {

                winner = player2;
                break;
            } else if (player2.getHand().handSize() == 0) {

                // player is winner
                winner = player1;
                break;
            }

            if (maxRounds < 0) {
                break;
            }
            // player1 - input
            System.out.print(player1.getName()+" press enter to play or no to exit round "+i+" :");
            String n = round.nextLine();
            if("no".equals(n)){
                break;
            }
            //player2 - intput
            System.out.print(player2.getName()+" press enter to play or no to exit round "+i+" :");
            n = round.nextLine();
            if("no".equals(n)){
                break;
            }
            i++;
            
        }
        if (winner != null) {

            // someone won
        } else if (player1.getHand().handSize() > player2.getHand().handSize()) {
            winner = player1;
        } else if (player2.getHand().handSize() > player1.getHand().handSize()) {
            winner = player2;
        } else {

            // draw print statement
            printUtil.announceDraw();
            return;
        }
        // game winner statment
        printUtil.announceGameWinner(winner);

    }
    @Override
    public void declareWinner(){
        
    }
    public void dealCards(Hand hand) {
        for (int i = 0; i < 26; i++) {
            hand.addCardToTop(deck.dealCard());
        }
    }
    public boolean battle(GamePlayer playerOne, GamePlayer playerTwo, Hand pot) {
        printUtil.printPlayerStatus(playerOne,playerTwo);

        // both players show top card from deck, each player draws from top of deck
        //store cards that are in play in an array.
        WarCard playerOneFaceUp = playerOne.getHand().removeCardFromTop();
        if (playerOneFaceUp == null) {
            return false;
        }

        WarCard playerTwoFaceUp = playerTwo.getHand().removeCardFromTop();
        if (playerTwoFaceUp == null) {
            return false;
        }

        //In case of war each player adds 3 cards to pot and the forth card is evaluated
        if (pot == null) {
            pot = new Hand();
        }
        pot.addCardToTop(playerOneFaceUp);
        pot.addCardToTop(playerTwoFaceUp);

        int result = playerOneFaceUp.compareTo(playerTwoFaceUp);
        switch (result) {
            case 0 -> {
                // printUtil.announceWarRound();
                // print statement for starting war
                //each player adds three cards to the prize hand
                List<WarCard> warPlayerOnePot = playerOne.getHand().take(3);
                if (warPlayerOnePot == null) {
                    return false;
                }
                pot.addCardsToTop(warPlayerOnePot);

                List<WarCard> warPlayerTwoPot = playerTwo.getHand().take(3);
                if (warPlayerTwoPot == null) {
                    return false;
                }
                pot.addCardsToTop(warPlayerTwoPot);

                return battle(playerOne, playerTwo, pot);
            }
            case 1 -> {
                //Give all cards on table to player 1
                //player1 adds both face up cards to bottom of her deck
                playerOne.getHand().mergeHand(pot);
                
                // print statement for round winner  for player1
                printUtil.announceRoundWinner(playerOne, playerOneFaceUp, playerTwo, playerTwoFaceUp, playerOne.getName());
            }
            case -1 -> {
                //Give all cards on table to player 2
                //player2 adds both face up cards to bottom of his deck
                // print statement for round winner  for player1
                playerTwo.getHand().mergeHand(pot);
                printUtil.announceRoundWinner(playerOne, playerOneFaceUp, playerTwo, playerTwoFaceUp, playerTwo.getName());
            }
        }
        return true;
    }
}