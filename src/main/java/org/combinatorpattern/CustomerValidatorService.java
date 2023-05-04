package org.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean isValidName(String name){
        return name!=null && !name.equals("");
    }

    private boolean isValidEmail(String email){
        return email != null && email.contains("@") && email.contains(".");
    }

    private boolean isValidPhone(String phone){
        return phone != null && phone.length() == 12 && phone.startsWith("+94");
    }

    private boolean isAdult(LocalDate dob){
        return dob!=null && Period.between(dob, LocalDate.now()).getYears() > 18;
    }

    public boolean isValidCustomer(Customer customer){
        return isValidName(customer.getName()) && isValidEmail(customer.getEmail()) && isValidPhone(customer.getPhone()) && isAdult(customer.getDob());
     }
}
