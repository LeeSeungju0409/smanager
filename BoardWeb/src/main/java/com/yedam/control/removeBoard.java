package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class removeBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String bno = req.getParameter("bno");
//		
//		BoardService svc = new BoardServiceImpl();
//		BoardVO board = svc.getBoard(Integer.parseInt(bno));
//		
//		req.setAttribute("board", board);
		String bno = req.getParameter("bno");
		
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.getBoard(Integer.parseInt(bno));
		
		req.setAttribute("board", board);
		
		req.getRequestDispatcher("WEB-INF/jsp/removeBoard.jsp")//
				.forward(req, resp); //페이지 재지정.

	}

}
