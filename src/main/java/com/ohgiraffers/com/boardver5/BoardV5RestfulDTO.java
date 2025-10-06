package com.ohgiraffers.com.boardver5;

public class BoardV5RestfulDTO {
    private String name;
    public BoardV5RestfulDTO() {}

    public BoardV5RestfulDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BoradV5DTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
