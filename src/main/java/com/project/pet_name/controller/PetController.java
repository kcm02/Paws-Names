package com.project.pet_name.controller;

import com.project.pet_name.model.Pet;
import com.project.pet_name.model.PetDTO;
import com.project.pet_name.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @GetMapping("/pets/{id}")
    @ResponseBody
    public Pet getPetById(@PathVariable Integer id) throws Exception {
        return petService.findPetById(id);
    }

    @GetMapping("/pets/random")
    @ResponseBody
    public String generateRandomNameByGender(@RequestParam String animalGender) {
        return petService.generateRandomNameByGender(animalGender);
    }

    @GetMapping("/pets")
    @ResponseBody
    public Page<PetDTO> getAllPetsWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Pet> pets = petService.getAllPetsWithPagination(page, size);
        List<PetDTO> petDTOs = pets.getContent().stream()
                .map(PetDTO::new) // 메서드 참조 사용
                .collect(Collectors.toList());
        return new PageImpl<>(petDTOs, pets.getPageable(), pets.getTotalElements());
    }

    @GetMapping("/pets/gender")
    @ResponseBody
    public Page<PetDTO> getPetsByGenderWithPagination(
            @RequestParam String animalGender,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Pet> pets = petService.getPetsByGenderWithPagination(animalGender, page, size);
        List<PetDTO> petDTOs = pets.getContent().stream()
                .map(PetDTO::new) // 메서드 참조 사용
                .collect(Collectors.toList());
        return new PageImpl<>(petDTOs, pets.getPageable(), pets.getTotalElements());
    }



    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/random-name")
    public String randomNamePage() {
        return "random";
    }
}

