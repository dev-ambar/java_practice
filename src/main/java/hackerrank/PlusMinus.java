package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PlusMinus {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(140638725 );
        arr.add(436257910 );
        arr.add(953274816 );
        arr.add(734065819 );
        arr.add(362748590);

    /*    List<Integer> positiveList = arr.stream().filter(e -> e >0).collect(toList());
        List<Integer> negativeList = arr.stream().filter(e -> e <0).collect(toList());
        List<Integer> zeroList = arr.stream().filter(e -> e==0).collect(toList());
        System.out.println(Long.valueOf(positiveList.size())/Long.valueOf(arr.size()));
        System.out.println(Long.valueOf(negativeList.size())/Long.valueOf(arr.size()));
        System.out.println(Long.valueOf(zeroList.size())/Long.valueOf(arr.size()));*/
        BigInteger total = BigInteger.valueOf(0);
        for(int e : arr)
        {
            total = total.add(BigInteger.valueOf(e));
        }

  List<Integer> s =  arr.stream().sorted((o1, o2) -> {
            if(o1>o2)
                return 1;
             else if(o1<o2)
                 return -1;
             else return 0;
        }).collect(toList());
        s.stream().forEach(System.out::println);
        BigInteger min = total.subtract(BigInteger.valueOf(s.get((arr.size())-1)));
        System.out.println("min" + min);

        BigInteger max = total.subtract(BigInteger.valueOf(s.get(0)));
        System.out.println("max" + max);

        System.out.println(min+" "+max);

    }
}


/*public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        PlusMinus.plusMinus(arr);

        bufferedReader.close();
    }
}*/
