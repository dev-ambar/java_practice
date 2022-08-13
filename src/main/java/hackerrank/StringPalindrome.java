package hackerrank;



public class StringPalindrome {


    private static int checkPalindrome(String str)
    {
        int i , j, flag;
         i = 0;
         j = str.length()-1;
         flag = 0;
         while(i<j && flag == 0) {

             if(str.charAt(i)!=str.charAt(j))
                 flag = 1;
              i+=1;
              j-=1;
         }


        return flag;
    }


    public static void main (String arg [])
    {
         int result = StringPalindrome.checkPalindrome("abcba");
         if(result==0)System.out.println("String is palindrome");
          else System.out.println("String is not palindrome");

    }
}
