package za.ac.cput.practice.factory;

import za.ac.cput.practice.domain.Customer;
import za.ac.cput.practice.domain.Name;
import za.ac.cput.practice.util.Helper;

import java.util.UUID;

public class CustomerFactory {

    public static Customer createCustomer(
            String firstName,
            String lastName,
            String email,
            String mobileNumber
    ) {

        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)) {
            throw new IllegalArgumentException("Name is required");
        }

        if (Helper.isNullOrEmpty(email)) {
            throw new IllegalArgumentException("Email is required");
        }

        if (Helper.isNullOrEmpty(mobileNumber)) {
            throw new IllegalArgumentException("Mobile number is required");
        }

        Name name = new Name.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();

        if (name == null) {
            throw new IllegalArgumentException("Invalid name");
        }

        return new Customer.Builder()
                .setPatientId(generateCustomerId())
                .setName(name)
                .setEmail(email)
                .setMobileNumber(mobileNumber)
                .build();
    }

    private static String generateCustomerId() {
        return "CUST-" + UUID.randomUUID().toString();
    }
}