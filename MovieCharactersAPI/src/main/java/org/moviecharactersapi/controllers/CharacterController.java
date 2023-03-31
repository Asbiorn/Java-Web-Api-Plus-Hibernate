package org.moviecharactersapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.moviecharactersapi.mappers.CharacterMapper;
import org.moviecharactersapi.models.Character;
import org.moviecharactersapi.services.CharacterService;
import org.moviecharactersapi.services.CharacterServiceImpl;
import org.moviecharactersapi.util.ApiErrorResponse;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.moviecharactersapi.models.dtos.Character.CharacterDTO;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("api/v1/characters")
public class CharacterController {
    private final CharacterService characterService;
    private final CharacterMapper characterMapper;

    public CharacterController(CharacterServiceImpl characterService, CharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }


    @Operation(summary = "Get all characters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CharacterDTO.class))) }),
            @ApiResponse(responseCode = "404",
                    description = "Character does not exist with supplied ID",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("")
    public ResponseEntity getAll() {
        try {
            Collection<CharacterDTO> characterDTOs = characterMapper.charactersToCharacterDTOs(
                    characterService.findAll()
            );
            return ResponseEntity.ok(characterDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Get a character by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CharacterDTO.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "character does not exist with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable int id) {
        try {
             CharacterDTO characterDTO = characterMapper.characterToCharacterDTO(characterService.findById(id));
            return ResponseEntity.ok(characterDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @Operation(summary = "Adding a new character")
    @PostMapping()
    public ResponseEntity<CharacterDTO> add(@RequestBody CharacterDTO characterDTO) {
        Character characterDTOToCharacter = characterMapper.characterDTOToCharacter(characterDTO);
        Character characterToAdd = characterService.add(characterDTOToCharacter); // no need to create new object
        URI location = URI.create("api/v1/character/" + characterToAdd.getId());

        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Updates a character")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "character successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorAttributeOptions.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "character not found with supplied ID",
                    content = @Content)
    })
    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody CharacterDTO characterDTO, @PathVariable int id) {
        if(id != characterDTO.getId())
            return ResponseEntity.badRequest().build();
        characterService.update(
                characterMapper.characterDTOToCharacter(characterDTO)
        );
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
