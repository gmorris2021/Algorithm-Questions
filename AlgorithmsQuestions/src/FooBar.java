import java.util.ArrayList;

public class FooBar {
    public static int[] solution(int[] l, int t) {
        int start = 0;
        int end = 0;
        int sum = l[0];
        int[] out = new int[2];
        while(start < l.length && end < l.length) {
            if (sum == t) {
                out[0] = start;
                out[1] = end;
                return out;
            } else if (sum < t) {
                end++;
                sum += l[end];
            } else {
                sum -= l[start];
                start++;
            }
            
        }
        out[0] = -1;
        out[1] = -1;
        return out;
    }
    
    public static void main(String[] args) {
        int[] in = {4,3,2,10, 8};
        int[] out = solution(in, 12);
        for (int i = 0; i < out.length; i++) {
            System.out.print(out[i] + " ");
        }
    }
}