import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class HashiItOut {
    static int[] letters = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader in= new BufferedReader(new FileReader("/Users/griffinmorris/eclipse-workspace/TestCode/src/HashiItOut.txt"));
        String s = in.readLine();
        int count = 0;
        String[] arr = new String[13];
        while (s != null) {
        arr[count] = s;
        count++;
        System.out.println(s);
        s = in.readLine();
        }
        int[] scount = new int[13];
        System.out.println("Num in Common");
        int sum = 0;
        for (int i = 0; i < 13; i++) {
            for (int j = i + 1; j < 13; j++) {
                if (numInCommonInPlace(arr[i], arr[j]) > 0) {
                    scount[i]++;
                    scount[j]++;
                System.out.println(arr[i] + " " + arr[j] + ":" + numInCommon(arr[i], arr[j]) + 
                        "," + numInCommonInPlace(arr[i], arr[j]));
                sum += numInCommonInPlace(arr[i], arr[j]);
            }
        }
        }
        System.out.println(sum);
        for (int i = 0; i < 13; i++) {
       //System.out.println(arr[i] + ":" + scount[i]);   
        }
        for (int i = 0; i < 13; i++) {
            numCount(arr[i]);
        }
        for (int i = 0; i < 26; i++) {
           // System.out.println((char)(65 + i) + ":" + letters[i]);
        }
        }
        
    
    public static int numInCommon(String s1, String s2) {
        for(int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            int b = s2.indexOf(a);
            if (b != -1) {
                return 1 + numInCommon(s1.substring(0, i) + s1.substring(i + 1), 
                        s2.substring(0, b) + s2.substring(b + 1));
            } 
        }
        return 0;
        
    }
    
    public static int numInCommonInPlace(String s1, String s2) {
        int count = 0;
        for(int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if (a == b) {
                count++;
            }
        }
        return count;
        
    }
    
    public static void numCount(String s) {
        Set<Character> chars = new HashSet<Character>();
        //for (int i = 0; i < s.length(); i++) {
           // chars.add(s.charAt(i));
        //}
        for (Character c : chars) {
            letters[c - 65]++;
        }
    }
    
}
