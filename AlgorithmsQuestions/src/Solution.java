import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int longestStrChain(String[] words) {
        
        Arrays.sort(words, new Comparator<String>(){
            @Override
            public int compare(String s, String a) {
                return s.length() - a.length();
            }
            
        });
        String cur;
        int len = 1;
        int maxlen = 0;
        for(int i = words.length - 1; i >= 0; i--) {
            cur = words[i];
            len = 1;
            for (int j = i; j >= 0; j--) {
                if (isPred(cur, words[j])) {
                    len++;
                    cur = words[j];
                }
            }
            if (len > maxlen) {
                maxlen = len;
            }
        }
        return maxlen;
        
    }
    
    public boolean isPred(String a, String b) {
        int len = Math.max(b.length(), a.length());
        for (int i = 0; i < len; i++) {
            if (a.length() < b.length()) {
                if(a.equals(b.substring(0, i) + b.substring(i+1))) {
                return true;
                }
            } else if (a.length() > b.length()) {
                if(b.equals(a.substring(0, i) + a.substring(i+1))) {
                    return true;
                    }
            } else {
                return false;
            }
        }
        return false;
    }
    
}