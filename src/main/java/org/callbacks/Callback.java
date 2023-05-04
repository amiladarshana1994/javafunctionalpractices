package org.callbacks;

import java.util.function.Consumer;

public class Callback {
    public static void main(String[] args) {
        hello("Amila", "Darshana", fName -> {
            System.out.println("lName not added for "+fName);
        });
        hello("Jaya", null, fName -> {
            System.out.println("lName not added for "+fName);
        });
        hello("Abc", null, () -> {
            System.out.println("lName not added");
        });
        hello("Xyz", "Lmn", () -> {
            System.out.println("lName not added");
        });
    }

    static void hello(String fName, String lName, Consumer<String> callback){
        System.out.println(fName);
        if(lName != null)
            System.out.println(lName);
        else callback.accept(fName);
    }

    static void hello(String fName, String lName, Runnable callback){
        System.out.println(fName);
        if(lName != null)
            System.out.println(lName);
        else callback.run();
    }
}
