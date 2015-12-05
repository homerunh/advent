import java.io.IOException;

import Questions.*;

/**
 * 
 * This is the Go Class.  Its purpose is to :
 * 
 * 
 * @author Ryan Harrigan
 * @version Dec 4, 2015
 * 
 * generic Q class:
 * 
public class Q  {
  public static void answer() throws IOException {
    questiona();
    questionb();
  }
  
  public static void question a() throws IOException {
    BufferedReader br = QuestionUtil.readFile("input.txt");
    String line;
    while ((line = br.readLine()) != null) {
       // process the line.
      
    }
  
    System.out.println("something: " );
  }
  
  public static void question b() throws IOException {
    BufferedReader br = QuestionUtil.readFile("input.txt");
    String line;
    while ((line = br.readLine()) != null) {
       // process the line.
      
    }
  
    System.out.println("something: " );
  }
}

 *
 */
public class Go {

	//-------------------------- Class Method --------------------------------------
	/**
	 * Place a description of your method here.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("The advent challenge!!!");
		Q1.answer();
		Q2.answer();
		Q3.answer();
		//Q4.answer();
		Q5.answer();
		
	}

	
}
