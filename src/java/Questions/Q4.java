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
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * This is the Q4 Class.  Its purpose is to :
 * 
 * 
 * @author Ryan Harrigan
 * @version Dec 5, 2015
 *
 */
public class Q4  {
  public static void answer() throws IOException {
    question4a();
    question4b();
  }
  
  public static void question4a() throws IOException {
    String input = "ckczppom";
    int counter = 0;
    
    
    while (!DigestUtils.md5Hex(input+counter).startsWith("00000")) {
      counter++;
    }
  
    System.out.println("4a)  Correct MD5 has found at counter: " + counter );
  }
  
  public static void question4b() throws IOException {
    String input = "ckczppom";
    int counter = 0;
    
    
    while (!DigestUtils.md5Hex(input+counter).startsWith("000000")) {
      counter++;
    }
  
    System.out.println("4b)  Correct MD5 has found at counter: " + counter );
  }
  
}
