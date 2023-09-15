package com.example.asterixapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asterix")
public class AsterixController {

    private final CharacterRepo characterRepo;

    public AsterixController(CharacterRepo characterRepo) {
        this.characterRepo = characterRepo;
    }

    @GetMapping("/characters")
    List<Character> findAllCharacters() {
        return characterRepo.findAll();
    }

    @PostMapping("/characters")
    Character addCharacter(@RequestBody Character newCharacter) {
        return characterRepo.save(newCharacter);
    }
}
