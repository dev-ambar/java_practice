package hackerrank;

import java.util.HashMap;
import java.util.HashSet;

public class StringHaveSameCharacter {

    public static void main(String arg[])
    {
        int  result = isHaveSameCharacter("sdfc","scfd");
        if(result==1)
            System.out.println("both string have same characters");
        else System.out.println("both string have not same characters");
    }

    private static int isHaveSameCharacter(String str1, String str2) {

        if(str1.length()!=str2.length())
            return 0;
        /*int arr [] = new int[256];
        for(int i = 0 ; i < str1.length() ; i++)
        {
            arr[str1.charAt(i)]++;
            arr[str2.charAt(i)]--;
        }
        for(int x : arr)
        {
            if(x!=0)
                return 0;
        }*/
        /*HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0 ;i <str1.length() ;i++)
        {
            if(!hm.containsKey(str1.charAt(i)))
                 hm.put(str1.charAt(i),0);
            else
                 hm.put(str1.charAt(i),hm.get(str1.charAt(i))+1);
            if(!hm.containsKey(str2.charAt(i)))
                hm.put(str2.charAt(i),0);
            else
                hm.put(str2.charAt(i),hm.get(str2.charAt(i))+1);
        }
        for(int e : hm.values())
        {
            if(e==0)return 0;
        }*/

        return 1;
    }
}
