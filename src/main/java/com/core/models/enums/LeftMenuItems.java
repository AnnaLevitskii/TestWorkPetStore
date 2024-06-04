package com.core.models.enums;

public enum LeftMenuItems {
    HOME("//div[text()='Home']"), LOST("//div[text()='Lost']"), FOUND("//div[text()='Found']"),
    SERVICES("//div[text()='Services']"), FAVORITES("//div[text()='Favorites']"),
    PROFILE("//div[@data-test-id='user-icon-container']"),
    LOGOUT("//div[@data-test-id='logout-container']");

    private final String locator;

    LeftMenuItems(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
