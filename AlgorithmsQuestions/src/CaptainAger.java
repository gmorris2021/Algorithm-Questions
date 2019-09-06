import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CaptainAger {
    
    public static void main(String[] args) throws IOException {
        String cur = "";
        int c;
        BufferedReader in = new BufferedReader(new FileReader("/Users/griffinmorris/eclipse-workspace/TestCode/src/CaptainAger.txt"));
        c = in.read();
        boolean isString = false;
        char[] arr = new char[20];
        int len = 4;
        for (int i = 0; i < 20; i++) {
            arr[i] = ' ';
        }
        //arr[0] = 'h';
        //arr[1] = 'u';
        arr[3] = 'm';
        while (c != -1) {
            if (isValid(c)) {
                if (isString == false) {
                    cur = "";
                }
                isString = true;
            } else {
                if (isString == true) {
                    if (condition(cur, arr, len)) {
                        System.out.println(cur);
                    }
                }
                isString = false;
            }
            if (isString) {
                cur = cur + (char)c;
            } 
            c = in.read();
        }
        
    }
    
    public static boolean isValid(int c) {
        return ((c >= 97 && c <= 122) || (c >= 65 && c <= 90)) || c == 45 || c == 39;
    }
    
    public static boolean condition(String s1, char[] arr, int len) {
        String s = s1.toLowerCase();
        for (int i = 0; i < 20 && i < s.length(); i++) {
            if (arr[i] != ' ' && s.charAt(i) != arr[i]) {
                return false;
            }
        }
        return s.length() == len;
    }
}
