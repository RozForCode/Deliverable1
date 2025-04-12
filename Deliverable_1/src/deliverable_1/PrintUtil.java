/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliverable_1;

/**
 *
 * @author navro
 */
public class PrintUtil {

    public void openingMessage() {
        System.out.println("It's a war of cards!\n" +
                "This Game is automated and will play until one deck is empty or the game reaches 27 rounds.\n");
        System.out.println("Indicate that you are ready by hitting enter.");
    }

    public void startGameMessage(Player player) {
        System.out.printf("%s ,let's Play!\n", player.getName());
    }

    public void printRoundHeader(Player playerOne, Player playerTwo) {
        String header = "#CardsInHand";
        String winner = "Round Winner";
        System.out.printf("%-20s %-20s %-20s %-20s %-20s \n", playerOne.getName(), header, playerTwo.getName(), header, winner);
    }
    
    // status
    public void printPlayerStatus(GamePlayer playerOne, GamePlayer playerTwo) {
        int header1 = playerOne.getHand().handSize();
        int header2 = playerTwo.getHand().handSize();
        System.out.printf("/n/nPlayer Status -> %-1s has %-1d %-10s %-1s has %-1d %-20s \n", playerOne.getName(), header1,"cards", playerTwo.getName(), header2,"cards");
    }
    public void symbolMeaning(){
        System.out.println("D --> Diamonds ");
        System.out.println("H --> Hearts ");
        System.out.println("S --> Spades ");
        System.out.println("C --> Clubs ");
        
    }


    //Print out winnings for each round and final winner of game.
//    public void announceRoundWinner(GamePlayer player1, WarCard card1, GamePlayer player2, WarCard card2, String winner) {
//        System.out.printf("%-20s %-20s %-20s %-20s %s is winner.\n", card1.toString(), player1.getHand().handSize(), card2.toString(), player2.getHand().handSize(), winner);
//    }
    public void announceRoundWinner(GamePlayer player1, WarCard card1, GamePlayer player2, WarCard card2, String winner) {
    System.out.println("\n===============================================");
    System.out.printf("%-18s%-14s\n", player1.getName() + " played", player2.getName() + " played");
    printCardsSideBySide(card1, card2);
    System.out.printf(" %-20s%-17s \n", card1.toString(), card2.toString());
    System.out.println("\nRound Winner --> " + winner.toUpperCase());
    System.out.println("===============================================\n");
}
    
    private void printCardsSideBySide(WarCard card1, WarCard card2) {
    String rank1 = card1.getRankLetter();
    String suit1 = card1.getSuit().getSymbol();
    
    String rank2 = card2.getRankLetter();
    String suit2 = card2.getSuit().getSymbol();

    System.out.printf(
        "\n|---------|       |---------|\n" +
        "| %-2s      |       | %-2s      |\n" +
        "|         |       |         |\n" +
        "|    %s    |  vs   |    %s    |\n" +
        "|         |       |         |\n" +
        "|      %-2s |       |      %-2s |\n" +
        "|_________|       |_________|\n", 
        rank1, rank2, suit1, suit2, rank1, rank2);
}


    //print war round
    public void announceWarRound() {
        System.out.println("WAR! There was a tie and War was initiated.");
    }

    public void announceGameWinner(Player player) {
        System.out.printf("The winner of the game is %s!", player.getName());
    }

    public void announceDraw() {
        System.out.printf("Sorry, he game ended in a draw.");
    }
}
