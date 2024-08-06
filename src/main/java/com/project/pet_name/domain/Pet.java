package com.project.pet_name.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "AnimalName")
    private String animalName;

    @Column(name = "AnimalGender")
    private String animalGender;

    @Column(name = "AnimalBirthYear")
    private Integer animalBirthYear;

    @Column(name = "BreedName")
    private String breedName;

    @Column(name = "NameCount")
    private Integer nameCount;
}