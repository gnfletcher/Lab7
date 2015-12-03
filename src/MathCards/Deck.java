package MathCards;

import java.util.ArrayList;

public class Deck {

  private ArrayList<Integer> deck;
  private ArrayList<Integer> discard;
  private int target;

  public Deck(){
    this.discard = null;
    this.deck = null;
    this.setTarget((int) ((Math.random()*40)+10));
    while ( deck.size() < 52){
      int j = 0;
      int i = 101;
      while(i < 114){
        i++;
      }
      i = 201;
      while(i < 214){
        i++;
      }
      i = 301;
      while(i < 314){
        i++;
      }
      i = 401;
      while(i < 414){
        i++; 
      }
      j++;
    }
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

    return true;
  }

  public void swapDeck(){
    for(int i = 0; i < discard.size(); i ++){
      deck.add(discard.get(i));
    }
    discard = null;
  }

  public void shuffle(){
    ArrayList<Integer> shuffle = null;
    for(int j = 0; j < 3; j++){
      for(int k = 0; k < deck.size(); k++){
        shuffle.add(deck.get(k));
      }

      while(shuffle.size() > 0){
        int i = (int)(Math.random()*shuffle.size());
        deck.add(shuffle.get(i));
        shuffle.remove(i);
      }
    }
  }

  public int getTarget() {
    return target;
  }

  public void setTarget(int target) {
    this.target = target;
  }
}
