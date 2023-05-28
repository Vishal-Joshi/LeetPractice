package my.practice.ctci.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vishal Joshi
 */
public class RestoreIP {

    List<String> result;

    static String s;
    public static void main(String[] args) {
        RestoreIP ip = new RestoreIP();
        s="25525511135";
        System.out.println(ip.restoreIpAddresses(s));

    }

    public List<String> restoreIpAddresses(String s) {
        List<String> resultList = new ArrayList<String>();
        if (s == null || s.length() < 4) {
            return resultList;
        }

        // DFS
        dfs(resultList, s, 0, "", 0);

        return resultList;
    }

    private void dfs(List<String> resultList, String s, int start, String stored, int count) {
        //exit
        System.out.println(stored);
        if (start == s.length() && count == 4) {
            resultList.add(stored);
        }

        if (start >= s.length() || count == 4) {
            return;
        }

        for (int i = 1; i < 4; i++) {
            if (start + i > s.length()) {
                break;
            }
            String part = s.substring(start, start + i);
            if ((part.startsWith("0") && part.length() > 1) || (i == 3 && Integer.valueOf(part) > 255)) {
                continue;
            }
            dfs(resultList, s, start + i, stored + part + (count == 3 ? "" : "."), count + 1);
        }
    }

//    public List<String> restoreIpAddresses(String s) {
//        result = new ArrayList<>();
//        backtrack(0, "");
//        return result;
//    }
//
//    private void backtrack(int start, String sub){
//        System.out.println(sub);
//        if(start==s.length() && isValid(sub)){
//            result.add(sub);
//            return;
//        }
//
//        if (start >= s.length() || sub.split("\\.").length == 4) {
//            return;
//        }
//
//        for(int end=start; end<s.length(); end++){
//            String subToAdd = null;
//            boolean withDot=false;
//            if(sub.split("\\.").length<=3){
//                subToAdd=s.substring(start, end+1)+".";
//                withDot=true;
//            } else {
//                withDot=false;
//                subToAdd=s.substring(start, end+1);
//            }
//            sub+=subToAdd;
//            backtrack(end+1, sub);
//            if(withDot){
//                sub=sub.substring(0, sub.length()-2);
//            } else {
//                sub=sub.substring(0, sub.length()-1);
//            }
//        }
//    }
//
//    private boolean isValid(String s){
//        String[] substrings = s.split("\\.");
//        if(substrings.length==4){
//            for(String sub: substrings){
//                if(sub.length()>1 && sub.startsWith("0")){
//                    return false;
//                }
//                try{
//                    if(Integer.parseInt(sub)>255){
//                        return false;
//                    }
//                } catch (NumberFormatException ex){
//                    return false;
//                }
//            }
//            return true;
//        }
//        return false;
//    }
}
