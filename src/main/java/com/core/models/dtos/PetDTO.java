package com.core.models.dtos;


import com.core.models.enums.PetSex;
import com.core.models.enums.PetType;
import com.core.utils.Path;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;
import java.util.Objects;

@Builder
@ToString
@Getter
@Setter
public class PetDTO implements Serializable, Path {
    private static final long serialVersionUID = 64565461L;

    private PetType type; //transient
    private PetSex sex;
    private String breed;
    private String color;
    private String distinctive_features;
    private String[] description;
    private String photo;
    private String location;
    private String contacts;
    private String email;
    private String text; //only Add new post

    public static void serializableAnimalDTO(PetDTO animal, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(SERIALIZE_PATH + fileName))) {
            outputStream.writeObject(animal);
        } catch (IOException e) {
            System.out.println("serializable exception was thrown");
            e.printStackTrace();
        }
    }

    public static PetDTO deSerializableAnimalDTO(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream(SERIALIZE_PATH + fileName))) {
            return (PetDTO) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("deserializable exception was thrown");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetDTO petDTO = (PetDTO) o;
        return type == petDTO.type && sex == petDTO.sex && Objects.equals(breed, petDTO.breed) && Objects.equals(color, petDTO.color) && Objects.equals(distinctive_features, petDTO.distinctive_features) && Objects.equals(description, petDTO.description) && Objects.equals(photo, petDTO.photo) && Objects.equals(location, petDTO.location) && Objects.equals(contacts, petDTO.contacts) && Objects.equals(email, petDTO.email) && Objects.equals(text, petDTO.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, sex, breed, color, distinctive_features, description, photo, location, contacts, email, text);
    }
}
