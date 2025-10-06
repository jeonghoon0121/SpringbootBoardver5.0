package com.ohgiraffers.com.boardver5;
import com.ohgiraffers.com.boardver3.BoardV3DTO;
import com.ohgiraffers.com.boardver3.BoardV3Mapper;
import com.ohgiraffers.com.boardver3.CommentV3DTO;
import com.ohgiraffers.com.boardver3.PostV3DTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardV5Service {
    private final BoardV5Mapper boardV5Mapper;
    public BoardV5Service(BoardV5Mapper boardV5Mapper){
    this.boardV5Mapper=boardV5Mapper;
}
}

