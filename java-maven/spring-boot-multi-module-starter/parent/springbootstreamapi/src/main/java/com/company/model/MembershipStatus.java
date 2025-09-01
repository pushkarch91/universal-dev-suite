package com.company.model;

public enum MembershipStatus {
    ACTIVE("Active", true),
    EXPIRED("Expired", false),
    CANCELLED("Cancelled", false),
    SUSPENDED("Suspended", false),
    PENDING("Pending Approval", false);

    private final String displayName;
    private final boolean usable; // Can customer actually use benefits?

    MembershipStatus(String displayName, boolean usable) {
        this.displayName = displayName;
        this.usable = usable;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isUsable() {
        return usable;
    }
}
