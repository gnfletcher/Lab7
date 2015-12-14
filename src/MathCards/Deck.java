package MathCards;

import java.util.ArrayList;

public class Deck {

  public ArrayList<Integer> deck = new ArrayList<Integer>();
  private ArrayList<Integer> discard = new ArrayList<Integer>();
  private int target;

  //Initializes values in array deck and calls shuffles. Uncomment line 90 to see at beginning of 
  //game.
  public Deck(){
    this.setTarget((int) ((Math.random()*40)+10));
    while (deck.size() < 52){
      int i = 101;
      while(i < 114){
        deck.add(i);
        i++;
      }
      i = 201;
      while(i < 214){
        deck.add(i);
        i++;
      }
      i = 301;
      while(i < 314){
        deck.add(i);
        i++;
      }
      i = 401;
      while(i < 414){
        deck.add(i);
        i++; 
      }
    }
    shuffle();
  }

  //Adds card to discard pile. Uncomment line 24 in Player class to print discard pile on each turn.
  public void insertCard(int card){
    discard.add(card);
  }

  //Checks if deck still has cards, if so it draws the first card and returns value. Uncomment line 
  //24 in Player class to print deck on each turn to test.
  public int drawCard(){
    int value;
    if (isEmpty()){
      swapDeck();
    }
    value = deck.get(0);
    deck.remove(0);
    return value;
  }

  //Checks if deck is empty. Tested by playing hand over 52 turns with line 90 uncommented which 
  //initiates swapDeck and shuffle and prints shuffle.
  public boolean isEmpty(){
    if (deck.size() == 0){
      return true;
    }
    return false;
  }

  //If deck is empty, swaps with discard pile and shuffles. Tested by method as isEmpty method. 
  public void swapDeck(){
    for(int i = 0; i < discard.size(); i ++){
      deck.add(discard.get(i));
    }
    discard = new ArrayList<Integer>();
    shuffle();
  }

  //Assigns deck values to temporary array. Randomly pulls card from array and adds back to deck. 
  //Repeats three times. Uncomment line 90 to see print of shuffle.
  public void shuffle(){
    ArrayList<Integer> shuffle = new ArrayList<Integer>();
    for(int j = 0; j < 3; j++){
      shuffle = new ArrayList<Integer>();
      for(int k = 0; k < deck.size(); k++){
        shuffle.add(deck.get(k));
      }
      deck = new ArrayList<Integer>();
      while(shuffle.size() > 0){
        int i = (int)(Math.random()*shuffle.size());
        deck.add(shuffle.get(i));
        shuffle.remove(i);
      }
      //Test.printDeck(deck);
    }
  }

  public int getTarget() {
    return target;
  }

  public void setTarget(int target) {
    this.target = target;
  }

  public ArrayList<Integer> getDeck() {
    return deck;
  }

  public ArrayList<Integer> getDiscard() {
    return discard;
  }
}
