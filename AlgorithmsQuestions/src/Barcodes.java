import java.util.*;

public class Barcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Arrays.sort(barcodes);
        ArrayList<Integer> bars = new ArrayList<Integer>();
        for (int i = 0; i < barcodes.length; i++) {
            bars.add(barcodes[i]);
        }
        int place = isGood(bars);
        while (place != -1) {
            insert(bars, 0);
            place = isGood(bars);
        }
        for (int i = 0; i < barcodes.length; i++) {
            barcodes[i] = bars.get(i);
        }
        return barcodes;
    }
    
    public int isGood(List<Integer> bars) {
        for (int i = 0; i < bars.size() - 1; i++) {
            if(bars.get(i) == bars.get(i + 1)) {
                return i;
            }
        }
        return -1;
    }
    
    public void insert(List<Integer> bars, int place) {
        int a = bars.remove(place);
        place = 0;
        while (place < bars.size() - 1 && (bars.get(place) == a || bars.get(place+1) == a)) {
            place++;
        }
        if (place == bars.size() - 1) {
            bars.add(a);
        } else {
            bars.add(place + 1, a);
        }
    }
}