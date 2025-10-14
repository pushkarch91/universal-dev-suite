package com.company.model;

import java.time.LocalDate;

public class Membership {
    private Long id;
    private String membershipNumber;
    private MembershipType type;    // enum
    private LocalDate startDate;
    private LocalDate endDate;
    private MembershipStatus status; // enum
    private boolean autoRenewal;

    public Membership() {

    }

    public Membership(boolean autoRenewal, MembershipStatus status, LocalDate endDate, LocalDate startDate, MembershipType type, String membershipNumber, Long id) {
        this.autoRenewal = autoRenewal;
        this.status = status;
        this.endDate = endDate;
        this.startDate = startDate;
        this.type = type;
        this.membershipNumber = membershipNumber;
        this.id = id;
    }

    public Membership(long l, String s, MembershipType membershipType, LocalDate now, LocalDate localDate, MembershipStatus membershipStatus, boolean b) {
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public MembershipType getType() {
        return type;
    }

    public void setType(MembershipType type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public MembershipStatus getStatus() {
        return status;
    }

    public void setStatus(MembershipStatus status) {
        this.status = status;
    }

    public boolean isAutoRenewal() {
        return autoRenewal;
    }

    public void setAutoRenewal(boolean autoRenewal) {
        this.autoRenewal = autoRenewal;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "id=" + id +
                ", membershipNumber='" + membershipNumber + '\'' +
                ", type=" + type +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", autoRenewal=" + autoRenewal +
                '}';
    }
}
