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

/**
 * 
 * This is the Q8 Class.  Its purpose is to :
 * 
 * escape patterns:
 *  \"       2 - 1 = 1
 *  \\       2 - 1 = 1
 *  \xXX     4 - 1 = 3
 *   
 *   DONT FORGET TO SUBTRACT THE OUTTER "" (2)
 *  
 * @author Ryan Harrigan
 * @version Dec 11, 2015
 *
 */
public class Q8 {

  public static void answer() throws IOException {
    question8a();
    question8b();
  }
  
  public static void question8a() throws IOException {
    BufferedReader br = QuestionUtil.readFile("input8.txt");
    String line;
    int literals = 0;
    int mem = 0;
    int minus1 = 0;
    int minus3 = 0;
    while ((line = br.readLine()) != null) {
       // process the line.
      literals += line.length(); //v -2 for outter "" 
      
      int[] m = countMemCharsPartA(line);
      
      minus1 = m[0];
      minus3 = m[1];
      
      mem += line.length() - (minus1) - (3 * minus3) - 2;
    }
  
    System.out.println("8a)  literals - mem = " + (literals - mem) );
  }
  
  public static int[] countMemCharsPartA(String s) {
    
    char[] input = s.toCharArray();
    int inputLength = input.length;
    int minus1Count = 0;
    int minus3Count = 0;
    
    
    
    for (int i = 0; i < inputLength; i++) {
      //if first is \
      if (input[i] == '\\') {
        
        //we're not at the end
        if ( (i < inputLength - 1) && (input[i+1] == '\\' || input[i+1] == '"' ) ) {
          minus1Count++;
          i++; //skip next char
        }
        
        else if( (i < inputLength - 3) && input[i+1] == 'x' && areBothHex(input[i+2], input[i+3] )) {
          minus3Count++;
          i+=3; //skip 3
        }
      }
    }
    
    int[] solution = new int[2];
    solution[0] = minus1Count;
    solution[1] = minus3Count;
    
    return solution;
  }
  
  public static boolean areBothHex(char c1, char c2) {
    return ( (c1 >= '0' && c1 <= '9') || (c1 >= 'a' && c1 <= 'f') || (c1 >= 'A' && c1 <= 'F') ) &&
        ( (c2 >= '0' && c2 <= '9') || (c2 >= 'a' && c2 <= 'f') || (c2 >= 'A' && c2 <= 'F') ) ;
  }
  
  public static void question8b() throws IOException {
    BufferedReader br = QuestionUtil.readFile("input8.txt");
    String line;
    int literals = 0;
    int mem = 0;
    while ((line = br.readLine()) != null) {
       // process the line.
      literals += line.length();
      mem += line.length() + countCharsPartB(line) + 2;
      
    }
  
    System.out.println("8b)  mem - literals = " + (mem - literals) );
  }
  
  public static int countCharsPartB(String str) {
    char[] input = str.toCharArray();
    int count = 0;
    for (char c : input) {
      if (c == '\\' || c == '"') {
        count++;
      }
    }
    return count;
  }
}
