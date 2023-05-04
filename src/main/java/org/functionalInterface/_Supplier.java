package org.functionalInterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDbUrl());
        System.out.println(getDbUrls.get());
    }

    static String getDbUrl(){
        return "jdbc://localhost:3306/dwesk";
    }

    static Supplier<List<String>> getDbUrls = () -> List.of("jdbc://localhost:3306/dwesk", "jdbc://localhost:3306/ivrdb");
}
