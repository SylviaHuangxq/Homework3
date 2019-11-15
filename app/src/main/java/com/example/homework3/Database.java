package com.example.homework3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Database {
    public static HashMap<String, Breed> breeds = new HashMap<>();

    public static Breed getBreedById(String breedID) {
        return breeds.get(breedID);
    }

    public static List<Breed> getAllBreeds() {
        return (List) breeds.values();
    }

    public static void saveBreedsToFakeDatabase(List<Breed> breedsToSave) {
        for (int i = 0; i < breedsToSave.size(); i++) {
            Breed breed = breedsToSave.get(i);


            breeds.put(breed.getBreedID(), breed);


        }
    }


}
