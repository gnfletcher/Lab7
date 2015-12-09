package MathCards;

import java.util.Scanner;

public class Game {


  public static final Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println(("Please enter your name, Player 1"));
    Player player1 = new Player (input.nextLine());

    System.out.println(("Please enter your name, Player 2"));
    Player player2 = new Player (input.nextLine());

    while (!player1.completeTurn() || !player2.completeTurn()){
      player1.takeTurn();
      if(player1.completeTurn()){
        player2.takeTurn();
        if(player2.completeTurn()){
          System.out.println("The game is a tie!!");
        } else {
          System.out.print("Player 1 wins!! Player 1's hand: ");
          player1.displayHand();
          break;
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
            break;
          }
        }
      }
    }
  }


}