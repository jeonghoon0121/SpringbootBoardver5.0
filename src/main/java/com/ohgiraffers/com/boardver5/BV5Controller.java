package com.ohgiraffers.com.boardver5;

import com.ohgiraffers.com.boardver3.PostV3DTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public String getBoardList(@PathVariable int boardId, Model model) {
        List<BV5DTOBoard> bv5DTOBoards=bv5Service.findAllBoards();
        BV5DTOBoard board = bv5Service.findoneBoard(boardId);
        List<BV5DTOPost> posts = bv5Service.findPostsByBoardId(boardId);

        model.addAttribute("boardlist",bv5DTOBoards );
        model.addAttribute("board", board);
        model.addAttribute("postlist", posts);
        return "boardv5/boardlist";
    }
    @GetMapping("post/{postId}")
    public String getPostDetail(@PathVariable int postId, Model model) {
        List<BV5DTOBoard> bv5DTOBoards=bv5Service.findAllBoards();
        BV5DTOPost post=bv5Service.findonePost(postId);
        List<BV5DTOComment> comments = bv5Service.findCommentsByPostId(postId);

        model.addAttribute("boardlist",bv5DTOBoards );
        model.addAttribute("post", post);
        model.addAttribute("commentlist", comments);
        return "boardv5/postDetail";
    }
    @Controller
    @RequestMapping("/boardv5/post")
    public class PostController {

        @GetMapping("/add/{boardId}")
        public String showPostAddForm(@PathVariable int boardId, Model model) {
            List<BV5DTOBoard> bv5DTOBoards=bv5Service.findAllBoards();
            model.addAttribute("boardlist",bv5DTOBoards );

            model.addAttribute("boardId", boardId);
            return "boardv5/postAdd";
        }
        @GetMapping("/update/{postId}")
        public String showPostUpdateForm(@PathVariable int postId, Model model) {
            List<BV5DTOBoard> bv5DTOBoards=bv5Service.findAllBoards();
            model.addAttribute("boardlist",bv5DTOBoards );

            model.addAttribute("postId", postId);
            return "boardv5/postUpdate";
        }
        @GetMapping("/delete/{postId}")
        public String showPostDeleteForm(@PathVariable int postId, Model model) {
            List<BV5DTOBoard> bv5DTOBoards=bv5Service.findAllBoards();
            model.addAttribute("boardlist",bv5DTOBoards );

            model.addAttribute("postId", postId);
            return "boardv5/postDelete";
        }
        /*post 더하기*/
        @PostMapping("/add/{boardId}")
        public String handlePostAdd(@PathVariable int boardId,
                                    @ModelAttribute BV5DTOPost bv5DTOPost) {
            
            bv5DTOPost.setBoardId(boardId);
            bv5Service.addNewPost(bv5DTOPost);
            return "redirect:/boardv5/board/" + boardId;
        }
        /*post 수정*/
        @PostMapping("/update/{postId}")
        public String handlePostUpdate(@PathVariable int postId,
                                    @ModelAttribute BV5DTOPost bv5DTOPost) {
            bv5DTOPost.setPostId(postId);
            bv5Service.updatePost(bv5DTOPost);
            return "redirect:/boardv5/post/" + postId;
        }
        /*post 삭제*/
        @PostMapping("/delete/{postId}")
        public String handlePostDelete(@PathVariable int postId,
                                       @ModelAttribute BV5DTOPost bv5DTOPost) {
            bv5DTOPost.setPostId(postId);
            int boardId=bv5Service.findonePost(bv5DTOPost.getPostId()).getBoardId();
            bv5Service.deletePost(bv5DTOPost);
            return "redirect:/boardv5/board/"+boardId;
        }



    }





}


