import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class Palindrome {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/palindrome", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/palindrome.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/palresults", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String phrase = request.queryParams("phraseInput");
      Boolean isPalindrome = Palindrome.palindromeChecker(phrase);
      model.put("isPalindrome", isPalindrome);
      model.put("phrase", phrase);
      model.put("template", "templates/palresults.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

  public static Boolean palindromeChecker(String phrase) {
    phrase = phrase.toLowerCase();
    phrase = phrase.replaceAll("\\W", "");
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
