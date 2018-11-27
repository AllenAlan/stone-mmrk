package com.allen.stone.api.learn.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/12 21:20
 **/
public class StreamTest {

    private String name;

    private int num;

    public StreamTest(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static void main(String[] args) {

        //stream() − 为集合创建串行流。
        //parallelStream() − 为集合创建并行流。
//        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList()).forEach(System.out::println);
//
//        Random random = new Random();
//        random.ints().limit(10).forEach(System.out::println);

//        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//        // 获取对应的平方数
//        List<Integer> list = numbers.stream().distinct().map(i -> i*i).sorted().collect(Collectors.toList());
//        list.forEach(System.out::println);

//        List<StreamTest> list = new ArrayList<StreamTest>();
//        list.add(new StreamTest("Mahesh", 10));
//        list.add(new StreamTest("Suresh", 11));
//        list.add(new StreamTest("Nilesh", 12));
//        list.add(new StreamTest("Mahesh", 1));
//        list.add(new StreamTest("Suresh", 2));
//        list.add(new StreamTest("Nilesh", 3));
//        list.add(new StreamTest("Mahesh", 4));
//        list.add(new StreamTest("Suresh", 5));
//        list.add(new StreamTest("Nilesh", 6));
//        list.add(new StreamTest("Mahesh", 7));
//        list.add(new StreamTest("Suresh", 8));
//        list.add(new StreamTest("Nilesh", 9));
          //sorted 排序
          //正排
//        list.stream().sorted();
//        //倒排
//        list.stream().sorted(Comparator.reverseOrder());
//        list = list.stream().sorted(Comparator.comparing(StreamTest::getName).thenComparing(StreamTest::getNum)).collect(Collectors.toList());
//        list.forEach((a) -> System.out.println(a.getName() + " , " + a.getNum()));

        //并行（parallel）程序
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List parallelList = strings.parallelStream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(parallelList);

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);


        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());

    }


//    @Override
//    public int compareTo(StreamTest o) {
//        return name.compareTo(o.getName());
//    }

//    @Override
//    public boolean equals(final Subject obj) {
//        if (obj == null) {
//            return false;
//        }
//        final StreamTest streamTest = (StreamTest) obj;
//        if (this == streamTest) {
//            return true;
//        } else {
//            return (this.name.equals(streamTest.name) && (this.num == streamTest.num));
//        }
//    }
//    @Override
//    public int hashCode() {
//        int hashno = 7;
//        hashno = 13 * hashno + (name == null ? 0 : name.hashCode());
//        return hashno;
//    }
}
