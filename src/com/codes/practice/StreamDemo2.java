package com.codes.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) throws IOException {
        //1. Integer Stream
        IntStream.range(1, 10).forEach(System.out::println);
        System.out.println();

        //2. Integer Stream with skip
        IntStream.range(1, 10).skip(5).forEach(x -> System.out.println(x));
        System.out.println();

        //3. Integer Stream with sum
        int sum = IntStream.range(1, 5).sum();
        System.out.println(sum);

        //4. Stream.of, sorted and findFirst
        Stream.of("string 1", "string 2", "string 3").sorted().findFirst().ifPresent(System.out::println);

        //5. Stream.of, sorted and findFirst
        String[] names = new String[8];
        names[0] = "Al";
        names[1] = "Ankit";
        names[2] = "Kushal";
        names[3] = "Sarika";
        names[4] = "Shivika";
        names[5] = "Sarah";
        names[6] = " ";
        names[7] = " ";

        int[] inames = new int[7];
        inames[0] = 34;
        inames[1] = 54;
        inames[2] = 11;
//        String[] names1 = {"AL","Ankit","Kushal","Sarika","Shivika"};
//        String[] names2 = new String[]{"AL","Ankit","Kushal","Sarika","Shivika"};
//
//        String[] names3;
//        names = new String[]{"AL","Ankit","Kushal","Sarika","Shivika"};

//        List<String> list = Arrays.asList(names);
//        list.add("Sarah");
        ArrayList<String> arraylist = new ArrayList<>();
        arraylist.add("Sarah liu");
        arraylist.add("Shiva Num");

        //    Object[] arr=arraylist.toArray();

        String[] arr1 = arraylist.toArray(new String[arraylist.size()]);

        Stream<String> s1 = Arrays.stream(arr1);
        Stream s2 = s1.filter(x -> x.startsWith("S"));
        Stream s3 = s2.sorted();
        s3.forEach(System.out::println);

        Arrays.stream(names).filter(x -> x.startsWith("S")).sorted().forEach(System.out::println);

        // 6. Average of squares of an int array
        Arrays.stream(new int[]{2, 4, 6, 8, 10}).map(x -> x * x).average().ifPresent(System.out::println);

        // 7. Stream from List, filter and print
        List<String> people = Arrays.asList("AL", "Ankit", "Kushal", "Sarika", "Shivika");

        people.stream().map(String::toLowerCase).filter(x -> x.startsWith("a")).forEach(System.out::println);

        //8. Stream rows from text file, sort, filter, and print
//        Stream<String> bands = Files.lines(Paths.get("C:\\Examples\\src\\com\\Interview\\dictionary.txt"));
//        bands.sorted().filter(x->x.length()>13).forEach(System.out::println);
//        bands.close();

        //9. Stream rows from text file and save it List
        List<String> bands2 = Files.lines(Paths.get("C:\\Examples\\src\\com\\Interview\\dictionary.txt"))
                .filter(x -> x.contains("ZYM"))
                .collect(Collectors.toList());
        bands2.forEach(x -> System.out.println(x));

        //10. Stream rows from CSV file and count it: skip row E due to no ","
        Stream<String> rows1 = Files.lines(Paths.get("C:\\Examples\\src\\com\\Interview\\data1.txt"));
        int rowCount = (int) rows1
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println(rowCount + " rows.");
        rows1.close();

        //11. Stream rows from CSV file and parse data from rows
        Stream<String> rows2 = Files.lines(Paths.get("C:\\Examples\\src\\com\\Interview\\data1.txt"));
        rows2.map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
        rows2.close();

        // 12. Stream rows from CSV file, store fields in HashMap
        Stream<String> rows3 = Files.lines(Paths.get("C:\\Examples\\src\\com\\Interview\\data1.txt"));
        Map<String, Integer> map = new HashMap<>();
        map = rows3
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])));
        rows3.close();
        for (String key : map.keySet()) {
            System.out.println(key + "  " + map.get(key));
        }

        // 13. Reduction - sum 13.6
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);

        // 14. Reduction - summary statistics
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        System.out.println(summary.getSum() + " " + summary.getMax() + " " + summary.getMin() + " " + summary.getAverage() + " " + summary.getCount());
        System.out.println("toString" + summary.toString());

    }
}
