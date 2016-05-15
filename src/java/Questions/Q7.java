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
 * This is the Q7 Class.  Its purpose is to :
 * 
 * Operators are:
 *   AND
 *   OR
 *   LSHIFT
 *   RSHIFT
 *   NOT
 * 
 * @author Ryan Harrigan
 * @version Dec 10, 2015
 *
 */
public class Q7 {

  
  
  public static void answer() throws IOException {
    question7a();
    question7b();
  }
  
  public static void question7a() throws IOException {
    BufferedReader br = QuestionUtil.readFile("input7.txt");
    String line;
    HashMap<String, String> map = new HashMap<String, String>();
    while ((line = br.readLine()) != null) {
       // process the line.
      String[] strs = line.split(" -> ");
      map.put(strs[1], strs[0]);
    }
  
    System.out.println("a is: " + solveA(map, "a") );
  }
  
  public static int solveA(HashMap<String, String> map, String keyToSolve) {
    String[] ss = keyToSolve.split(" ");
    
    if (ss.length == 1) {
      if (isNumeric(ss[0])) {
        return Integer.parseInt(ss[0]);
      }
      else {
        return solveA(map, map.get(ss[0]));
      }
      
    }
    
    else if (ss.length == 2) {
      return ~solveA(map, ss[1]);
    }
    
    else if (ss.length == 3) {
      if (ss[1].equals("AND")) {
        return solveA(map, ss[0]) & solveA(map, ss[2]);
      }
      else if (ss[1].equals("OR")) {
        return solveA(map, ss[0]) | solveA(map, ss[2]);
      }
      else if (ss[1].equals("LSHIFT")) {
        return solveA(map, ss[0]) << solveA(map, ss[2]);
      }
      else if (ss[1].equals("RSHIFT")) {
        return solveA(map, ss[0]) >> solveA(map, ss[2]);
      }
    }
    return 0;
    
  }
  
  public static boolean isNumeric(String str) {
    return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
  }
  
  public static void question7b() throws IOException {
    BufferedReader br = QuestionUtil.readFile("input7.txt");
    String line;
    while ((line = br.readLine()) != null) {
       // process the line.
      
    }
  
    System.out.println("something: " );
  }
  
  
}
