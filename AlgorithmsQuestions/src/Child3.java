import java.util.ArrayList;
import java.util.List;

public class Child3 {
    public static void main(String[] args) {
        List<List<Integer>> roomlist = new ArrayList<List<Integer>>();
        roomlist.add(0, null);
        int[] arr1 = {11};
        roomlist.add(makeArr(arr1));
        int[] arr2 = {9};
        roomlist.add(makeArr(arr2));
        int[] arr3 = {8};
        roomlist.add(makeArr(arr3));
        int[] arr4 = {3};
        roomlist.add(makeArr(arr4));
        int[] arr5 = {2};
        roomlist.add(makeArr(arr5));;
        int[] arr6 = {18, 17};
        roomlist.add(makeArr(arr6));
        int[] arr7 = {24};
        roomlist.add(makeArr(arr7));
        int[] arr8 = {6};
        roomlist.add(makeArr(arr8));
        int[] arr9 = {21, 18};
        roomlist.add(makeArr(arr9));
        int[] arr10 = {16};
        roomlist.add(makeArr(arr10));
        int[] arr11 = {4};
        roomlist.add(makeArr(arr11));
        int[] arr12 = {23, 17};
        roomlist.add(makeArr(arr12));
        int[] arr13 = {14};
        roomlist.add(makeArr(arr13));
        int[] arr14 = {7};
        roomlist.add(makeArr(arr14));
        int[] arr15 = {18, 12};
        roomlist.add(makeArr(arr15));
        int[] arr16 = {5};
        roomlist.add(makeArr(arr16));
        int[] arr17 = {19};
        roomlist.add(makeArr(arr17));
        int[] arr18 = {20};
        roomlist.add(makeArr(arr18));
        int[] arr19 = {21, 15, 12};
        roomlist.add(makeArr(arr19));
        int[] arr20 = {21, 15, 23};
        roomlist.add(makeArr(arr20));
        int[] arr21 = {14, 22};
        roomlist.add(makeArr(arr21));
        int[] arr22 = {13};
        roomlist.add(makeArr(arr22));
        int[] arr23 = {10};
        roomlist.add(makeArr(arr23));
}


static List<Integer> makeArr(int[] arr) {
    List<Integer> out = new ArrayList<Integer>();
    for (int i = 0; i < arr.length; i++) {
        out.add(arr[i]);
    }
    return out;
}
}
