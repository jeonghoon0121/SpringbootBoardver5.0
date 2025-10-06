package com.ohgiraffers.com.boardver5;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BV5Service {
    private final BV5Mapper bv5Mapper;
    public BV5Service(BV5Mapper bv5Mapper){
    this.bv5Mapper=bv5Mapper;
}

    public List<BV5DTOBoard> findAllBoards(){return bv5Mapper.findAllBoards();}
    public List<BV5DTOPost> findAllPosts(){return bv5Mapper.findAllPosts();}
    public List<BV5DTOComment> findAllComments(){return bv5Mapper.findAllComments();}
    public List<BV5DTOPost> findPostsByBoardId(int boardId) {
        List<BV5DTOPost> result = new ArrayList<>();
        for (BV5DTOPost post : findAllPosts()) {
            if (post.getBoardId() == boardId) {
                result.add(post);
            }
        }
        return result;
    }

    public BV5DTOBoard findoneBoard(int boardId) {
        return bv5Mapper.findOneBoard(boardId);
    }
}

