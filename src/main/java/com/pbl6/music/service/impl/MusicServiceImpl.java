package com.pbl6.music.service.impl;

//import com.pbl6.music.dto.response.MusicResponseDTO;
//import com.pbl6.music.dto.response.PageResponse;
import com.pbl6.music.service.IMusicService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MusicServiceImpl implements IMusicService {
//
//     MusicRepository musicRepository;
//
//
//     MusicMapper musicMapper;
//    @Override
//    public PageResponse<?> getAll(int page, int pageSize) {
//
//        Pageable pageable = PageRequest.of(page > 0 ? page - 1 : 0, pageSize);
//        Page<MusicResponseDTO> musics = musicRepository.findAllMusic(pageable);
//
//        return PageResponse.builder()
//                .page(page)
//                .pageSize(pageSize)
//                .totalPage(musics.getTotalPages())
//                .items(musics.getContent())
//                .build();
//    }
//
//    @Override
//    public MusicResponseDTO getById(Long id) {
//        MusicEntity musicEntity = musicRepository.findById(id).orElseThrow(() -> new ApiException(ErrorCode.MUSIC_NOT_FOUND));
//       return musicMapper.toResponseDTO(musicEntity);
//    }
}
