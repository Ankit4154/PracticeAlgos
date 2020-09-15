/*
Program to split a given string into tokens
and prints them in alphabetical order
*/
import java.util.Set;
import java.util.TreeSet;

public class StringToken {
    public static void main(String args[]) {
        String s = "abc";
        String res = "";
        Set<String> set = new TreeSet<String>();
        for(int i=0;i<s.length();i++){
            for(int j=0;j<(s.length()- i);j++){
                for(int k=j;k<=i+j;k++){
                    res += s.charAt(k);
                }
                set.add(res);
                //System.out.print(res+" ");
                res = "";
            }
        }
        for(String x: set)
            System.out.println(x);
    }
}