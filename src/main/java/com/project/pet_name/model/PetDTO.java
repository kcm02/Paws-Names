package com.project.pet_name.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // null 값은 JSON에 포함하지 않음
public class PetDTO {
    private String animalName;
    private String animalGender;
    private String breedName;
    private Integer nameCount;

    // 필요한 경우 생성자 추가
    public PetDTO(Pet pet) {
        this.animalName = pet.getAnimalName();
        this.animalGender = pet.getAnimalGender();
        this.breedName = pet.getBreedName();
        this.nameCount = pet.getNameCount();
    }
}

