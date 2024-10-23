package com.pbl6.music.repository;

import com.pbl6.music.dto.MusicDTO;
import com.pbl6.music.entity.MusicEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<MusicEntity, Long> {

    @Query("""
        select new com.pbl6.music.dto.MusicDTO(
            m.musicId,
            m.title,
            m.fullUrl,
            m.price,
            m.isPurchased,
            m.categoryEntity.categoryId)
        from MusicEntity m
        where m.isPurchased = false
        """)
    Page<MusicDTO> findAllAvailableMusic(Pageable pageable);

}
