/**
 *  Ryan Harrigan
 * 
 *
 */
package Questions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * This is the Q6 Class.  Its purpose is to :
 * 
 * 
 * @author Ryan Harrigan
 * @version May 13, 2016
 *
 */
public class Q6 {
  
  public static boolean[][] lights = new boolean[1000][1000];
  public static int[][] lightsint = new int[1000][1000];
  public static int lightSize = 1000;
  
  public static void question6a() throws IOException {
    turnOffAllLights();
    try (BufferedReader br = new BufferedReader(new FileReader("input6.txt"))) {
      String line;
      
      while ((line = br.readLine()) != null) {
         // process the line.
        processCommand( parseCommand(line));
     
      }
    }
    countLights();
  }
  
  public static void question6b() throws IOException {
    turnOffAllLightsint();
    try (BufferedReader br = new BufferedReader(new FileReader("input6.txt"))) {
      String line;
      
      while ((line = br.readLine()) != null) {
         // process the line.
        processCommandint(parseCommand(line));
      }
    }
    countLightsInt();
  }
  
  public static void countLights() {
    int count = 0;
    for (int i = 0; i < lightSize; i++) {
      for (int j = 0; j < lightSize; j++) {
        if (lights[i][j]) count++;
      }
    }
    
    System.out.println("count is " + count);
  }
  
  public static void countLightsInt() {
    int count = 0;
    for (int i = 0; i < lightSize; i++) {
      for (int j = 0; j < lightSize; j++) {
        count += lightsint[i][j]; 
      }
    }
    
    System.out.println("count is " + count);
  }
  
  public static void turnOffAllLights() {
    for (int i = 0; i < lightSize; i++) {
      for (int j = 0; j < lightSize; j++) {
        lights[i][j] = false;
      }
    }
  }
  
  public static void turnOffAllLightsint() {
    for (int i = 0; i < lightSize; i++) {
      for (int j = 0; j < lightSize; j++) {
        lightsint[i][j] = 0;
      }
    }
  }
  
  public static void processCommand(Command c) {
    for (int i = c.startY ; i <c.endY + 1 ; i++) {
      for (int j = c.startX ; j <c.endX + 1; j++) {
        switch(c.doThis) {
        case "on":
          lights[i][j] = true;
          break;
        case "off":
          lights[i][j] = false;
          break;
        case "toggle":
          lights[i][j] = !lights[i][j];
          break;
        }
      }
    }
  }
  
  public static void processCommandint(Command c) {
    for (int i = c.startY ; i <c.endY + 1 ; i++) {
      for (int j = c.startX ; j <c.endX + 1; j++) {
        switch(c.doThis) {
        case "on":
          lightsint[i][j]++;
          break;
        case "off":
          if (lightsint[i][j] > 0)lightsint[i][j]--;
          break;
        case "toggle":
          lightsint[i][j]+=2;
          break;
        }
      }
    }
  }
  
  /**
   * Turn a string into a command... Example commandStings:
   * 
   * turn on 489,959 through 759,964
   * turn off 820,516 through 871,914
   * toggle 756,965 through 812,992
   * 
   * @param commandString
   * @return
   */
  public static Command parseCommand(String commandString) {
    String doThis = "";
    int x1 = -1;
    int y1 = -1;
    int x2 = -1;
    int y2 = -1;
    
    //split
    String[] pieces = commandString.split(" ");
    
    if (pieces[0].equals("turn")) {
      //turn on
      if (pieces[1].equals("on")) {
        doThis += "on";
      }
      //turn off
      else {
        doThis += "off";
      }
      
      String[] firstPoint = pieces[2].split(",");
      x1 = Integer.parseInt(firstPoint[0]);
      y1 = Integer.parseInt(firstPoint[1]);
      String[] secondPoint = pieces[4].split(",");
      x2 = Integer.parseInt(secondPoint[0]);
      y2 = Integer.parseInt(secondPoint[1]);
    }
    //toggle
    else {
      doThis += "toggle";
      String[] firstPoint = pieces[1].split(",");
      x1 = Integer.parseInt(firstPoint[0]);
      y1 = Integer.parseInt(firstPoint[1]);
      String[] secondPoint = pieces[3].split(",");
      x2 = Integer.parseInt(secondPoint[0]);
      y2 = Integer.parseInt(secondPoint[1]);;
    }
    return new Command(doThis, x1, y1, x2, y2);
  }
  
  public static class Command {
    public String doThis;
    public int startX;
    public int startY;
    public int endX;
    public int endY;
    
    public Command(String doThis, int startX, int startY, int endX, int endY ) {
      this.doThis = doThis;
      this.startX = startX;
      this.startY = startY;
      this.endX = endX;
      this.endY = endY;
    }
    
    public String toString() {
      return "type: " + this.doThis + "\nx1: " + this.startX + "\ny1: " + this.startY+ "\nx2: " + this.endX + "\ny2: " + this.endY ;
    }
  }

}
