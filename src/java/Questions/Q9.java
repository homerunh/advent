package Questions;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;



public class Q9 {
  
  static int [][] tsp = { {0, 65, 129, 144, 71, 137, 3, 149 },
    {65, 0, 63, 4, 105, 125, 55, 14},
    {129, 63, 0, 68, 52, 65, 22, 143},
    {144, 4, 68, 0, 8, 23, 136, 115},
    {71, 105, 52, 8, 0, 101, 84, 96},
    {137, 125, 65, 23, 101, 0, 107, 14},
    {3, 55, 22, 136, 84, 107, 0, 46},
    {149, 14, 143, 115, 96, 14, 46, 0}};
  static HashMap<String, Integer> costMap = new HashMap<String, Integer>();
  
  
  public static void answer() throws IOException {
    question9a();
    question9b();
  }
  
  public static void question9a() throws IOException {
    
    
    printSeq(8, 8);
    int minimum = Integer.MAX_VALUE;
    for (Integer c : costMap.values()) {
      if (c < minimum)
        minimum = c;
    }
    
    System.out.println("9a)  min cost is: " + minimum);
  }
  
  public static void question9b() throws IOException {
    printSeq(8, 8);
    int maximum = Integer.MIN_VALUE;
    for (Integer c : costMap.values()) {
      if (c > maximum)
        maximum = c;
    }
    
    System.out.println("9b)  min cost is: " + maximum);
    
    
  }
  
  public static void printSeqRecursive(int[] nums, int n, int k, int index) {
    int i;
    
    if (k == 0) {
      Set<Integer> someInts = new HashSet<Integer>();
      for (int j : nums) {
        someInts.add(j);
      }
      
      if (someInts.size() == nums.length) {
        //magic here!
        String path = printArray(nums, index);
        //System.out.println("total for " + path + " is  = " + calculateRoundTripTotal(path) );
        costMap.put(path, calculateRoundTripTotal(path));
      }
        
    }
    
    if (k > 0) {
      for (i = 1; i<=n; ++i) {
        nums[index] = i;
        printSeqRecursive(nums, n, k - 1, index + 1);
      }
    }
  }
  
  public static void printSeq(int n, int k) {
    int[] nums = new int[k];
    printSeqRecursive(nums, n, k, 0);
    return;
  }
  
  public static String printArray(int arr[], int size) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
      sb.append(arr[i] + " ");
    }
    
    //System.out.println(sb.toString());
    return sb.toString();
  }
 
  public static int getCost(int source, int destination) {
    return tsp[source][destination];
  }
  
  public static int calculateRoundTripTotal(String path) {
    String[] pathArray = path.split(" ");
    int runningTotal = 0;
    int src = -1;
    int dest = -1;
    for (int i = 0; i < pathArray.length - 1; i++) {
      src = Integer.parseInt(pathArray[i]) - 1;
      dest = Integer.parseInt(pathArray[i+1]) - 1;
      runningTotal += getCost(src, dest);
    }
    
    return runningTotal;
  }

}
