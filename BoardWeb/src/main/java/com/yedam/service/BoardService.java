package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchVO;
import com.yedam.vo.BoardVO;

/*
 * MCV 패턴의 디자인에 따라서 Model영역(service, dao:mapper).
 * 책: 4강 MVC기반 웹프로젝트 참고.
 * 숙제: 536페이지 MVC에 자세히 읽고 오세요.
 * 
 * 서비스부분 없으면...
 * dao)
 * 등록 -> 수정 -> 조회
 * method) add + mod + select;
 * 수정 -> 등록 -> 조회
 * method) mod + add + select;
 * 조회 -> 수정 -> 등록
 * method) select + mod + add;
 * 
 * 
 * 서비스부분 있으면...
 * service)
 * add + mod + select; 1줄
 * dao)
 * method) add;
 * method) mod;
 * method) select;
 */
public interface BoardService {
	List<BoardVO> boardList(SearchVO search);
	int totalCount(SearchVO search); // 페이징 계산용 건수.
	boolean addBoard(BoardVO board);
	boolean modifyBoard(BoardVO board);
	boolean removeBoard(int boardNo);
	BoardVO getBoard(int boardNo);
}
