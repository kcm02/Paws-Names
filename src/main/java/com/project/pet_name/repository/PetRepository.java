package com.project.pet_name.repository;

import com.project.pet_name.model.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PetRepository extends JpaRepository<Pet, Integer> {

    Page<Pet> findAllByOrderByNameCountDesc(Pageable pageable);

    @Query(value = "SELECT * FROM pets WHERE animal_gender = ?1 ORDER BY name_count DESC", nativeQuery = true)
    Page<Pet> findByAnimalGenderOrderByNameCountDesc(String animalGender, Pageable pageable);

    @Query(value = "SELECT * FROM pets WHERE animal_gender = ?1 ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Pet generateRandomNameByGender(String animalGender);

}
