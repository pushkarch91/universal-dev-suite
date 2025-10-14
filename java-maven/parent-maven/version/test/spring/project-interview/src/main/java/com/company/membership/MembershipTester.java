package com.company.membership;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MembershipTester {

    public static void main(String[] args) {

        Customer mark = new Customer();
        mark.setName("mark");
        mark.setJoinDate(LocalDate.of(2020, 1, 1));

        Customer steve = new Customer();
        steve.setName("steve");
        steve.setJoinDate(LocalDate.of(2020, 1, 1));

        Customer adam = new Customer();
        adam.setName("adam");
        adam.setJoinDate(LocalDate.of(2020, 1, 1));

        Customer michael = new Customer();
        michael.setName("michael");
        michael.setJoinDate(LocalDate.of(2020, 1, 1));

        Customer andrew = new Customer();
        andrew.setName("andrew");
        andrew.setJoinDate(LocalDate.of(2020, 1, 1));

        // mark subscriptions
        Subscription markGold = new Subscription();
        markGold.setType("GOLD");
        markGold.setStartDate(LocalDate.now().minusMonths(3));
        markGold.setEndDate(LocalDate.now().plusMonths(3));
        markGold.setCustomer(mark);
        mark.setSubscriptions(List.of(markGold));

        // steve subscriptions
        Subscription steveSilver = new Subscription();
        steveSilver.setType("SILVER");
        steveSilver.setStartDate(LocalDate.now().minusMonths(1));
        steveSilver.setEndDate(LocalDate.now().plusMonths(1));
        steveSilver.setCustomer(steve);
        steve.setSubscriptions(List.of(steveSilver));

        // adam subscriptions (expired)
        Subscription adamGold = new Subscription();
        adamGold.setType("GOLD");
        adamGold.setStartDate(LocalDate.now().minusMonths(5));
        adamGold.setEndDate(LocalDate.now().minusMonths(1));
        adamGold.setCustomer(adam);
        adam.setSubscriptions(List.of(adamGold));

        // michael subscriptions (two active)
        Subscription michaelPlatinum = new Subscription();
        michaelPlatinum.setType("PLATINUM");
        michaelPlatinum.setStartDate(LocalDate.now().minusDays(10));
        michaelPlatinum.setEndDate(LocalDate.now().plusDays(20));
        michaelPlatinum.setCustomer(michael);

        Subscription michaelGold = new Subscription();
        michaelGold.setType("GOLD");
        michaelGold.setStartDate(LocalDate.now().minusMonths(1));
        michaelGold.setEndDate(LocalDate.now().plusMonths(1));
        michaelGold.setCustomer(michael);

        michael.setSubscriptions(List.of(michaelPlatinum, michaelGold));

        // andrew subscriptions
        Subscription andrewSilver = new Subscription();
        andrewSilver.setType("SILVER");
        andrewSilver.setStartDate(LocalDate.now().minusMonths(1));
        andrewSilver.setEndDate(LocalDate.now().plusMonths(1));
        andrewSilver.setCustomer(andrew);
        andrew.setSubscriptions(List.of(andrewSilver));

        List<Customer> customers = new ArrayList<>(List.of(mark, steve, adam, michael, andrew));

        Map<String, Long> membershipTypeToCustomerCount = customers.stream()
                .flatMap(customer -> customer.getSubscriptions().stream()
                        .filter(m -> !m.getStartDate().isAfter(LocalDate.now()) && !m.getEndDate().isBefore(LocalDate.now()))
                        .map(Subscription::getType)
                        .distinct()
                )
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Membership type to active customer count:");
        membershipTypeToCustomerCount.forEach((type, count) ->
                System.out.println(type + ": " + count));

        List<Customer> expiredCustomers = customers.stream()
                .filter(customer ->
                        customer.getSubscriptions() != null &&
                                !customer.getSubscriptions().isEmpty() &&
                                customer.getSubscriptions().stream()
                                        .allMatch(m -> m.getEndDate().isBefore(LocalDate.now()))
                )
                .toList();

        System.out.println("\nCustomers whose all memberships have expired:");
        expiredCustomers.forEach(c -> System.out.println(c.getName()));
    }
}

@Entity
class Customer {
    @Id
    private Long id;

    private String name;
    private LocalDate joinDate;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Subscription> subscriptions = new ArrayList<>();

    // --- constructors ---
    public Customer() {
    }

    public Customer(Long id, String name, LocalDate joinDate, List<Subscription> subscriptions) {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
        this.subscriptions = subscriptions != null ? subscriptions : new ArrayList<>();
    }

    // --- getters & setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions != null ? subscriptions : new ArrayList<>();
    }
}

@Entity
class Subscription {
    @Id
    private Long id;

    private String type;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // --- constructors ---
    public Subscription() {
    }

    public Subscription(Long id, String type, LocalDate startDate, LocalDate endDate, Customer customer) {
        this.id = id;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
    }

    // --- getters & setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
