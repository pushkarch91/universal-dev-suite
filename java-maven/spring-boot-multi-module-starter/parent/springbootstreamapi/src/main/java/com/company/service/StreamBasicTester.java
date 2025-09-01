package com.company.service;

import com.company.model.Customer;
import com.company.model.CustomerStatus;
import com.company.model.MembershipType;

import java.util.List;
import java.util.stream.Collectors;

public class StreamBasicTester extends BaseClass {

    private final List<Customer> customers;

    public StreamBasicTester() {
        customers = getCustomers();
    }

    public static void main(String[] args) {
        StreamBasicTester obj = new StreamBasicTester();

        System.out.println("\nFind all Customers:");
        obj.findAllCustomers();

        System.out.println("\nFind all Active Customers:");
        obj.findAllActiveCustomers();

        System.out.println("\nFind all Non Active Customers:");
        obj.findAllNonActiveCustomers();

        System.out.println("\nFind all Customers with Gold Membership:");
        obj.findAllCustomersWithGoldMembership();

        System.out.println("\nFind all Customers with their Membership:");
        obj.findAllCustomersAndTheirMembership();
    }

    public void findAllCustomers() {
        customers.forEach(System.out::println);
    }

    public void findAllActiveCustomers() {
        customers.stream()
                .filter(c -> c.getStatus() == CustomerStatus.ACTIVE)
                .forEach(System.out::println);
    }

    public void findAllNonActiveCustomers() {
        customers.stream()
                .filter(c -> c.getStatus() != CustomerStatus.ACTIVE)
                .forEach(System.out::println);
    }

    public void findAllCustomersWithGoldMembership() {
        customers.stream()
                .flatMap(c -> c.getMemberships().stream())
                .filter(m -> m.getType() == MembershipType.GOLD)
                .forEach(m -> System.out.println(m.getMembershipNumber()
                        + " (" + m.getType().getDisplayName() + ")"));
    }

    public void findAllCustomersAndTheirMembership() {
        customers.forEach(c -> {
            String membershipTypes = c.getMemberships().stream()
                    .map(m -> m.getType().getDisplayName())
                    .collect(Collectors.joining(", "));
            System.out.println(c.getFirstName() + " has memberships: " + membershipTypes);
        });
    }
}
