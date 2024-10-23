package com.pbl6.music.service;

import com.pbl6.music.dto.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<CategoryDTO> getAllCategories();
    Optional<CategoryDTO> findByCategoryId(Long categoryId);
}
