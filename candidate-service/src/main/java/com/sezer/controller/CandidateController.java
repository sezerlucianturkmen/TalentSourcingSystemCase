package com.sezer.controller;

import com.sezer.dto.request.CreateCandidateRequestDto;
import com.sezer.dto.request.UpdateCandidateRequestDto;
import com.sezer.dto.response.CandidateResponseDto;
import com.sezer.service.CandidateService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sezer.constant.EndPoint.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(CANDIDATE)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping(SAVE)
    @Operation(summary = "You could create a candidate with his / her contact information.")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<CandidateResponseDto> createCandidate(@RequestBody CreateCandidateRequestDto dto){
        return ResponseEntity.ok(candidateService.createCandidate(dto));
    }

    @PutMapping(UPDATE)
    @Operation(summary = "You could update a candidate with his / her contact information.")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<CandidateResponseDto> updateCandidate(@RequestBody UpdateCandidateRequestDto dto){
        return ResponseEntity.ok(candidateService.updateCandidate(dto));
    }

    @GetMapping(FINDALL)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<CandidateResponseDto>> findAll(){
        return ResponseEntity.ok(candidateService.findAllCandidates());
    }


    @GetMapping(FINDALLSOURCED)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<CandidateResponseDto>> findAllSourced(){
        return ResponseEntity.ok(candidateService.findAllCandidatesSourced());
    }


    @DeleteMapping(DELETE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @Operation(summary = "You can delete candidate")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.ok(candidateService.deleteCandidate(id));
    }

    @GetMapping(FINDBYID)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @Operation(summary = "You can find candidate")
    public ResponseEntity<CandidateResponseDto> findCandidate(@PathVariable Long id){
        return ResponseEntity.ok(candidateService.findCandidate(id));
    }

}
