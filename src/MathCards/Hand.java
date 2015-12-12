package MathCards;

import java.util.ArrayList;
import java.util.Scanner;

public class Hand {

  private ArrayList <Integer> hand;
  public static final Scanner input = new Scanner(System.in);

  public Hand(){
    this.hand = new ArrayList<Integer>();
  }

  public ArrayList <Integer> getHand() {
    return hand;
  } 

  public void setHand(ArrayList <Integer> hand) {
    this.hand = hand;
  }

  public void displayHand(String name){
    ArrayList<String> handFaceValue = new ArrayList<String>();
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
    System.out.println(name + ", your hand: " + handFaceValue);
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
    this.hand.add(value);
  }

  public void dropCard(int discard){
    Game.getDeck().insertCard(hand.get(discard));
    hand.remove(discard);
  }

  public int[] sumAndProduct(String name){
    int[] total = new int[2];
    int sum = 0;
    int product = 1;
    for(int i = 0; i < hand.size(); i++){
      if((hand.get(i)%100) == 1){
        sum = sum + aceValue(name , "sum");
        product = product*aceValue(name , "product");
      } else if ((hand.get(i)%100) > 10){
        sum = sum + 10;
        product = product * 10;
      } else{
        sum = sum + (hand.get(i)%100);
        product = product * (hand.get(i)%100);
      }
      total[0]=sum;
      total[1]=product;
    }
    return total;
  }

  public int containsCard(String card){
    int index = -1;
    ArrayList<String> handFaceValue = new ArrayList<String>();
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
    for (int i = 0; i < hand.size(); i ++){
      if(handFaceValue.get(i).equalsIgnoreCase(card)){
        index = i;
      }
    }
    return index;
  }

  public int aceValue(String name, String type){
    System.out.println(name + ", would you like to use your Ace as a 1 or 11 to find the " + type +
        "?");
    //Test.typeAceValue(hand, Game.deck.getTarget());
    int value = input.nextInt();
    while(value != 1 && value != 11){
      System.out.println("Invalid input. Would you like to use your Ace as a 1 or 11 to find the " 
          + type + "?");
      value = input.nextInt();
    }
    return value;
  }

}
