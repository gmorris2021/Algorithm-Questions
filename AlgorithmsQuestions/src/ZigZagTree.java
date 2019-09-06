import java.util.*;

public class ZigZagTree {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> l = new LinkedList<Integer>();
       return pathInZigZagTreeRec(label, l);
    }
    
    public List<Integer> pathInZigZagTreeRec(int label, List<Integer> l) {
        l.add(0, label);
        if (label == 1) {
            return l;
        }
        int rownumber = 0;
        int m = label;
        while (m > 0) {
            rownumber++;
            m /= 2;
        }
        m = rownumber;
        int numInRow = (int)Math.pow(2, m - 1);
        int start = numInRow;
        int place = label - numInRow;
        int placeabove = (int)Math.pow(2, m - 2) - place / 2;
        int num = (int)Math.pow(2, m - 2) + placeabove - 1;
        return pathInZigZagTreeRec(num, l);
    }
}
