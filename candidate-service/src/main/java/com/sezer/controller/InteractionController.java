package com.sezer.controller;

import com.sezer.dto.request.CreateCandidateRequestDto;
import com.sezer.dto.request.CreateInteractionRequestDto;
import com.sezer.dto.request.UpdateCandidateRequestDto;
import com.sezer.dto.request.UpdateInteractionRequestDto;
import com.sezer.dto.response.CandidateResponseDto;
import com.sezer.dto.response.InteractionResponseDto;
import com.sezer.repository.entity.Interaction;
import com.sezer.service.CandidateService;
import com.sezer.service.InteractionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sezer.constant.EndPoint.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(INTERACTION)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InteractionController {

    private final InteractionService interactionService;

    @PostMapping(SAVE)
    @Operation(summary = "You could create an interaction with a candidate")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<CandidateResponseDto> createInteraction(@RequestBody CreateInteractionRequestDto dto){
        return ResponseEntity.ok(interactionService.createInteraction(dto));
    }

    @PutMapping(UPDATE)
    @Operation(summary = "You could update interaction.")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<CandidateResponseDto> updateInteraction(@RequestBody UpdateInteractionRequestDto dto){
        return ResponseEntity.ok(interactionService.updateInteraction(dto));
    }

    @GetMapping(FINDALLBYID)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<InteractionResponseDto>> findAll(@PathVariable Long candidateid){
        return ResponseEntity.ok(interactionService.findAllInteraction(candidateid));
    }

    @DeleteMapping(DELETE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @Operation(summary = "You can delete interaction")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.ok(interactionService.deleteInteraction(id));
    }


}
