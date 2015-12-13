package MathCards;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Test {

  /* 
   * Automated testing for MathCards package. Assigns names to players. Draws on every turn until 
   * players hand is full. Randomly selects card to discard when players hand is full. Selects 
   * value of 11 for Ace is this will meet the target value otherwise it selects a value of 1.
   * There are also methods to print values for deck and discard pile.
   * Uncomment the following lines to test:
   * MathCards.Game: lines 61 & 67
   * MathCards.Player: lines 23, 45 & 84
   * MathCards.Deck: line 80
   * MathCards.Hand: line 115
   */

  private static Robot robot;

  //used in Player.takeTurn, line 23. Prints current values for deck and discard pile values. Shows
  //values at the end of each turn to show function of draw and discard.
  public static void printDecks(){
    System.out.println(Game.deck.getDeck());
    System.out.println(Game.deck.getDiscard());
  }

  //used in Deck.shuffle(), line 80. Prints current values for deck indices. Shows effectiveness
  //of shuffle method.
  public static void printDeck(ArrayList<Integer> deck) {
    System.out.println(deck);
  }

  //used in main method of Game, lines 61 and 67. Calls new instance of class Robot, passes 
  // string parameter name to method type which returns keystrokes for name.
  public static void typeName(String name){
    try {
      robot = new Robot();
      type(name);
      robot.keyPress(KeyEvent.VK_ENTER);
    } catch (AWTException e) {
      e.printStackTrace();
    }
  }

  //Used in Player.takeTurn(), line 45. Calls new instance of Robot class and returns keystrokes for
  //string "draw".
  public static void typeDraw(){
    try {
      robot = new Robot();
      type("draw");
      robot.keyPress(KeyEvent.VK_ENTER);
    } catch (AWTException e) {
      e.printStackTrace();
    }
  }

  //Used in Player.drop(), line 84. Calls new instance of Robot class. Takes integer value of 
  //randomly selected card from hand, passes to cardToChar. Return of cardToChar passed to typeChar 
  //for keystroke.
  public static void typeDiscardValue(Integer integer){
    try {
      robot = new Robot();
      typeChar(cardToChar(integer));
      robot.keyPress(KeyEvent.VK_ENTER);
    } catch (AWTException e) {
      e.printStackTrace();
    }
  }

  //Used in Hand.aceValue(), line 115. Returns user input for value of an Ace held in the player's
  //hand.
  public static void typeAceValue(ArrayList<Integer> hand, int target){
    try {
      robot = new Robot();
      int sum = 0;
      int product = 1;
      for(int i = 0; i < hand.size(); i++){
        if((hand.get(i)%100) == 1){
          sum = sum + 11;
          product = product*11;
        } else if ((hand.get(i)%100) > 10){
          sum = sum + 10;
          product = product * 10;
        } else{
          sum = sum + (hand.get(i)%100);
          product = product * (hand.get(i)%100);
        }
      }
      if(sum == target || product == target){
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_ENTER);
      }else{
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_ENTER);
      }
    } catch (AWTException e) {
      e.printStackTrace();
    }
  }

  //Takes integer input from hand and returns character value to pass to typeChar.
  public static char cardToChar(int card){
    char faceValue;
    if(card%100 == 13){
      faceValue = 'K';
    }else if (card%100 == 12){
      faceValue = 'Q';
    }else if (card%100 == 11){
      faceValue = 'J';
    }else if (card%100 == 1){
      faceValue = 'A';
    }else if (card%100 == 10){
      faceValue = '0';
    }else if (card%100 == 9){
      faceValue = '9';
    }else if (card%100 == 8){
      faceValue = '8';
    }else if (card%100 == 7){
      faceValue = '7';
    }else if (card%100 == 6){
      faceValue = '6';
    }else if (card%100 == 5){
      faceValue = '5';
    }else if (card%100 == 4){
      faceValue = '4';
    }else if (card%100 == 3){
      faceValue = '3';
    }else if (card%100 == 2){
      faceValue = '2';
    } else {
      faceValue = '0';
    }
    return faceValue;
  }

  //Takes character from cardToChar and returns corresponding keystroke.
  public static void typeChar(char character){
    switch (character) {
      case 'A': 
        robot.keyPress(KeyEvent.VK_A); 
        break;
      case 'K': 
        robot.keyPress(KeyEvent.VK_K); 
        break;
      case 'Q': 
        robot.keyPress(KeyEvent.VK_Q); 
        break;
      case 'J': 
        robot.keyPress(KeyEvent.VK_J); 
        break;
      case '1': 
        robot.keyPress(KeyEvent.VK_1); 
        break;
      case '2': 
        robot.keyPress(KeyEvent.VK_2); 
        break;
      case '3': 
        robot.keyPress(KeyEvent.VK_3); 
        break;
      case '4': 
        robot.keyPress(KeyEvent.VK_4); 
        break;
      case '5': 
        robot.keyPress(KeyEvent.VK_5); 
        break;
      case '6': 
        robot.keyPress(KeyEvent.VK_6); 
        break;
      case '7': 
        robot.keyPress(KeyEvent.VK_7); 
        break;
      case '8': 
        robot.keyPress(KeyEvent.VK_8); 
        break;
      case '9': 
        robot.keyPress(KeyEvent.VK_9); 
        break;
      case '0': 
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_0);
        break;
    }
  }

  //Takes string parameter, converts to character array and returns corresponding keystroke for 
  //each character array index value.
  public static void type(String string){
    char[] characters = string.toCharArray();
    for(int i = 0; i < characters.length; i++){
      switch (characters[i]) {
        case 'a': 
          robot.keyPress(KeyEvent.VK_A); 
          break;
        case 'b': 
          robot.keyPress(KeyEvent.VK_B); 
          break;
        case 'c': 
          robot.keyPress(KeyEvent.VK_C); 
          break;
        case 'd': 
          robot.keyPress(KeyEvent.VK_D); 
          break;
        case 'e': 
          robot.keyPress(KeyEvent.VK_E); 
          break;
        case 'f': 
          robot.keyPress(KeyEvent.VK_F); 
          break;
        case 'g': 
          robot.keyPress(KeyEvent.VK_G); 
          break;
        case 'h': 
          robot.keyPress(KeyEvent.VK_H); 
          break;
        case 'i': 
          robot.keyPress(KeyEvent.VK_I); 
          break;
        case 'j': 
          robot.keyPress(KeyEvent.VK_J); 
          break;
        case 'k': 
          robot.keyPress(KeyEvent.VK_K); 
          break;
        case 'l': 
          robot.keyPress(KeyEvent.VK_L); 
          break;
        case 'm': 
          robot.keyPress(KeyEvent.VK_M); 
          break;
        case 'n': 
          robot.keyPress(KeyEvent.VK_N); 
          break;
        case 'o': 
          robot.keyPress(KeyEvent.VK_O); 
          break;
        case 'p': 
          robot.keyPress(KeyEvent.VK_P); 
          break;
        case 'q': 
          robot.keyPress(KeyEvent.VK_Q); 
          break;
        case 'r': 
          robot.keyPress(KeyEvent.VK_R); 
          break;
        case 's': 
          robot.keyPress(KeyEvent.VK_S); 
          break;
        case 't': 
          robot.keyPress(KeyEvent.VK_T); 
          break;
        case 'u': 
          robot.keyPress(KeyEvent.VK_U); 
          break;
        case 'v': 
          robot.keyPress(KeyEvent.VK_V); 
          break;
        case 'w': 
          robot.keyPress(KeyEvent.VK_W); 
          break;
        case 'x': 
          robot.keyPress(KeyEvent.VK_X); 
          break;
        case 'y': 
          robot.keyPress(KeyEvent.VK_Y); 
          break;
        case 'z': 
          robot.keyPress(KeyEvent.VK_Z); 
          break;
        case 'A':
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_A);
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'B': 
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_B); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'C':
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_C); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'D': 
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_D); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'E': 
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_E); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'F':
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_F); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'G':
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_G); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'H':
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_H); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'I':
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_I); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'J':
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_J); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'K': 
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_K); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'L':
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_L); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'M': 
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_M); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'N':
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_N); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'O': 
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_O); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'P':
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_P); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'Q':
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_Q); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'R': 
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_R); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'S':
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_S); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'T': 
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_T); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'U':
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_U); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'V':
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_V); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'W':
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_W); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'X':
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_X); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'Y': 
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_Y); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
        case 'Z': 
          robot.keyPress(KeyEvent.VK_SHIFT);
          robot.keyPress(KeyEvent.VK_Z); 
          robot.keyRelease(KeyEvent.VK_SHIFT);
          break;
      }
    }
  }
}