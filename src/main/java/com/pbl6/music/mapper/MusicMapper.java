package com.pbl6.music.mapper;

//import com.pbl6.music.dto.MusicResponseDTO;
import com.pbl6.music.entity.MusicEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MusicMapper {

//    @Mapping(source = "composer.fullName", target = "composerFullName")
//    @Mapping(source = "category.name", target = "categoryName")
//    @Mapping(source = "composer.id", target = "composerId")
//    @Mapping(source = "category.id", target = "categoryId")
//    MusicResponseDTO toResponseDTO(MusicEntity musicEntity);
//
//    MusicEntity toEntity(MusicResponseDTO musicDTO);
}
