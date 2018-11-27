package com.allen.stone.api.learn.java8;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/10 8:18
 **/
public class LambdaTest {

    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }

    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static LambdaTest create(final Supplier<LambdaTest> supplier) {
        return supplier.get();
    }

    public static void collide(final LambdaTest car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final LambdaTest another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }


    public static void main(String args[]) {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }
        items.forEach((k, v) ->
                System.out.print("Item : " + k + " value : " + v));
        items.forEach((k, v) ->{
            System.out.println("Item : " + k + " Count : " + v);
            if("E".equals(k)){
                System.out.print(v);
            }
        });

    }

//    public static void main(String args[]) {
//        final int num = 1;
//        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
//        s.convert(2);  // 输出结果为 3
//    }
//
//    @FunctionalInterface
//    public interface Converter<T1, T2> {
//        void convert(int i);
//    }

//    public static void main(String args[]){
//        LambdaTest tester = new LambdaTest();
//
//
//        // 类型声明
//        MathOperation addition = (int a, int b) -> a + b;
//
//        // 不用类型声明
//        MathOperation subtraction = (a, b) -> a - b;
//
//        // 大括号中的返回语句
//        MathOperation multiplication = (int a, int b) -> { return a * b; };
//
//        // 没有大括号及返回语句
//        MathOperation division = (int a, int b) -> a / b;
//
//        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
//        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
//        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
//        System.out.println("10 / 5 = " + tester.operate(10, 5, division));
//
//        // 不用括号
//        GreetingService greetService1 = message -> System.out.println("Hello " + message);
//
//        // 用括号
//        GreetingService greetService2 = (message) -> System.out.println("Hello " + message);
//
//        greetService1.sayMessage("Runoob");
//        greetService2.sayMessage("Google");
//    }
//
//    interface GreetingService {
//        void sayMessage(String message);
//    }
//
//    interface MathOperation {
//        int operation(int a, int b);
//    }
//
//    private int operate(int a, int b, MathOperation mathOperation){
//        return mathOperation.operation(a, b);
//    }
}
