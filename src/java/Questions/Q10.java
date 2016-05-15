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

import java.io.IOException;

/**
 * 
 * This is the Q10 Class.  Its purpose is to :
 * 
 * 
 * @author Ryan Harrigan
 * @version Dec 26, 2015
 *
 */
public class Q10  {
  
  static StringBuilder sb = new StringBuilder();
  
  public static void answer() throws IOException {
    question10a();
    question10b();
  }
  
  public static void question10a() throws IOException {
    String input = "1113122113";
    String []inputs = new String[41];
    inputs[0] = input;
    for (int i = 0; i < 40; i++) {
      inputs[i + 1] = lookAndSay(inputs[i]);
      sb = new StringBuilder();
    }
    System.out.println("10a)  length is: " + inputs[40].length());
    
  }
  
  public static String lookAndSay(String input) {
    String lastChar = "";
    int counter = 0;
    //loop over string...
    for (int i = 0; i < input.length(); i++) {
      String thisChar = input.substring(i, i+1);
      
      
      if (thisChar.equals(lastChar)) {
        counter++;
      }
      else {
        
        if (counter != 0)
          sb.append(counter + lastChar);
        counter = 1;
      }
      lastChar = thisChar;
    }
    sb.append(counter + lastChar);
    return sb.toString();
  }
  
  public static void question10b() throws IOException {
    String input = "1113122113";
    String []inputs = new String[51];
    inputs[0] = input;
    for (int i = 0; i < 50; i++) {
      inputs[i + 1] = lookAndSay(inputs[i]);
      sb = new StringBuilder();
    }
    System.out.println("10b)  length is: " + inputs[50].length());
  }
}