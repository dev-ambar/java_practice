package multiThreading;

import java.util.stream.IntStream;

public class Test {

    public static void main (String args [])
    {
        IntStream.rangeClosed(2,50).forEach(i ->
        {
            if(isPrime(i))
                System.out.println(i+"is prime number");
        });
    }

    private static boolean isPrime(int i) {
        if(i==2)
            return true;
        else
            for(int j= 2 ; j<i ; j++)
            {
                if(i%j == 0)
                    return false;
            }
            return true;
    }
}
