package MathCards;

import java.util.ArrayList;

public class Deck {

  private ArrayList<Integer> deck = new ArrayList<Integer>();
  private ArrayList<Integer> discard = new ArrayList<Integer>();
  private int target;

  public Deck(){
    discard = null;
    this.setTarget((int) ((Math.random()*40)+10));
    while ( deck.size() < 52){
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

  public void insertCard(int card){
    discard.add(card);
  }

  public int drawCard(){
    int value;
    if (isEmpty()){
      swapDeck();
    }
    value = deck.get(0);
    deck.remove(0);
    return value;
  }

  public boolean isEmpty(){
    if (deck.size() == 0){
      return true;
    }
    return false;
  }

  public void swapDeck(){
    for(int i = 0; i < discard.size(); i ++){
      deck.add(discard.get(i));
    }
    shuffle();
    discard = null;
  }

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
      //System.out.println(deck);
    }
  }

  public int getTarget() {
    return target;
  }

  public void setTarget(int target) {
    this.target = target;
  }
}
