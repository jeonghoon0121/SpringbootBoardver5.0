package com.ohgiraffers.com.boardver5;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoardV5RestfulService {

    public List<BoardV5RestfulDTO> getAllBoards() {
        // 실제 DB 연동 전에는 테스트용 하드코드
        return List.of(
                new BoardV5RestfulDTO("test1"),
                new BoardV5RestfulDTO("test2")
        );
    }
}
