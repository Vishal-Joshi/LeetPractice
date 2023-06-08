package my.practice.ctci.leet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vishal Joshi
 */
public class Anagram {

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            Integer sElemCount = sCount.get(s.charAt(i));
            Integer tElemCount = tCount.get(t.charAt(i));
            if(sElemCount != null){
                sCount.put(s.charAt(i), ++sElemCount);
            } else {
                sCount.put(s.charAt(i), 1);
            }

            if(tElemCount != null){
                tCount.put(t.charAt(i), ++tElemCount);
            } else {
                tCount.put(t.charAt(i), 1);
            }
        }

        for(Map.Entry<Character, Integer> entry: sCount.entrySet()){
            if(!entry.getValue().equals(tCount.get(entry.getKey()))) {
                return false;
            }
        }

        return true;
    }
}
