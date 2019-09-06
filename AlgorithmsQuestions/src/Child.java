import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Child {
   

    
    public static void main(String[] args) {
        int[] b = parse("cerium");
        for (int i = 0; i < b.length; i++) {
            System.out.print("1" + tan(b[i]) + " ");
        }
    }  
    
    static int tan(double d) {
       return 8 - (int)Math.floor((java.lang.Math.tan(d)));
    }
    
    static int[] parse(String s) {
        int[] a = new int[s.length() / 2];
        for (int i = 0; i < s.length(); i = i + 2) {
            a[i / 2] = (s.charAt(i) - 96) * (s.charAt(i + 1) - 96);
            System.out.print(a[i / 2] + " ");
        }
        System.out.println();
    return a;
    }  
}
