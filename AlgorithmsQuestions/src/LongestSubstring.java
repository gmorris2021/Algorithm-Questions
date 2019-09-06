import java.util.LinkedList;
import java.util.Queue;

public class LongestSubstring {
    public String longestDupSubstring(String S) {
        SuffixTrie s = new SuffixTrie();
        for (int i = S.length() - 1; i >= 0; i--) {
            s.addString(S.substring(i, S.length()), 5);
        }
        return s.bfs();
    }
    
    private class SuffixTrie {
        Node root;
        
        public SuffixTrie() {
            root = new Node();
        }
        
        public void addString(String s, int value) {
            Node cur = root;
            Node next;
            for (int i = 0; i < s.length(); i++) {
                next = cur.getNode(s.charAt(i));
                if (next == null) {
                    next = new Node();
                    cur.setNode(s.charAt(i), next);
                } 
                cur = next;
            }
            cur.val = value;
        }
            
        public String bfs() {
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);
            Node v;
            String out = "";
            Node lowest = root;
            Node cur;
            while (!q.isEmpty()) {
                v = q.poll();
                for (int i = 0; i < 26; i++) {
                    cur = v.getNode((char)(i + 97));
                    if (cur != null) {
                        q.add(cur);
                        if (cur.numchildren >= 2 || (cur.numchildren > 0 && cur.val != -1)) {
                            lowest = cur;
                        }
                    }
                }  
            }
            while (lowest != root) {
                cur = lowest.parent;
                for (int i = 0; i < 26; i++) {
                    if (cur.getNode((char)(i + 97)) == lowest) {
                        out = (char)(i + 97) + out;
                    }
                }
                lowest = cur;
            }
            return out;
        }
        
        
        
        private class Node {
            Node[] children;
            Node parent;
            int numchildren;
            int val;
            public Node() {
                val = -1;
                numchildren = 0;
                parent = null;
                children = null;
            }
            
            public void setNode(char c, Node newN) {
                if (children == null) {
                    children = new Node[26];
                }
                if (children[(int)c - 97] == null) {
                    numchildren++;
                }
                children[(int)c - 97] = newN;
                newN.parent = this;
            }
            
            public Node getNode(char c) {
                if (children == null) {
                    return null;
                } else {
                    return children[(int)c - 97];
                }
            }
        }
    }
}