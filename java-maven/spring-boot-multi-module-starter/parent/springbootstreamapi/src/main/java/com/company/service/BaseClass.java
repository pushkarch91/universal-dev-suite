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

        Customer john = Customer.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .email("john@example.com")
                .phoneNumber("9999999999")
                .status(CustomerStatus.ACTIVE)
                .memberships(Arrays.asList(gold, trial))
                .build();

        Customer mary = Customer.builder()
                .id(2L)
                .firstName("Mary")
                .lastName("Smith")
                .email("mary@example.com")
                .phoneNumber("8888888888")
                .status(CustomerStatus.ACTIVE)
                .memberships(Collections.singletonList(silver))
                .build();

        Customer raj = Customer.builder()
                .id(3L)
                .firstName("Raj")
                .lastName("Kumar")
                .email("raj@example.com")
                .phoneNumber("7777777777")
                .status(CustomerStatus.INACTIVE)
                .memberships(Collections.singletonList(platinum))
                .build();

        Customer anita = Customer.builder()
                .id(4L)
                .firstName("Anita")
                .lastName("Sharma")
                .email("anita@example.com")
                .phoneNumber("6666666666")
                .status(CustomerStatus.ACTIVE)
                .memberships(Collections.singletonList(diamond))
                .build();

        Customer peter = Customer.builder()
                .id(5L)
                .firstName("Peter")
                .lastName("Parker")
                .email("peter@example.com")
                .phoneNumber("5555555555")
                .status(CustomerStatus.BLOCKED)
                .memberships(Arrays.asList(silver, trial))
                .build();

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
