package Java8Feature;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiTest {


    public static void main(String[] args) {

       List<Person> personList =  getPersons();

        List<Person> females = personList.stream().filter(person -> person.getGender().equals(Gender.FEMALE)).collect(Collectors.toList());
        //females.stream().forEach(System.out::println);
        boolean allMatch = personList.stream().allMatch(person -> person.getAge() >= 6);
        //System.out.println("anyMatch -->"+allMatch);
        boolean anyMatch = personList.stream().anyMatch(person -> person.getAge() > 60);
        //System.out.println("anyMatch -->"+anyMatch);
        List<Person> femalesAboveThirty = personList.stream().filter(person -> person.getAge() > 20 && person.getGender().equals(Gender.FEMALE)).collect(Collectors.toList());
        //femalesAboveThirty.stream().forEach(System.out::println);
        List<Person> personSortByAge = personList.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        //personSortByAge.stream().forEach(System.out::println);
        List<Person> personSortByAgeAndName = personList.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName)).collect(Collectors.toList());
        //personSortByAgeAndName.stream().forEach(System.out::println);
        /*personList.stream().max(Comparator.comparing(Person::getAge)).map(Person::getName)
                .ifPresent(System.out::println);*/

/*        personList.stream().min(Comparator.comparing(Person::getAge)).map(Person::getName)
                .ifPresent(System.out::println);*/

        Map<Gender, List<Person>> groupByGender = personList.stream().collect(Collectors.groupingBy(Person::getGender));

/*        groupByGender.forEach((gender, people) -> {
            System.out.println(gender);
            people.stream().forEach(System.out::println);
                }
            );*/

        personList.stream().filter(person -> person.getGender().equals(Gender.MALE))
                .max(Comparator.comparing(Person::getAge)).map(Person::toString).ifPresent(System.out::println);



    }

    private static List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Ambar Gupta", Gender.MALE, 39));
        persons.add(new Person("Aarav Gupta", Gender.MALE, 6));
        persons.add(new Person("Anukriti Gupta", Gender.FEMALE, 9));
        persons.add(new Person("Shivangi Gupta", Gender.FEMALE, 38));
        persons.add(new Person("James Bond", Gender.MALE, 49));
        persons.add(new Person("Tom Cruse", Gender.MALE, 61));
        persons.add(new Person("Helina Jones", Gender.FEMALE, 29));
        persons.add(new Person("Sara Ali Khan", Gender.FEMALE, 28));
        return persons;
    }


}