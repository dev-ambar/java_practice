package Java8Feature;

import java.util.*;
import java.util.stream.Collectors;

public class FilterExample {

    public static void main(String[] arg)
    {

        List<String> nameList = Arrays.asList("AMBAR","SHIVANGI","AARAV","RAIN","CLOUD","BANDARAMAM");
        List<Integer> ageList = Arrays.asList(18,17,20,52,35,85,9);

         for (String name : nameList)
         {
             if(!name.equalsIgnoreCase("Ambar"))
                System.out.println(name);
         }

        System.out.println("With Functional Programming");
         nameList.stream().filter(name -> !name.equalsIgnoreCase("Ambar")).forEach(name ->System.out.println(name));


         List<Integer> eventAgeList =  ageList.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
         eventAgeList.stream().forEach(System.out::println);

          ageList.stream().map(i-> i=i+2).collect(Collectors.toList()).stream().forEach(System.out::println);
          ageList.stream().filter(i->i%2 == 1).map(j->j+1).map(k->k/2).collect(Collectors.toList()).stream().forEach(System.out::println);
          ageList.stream().sorted().forEach(System.out::println);

       ageList.stream().sorted((o1, o2) -> {
              if (o1<o2)
                  return 1;
              else if(o1>o2)
                  return -1;
              else return 0;

        }).forEach(System.out::println);
   ageList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

       Comparator<String> c = (o1, o2) -> {
             if(o1.length() < o2.length())
                 return -1;
             else if (o1.length()>o2.length())
                     return 1;
             else return 0;

        };

        Comparable<String> d = new Comparable<String>() {

            @Override
            public int compareTo(String o) {
                return 0;
            }
        };
   nameList.stream().sorted(c).forEach(System.out::println);

        nameList.stream().map(s->
        {
             HashMap<String,Integer> temp = new HashMap<>();
              temp.put(s,s.length());

               return temp;
        });



        Map<Integer, String> map = new HashMap<>();

        // Add entries to the Map
        map.put(1, "Geeks");
        map.put(2, "forGeeks");
        map.put(3, "A computer Portal");


        map.forEach((k,v) -> System.out.println(k +"::"+ v));

    }




}
