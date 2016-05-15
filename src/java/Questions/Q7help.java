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
 * This is the Q7help Class.  Its purpose is to :
 * 
 * 
 * @author Ryan Harrigan
 * @version Dec 10, 2015
 *
 */
public class Q7help {

HashMap<String, String> map = new HashMap<String, String>();
HashMap<String, Integer> answerCache = new HashMap<String, Integer>();
  
  public Q7help() {
    this.map = new HashMap<String, String>();
  }
  
  public void question7a() throws IOException {
    BufferedReader br = QuestionUtil.readFile("input7.txt");
    String line;
    
    while ((line = br.readLine()) != null) {
       // process the line.
      String[] strs = line.split(" -> ");
      map.put(strs[1], strs[0]);
    }
  
    System.out.println("a is: " + solveA("a") );
  }
  
  public  int solveA(String keyToSolve) {
    String[] ss = keyToSolve.split(" ");
    
    if (ss.length == 1) {
      if (isNumeric(ss[0])) {
        return Integer.parseInt(ss[0]);
      }
      else {
        return solveA( map.get(ss[0]));
      }
      
    }
    
    else if (ss.length == 2) {
      return ~solveA(ss[1]);
    }
    
    else if (ss.length == 3) {
      if (ss[1].equals("AND")) {
        return solveA(ss[0]) & solveA( ss[2]);
      }
      else if (ss[1].equals("OR")) {
        return solveA( ss[0]) | solveA(ss[2]);
      }
      else if (ss[1].equals("LSHIFT")) {
        return solveA(ss[0]) << solveA(ss[2]);
      }
      else if (ss[1].equals("RSHIFT")) {
        return solveA(ss[0]) >> solveA(ss[2]);
      }
    }
    return 0;
    
  }
  
  public boolean isNumeric(String str) {
    return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
  }
  
  
}
