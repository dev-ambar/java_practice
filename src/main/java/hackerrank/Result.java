package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Result {

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here

        int sm  = 0 ;
        int sl = 0;
        for(int i = 0 ;i< arr.size() ; i++)
        {
            for(int j = 0 ; j < arr.get(i).size(); j++)
            {
                if(i == j)
                    sm = sm + arr.get(i).get(j);
                if(i + j == arr.size()-1)
                    sl = sl + arr.get(i).get(j);
            }

        }

        return Math.abs(sm - sl);
    }

    public  static void  main (String arg [])
    {
        List<List<Integer>> arr =  new ArrayList<>();
         List<Integer> temp = new ArrayList<>();
         temp.add(11);
         temp.add(2);
         temp.add(4);
         temp.add(14);

        List<Integer> temp1 = new ArrayList<>();
        temp1.add(4);
        temp1.add(5);
        temp1.add(6);
        temp1.add(16);

        List<Integer> temp2 = new ArrayList<>();
        temp2.add(10);
        temp2.add(8);
        temp2.add(18);
        temp2.add(12);

        List<Integer> temp3 = new ArrayList<>();
        temp3.add(1);
        temp3.add(8);
        temp3.add(9);
        temp3.add(3);


        arr.add(temp);
        arr.add(temp1);
        arr.add(temp2);
        arr.add(temp3);

           arr.stream().forEach(System.out::println);
           int s = diagonalDifference(arr);
             System.out.println(s);
    }

}
