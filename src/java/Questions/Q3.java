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

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * 
 * This is the Q3 Class.  Its purpose is to :
 * 
 * 
 * @author Ryan Harrigan
 * @version Dec 5, 2015
 *
 */
public class Q3  {
  
  
  
  public static void answer() throws IOException {
    question3a();
    question3b();
  }
  
  public static void question3a() throws IOException {
    BufferedReader br = QuestionUtil.readFile("input3.txt");
    String line;
    HashMap<String, Point> visited = new HashMap<String, Point>();
    Point location = new Point(0,0);
    visited.put(location.toString(), location);
    while ((line = br.readLine()) != null) {
      char[] directions = line.toCharArray();
      for (char direction : directions) {
        switch(direction) {
        case '^':
          location.setLocation(location.getX(), location.getY() + 1);
          break;
        case 'v':
          location.setLocation(location.getX(), location.getY() - 1);
          break;
        case '<':
          location.setLocation(location.getX() - 1, location.getY());
          break;
        case '>':
          location.setLocation(location.getX() + 1, location.getY());
          break;
        default:
        }
        visited.put(location.toString(), location);
      }
      
    }
  
    System.out.println("3a)  The number of houses visted by Santa: "+ visited.size());
  }
  
  public static void question3b() throws IOException {
    BufferedReader br = QuestionUtil.readFile("input3.txt");
    String line;
    HashMap<String, Point> visited = new HashMap<String, Point>();
    Point tempLocation = null;
    Point santaLocation = new Point(0,0);
    Point botLocation = new Point(0,0);
    visited.put(santaLocation.toString(), santaLocation);
    visited.put(botLocation.toString(), botLocation);
    while ((line = br.readLine()) != null) {
      char[] directions = line.toCharArray();
      int flag = 0;
      for (char direction : directions) {
        tempLocation = flag % 2 == 0 ? santaLocation : botLocation;
        switch(direction) {
        case '^':
          tempLocation.setLocation(tempLocation.getX(), tempLocation.getY() + 1);
          break;
        case 'v':
          tempLocation.setLocation(tempLocation.getX(), tempLocation.getY() - 1);
          break;
        case '<':
          tempLocation.setLocation(tempLocation.getX() - 1, tempLocation.getY());
          break;
        case '>':
          tempLocation.setLocation(tempLocation.getX() + 1, tempLocation.getY());
          break;
        default:
        }
        flag++;
        visited.put(tempLocation.toString(), tempLocation);
      }
      
    }
  
    System.out.println("3b)  The number of houses visted by Santa/Bot team: "+ visited.size());
  }
  
  
}
