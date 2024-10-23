package com.pbl6.music.mapper;

import com.pbl6.music.dto.CategoryDTO;
import com.pbl6.music.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "categoryId", target = "categoryIdDTO")
    @Mapping(source = "categoryName", target = "categoryNameDTO")
    CategoryDTO toCategoryDTO(CategoryEntity category);

    CategoryEntity toCategoryEntity(CategoryDTO dto);
}
