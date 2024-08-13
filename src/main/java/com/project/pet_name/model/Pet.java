package com.project.pet_name.model;

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

    @Column(name = "animal_name")
    private String animalName;

    @Column(name = "animal_gender")
    private String animalGender;

    @Column(name = "breed_name")
    private String breedName;

    @Column(name = "name_count")
    private Integer nameCount;
}