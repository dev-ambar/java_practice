package miscellaneous.example.abstraction;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicate {

    public static void main(String[] args) {

         int [] intArr = {2,5,8,2,4,8};

         int [] uniArr = Arrays.stream(intArr).distinct().toArray();

         Arrays.stream(uniArr).forEach(System.out::println);

    }









}
