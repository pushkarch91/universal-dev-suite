package com.company.model;

public enum MembershipType {
    BASIC("Basic Plan", 0.0, 1),       // No rewards, monthly cycle
    SILVER("Silver Plan", 0.01, 1),    // 1% rewards
    GOLD("Gold Plan", 0.02, 1),        // 2% rewards
    PLATINUM("Platinum Plan", 0.05, 12), // 5% rewards, annual cycle
    DIAMOND("Diamond Elite", 0.10, 12),  // 10% rewards, annual cycle
    TRIAL("Trial Plan", 0.0, 0);       // No rewards, no billing

    private final String displayName;
    private final double rewardMultiplier; // e.g., 0.05 = 5%
    private final int billingCycleMonths;  // e.g., 1 = monthly, 12 = yearly

    MembershipType(String displayName, double rewardMultiplier, int billingCycleMonths) {
        this.displayName = displayName;
        this.rewardMultiplier = rewardMultiplier;
        this.billingCycleMonths = billingCycleMonths;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getRewardMultiplier() {
        return rewardMultiplier;
    }

    public int getBillingCycleMonths() {
        return billingCycleMonths;
    }
}
