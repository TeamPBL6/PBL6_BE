package com.pbl6.music.service.impl;

import com.pbl6.music.dto.CategoryDTO;
import com.pbl6.music.entity.CategoryEntity;
import com.pbl6.music.mapper.CategoryMapper;
import com.pbl6.music.repository.CategoryRepository;
import com.pbl6.music.service.ICategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    CategoryRepository categoryRepository;

    CategoryMapper categoryMapper;

    public List<CategoryDTO> getAllCategory() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        return categories.stream().map(categoryMapper::toCategoryDTO).toList();
    }

    public Optional<CategoryDTO> findByCategoryId(Long categoryId) {
        Optional<CategoryEntity> categoryOptional = categoryRepository.findByCategoryId(categoryId);
        return categoryOptional.map(categoryMapper::toCategoryDTO);
    }
}
