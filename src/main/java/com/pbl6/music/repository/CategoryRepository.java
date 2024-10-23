package com.pbl6.music.repository;

import com.pbl6.music.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    // Tìm Category theo ID
    Optional<CategoryEntity> findByCategoryId(Long categoryId);

    // Lấy tất cả Category có phân trang
    Page<CategoryEntity> findAll(Pageable pageable);

}
