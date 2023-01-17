package com.sezer.mapper;


import com.sezer.dto.request.CreateCandidateRequestDto;
import com.sezer.dto.response.CandidateResponseDto;
import com.sezer.repository.entity.Candidate;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ICandidateMapper {


    ICandidateMapper INSTANCE = Mappers.getMapper(ICandidateMapper.class);

    Candidate toCandidate(final CreateCandidateRequestDto dto);
    CandidateResponseDto toCandidateResponseDto(final Candidate candidate);






}