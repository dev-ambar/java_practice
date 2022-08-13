package hackerrank;

public class Transform {

     public static int  transform(String str1, String str2)
     {
         if(str1.length()!=str2.length())
              return -1;

          int  [] arr = new int[256];

         for(int i = 0 ; i < str1.length() ;i++)
         {
              arr[str1.charAt(i)]++;
              arr[str2.charAt(i)]--;
         }
         for(int i = 0 ; i< arr.length;i++)
         {
             if(arr[i]!=0) return -1;
         }
         int p1 = str1.length()-1;
         int p2 = str2.length()-1;
         int mc = 0;
         for(int i = p1 ; i >=0 ; i-- )
         {
              if(str1.charAt(i)!= str2.charAt(p2))
              {
                   mc ++;
              }
              else
              {
                  p2--;
              }
         }

         return mc;

     }

     public static void main(String arg[])
     {
         String str1 = "ambar"; //ramba brama abrma rabma
         String str2 = "rabma";
         int t =  transform(str1 , str2);
         System.out.println("minimum number of iteration require ->"+ t);
     }
}
