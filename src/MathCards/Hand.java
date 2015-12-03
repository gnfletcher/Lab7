package MathCards;

import java.util.ArrayList;
import java.util.Scanner;

public class Hand {

  private ArrayList <Integer> hand;
  public static final Scanner input = new Scanner(System.in);

  public Hand(){
    this.setHand(null);
  }

  public ArrayList <Integer> getHand() {
    return hand;
  } 

  public void setHand(ArrayList <Integer> hand) {
    this.hand = hand;
  }
  
  public void displayHand(){
    ArrayList<String> handFaceValue = null;
    for (int i = 0; i < hand.size(); i++){
      if((hand.get(i)%100) == 13){
        handFaceValue.add("K");
      } else if ((hand.get(i)%100) == 12){
        handFaceValue.add("Q");
      }else if ((hand.get(i)%100) == 11){
        handFaceValue.add("J");
      }else if ((hand.get(i)%100) == 1){
        handFaceValue.add("A");
      } else {
        int value = hand.get(i)%100;
        handFaceValue.add(String.valueOf(value));
      }
    }
    System.out.println(" Your hand: " + handFaceValue);
  }

  public boolean isEmpty(){
    if (hand.size() == 0){
      return true;
    }
    return false;

  }

  public boolean isFull(){
    if (hand.size() == 5){
      return true;
    }
    return false;
  }

  public void addCard(int value){
    Deck.drawCard();

  }

  public int dropCard(){
    int value =0;
    return value;
  }

  public int[] sumAndProduct(){
    int[] total = new int[2];
    int sum = 0;
    int product = 1;
    for(int i = 0; i < hand.size(); i++){
      if((hand.get(i)%100) == 1){
        sum = sum + aceValue();
        product = product*aceValue();
      } else {
        sum = sum + (hand.get(i)%100);
        product = product * (hand.get(i)%100);
      }
      total[0]=sum;
      total[1]=product;
    }
    return total;
  }

  public int containsCard(){
    int i;
    for(i = 0 ;  i < hand.size(); i++){


    }
    return hand.get(i);
  }

  public int aceValue(){
    System.out.println("Would you like to use your Ace as a 1 or 11?");
    int value = input.nextInt();
    while(value != 1 || value != 11){
      System.out.println("Invalid input. Would you like to use your Ace as a 1 or 11? ");
      value = input.nextInt();
    }
    return value;
  }

}
