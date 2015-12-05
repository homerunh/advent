/**
 *  Ryan Harrigan
 *  PID: homerunh
 *  Student ID#: 904932498
 *  CS xxxx
 *  
 *  On my honor:
 *
 *  - I have not discussed the Java language code in my program with
 *  anyone other than my instructor or the teaching assistants
 *  assigned to this course.
 *
 *  - I have not used Java language code obtained from another student,
 *  or any other unauthorized source, either modified or unmodified.
 *
 *  - If any Java language code or documentation used in my program
 *  was obtained from another source, such as a text book or course
 *  notes, that has been clearly noted with a proper citation in
 *  the comments of my program.
 *
 *  - I have not designed this program in such a way as to defeat or
 *  interfere with the normal operation of the Automated Grader.
 *
 *  Pledge: On my honor, I have neither given nor received unauthorized
 *  aid on this assignment.
 *
 *  Ryan Harrigan
 *
 *
 */
package Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * 
 * This is the Q5 Class.  Its purpose is to :
 * 
 * 
 * @author Ryan Harrigan
 * @version Dec 5, 2015
 *
 */
public class Q5  {
  public static void answer() throws IOException {
    question5a();
    question5b();
  }
  
  public static void question5a() throws IOException {
    BufferedReader br = QuestionUtil.readFile("input5.txt");
    String line;
    int niceStringCount = 0;
    
    while ((line = br.readLine()) != null) {
       // process the line.
      if (isStringNice1(line)) {
        niceStringCount++;
      }
      
    }
  
    System.out.println("5a)  # of nice strings : " + niceStringCount );
  }
  
  public static void question5b() throws IOException {
    BufferedReader br = QuestionUtil.readFile("input5.txt");
    String line;
    int niceStringCount = 0;
    while ((line = br.readLine()) != null) {
      
      //look for two letters
      //look for three letters
      if (isStringNice2a(line) && isStringNice2b(line)) {
        niceStringCount++;
      }
    }
  
    System.out.println("5b)  # of nice strings : " + niceStringCount );
  }
  
  public static boolean isStringNice1(String testString) {
    //counts
    int vowelCount = 0;
    int doubleLetterCount = 0;
    
    //length of string to check
    int length = testString.length();
    for (int i = 0; i < length -1; i++) {
      //check the string, 2 characters at a time...
      String twoChars = testString.substring(i, i+2);
      
      if (containsEvil(twoChars)) {
        //if the string is evil, we're done...
        return false;
      }
      
      //then, count vowels and double letters.
      String firstOfTwoLetters = testString.substring(i, i+1);
      String secondOfTwoLetters = testString.substring(i+1, i+2);
      boolean isFirstVowel = isVowel(firstOfTwoLetters);
      boolean isSecondVowel = isVowel(secondOfTwoLetters);
      
      if (isSecondVowel) {
        vowelCount++;
      } 
      
      if (isFirstVowel) {
        vowelCount++;
      }
      
      if (firstOfTwoLetters.equals(secondOfTwoLetters)) {
        doubleLetterCount++;
      }
      
    }
    
    //cleanup : 
    // we actually count each vowel twice, except if they are 
    // the first and last letters of the string... so we'll double count 
    // those now.
    String firstLetter = (String) testString.subSequence(0, 1);
    String lastLetter = (String) testString.subSequence(length-1, length);
    
    if (isVowel(firstLetter)) {
      vowelCount++;
    }
    
    if (isVowel(lastLetter)) {
      vowelCount++;
    }
    
    if (vowelCount >= 6 && doubleLetterCount > 0) {
      //the string is nice!
      return true;
    }
    return false;
  }
  
  public static boolean isStringNice2a(String testString) {
    HashMap<String, Integer> letters = new HashMap<String, Integer>(); 
    int count = 0;
    //length of string to check
    int length = testString.length();
    for (int i = 0; i < length - 1; i++) {
      //check the string, 2 characters at a time...
      String twoChars = testString.substring(i, i+2);
      
      if (letters.containsKey(twoChars)) {
        //dont counnt
        if (i - letters.get(twoChars) == 1 ) {
          
        } else {
          count++;
        }
      }
      else {
        letters.put(twoChars, i);
      }
    }
    
    return count > 0;
  }
  
  public static boolean isStringNice2b(String testString) {
      
      
      //length of string to check
      int length = testString.length();
      for (int i = 0; i < length - 2; i++) {
        String firstOfThreeChars = testString.substring(i, i+1);
        String lastOfThreeChars = testString.substring(i+2, i+3);
        if (firstOfThreeChars.equals(lastOfThreeChars)) {
          return true;
        }
      }
      
      return false;
    }
  
  public static boolean containsEvil(String testString) {
    return testString.equals("ab") || testString.equals("cd") || testString.equals("pq") || testString.equals("xy");
  }
  
  public static boolean isVowel(String testString) {
    return testString.equals("a") || testString.equals("e") || testString.equals("i")  || testString.equals("o") || testString.equals("u");
  }
  
}
