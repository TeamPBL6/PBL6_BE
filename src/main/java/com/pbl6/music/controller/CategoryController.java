package com.pbl6.music.controller;

import com.pbl6.music.dto.APIResponse;
import com.pbl6.music.dto.CategoryDTO;
import com.pbl6.music.service.ICategoryService;
import com.pbl6.music.util.JsonResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoryController {

    ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<APIResponse<List<CategoryDTO>>> getAll() {
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return JsonResponse.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Optional<CategoryDTO>>> getByID(@PathVariable("id") Long categoryId) {
        Optional<CategoryDTO> productDTO = categoryService.findByCategoryId(categoryId);
        return JsonResponse.ok(productDTO);
    }

}
