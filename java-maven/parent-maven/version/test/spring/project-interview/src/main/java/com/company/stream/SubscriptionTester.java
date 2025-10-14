package com.company.stream;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SubscriptionTester {

    public static void main(String[] args) {

        // --- Customers (no builder) ---
        Customer mark = new Customer();
        mark.setName("mark");
        mark.setJoinDate(LocalDate.of(2020, 1, 1));
        // Optional: set DOB if you want birthday logic to work
        mark.setDateOfBirth(LocalDate.of(1990, 5, 10));

        Customer steve = new Customer();
        steve.setName("steve");
        steve.setJoinDate(LocalDate.of(2020, 1, 1));
        steve.setDateOfBirth(LocalDate.of(1992, 6, 15));

        Customer adam = new Customer();
        adam.setName("adam");
        adam.setJoinDate(LocalDate.of(2020, 1, 1));
        adam.setDateOfBirth(LocalDate.of(1988, 7, 20));

        Customer michael = new Customer();
        michael.setName("michael");
        michael.setJoinDate(LocalDate.of(2020, 1, 1));
        michael.setDateOfBirth(LocalDate.of(1995, 8, 25));

        Customer andrew = new Customer();
        andrew.setName("andrew");
        andrew.setJoinDate(LocalDate.of(2020, 1, 1));
        andrew.setDateOfBirth(LocalDate.of(1993, 9, 30));

        // --- Memberships (no builder) ---
        Membership m1 = new Membership();
        m1.setType("GOLD");
        m1.setStartDate(LocalDate.now().minusMonths(3));
        m1.setEndDate(LocalDate.now().plusMonths(3));
        m1.setCustomer(mark);
        mark.setMemberships(List.of(m1));

        Membership s1 = new Membership();
        s1.setType("SILVER");
        s1.setStartDate(LocalDate.now().minusMonths(1));
        s1.setEndDate(LocalDate.now().plusMonths(1));
        s1.setCustomer(steve);
        steve.setMemberships(List.of(s1));

        Membership a1 = new Membership();
        a1.setType("GOLD");
        a1.setStartDate(LocalDate.now().minusMonths(5));
        a1.setEndDate(LocalDate.now().minusMonths(1)); // expired
        a1.setCustomer(adam);
        adam.setMemberships(List.of(a1));

        Membership mp = new Membership();
        mp.setType("PLATINUM");
        mp.setStartDate(LocalDate.now().minusDays(10));
        mp.setEndDate(LocalDate.now().plusDays(20));
        mp.setCustomer(michael);

        Membership mg = new Membership();
        mg.setType("GOLD");
        mg.setStartDate(LocalDate.now().minusMonths(1));
        mg.setEndDate(LocalDate.now().plusMonths(1));
        mg.setCustomer(michael);
        michael.setMemberships(List.of(mp, mg));

        Membership as = new Membership();
        as.setType("SILVER");
        as.setStartDate(LocalDate.now().minusMonths(1));
        as.setEndDate(LocalDate.now().plusMonths(1));
        as.setCustomer(andrew);
        andrew.setMemberships(List.of(as));

        List<Customer> customers = new ArrayList<>(List.of(mark, steve, adam, michael, andrew));

        Map<String, Long> membershipTypeToCustomerCount = customers.stream()
                .flatMap(c -> c.getMemberships().stream()
                        .filter(m -> !m.getStartDate().isAfter(LocalDate.now())
                                && !m.getEndDate().isBefore(LocalDate.now()))
                        .map(Membership::getType)
                        .distinct()
                )
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Membership type to active customer count:");
        membershipTypeToCustomerCount.forEach((type, count) ->
                System.out.println(type + ": " + count));

        List<Customer> expiredCustomers = customers.stream()
                .filter(c -> c.getMemberships() != null
                        && !c.getMemberships().isEmpty()
                        && c.getMemberships().stream()
                        .allMatch(m -> m.getEndDate().isBefore(LocalDate.now())))
                .toList();

        System.out.println("\nCustomers whose all memberships have expired:");
        expiredCustomers.forEach(c -> System.out.println(c.getName()));

        // NPE-safe birthday check (dateOfBirth could be null)
        List<Customer> birthdayToday = customers.stream()
                .filter(c -> {
                    LocalDate dob = c.getDateOfBirth();
                    if (dob == null) return false;
                    LocalDate today = LocalDate.now();
                    return dob.getMonth() == today.getMonth()
                            && dob.getDayOfMonth() == today.getDayOfMonth();
                })
                .toList();

        System.out.println("\nBirthdays today:");
        birthdayToday.forEach(c -> System.out.println(c.getName()));
    }
}

// ==================== ENTITIES (no Lombok) ====================

@Entity
class Customer {
    @Id
    private Long id;

    private String name;
    private LocalDate dateOfBirth;
    private LocalDate joinDate;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Membership> memberships = new ArrayList<>();

    public Customer() {
    }

    public Customer(Long id, String name, LocalDate dateOfBirth, LocalDate joinDate, List<Membership> memberships) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.joinDate = joinDate;
        this.memberships = memberships != null ? memberships : new ArrayList<>();
    }

    // getters & setters
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public List<Membership> getMemberships() {
        return memberships;
    }

    public void setMemberships(List<Membership> memberships) {
        this.memberships = memberships != null ? memberships : new ArrayList<>();
    }
}

@Entity
class Membership {
    @Id
    private Long id;

    private String type;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Membership() {
    }

    public Membership(Long id, String type, LocalDate startDate, LocalDate endDate, Customer customer) {
        this.id = id;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
    }

    // getters & setters
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


