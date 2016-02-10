import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class Palindrome {
  public static void main(String[] args) {

  }

  public static Boolean palindromeChecker(String phrase) {
    char[] phraseArray = phrase.toCharArray();
    ArrayList<Character> phraseArrayList = new ArrayList<Character>();
    ArrayList<Character> resultArray = new ArrayList<Character>();
    for (Integer i = phraseArray.length -1; i >= 0; i--){
      resultArray.add(phraseArray[i]);
    }
    for(char c : phraseArray) { // phraseArray = [a, n, n, a]
      phraseArrayList.add(c);
    }
    if (phraseArrayList.equals(resultArray)) {
      return true;
    } else {
      return false;
    }
  }
}
