package Questions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 
 * This is the QuestionUtil Class.  Its purpose is to :
 * 
 * read strings from files.
 * 
 * @author Ryan Harrigan
 * @version Dec 5, 2015
 *
 *
 *  Here is how you can use it!
 *  
 *  
    BufferedReader br = QuestionUtil.readFile("input1.txt");
    String line;
    while ((line = br.readLine()) != null) {
       // process the line.
      
    }
  
    System.out.println("something: " + answer);
 *
 *
 */
public class QuestionUtil {
  
  public static BufferedReader readFile(String fileName) throws FileNotFoundException {
    return new BufferedReader(new FileReader(fileName)); 
  }
}
