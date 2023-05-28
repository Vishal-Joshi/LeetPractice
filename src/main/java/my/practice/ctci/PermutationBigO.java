package my.practice.ctci;

/**
 * @author Vishal Joshi
 */
public class PermutationBigO {

    public void permutation (String str){
        permutation(str, "");
    }

    private void permutation(String str, String prefix) {
        if(str.length()==0){
            System.out.println(prefix);
        } else {
            for(int i=0; i<str.length();i++){
                String rem = str.substring(0,i)+str.substring(i+1);
                System.out.printf("permutation(%s, %s);%n", rem, prefix+str.charAt(i));
                permutation(rem, prefix+str.charAt(i));
            }
        }

    }
}
