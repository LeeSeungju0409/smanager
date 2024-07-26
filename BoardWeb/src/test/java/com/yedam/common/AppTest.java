package com.yedam.common;

import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class AppTest {
	public static void main(String[] args) {
		ReplyService svc = new ReplyServiceImpl();
		SearchVO search = new SearchVO();
		search.setBno(144);
		search.setPage(5);

		svc.replyList(search).forEach(System.out::println);
		System.out.println("-END-");
		
		
		
		
		
//		ReplyService svc = new ReplyServiceImpl();
//		ReplyVO rvo = new ReplyVO();
//		rvo.setReplyContent("등록연습");
//		rvo.setReplyer("user03");
//		rvo.setBoardNo(148);
//		
//		if(svc.removeReply(1)) {
//			System.out.println("삭제완료!");
//		}
//		
//	
//		svc.replyList(148).forEach(System.out::println);
//		
//
//		System.out.println("-END-");
		
//		BoardService svc = new BoardServiceImpl();
//		SearchVO search = new SearchVO();
//		search.setSearchCondition("T");
//		search.setKeyword("java");
//		search.setPage(1);
//		
//		svc.boardList(search).forEach(System.out::println);
//		System.out.println("- End -");
		
		
//		SqlSession sqlSession = //
//				DataSource.getInstance().openSession(true); //자동으로 커밋하려고 true 넣음.
//		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
//		
//		BoardVO brd = new BoardVO();
////		brd.setTitle("매퍼테스트1111");
//		brd.setContent("조건이 제대로 되는지2222");
//		brd.setWriter("newbie");
//		brd.setBoardNo(5);
//		
////		if(mapper.insertBoard(brd)==1) {
////			System.out.println("OK");
////		}
//		
//		if(mapper.updateBoard(brd)==1) {
//			System.out.println("OK");
//		}
//		
//		if(mapper.deleteBoard(brd.getBoardNo())==1) {
//			System.out.println("OK");
//		}
//	
//		
//		System.out.println(brd.getBoardNo());
//		
//		mapper.selectList().forEach(board -> System.out.println(board.toString()));
//		
//		System.out.println("- End -");
		
		


			
	}
}
