package org.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface CustomerRegistrationValidator extends Function<Customer, CustomerValidationResult> {

    static CustomerRegistrationValidator isValidName(){
        return customer -> customer.getName()!=null && !customer.getName().equals("") ?
                CustomerValidationResult.SUCCESS : CustomerValidationResult.INVALID_NAME;
    }

    static CustomerRegistrationValidator isValidEmail(){
        return customer -> customer.getEmail() != null && customer.getEmail().contains("@") && customer.getEmail().contains(".") ?
                CustomerValidationResult.SUCCESS : CustomerValidationResult.INVALID_EMAIL;
    }

    static CustomerRegistrationValidator isValidPhone(){
        return customer -> customer.getPhone() != null && customer.getPhone().length() == 12 && customer.getPhone().startsWith("+94") ?
                CustomerValidationResult.SUCCESS : CustomerValidationResult.INVALID_PHONE;
    }

    static CustomerRegistrationValidator isAdult(){
        return customer -> customer.getDob()!=null && Period.between(customer.getDob(), LocalDate.now()).getYears() > 18 ?
                CustomerValidationResult.SUCCESS : CustomerValidationResult.NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other){
        return customer -> {
            CustomerValidationResult result = this.apply(customer);
            return result.equals(CustomerValidationResult.SUCCESS) ? other.apply(customer) : result;
        };
    }
}
