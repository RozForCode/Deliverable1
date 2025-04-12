/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliverable_1;

import java.util.Scanner;

/**
 *
 * @author navro
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String name1 = "";
        String name2 = "";

        // Get Player 1's name (loop until valid input)
        while (name1.trim().isEmpty()) {
            System.out.print("Enter Player 1's name: ");
            name1 = in.nextLine().trim(); // Trim to remove leading/trailing spaces
            if (name1.isEmpty()) {
                System.out.println("Name cannot be empty. Please enter a valid name.");
            }
        }

        // Get Player 2's name (loop until valid input)
        while (name2.trim().isEmpty()) {
            System.out.print("Enter Player 2's name: ");
            name2 = in.nextLine().trim();
            if (name2.isEmpty()) {
                System.out.println("Name cannot be empty. Please enter a valid name.");
            }
         WarGame game = new WarGame(name1,name2);
         game.play();
        }
    }
    
}
