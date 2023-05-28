package my.practice.ctci.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishal Joshi
 */
public class SplitArrayFibonacci {

    public static void main(String[] args) {
        SplitArrayFibonacci fib = new SplitArrayFibonacci();
        System.out.println(fib.splitIntoFibonacci("123456579"));
    }

    List<Integer> result;
    public List<Integer> splitIntoFibonacci(String s) {
        result = new ArrayList<>();
        backtrack(0, new ArrayList<>(), s);
        return result;
    }

    private boolean backtrack(int start, List<Integer> current, String s){
        System.out.println(current);
        if(start>=s.length() && isFibonacci(current)){
            System.out.println("Fibonaaci found: "+ current);
            result=current;
            return true;
        }

        if(current.size()>2 && !isFibonacci(current)){
            return false;
        }

        for(int i=start; i<s.length(); i++){
            if((i-start)>=(s.length()/2)){
                break;
            }
            String toAdd = s.substring(start, i+1);
            if(toAdd.length()>1 && toAdd.startsWith("0")){
                continue;
            }
            long num = Long.parseLong(toAdd);
            if (num > Integer.MAX_VALUE) {
                break;
            }
            current.add((int)num);
            if(backtrack(i+1, current, s)){
                return true;
            } else {
                current.remove(current.size()-1);
            }

        }
        return false;
    }

    private boolean isFibonacci(List<Integer> current){
        if(current.size()>2){
            int pointer = 2;
            while(pointer<current.size()){
                if(current.get(pointer)==current.get(pointer-1)+current.get(pointer-2)){
                    pointer++;
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
