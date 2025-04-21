package com.company.stream;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SubscriptionTester {

    public static void main(String[] args) {

        Customer mark = Customer.builder().name("mark").joinDate(LocalDate.of(2020, 1, 1)).build();
        Customer steve = Customer.builder().name("steve").joinDate(LocalDate.of(2020, 1, 1)).build();
        Customer adam = Customer.builder().name("adam").joinDate(LocalDate.of(2020, 1, 1)).build();
        Customer michael = Customer.builder().name("michael").joinDate(LocalDate.of(2020, 1, 1)).build();
        Customer andrew = Customer.builder().name("andrew").joinDate(LocalDate.of(2020, 1, 1)).build();

        mark.setMemberships(List.of(
                Membership.builder()
                        .type("GOLD")
                        .startDate(LocalDate.now().minusMonths(3))
                        .endDate(LocalDate.now().plusMonths(3))
                        .customer(mark)
                        .build()
        ));

        steve.setMemberships(List.of(
                Membership.builder()
                        .type("SILVER")
                        .startDate(LocalDate.now().minusMonths(1))
                        .endDate(LocalDate.now().plusMonths(1))
                        .customer(steve)
                        .build()
        ));

        adam.setMemberships(List.of(
                Membership.builder()
                        .type("GOLD")
                        .startDate(LocalDate.now().minusMonths(5))
                        .endDate(LocalDate.now().minusMonths(1)) // expired
                        .customer(adam)
                        .build()
        ));

        michael.setMemberships(List.of(
                Membership.builder()
                        .type("PLATINUM")
                        .startDate(LocalDate.now().minusDays(10))
                        .endDate(LocalDate.now().plusDays(20))
                        .customer(michael)
                        .build(),
                Membership.builder()
                        .type("GOLD")
                        .startDate(LocalDate.now().minusMonths(1))
                        .endDate(LocalDate.now().plusMonths(1))
                        .customer(michael)
                        .build()
        ));

        andrew.setMemberships(List.of(
                Membership.builder()
                        .type("SILVER")
                        .startDate(LocalDate.now().minusMonths(1))
                        .endDate(LocalDate.now().plusMonths(1))
                        .customer(andrew)
                        .build()
        ));

        List<Customer> customers = new ArrayList<>(List.of(mark, steve, adam, michael, andrew));

        Map<String, Long> membershipTypeToCustomerCount = customers.stream()
                .flatMap(customer -> customer.getMemberships().stream()
                        .filter(m -> !m.getStartDate().isAfter(LocalDate.now()) && !m.getEndDate().isBefore(LocalDate.now()))
                        .map(Membership::getType)
                        .distinct()
                )
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Membership type to active customer count:");
        membershipTypeToCustomerCount.forEach((type, count) ->
                System.out.println(type + ": " + count));

        List<Customer> expiredCustomers = customers.stream()
                .filter(customer ->
                        customer.getMemberships() != null &&
                                !customer.getMemberships().isEmpty() &&
                                customer.getMemberships().stream()
                                        .allMatch(m -> m.getEndDate().isBefore(LocalDate.now()))
                )
                .toList();

        System.out.println("\nCustomers whose all memberships have expired:");
        expiredCustomers.forEach(c -> System.out.println(c.getName()));

        List<Customer> birthdayToday = customers.stream()
                .filter(c -> {
                    LocalDate dob = c.getDateOfBirth();
                    LocalDate today = LocalDate.now();
                    return dob.getMonth() == today.getMonth() && dob.getDayOfMonth() == today.getDayOfMonth();
                })
                .toList();

    }
}

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Customer {
    @Id
    private Long id;

    private String name;
    private LocalDate dateOfBirth;
    private LocalDate joinDate;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Membership> memberships = new ArrayList<>();
}

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Membership {
    @Id
    private Long id;

    private String type;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}

