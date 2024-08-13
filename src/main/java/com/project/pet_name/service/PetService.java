package com.project.pet_name.service;

import com.project.pet_name.model.Pet;
import com.project.pet_name.repository.PetRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    // Runs at the same time as the app is running
    @PostConstruct
    public void init() {
//        Pet pet = petRepository.generateRandomNameByGender("F");
//        System.out.println(pet.getAnimalName());
    }

    // Method to find pet by id
    public Pet findPetById(Integer id) throws Exception {
        Pet pet = petRepository.findById(id).orElseThrow(() -> new Exception("Pet not found"));
        return pet;
    }

    // Method to generate a random name for each animalGender
    public String generateRandomNameByGender(String animalGender) {
        Pet pet = petRepository.generateRandomNameByGender(animalGender);
        return pet.getAnimalName();
    }

    // Method to get all pets with pagination
    public Page<Pet> getAllPetsWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return petRepository.findAllByOrderByNameCountDesc(pageable);
    }

    // Method to get pets by gender with pagination
    public Page<Pet> getPetsByGenderWithPagination(String animalGender, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return petRepository.findByAnimalGenderOrderByNameCountDesc(animalGender, pageable);
    }

}
