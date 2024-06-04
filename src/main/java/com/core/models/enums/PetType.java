package com.core.models.enums;

public enum PetType {
    DOG("Dog") , CAT("Cat"), BIRD("Bird"), RODENT("Rodent"),
    REPTILE("Reptile"), FERRET("Ferret"), RABBIT("Rabbit"),
    TURTLE("Turtle"), EXOTIC_ANIMAL("Exotic animal");

    private final String text;

    PetType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
