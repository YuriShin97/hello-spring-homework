package com.ktdsuniversity.edu.hellospringhomework.bbs.web;

import com.ktdsuniversity.edu.hellospringhomework.bbs.service.BoardService;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.WriteBoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/list")
    public String viewBoardList(Model model){

        BoardListVO boardListVO = this.boardService.getAllBoards();

        model.addAttribute("boardListVO", boardListVO);
        
        return "board/boardlist";
    }

    @GetMapping("/board/write")
    public String viewBoardWritePage(){
        return "board/boardwrite";
    }

    @PostMapping("/board/write")
    public String doCreateNewBoard(WriteBoardVO writeBoardVO){
        boolean isCreate = this.boardService.createNewBoard(writeBoardVO);
        System.out.println("게시글 등록 결과: " + isCreate);
        return "redirect:/board/list";
    }

    @GetMapping("/board/view/{id}")
    public String viewOneBoard(@PathVariable int id, Model model){
        BoardVO boardVO = this.boardService.selectOneBoard(id);

        model.addAttribute("boardVO", boardVO);

        return "board/boardview";
    }
}
