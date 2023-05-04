package org.combinatorpattern;

import java.time.LocalDate;

public class CustomerOperations {
    public static void main(String[] args) {
        Customer amila = new Customer("Amila", "amila@gmail.com", "+94713333333", LocalDate.of(2000,1,1));
        boolean isValidCustomer = new CustomerValidatorService().isValidCustomer(amila);
        System.out.println("Amila validated : "+isValidCustomer);

        // combinator pattern
        CustomerValidationResult result = CustomerRegistrationValidator
                .isValidEmail()
                .and(CustomerRegistrationValidator.isValidName())
                .and(CustomerRegistrationValidator.isValidPhone())
                .and(CustomerRegistrationValidator.isAdult())
                .apply(amila);
        System.out.println(result);
        if(result != CustomerValidationResult.SUCCESS)
            throw new IllegalArgumentException(result.name());
    }
}
