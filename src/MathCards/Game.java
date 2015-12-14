/****************************************************************
 * Name: Greg Fletcher and Tom Abraham
 * Course: IOOP
 * Section: 07
 * Date: 12/14/2015
 ****************************************************************
 * ID: Lab 7
 * Purpose: Using a standard deck of cards, develop a game for two players that start the players 
 * with 0 cards. At the start of the game, a number between 10 and 50 is randomly generated as the 
 * target for this game. On each turn the player can determine whether they would like to pick up a 
 * card from the deck or drop a card. The player can have a maximum of 5 cards in their hand at any
 * time. The goal is for the player to hold a collection of cards that reaches the target through 
 * sum or product. The target cannot be reached by the sum or product of a subset of the player's 
 * cards. For a player's turn, if they choose to draw a card the player adds the first card from the
 * deck to their hand and their turn is complete. The top card on the deck is hidden, so the player 
 * does not know what card they will be picking up before they do. If the player drops a card for 
 * their turn, you must ask the player which card they would like to drop from their hand and their 
 * hand is updated accordingly. Once one player achieves the target, the other player has one more 
 * turn. If the other player achieves the target in the final turn, display that the game results in
 * a tie. Otherwise, display which player has won and their hand. At any time if the deck becomes 
 * empty, the collection of dropped cards is shuffled and replaces the empty deck. Normal rules 
 * apply: a non face card gets the value of the card, a face card is 10, and an Ace is 1 or 11 (you 
 * will have to ask the user which they would like it to be).
 * 
 ****************************************************************
 * Test Suite:
 * **************************************************************
 * Normal Cases:
 * Follow instructions in MathCards.Test.java for automated testing procedures. Automated testing
 * will play hands until the conditions in Mathcards.Game.java main have been met. 
 *
 * Boundary Cases:
 * Input: 2,147,483,647, 2,147,483,647
 * Expected Output: The cone is too large!
 * Input: 1, 1
 * Expected Output: The cone is too small! 
 *
 * Extreme Cases:
 * Input:2,147,483,648, 2,147,483,648
 * Expected Output: Input Error
 *
 ******************************************************************
 */

package MathCards;

import java.util.Scanner;

public class Game {

  public static Deck deck = new Deck();
  public static Player player1;
  public static Player player2;
  public static final Scanner input = new Scanner(System.in);

  public static void main(String[] args){

    //set player 1 name
    System.out.println(("Please enter your name, Player 1:"));
    //For automated testing, set string parameter for player 1's name and uncomment.
    //Test.typeName("Greg");
    player1 = new Player (input.nextLine());
    
    //set player 2 name
    System.out.println(("Please enter your name, Player 2:"));
    //For automated testing, set string parameter for player 2's name and uncomment.
    //Test.typeName("Tom");
    player2 = new Player (input.nextLine());
    
    int turns = 1;
    //Main game play. Calls players to takeTurn, calls completeTurn to see if the target is met.
    //Prints results of game. Follow comments in Test class for automated testing.
    while( !player1.targetReached() && !player2.targetReached()){
      turns++;
      player1.takeTurn();
      if(player1.completeTurn()){
        player2.takeTurn();
        if(player2.completeTurn()){
          System.out.println("The game is a tie!!");
        } else {
          System.out.print("Player 1 wins!! Player 1's hand: ");
          player1.displayHand();
        }
      } else {
        player2.takeTurn();
        if(player2.completeTurn()){
          player1.takeTurn();
          if(player1.completeTurn()){
            System.out.println("The game is a tie!!");
          } else {
            System.out.print("Player 2 wins!! Player 2's hand: ");
            player2.displayHand();
          }
        }
      }
    }
    System.out.println("The game took " + turns + " turns!");
  }

  public static Deck getDeck() {
    return deck;
  }
 
}