package org.functionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        System.out.println("isValidPhoneNumber 0771231231 : "+isValidPhoneNumber("0771231231"));
        System.out.println("isValidPhoneNumber 0671231231 : "+isValidPhoneNumber("0671231231"));
        System.out.println("isValidPhoneNumber 077123123 : "+isValidPhoneNumber("077123123"));

        System.out.println("isValidPhoneNumberPredicate 0771231231 : "+isValidPhoneNumberPredicate.test("0771231231"));
        System.out.println("isValidPhoneNumberPredicate 0671231231 : "+isValidPhoneNumberPredicate.test("0671231231"));
        System.out.println("isValidPhoneNumberPredicate 077123123 : "+isValidPhoneNumberPredicate.test("077123123"));

        System.out.println("isContain3 0771231231 : "+isContain3("0771231231"));
        System.out.println("isContain3 0771211211 : "+isContain3("0771211211"));
        System.out.println("isContain3 077121111 : "+isContain3("077121111"));

        System.out.println("isValidPhoneNumberAndContain3Predicate 0771231231 : "+isValidPhoneNumberPredicate.and(isContain3Predicate).test("0771231231"));
        System.out.println("isValidPhoneNumberAndContain3Predicate 0771211211 : "+isValidPhoneNumberPredicate.and(isContain3Predicate).test("0771211211"));
        System.out.println("isValidPhoneNumberAndContain3Predicate 077121111 : "+isValidPhoneNumberPredicate.and(isContain3Predicate).test("077121111"));

        System.out.println("isValidPhoneNumberOrContain3Predicate 0771231231 : "+isValidPhoneNumberPredicate.or(isContain3Predicate).test("0771231231"));
        System.out.println("isValidPhoneNumberOrContain3Predicate 0771211211 : "+isValidPhoneNumberPredicate.or(isContain3Predicate).test("0771211211"));
        System.out.println("isValidPhoneNumberOrContain3Predicate 077121111 : "+isValidPhoneNumberPredicate.or(isContain3Predicate).test("077121111"));

        System.out.println("isValidPhoneNumberAndEquelPredicate 0771231231 0771231231 : "+isValidPhoneNumberAndEquelPredicate.test("0771231231", "0771231231"));
        System.out.println("isValidPhoneNumberAndEquelPredicate 0771211211 0771231231 : "+isValidPhoneNumberAndEquelPredicate.test("0771211211", "0771231231"));
        System.out.println("isValidPhoneNumberAndEquelPredicate 077121111 0771231231 : "+isValidPhoneNumberAndEquelPredicate.test("077121111", "0771231231"));
    }

    static Predicate<String> isValidPhoneNumberPredicate = phoneNumber -> phoneNumber != null && phoneNumber.startsWith("07") && phoneNumber.length() == 10;
    static Predicate<String> isContain3Predicate = phoneNumber -> phoneNumber != null && phoneNumber.contains("3");
    static BiPredicate<String,String> isValidPhoneNumberAndEquelPredicate = (phoneNumber1, phoneNumber2) -> phoneNumber1 != null && phoneNumber1.startsWith("07") && phoneNumber1.length() == 10 && phoneNumber2!=null && phoneNumber2.equals(phoneNumber1);

    static boolean isValidPhoneNumber(String phoneNumber){
        return phoneNumber != null && phoneNumber.startsWith("07") && phoneNumber.length() == 10;
    }

    static boolean isContain3(String phoneNumber){
        return phoneNumber != null && phoneNumber.contains("3");
    }
}
