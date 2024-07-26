package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String res = req.getParameter("res");
		res = res == null ? "User" : res;
		String order = req.getParameter("order");
		order = order == null ? "member_nm" : order;

		MemberService mvc = new MemberServiceImpl();
		List<MemberVO> list = mvc.memberList(res, order);

		MemberVO mvo = new MemberVO();
		mvo.setResponsibility(res);
		mvo.setMemberNm(order);

		req.setAttribute("memberList", list);
		req.setAttribute("res", res);
		req.getRequestDispatcher("admin/memberList.tiles").forward(req, resp);

	}
}
