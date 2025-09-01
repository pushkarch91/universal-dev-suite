package com.company.model;

public enum CustomerStatus {
    ACTIVE("Active Customer", true),
    INACTIVE("Inactive Customer", false),
    BLOCKED("Blocked due to violation", false),
    DELETED("Deleted Account", false);

    private final String displayName;
    private final boolean allowedLogin;

    CustomerStatus(String displayName, boolean allowedLogin) {
        this.displayName = displayName;
        this.allowedLogin = allowedLogin;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isAllowedLogin() {
        return allowedLogin;
    }
}
