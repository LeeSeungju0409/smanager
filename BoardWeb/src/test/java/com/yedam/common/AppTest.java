package com.yedam.common;


import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class AppTest {
	public static void main(String[] args) {
		BoardService svc = new BoardServiceImpl();
		svc.boardList().forEach(System.out::println);
		System.out.println("- End -");
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
