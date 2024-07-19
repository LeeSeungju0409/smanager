package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class UpdateBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String bno = req.getParameter("bno");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        
		BoardService svc = new BoardServiceImpl();
        BoardVO board = new BoardVO();
        board.setBoardNo(Integer.parseInt(bno));
        board.setContent(content);
        board.setTitle(title);
		if(svc.modifyBoard(board)) {
			// 목록으로 이동
			resp.sendRedirect("boardList.do");
		} else {
			// 삭제페이지로 이동
			resp.sendRedirect("modifyBoard.do?bno=" + bno);
		}
//		req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);
	}

}
