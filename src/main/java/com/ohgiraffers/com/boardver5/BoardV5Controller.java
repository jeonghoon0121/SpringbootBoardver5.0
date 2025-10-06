package com.ohgiraffers.com.boardver5;

import com.ohgiraffers.com.boardver3.BoardV3DTO;
import com.ohgiraffers.com.boardver3.BoardV3Service;
import com.ohgiraffers.com.boardver3.CommentV3DTO;
import com.ohgiraffers.com.boardver3.PostV3DTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/boardv5")
public class BoardV5Controller {
    private final BoardV5Service boardV5Service;
    public BoardV5Controller(BoardV5Service boardV5Service) {
        this.boardV5Service = boardV5Service;
    }
    @GetMapping
    public String redirectToHome1() {
        return "redirect:/boardv5/home";
    }
    @GetMapping("/")
    public String redirectToHome2() {
        return "redirect:/boardv5/home";
    }

    @GetMapping("/home")
    public String redirectToHome3(Model model) {
        return "boardv5/home";
    }






}
