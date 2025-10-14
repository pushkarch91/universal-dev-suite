package com.company.service;

import com.company.model.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BaseClass {

    public Membership getGoldMembership() {
        return new Membership(
                1L,
                "MBR-1001",
                MembershipType.GOLD,
                LocalDate.now(),
                LocalDate.now().plusYears(1),
                MembershipStatus.ACTIVE,
                true
        );
    }

    public Membership getSilverMembership() {
        return new Membership(
                2L,
                "MBR-1002",
                MembershipType.SILVER,
                LocalDate.now().minusMonths(3),
                LocalDate.now().plusMonths(9),
                MembershipStatus.ACTIVE,
                true
        );
    }

    public Membership getTrialMembership() {
        return new Membership(
                3L,
                "MBR-1003",
                MembershipType.TRIAL,
                LocalDate.now(),
                LocalDate.now().plusDays(30),
                MembershipStatus.PENDING,
                false
        );
    }

    public Membership getPlatinumMembership() {
        return new Membership(
                4L,
                "MBR-1004",
                MembershipType.PLATINUM,
                LocalDate.now().minusYears(1),
                LocalDate.now().plusYears(1),
                MembershipStatus.ACTIVE,
                true
        );
    }

    public Membership getDiamondMembership() {
        return new Membership(
                5L,
                "MBR-1005",
                MembershipType.DIAMOND,
                LocalDate.now().minusMonths(6),
                LocalDate.now().plusMonths(18),
                MembershipStatus.ACTIVE,
                true
        );
    }

    // ---- Membership List ----
    public List<Membership> getMemberships() {
        return Arrays.asList(
                getGoldMembership(),
                getSilverMembership(),
                getTrialMembership(),
                getPlatinumMembership(),
                getDiamondMembership()
        );
    }

    // ---- Customer List ----
    public List<Customer> getCustomers() {
        Membership gold = getGoldMembership();
        Membership silver = getSilverMembership();
        Membership trial = getTrialMembership();
        Membership platinum = getPlatinumMembership();
        Membership diamond = getDiamondMembership();

        Customer john = new Customer();
        john.setId(1L);
        john.setFirstName("John");
        john.setLastName("Doe");
        john.setEmail("john@example.com");
        john.setPhoneNumber("9999999999");
        john.setStatus(CustomerStatus.ACTIVE);
        john.setMemberships(Arrays.asList(gold, trial));

        Customer mary = new Customer();
        mary.setId(2L);
        mary.setFirstName("Mary");
        mary.setLastName("Smith");
        mary.setEmail("mary@example.com");
        mary.setPhoneNumber("8888888888");
        mary.setStatus(CustomerStatus.ACTIVE);
        mary.setMemberships(Collections.singletonList(silver));

        Customer raj = new Customer();
        raj.setId(3L);
        raj.setFirstName("Raj");
        raj.setLastName("Kumar");
        raj.setEmail("raj@example.com");
        raj.setPhoneNumber("7777777777");
        raj.setStatus(CustomerStatus.INACTIVE);
        raj.setMemberships(Collections.singletonList(platinum));

        Customer anita = new Customer();
        anita.setId(4L);
        anita.setFirstName("Anita");
        anita.setLastName("Sharma");
        anita.setEmail("anita@example.com");
        anita.setPhoneNumber("6666666666");
        anita.setStatus(CustomerStatus.ACTIVE);
        anita.setMemberships(Collections.singletonList(diamond));

        Customer peter = new Customer();
        peter.setId(5L);
        peter.setFirstName("Peter");
        peter.setLastName("Parker");
        peter.setEmail("peter@example.com");
        peter.setPhoneNumber("5555555555");
        peter.setStatus(CustomerStatus.BLOCKED);
        peter.setMemberships(Arrays.asList(silver, trial));


        return Arrays.asList(john, mary, raj, anita, peter);
    }

    // ---- Demo Streams ----
    public void demoStreams() {
        List<Customer> customers = getCustomers();

        System.out.println("---- Active Customers ----");
        customers.stream()
                .filter(c -> c.getStatus() == CustomerStatus.ACTIVE)
                .forEach(c -> System.out.println(c.getFirstName() + " " + c.getLastName()));

        System.out.println("\n---- Gold Members ----");
        customers.stream()
                .flatMap(c -> c.getMemberships().stream())
                .filter(m -> m.getType() == MembershipType.GOLD)
                .forEach(m -> System.out.println(m.getMembershipNumber()
                        + " (" + m.getType().getDisplayName() + ")"));

        System.out.println("\n---- Customer -> Membership Summary ----");
        customers.forEach(c -> {
            String membershipTypes = c.getMemberships().stream()
                    .map(m -> m.getType().getDisplayName())
                    .collect(Collectors.joining(", "));
            System.out.println(c.getFirstName() + " has memberships: " + membershipTypes);
        });
    }

}
