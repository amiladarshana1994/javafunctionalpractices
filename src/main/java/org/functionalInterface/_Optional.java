package org.functionalInterface;

import java.util.Optional;

public class _Optional {
    public static void main(String[] args) {
        sendEmail(null);
        sendEmail("amila.darshana@gmail.com");
    }

    static void sendEmail(String email){
        Optional.ofNullable(email)
                .ifPresentOrElse(
                        value -> System.out.println("Sending email to "+value),
                        () -> System.out.println("Email send failed")
                );
    }
}
