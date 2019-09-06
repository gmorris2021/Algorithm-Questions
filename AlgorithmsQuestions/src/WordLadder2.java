import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2{
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    HashMap<String, List<String>> strs = new HashMap<String, List<String>>();
    for (String s : wordList) {
        putMap(strs, s);
    }
    bfsNode outNode = bfs(beginWord, endWord, strs);
    List<List<String>> outlist = new ArrayList<List<String>>();
    List<String> curlist = new ArrayList<String>();
    backtrack(outNode, curlist, outlist, beginWord, 0, wordList.size());
    cut(outlist);
    return outlist; 
}
    
    private bfsNode bfs(String strt, String end, HashMap<String, List<String>> strs)     {
      Set<String> discovered = new HashSet<String>();
      HashMap<String, bfsNode> nodes = new HashMap<String, bfsNode>();
      Queue<String> q = new LinkedList<String>();  
      q.add(strt);
      String v;
      bfsNode cur = null;
      bfsNode foundcur = null;
      String strcheck;
      boolean found = false;
      List<String> nbs;
      nodes.put(strt, new bfsNode(strt));
      while (!q.isEmpty()) {
          v = q.poll();
          if (!discovered.contains(v)) {
          discovered.add(v);
          for (int i = 0; i < v.length(); i++) {
             strcheck = v.substring(0, i) + '*' + v.substring(i + 1);
             nbs = strs.get(strcheck);
             if (nbs != null) {
             for (String s : nbs) {
              if (!s.equals(v)) {   
              if (!discovered.contains(s)) {
                  if (!found) {
                      q.add(s);
                  }
                  if (!nodes.containsKey(s)) {
                      cur = new bfsNode(s);
                  } else {
                      cur = nodes.get(s);
                  }
                  cur.addPar(nodes.get(v));
                  nodes.put(s, cur);
              } 
              if (end.equals(s)) {
                  found = true;
                  foundcur = cur;
              }
              }
            }
             }
          } 
          }
      }
      if (!found) {
          return null;
      } else {
         return foundcur;
      }
    }
    
    private void backtrack(bfsNode node, List<String> curlist, List<List<String>> outlist, String start, int count, int end) {
        if (count >= end) {
            return;
        }
        if (node != null) {
            curlist.add(0, node.str);
            if (node.str.equals(start)) {
                outlist.add(curlist);
                return;
            }
            for (bfsNode b : node.rents) {
                backtrack(b, new ArrayList<String>(curlist), outlist, start, count + 1, end);
            }
        } 
    }
    
    private void cut(List<List<String>> outlist) {
        int min = Integer.MAX_VALUE;
        for (List<String> s : outlist) {
            if (s.size() < min) {
                min = s.size();
            }
        }
        for (int i = 0; i < outlist.size(); ) {
            if(outlist.get(i).size() > min) {
                outlist.remove(i);
            } else {
                i++;
            }
        }
    }
    
    private void putMap(HashMap<String, List<String>> map, String str) {
        String strsert;
        List<String> list;
        for (int i = 0; i < str.length(); i++) {
            strsert = str.substring(0, i) + '*' + str.substring(i + 1);
            list = map.get(strsert);
            if (list == null) {
                list = new ArrayList<String>();
                list.add(str);
                map.put(strsert, list);
            } else {
                list.add(str);
                map.put(strsert, list);
            }
        }
        
    }
    
    private class bfsNode {
        Set<bfsNode> rents;
        String str;
        public bfsNode(String str) {
            this.str = str;
            rents = new HashSet<bfsNode>();
        }
        
        public void addPar(bfsNode rent) {
            rents.add(rent);
        }
    }
    
    
}