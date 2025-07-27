import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n: tangerine){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        Set<Integer> set = map.keySet();
        ArrayList<Pair> list = new ArrayList<>();
        for(int key: set){
            list.add(new Pair(key, map.get(key)));
        }
        
        Collections.sort(list);
        
        int total = tangerine.length;
        int kindNum = set.size();
        for(Pair tmp: list){
            int minus = total-tmp.value;
            
            if(minus>=k){
                total -= tmp.value;
                kindNum--;
            }else{
                break;
            }
        }
        
        
        
        return kindNum;
        
    }
}

class Pair implements Comparable<Pair>{
    int key;
    int value;
    
    public Pair(int key, int value){
        this.key = key;
        this.value = value;
    }
    
    @Override
    public int compareTo(Pair o){
        return this.value - o.value;
    }
}