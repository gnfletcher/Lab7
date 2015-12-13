package MathCards;

import java.util.Scanner;

public class Player {

  private String name;
  private Hand hand = new Hand();
  public int [] total = new int[2];
  public static final Scanner input = new Scanner(System.in);

  public Player() {
    this.name = null;
    this.hand = new Hand();
  }

  public Player(String name) {
    this.name = name;
    this.hand = new Hand(); 
  }

  //Prints target, players name and hand. Calls pickUpOrDrop method.
  public boolean takeTurn(){
    //Test.printDecks();
    System.out.println("Target: " + Game.getDeck().getTarget());
    System.out.println(name + "'s turn!");
    displayHand();
    pickUpOrDrop();
    return true;
  }

  //Prints hand values
  public void displayHand(){
    hand.displayHand(name);
  }

  //Determines if player must draw or discard or may choose. If given choice, validates selection
  //prints player name and hand.
  public void pickUpOrDrop(){
    if(hand.isEmpty()){
      System.out.println("Your hand is empty, you must draw!");
      pickUp();
    } else if (hand.isFull()){
      System.out.println("Your hand is full, you must discard!");
      drop();
    } else {
      System.out.println("Would you like to draw or discard?");
      System.out.println("Please enter 'draw' or 'discard': ");
      //Test.typeDraw();
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
    hand.displayHand(name);
  }

  //Takes first index value in deck and adds to hand. Prints value of card drawn.
  public void pickUp(){
    int value = Game.getDeck().drawCard();
    hand.addCard(value);
    value = value%100;
    System.out.print(name + " drew ");
    if(value == 13){
      System.out.println("a K");
    } else if (value == 12){
      System.out.println("a Q");
    } else if (value == 11){
      System.out.println("a J");
    } else if (value == 1){
      System.out.println("an A");
    } else {
      System.out.println("a " + value);
    }
  }

  //Takes user input and passes input to hand.dropCard.
  public void drop(){
    String value;
    int discard;
    do{
      System.out.println("Which card would you like to discard?");
      System.out.println("Please enter the value of the card and hit enter: ");
      //Test.typeDiscardValue(hand.getHand().get((int) Math.floor(Math.random()*4)+1));
      value = input.next();
      discard = hand.containsCard(value);
      if (discard == -1){
        System.out.println("Card does not exist in hand. Please try again.");
      }
    } while (hand.containsCard(value) == -1);
    hand.dropCard(discard);
  }
  
  //Determine if target is met.
  public boolean targetReached(){
    if (total[0] == Game.getDeck().getTarget() || total [1] == Game.getDeck().getTarget()){
      return true;
    }
    return false;
  }

  //Call sumAndProduct to determine values from hand. Prints values. Calls targetReached.
  public boolean completeTurn(){
    total = hand.sumAndProduct(name);
    System.out.println(name +", your sum is " + total[0] + ".");
    System.out.println(name +", your product is " + total[1] + ".");
    System.out.println("");
    if (targetReached()){
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
  
  public Hand getHand(){
    return this.hand;
  }
}
