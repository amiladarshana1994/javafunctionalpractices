package org.imperative.functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer amila = new Customer("Amila", "1234");
        //normal java function approach
        greetingCustomer(amila);
        //consumer function approach
        greetingCustomerConsumer.accept(amila);

        //normal java function approach
        greetingCustomerFrom(amila, "Darshana");
        //BiConsumer function approach
        greetingCustomerFromConsumer.accept(amila, "Gayan");
    }

    static class Customer {
        private final String name;
        private final String phone;

        public Customer(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }

    static Consumer<Customer> greetingCustomerConsumer = customer -> System.out.println("Hi "+customer.name + ", Thank you for the register "+customer.phone);

    static BiConsumer<Customer, String> greetingCustomerFromConsumer = (customer, from) -> System.out.println("Hi "+customer.name + ", Thank you for the register "+customer.phone+". Your supervisor is "+from);

    static void greetingCustomer(Customer customer){
        System.out.println("Hi "+customer.name + ", Thank you for the register "+customer.phone);
    }

    static void greetingCustomerFrom(Customer customer, String from){
        System.out.println("Hi "+customer.name + ", Thank you for the register "+customer.phone+". Your supervisor is "+from);
    }
}
