package com.ohgiraffers.com.boardver5;

import com.ohgiraffers.com.boardver3.PostV3DTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/boardv5")
public class BV5Controller {
    private final BV5Service bv5Service;

    public BV5Controller(BV5Service bv5Service) {
        this.bv5Service = bv5Service;
    }
    @GetMapping({"", "/", "/home", "/home/"})
    public String BoardHome(Model model) {
        List<BV5DTOBoard> bv5DTOBoards=bv5Service.findAllBoards();
        List<BV5DTOPost> bv5DTOPosts=bv5Service.findAllPosts();
        List<BV5DTOComment> bv5DTOComments=bv5Service.findAllComments();
        model.addAttribute("boardlist",bv5DTOBoards );
        model.addAttribute("postlist",bv5DTOPosts );
        model.addAttribute("commentlist",bv5DTOComments );
        return "boardv5/home";
    }
    @GetMapping("test")
    public String TestHomeBoard(Model model) {
        List<BV5DTOBoard> bv5DTOBoards=bv5Service.findAllBoards();
        List<BV5DTOPost> bv5DTOPosts=bv5Service.findAllPosts();
        List<BV5DTOComment> bv5DTOComments=bv5Service.findAllComments();
        for (BV5DTOBoard boards : bv5DTOBoards) {
            System.out.println(boards);
        }
        for (BV5DTOPost posts : bv5DTOPosts){
            System.out.println(posts);
        }
        for (BV5DTOComment comments : bv5DTOComments){
            System.out.println(comments);
        }
        model.addAttribute("boardlist",bv5DTOBoards );
        model.addAttribute("postlist",bv5DTOPosts );
        model.addAttribute("commentlist",bv5DTOComments );
        return "boardv5/home";
    }
    @GetMapping("board/{boardId}")
    public String BoardList(@PathVariable int boardId, Model model) {
        BV5DTOBoard board = bv5Service.findoneBoard(boardId); // 게시판 정보 가져오기
        List<BV5DTOPost> posts = bv5Service.findPostsByBoardId(boardId);

        model.addAttribute("board", board);       // ✅ board 객체 추가
        model.addAttribute("postlist", posts);    // 게시글 목록 추가
        return "boardv5/boardlist";

    }



}


