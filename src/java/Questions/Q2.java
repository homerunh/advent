package Questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * 
 * See problem statement at http://adventofcode.com/day/2
 * 
 * 
 * This is the Q2 Class.  Its purpose is to :
 * 
 * 
 * @author Ryan Harrigan
 * @version Dec 5, 2015
 *
 */
public class Q2 {

  public static void answer() throws IOException {
    question2a();
    question2b();
  }
  
  public static void question2a() throws IOException {
    BufferedReader br = QuestionUtil.readFile("input2.txt");
    int paperTotal, ribbonTotal;
    paperTotal = ribbonTotal = 0;
    Box box;
    String line;
    while ((line = br.readLine()) != null) {
       // process the line.
      box = parseBox(line);
      paperTotal += box.getSA() + box.getExtraSlack();
      ribbonTotal += box.getRibbonWrap() + box.getRibbonBow();
    }
  
    System.out.println("2a) Wrapping paper: sum of wrapping paper need:  " + paperTotal);
    System.out.println("2b) Wrapping paper: sum of ribbon needed:  " + ribbonTotal);
  }
  
  public static void question2b() {
    
  }
  
  public static Box parseBox(String boxString) {
    String[] sides = boxString.split("x");
    return new Box(Integer.parseInt(sides[0]), Integer.parseInt(sides[1]), Integer.parseInt(sides[2]));
  }
  
  private static class Box {
    int w, h, l = 0;
    int[] sorted = null;
    
    public Box(int w, int h, int l) {
      this.w = w;
      this.h = h;
      this.l = l;
      sorted = sortBox();
    }
    
    /**
     * get surface area
     */
    public int getSA() {
      return 2*w*l + 2*w*h + 2*h*l;
    }
    
    /**
     * get the extra slack needed for a box,
     * 
     * it is: 
     * the area of the smallest side
     */
    public int getExtraSlack() {
      return sorted[0] * sorted[1];
    }
    
    /**
     * get the length of ribbon to wrap a box:
     * the shortest distance around the sides.
     * 
     * let h and w be the smallest sides of a box,
     * then formula is -->  2*h + 2*w
     */
    public int getRibbonWrap() {
      return 2*sorted[0] + 2*sorted[1];
    }
    
    /**
     * get the length of ribbon for the bow:
     * equal to the volume of the box
     */
    public int getRibbonBow() {
      return w*l*h;
    }
    
    private int[] sortBox() {
      int[] sides = {w, h, l};
      Arrays.sort(sides);
      return sides;
    }
  }
}
