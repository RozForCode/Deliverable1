/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliverable_1;

/**
 *
 * @author navro
 */
public class GamePlayer extends Player {
    
    private Hand hand;
    
    public GamePlayer(String name, Hand hand){
        super(name);
        this.hand = hand;
    }
    public Hand getHand() {
        return this.hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
    @Override
    public void play(){
        System.out.println(super.getName() + "Player ready!");
    }
}
