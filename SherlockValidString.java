import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SherlockValidString {
    public static void main(String[] args) {
        String s = "abcdefghhgfedecba";


        System.out.println(checkString(s));



    }

    public static String checkString(String s){
        final String good = "YES";
        final String bad = "NO";
        if(s.equals(null) || s.isEmpty())
            return bad;
        if(s.length() == 3){
            return good;
        }
        int[] arr = new int[26];
        for(int i = 0; i<s.length();i++){
            int index = s.charAt(i) - 97 ;
            arr[index]++;
        }
        Arrays.sort(arr);
        int j =0;
        while(arr[j]==0){
            j++;
        }
        int min = arr[j];
        int max = arr[25];
        String res = bad;
        if(min == max) res = good;
        else{
            if((max-min ==1 && arr[24]==min) || (min == 1 && arr[j+1]==max))
                res =good;
        }
        return res;
    }
}
