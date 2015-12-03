package MathCards;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

  private String name;
  private Hand hand = new Hand();
  private Deck deck = new Deck();
  public static final Scanner input = new Scanner(System.in);

  public Player() {
    this.name = null;
    this.hand = new Hand();
  }
  
  public Player(String name) {
    this.name = name;
    this.hand = new Hand(); 
  }
  
  public boolean takeTurn(){
    displayHand();
    pickUpOrDrop();
    return true;
  }

  public void displayHand(){
    hand.displayHand();
  }

  public void pickUpOrDrop(){
    if(hand.isEmpty()){
      System.out.println("You must draw!");
      pickUp();
    } else if (hand.isFull()){
      System.out.println("You must discard!");
    } else {
      System.out.println("Would you like to draw or discard?");
      System.out.println("Please enter 'draw' or 'discard': ");
      String action = input.next();
      while(!(action.equalsIgnoreCase("draw") || action.equalsIgnoreCase("discard"))){
        System.out.println("Invalid input, please enter 'draw' or 'discard': ");
        action = input.next();
      }
      if(action.equalsIgnoreCase("draw")){
        pickUp();
      } else {
        drop();
      }
    }
  }

  public void pickUp(){
   int value = deck.drawCard();
   System.out.println(value);
   hand.addCard(value);
  }

  public void drop(){
    int value = hand.dropCard();
    System.out.println(value);
    deck.insertCard(value);
  }
  
  public boolean completeTurn(){
    int[] total = hand.sumAndProduct();
    if (total[0] == deck.getTarget() || total [1] == deck.getTarget()){
      return true;
    }
    return false;
  }
  
  public String getName(){
    return this.name;  
  }
  
  public void setName(String name) {
    this.name = name;
  }
}
