package com.ohgiraffers.com.boardver5;

import java.time.LocalDateTime;

public class BV5DTOComment {
    private Integer commentId;
    private Integer postId;
    private String authorId;
    private String password;
    private String content;
    private String ipHash;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public BV5DTOComment(){}

    public BV5DTOComment(Integer commentId, Integer postId, String authorId, String password, String content, String ipHash, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.commentId = commentId;
        this.postId = postId;
        this.authorId = authorId;
        this.password = password;
        this.content = content;
        this.ipHash = ipHash;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "BV5DTOComment{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", authorId='" + authorId + '\'' +
                ", password='" + password + '\'' +
                ", content='" + content + '\'' +
                ", ipHash='" + ipHash + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
