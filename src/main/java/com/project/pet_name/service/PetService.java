package com.project.pet_name.service;

import com.project.pet_name.domain.Pet;
import com.project.pet_name.repository.PetRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    @PostConstruct
    public void init() {
        Pet pet = petRepository.findById(1).orElseThrow(() -> new RuntimeException("Pet not found"));
        System.out.println("Animal Name: " + pet.getAnimalName());
    }

}
