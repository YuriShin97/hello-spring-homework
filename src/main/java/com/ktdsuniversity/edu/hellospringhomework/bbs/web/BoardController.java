package com.ktdsuniversity.edu.hellospringhomework.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ktdsuniversity.edu.hellospringhomework.bbs.service.BoardService;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.ModifyBoardVO;
import com.ktdsuniversity.edu.hellospringhomework.bbs.vo.WriteBoardVO;

// 컨트롤러 선언하고 스프링에 등록
@Controller
public class BoardController {

    // BoardService 선언
    @Autowired
    private BoardService boardService;

    // 게시판 전체 리스트를 보는 화면에 대한 핸들러
    @GetMapping("/board/list")
    public String viewBoardList(Model model){

        // 모든 게시글 정보를 가져와서
        BoardListVO boardListVO = this.boardService.getAllBoards();

        // Model에 저장한 후
        model.addAttribute("boardListVO", boardListVO);

        // 반환
        return "board/boardlist";
    }

    // 게시판 새 글 쓰기 화면에 대한 핸들러
    @GetMapping("/board/write")
    public String viewBoardWritePage(){
        return "board/boardwrite";
    }

    // 게시판 새 글 쓰기 요청에 대한 핸들러
    @PostMapping("/board/write")
    public String doCreateNewBoard(WriteBoardVO writeBoardVO){
        // 새 게시글 등록
        boolean isCreate = this.boardService.createNewBoard(writeBoardVO);
        // 콘솔에 등록 결과 출력
        System.out.println("게시글 등록 결과: " + isCreate);
        // 등록후 게시판 리스트로 리다이렉트
        return "redirect:/board/list";
    }

    // 특정 글 보기 화면에 대한 핸들러
    @GetMapping("/board/view/{id}")
    public String viewOneBoard(@PathVariable int id, Model model){
        // path variable로 받은 id 값에 해당하는 게시글을 가져옴
        BoardVO boardVO = this.boardService.selectOneBoard(id, true);

        // 모델에 해당 게시글 정보를 담고
        model.addAttribute("boardVO", boardVO);

        // 해당 게시글 보기 화면으로 넘어감
        return "board/boardview";
    }
    
    @GetMapping("/board/view")
    public String viewOneBoardTwo(@RequestParam int id, Model model) {
    	
    	BoardVO boardVO = this.boardService.selectOneBoard(id, true);
    	model.addAttribute("boardVO", boardVO);
    	
    	return "board/boardview";
    }
    
    // 특정 게시글 수정 화면에 대한 핸들러
    @GetMapping("/board/modify/{id}")
    public String modifyOneBoard(@PathVariable int id, Model model){
        // path variable로 받은 id 값에 해당하는 게시글을 가져옴
        BoardVO boardVO = this.boardService.selectOneBoard(id, false);

        // 모델에 해당 게시글 정보를 담고
        // setAttribute
        model.addAttribute("boardVO", boardVO);

        // 해당 게시글 보기 화면으로 넘어감
        // setViewName
        return "board/boardmodify";
    }
    
    @PostMapping("/board/modify/{id}")
    public String doModifyOneBoard(@PathVariable int id, ModifyBoardVO modifyBoardVO, Model model) {
    	
    	modifyBoardVO.setId(id);
    	
    	boolean isUpdated = this.boardService.updateOneBoard(modifyBoardVO);
    	
    	// TODO post update process
    	if(isUpdated) {
    		// TODO 성공적으로 수정했다면, 수정한 게시글의 상세조회 페이지로 이동시킨다.
    		return "redirect:/board/view/" + id;
    	}
    	else {
    		// TODO 사용자가 작성했던 내용을 JSP 에 그대로 보내준다.
    		model.addAttribute("boardVO", modifyBoardVO);
    		return "board/boardmodify";
    	}
    }
    
    @GetMapping("/board/delete/{id}")
    public String deleteBoard(@PathVariable int id) {
    	boolean isDeleted = this.boardService.deleteOneBoard(id);
    	if(isDeleted) {
    		return "redirect:/board/list";
    	} else {
    		return "redirect:/board/view/" + id;
    	}
    }
}
