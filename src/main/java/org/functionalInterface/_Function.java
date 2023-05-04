package org.functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {

        // Function take 1 argument and return 1 result
        System.out.println("incrementByOne : "+incrementByOne(1));
        System.out.println("incrementByOneFunction : "+incrementByOneFunction.apply(1));
        System.out.println("multiplyByOneFunction : "+ multiplyByOneFunction.apply(1));

        //chain
        Function<Integer, Integer> incrementAndThenMulti = incrementByOneFunction.andThen(multiplyByOneFunction);
        System.out.println("incrementAndThenMulti : "+incrementAndThenMulti.apply(1));

        Function<Integer, Integer> incrementAndThenMultiAndThenDivide = incrementByOneFunction.andThen(multiplyByOneFunction).andThen(devideByTwoFunction);
        System.out.println("incrementAndThenMultiAndThenDivide : "+incrementAndThenMultiAndThenDivide.apply(1));

        // BiFunction take 2 argument and return 1 result
        System.out.println("incrementByOneAndMultiply : "+incrementByOneAndMultiply(1, 100));
        System.out.println("incrementByOneAndMulByNumberFunction : "+incrementByOneAndMulByNumberFunction.apply(1, 100));
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1 ;
    static Function<Integer, Integer> multiplyByOneFunction = number -> number * 10 ;
    static Function<Integer, Integer> devideByTwoFunction = number -> number / 2 ;
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMulByNumberFunction =
            (numberForIncrement, numberForMultiply) -> (numberForIncrement + 1) * numberForMultiply;
    static int incrementByOne(int number){
        return number+1;
    }
    static int incrementByOneAndMultiply(int number, int multiplyBy){
        return (number+1)*multiplyBy;
    }
}
