package Questions;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * See problem statement at http://adventofcode.com/day/1
 * 
 * 
 * This is the Q1 Class.  Its purpose is to :
 * 
 * count '(' and ')' characters in a string.
 * 
 * such that:
 *    ( = 1
 *    ) = -1
 * 
 * @author Ryan Harrigan
 * @version Dec 5, 2015
 *
 */
public class Q1 {

  
  public static void answer() throws IOException {
    question1a();
    question1b();
  }
  /**
   * find sum of input string of '(' and ')' 
   *  
   */
  public static void question1a() throws IOException {
    int count = 0;
    BufferedReader br = QuestionUtil.readFile("input1.txt");
    String line;
    
    while ((line = br.readLine()) != null) { 
      char[] str = line.toCharArray();
      
      for (char c : str) {
        if (c == '(') count++;
        else if (c == ')') count--;
        else ;
      }
    }
    
    System.out.println("1a)  Count is: " + count);
  }
  
  /**
   * find position where running total of an input string 
   * reaches -1 for the first time.
   */
  public static void question1b() throws IOException {
    int count, position;
    count = position = 0;
    BufferedReader br = QuestionUtil.readFile("input1.txt");
    String line;
    while ((line = br.readLine()) != null) {
      char[] str = line.toCharArray();
      for (char c : str) {

        if (count == -1) {
          System.out.println("1b)  Hit -1 at position: " + position);
          break;
        }
        
        if (c == '(') {
          count++;
          position++;
        }
        else if (c == ')') {
          count--;
          position++;
        }
        else ;
      }
    }
  }

}
