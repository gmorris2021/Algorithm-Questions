
import java.util.*;
public class TopKElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Boolean> inHeap = new HashMap<Integer, Boolean>();
        PriorityQueue<Entry> a = new PriorityQueue<Entry>();
        HashMap<Integer,Integer> out = new HashMap<Integer, Integer>();
        int count;
        for (int i = 0; i < nums.length; i++) {
            count = out.getOrDefault(nums[i], 0) + 1;
            out.put(nums[i], count);
        }
        for (int i = 0; i < nums.length; i++) {
            count = out.get(nums[i]);
            if (a.size() == 0) {
                a.add(new Entry(nums[i], count));
                inHeap.put(nums[i], true);
            } else if (!inHeap.getOrDefault(nums[i] ,false) && a.size() < k) {
                a.add(new Entry(nums[i], count));
                inHeap.put(nums[i], true);
            } else if (!inHeap.getOrDefault(nums[i] ,false) && out.get(a.peek().val) < count)                {
                inHeap.put(nums[i], true);
                inHeap.put(a.poll().val, false);
                a.add(new Entry(nums[i], count));
            }
        }
        List<Integer> oout = new LinkedList<Integer>();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            oout.add(a.poll().val);
        }
        return oout;
    }
        
        class Entry implements Comparable<Entry>{
            int val;
            int num;
            public Entry(int val, int num) {
                this.val = val;
                this.num = num;
            }
            
            @Override
            public int compareTo(Entry a) {
                return this.num - a.num;
            }
            
            @Override
            public String toString() {
                return val + ":" + num; 
            }
            
            public boolean is(int a) {
                return val == a;
            }
        }
    }
