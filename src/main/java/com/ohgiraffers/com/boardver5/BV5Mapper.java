package com.ohgiraffers.com.boardver5;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BV5Mapper {
    List<BV5DTOBoard> findAllBoards();
    List<BV5DTOPost> findAllPosts();
    List<BV5DTOComment> findAllComments();
    BV5DTOBoard findOneBoard(int boardId);
    BV5DTOPost findOnePost(int postId);
    BV5DTOComment findOneComment(int commentId);

    void addNewPost(BV5DTOPost bv5DTOPost);
    void updatePost(BV5DTOPost bv5DTOPost);
    void deletePost(BV5DTOPost bv5DTOPost);
}
