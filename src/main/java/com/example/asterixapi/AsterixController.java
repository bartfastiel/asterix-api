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

    @PutMapping("/characters/{characterId}")
    Character insertOrUpdateCharacter(@PathVariable String characterId, @RequestBody Character newCharacter) {
        if (!characterId.equals(newCharacter.id())) {
            throw new IllegalArgumentException("Character ID does not match");
        }
        return characterRepo.save(newCharacter);
    }

    @DeleteMapping("/characters/{characterId}")
    void deleteCharacter(@PathVariable String characterId) {
        characterRepo.deleteById(characterId);
    }
}
