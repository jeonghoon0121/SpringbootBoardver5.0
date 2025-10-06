package com.ohgiraffers.com.boardver5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restful")
public class BoardV5RestfulController {
    private final BoardV5RestfulService boardV5RestfulService;

    public BoardV5RestfulController(BoardV5RestfulService boardV5RestfulService) {
        this.boardV5RestfulService = boardV5RestfulService;
    }

    @GetMapping("/boardv5")
    public List<BoardV5RestfulDTO> getDTOs(){
        return boardV5RestfulService.getAllBoards();
    }
}
