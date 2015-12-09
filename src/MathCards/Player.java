package MathCards;

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
    System.out.println(name + ", your target: " + deck.getTarget());
    displayHand();
    pickUpOrDrop();
    return true;
  }

  public void displayHand(){
    hand.displayHand(name);
  }

  public void pickUpOrDrop(){
    if(hand.isEmpty()){
      System.out.println("You must draw!");
      pickUp();
    } else if (hand.isFull()){
      System.out.println("You must discard!");
      drop();
    } else {
      //System.out.println("Your target: " + deck.getTarget());
      //displayHand();
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
    hand.addCard(value);
    value = value%100;
    if(value == 13){
      System.out.println("K");
    } else if (value == 12){
      System.out.println("Q");
    } else if (value == 11){
      System.out.println("J");
    } else if (value == 1){
      System.out.println("A");
    } else {
      System.out.println(value);
    }
    hand.displayHand(name);
  }

  public void drop(){
    String value;
    int discard;
    do{
      displayHand();
      System.out.println("Which card would you like to discard?");
      System.out.println("Please enter the value of the card and hit enter: ");
      value = input.nextLine();
      discard = hand.containsCard(value);
      if (discard == -1){
        System.out.println("Card does not exist in hand. Please try again.");
      }
    } while (hand.containsCard(value) == -1);
    hand.dropCard(discard);
  }

  public boolean completeTurn(){
    int[] total = hand.sumAndProduct(name);
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
