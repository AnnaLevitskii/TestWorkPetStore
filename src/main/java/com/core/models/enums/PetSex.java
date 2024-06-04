package com.core.models.enums;

public enum PetSex {
    FEMALE("Female"), MALE("Male"), OTHER("Other");
    private final String text;

    PetSex(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
