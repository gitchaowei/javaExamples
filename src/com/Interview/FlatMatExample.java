package com.Interview;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMatExample {
    public static void main(String[] args)
    {
//        FlatMapExample1 ();
//        FlatMapExample2 ();
        FlatMapTry();
     }

    private static void FlatMapExample1 () {
        // Creating a list of Prime Numbers
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);

        // Creating a list of Odd Numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);

        // Creating a list of Even Numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

        List<List<Integer>> listOfListofInts =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);

        System.out.println("The Structure before flattening is : " +
        listOfListofInts);

        // Using flatMap for transformating and flattening.
        List<Integer> listofInts  = listOfListofInts.stream()
                .flatMap(list -> list.stream()).collect(Collectors.toList());

        for (Integer i: listofInts) {
            System.out.println("Integer in the list: " + i);
        }
        System.out.println("The Structure after flattening is : " + listofInts);
    }

    private static void FlatMapExample2() {

        Developer o1 = new Developer();
        o1.setName("mkyong");
        o1.addBook("Java 8 in Action");
        o1.addBook("Spring Boot in Action");
        o1.addBook("Effective Java (3nd Edition)");

        Developer o2 = new Developer();
        o2.setName("zilap");
        o2.addBook("Learning Python, 5th Edition");
        o2.addBook("Effective Java (3nd Edition)");

        List<Developer> list = new ArrayList<>();
        list.add(o1);
        list.add(o2);

        // hmm....Set of Set...how to process?
        /*Set<Set<String>> collect = list.stream()
                .map(x -> x.getBook())
                .collect(Collectors.toSet());*/

        Set<String> collect =
                list.stream()
                        .map(x -> x.getBook())                              //  Stream<Set<String>>
                        .flatMap(x -> x.stream())                           //  Stream<String>
                        .filter(x -> !x.toLowerCase().contains("python"))   //  filter for not containing python book
                        .collect(Collectors.toSet());                       //  remove duplicated

        collect.forEach(System.out::println);

    }


    private static void FlatMapTry() {

        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        // array to a stream
        Stream<String[]> stream1 = Arrays.stream(array);

        // x is a String[]
        List<String[]> result = stream1
                .filter(x -> {
                    for(String s : x){      //
                        if(s.equals("a")){
                            return false;
                        }
                    }
                    return true;
                }).collect(Collectors.toList());

        // print array
        result.forEach(x -> System.out.println(Arrays.toString(x)));
        // output
        // [c, d]
        // [e, f]

        List<String> collect = Stream.of(array)     // Stream<String[]>
                .flatMap(Stream::of)                // Stream<String>
                .filter(x -> !"a".equals(x))        // filter out the a
                .collect(Collectors.toList());      // return a List

        collect.forEach(System.out::println);
        // output:
        // b
        // c
        // d
        // e
        // f

    }
}


class Developer {

    private Integer id;
    private String name;
    private Set<String> book;

    //getters, setters, toString

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getBook() {
        return book;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBook(Set<String> book) {
        this.book = book;
    }
}
