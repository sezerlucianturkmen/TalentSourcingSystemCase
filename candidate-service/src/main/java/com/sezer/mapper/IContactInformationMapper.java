package com.sezer.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IContactInformationMapper {


    IContactInformationMapper INSTANCE = Mappers.getMapper(IContactInformationMapper.class);








}