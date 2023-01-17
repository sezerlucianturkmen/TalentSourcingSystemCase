package com.sezer.mapper;

import com.sezer.dto.request.CreateInteractionRequestDto;
import com.sezer.dto.response.InteractionResponseDto;
import com.sezer.repository.entity.Interaction;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IInteractionMapper {


    IInteractionMapper INSTANCE = Mappers.getMapper(IInteractionMapper.class);

    Interaction toInteraction(final CreateInteractionRequestDto dto);

    InteractionResponseDto toInteractionResponseDto(final Interaction interaction);







}