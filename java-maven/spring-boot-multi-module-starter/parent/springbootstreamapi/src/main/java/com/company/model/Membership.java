package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Membership {
    private Long id;
    private String membershipNumber;
    private MembershipType type;    // enum
    private LocalDate startDate;
    private LocalDate endDate;
    private MembershipStatus status; // enum
    private boolean autoRenewal;
}
