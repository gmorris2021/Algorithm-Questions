import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CFG { 
  
    static int MAX_CHAR = 256; 
  
    // A utility function to find factorial of n 
    static int fact(int n) 
    { 
        return (n <= 1) ? 1 : n * fact(n - 1); 
    } 
  
    // Construct a count array where value at every index 
    // contains count of smaller characters in whole string 
    static void populateAndIncreaseCount(int[] count, char[] str) 
    { 
        int i; 
  
        for (i = 0; i < str.length; ++i) 
            ++count[str[i]]; 
  
        for (i = 1; i < MAX_CHAR; ++i) 
            count[i] += count[i - 1]; 
    } 
  
    // Removes a character ch from count[] array 
    // constructed by populateAndIncreaseCount() 
    static void updatecount(int[] count, char ch) 
    { 
        int i; 
        for (i = ch; i < MAX_CHAR; ++i) 
            --count[i]; 
    } 
  
    // A function to find rank of a string in all permutations 
    // of characters 
    static int findRank(char[] str) 
    { 
        int len = str.length; 
        int mul = fact(len); 
        int rank = 1, i; 
  
        // all elements of count[] are initialized with 0 
        int count[] = new int[MAX_CHAR]; 
  
        // Populate the count array such that count[i] 
        // contains count of characters which are present 
        // in str and are smaller than i 
        populateAndIncreaseCount(count, str); 
  
        for (i = 0; i < len; ++i) { 
            mul /= len - i; 
  
            // count number of chars smaller than str[i] 
            // fron str[i+1] to str[len-1] 
            rank += count[str[i] - 1] * mul; 
  
            // Reduce count of characters greater than str[i] 
            updatecount(count, str[i]); 
        } 
  
        return rank - 1; 
    } 
  
    // Driver code 
    public static void main(String args[]) throws IOException
    { 
        BufferedReader objReader = null;
        BufferedWriter objWriter = null;
        BufferedReader objReader2 = null;
        BufferedWriter objWriter2 = null;
        try {
            objReader = new BufferedReader(new FileReader("/Users/griffinmorris/eclipse-workspace/TestCode/Problem2.txt"));
            objWriter = new BufferedWriter(new FileWriter("/Users/griffinmorris/eclipse-workspace/TestCode/Problem3.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (objReader != null) {
            String curRead = objReader.readLine();
            while (curRead != null) {
                char str[] = curRead.toCharArray(); 
                System.out.print((char)(findRank(str))); 
                objWriter.write((char)(findRank(str))); 
                curRead = objReader.readLine();
            }
        }
        if (objWriter != null) {
            objWriter.flush();
            objWriter.close();
        }
        
    } 
} 