<%@page import="com.yedam.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.mapper.MemberMapper"%>
<%@page import="com.yedam.common.DataSource"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member.jsp</title>
</head>
<body>
	<% 
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	MemberVO mvo = new MemberVO();
	%>
	
	<h3>회원상세보기</h3>
	<table border="2">
		<tr>
			<th>아이디</th><td><%=mvo.getMemberId() %></td></tr>
		<tr>
			<th>이름</th><td><%=mvo.getMemberNm() %></td></tr>
		<tr>
			<th>비밀번호</th><td><%=mvo.getMemberPw() %></td></tr>
		<tr>
			<th>권한</th><td><%=mvo.getResponsibility() %></td></tr>
	</table>
	<a href="../SampleServlet">목록으로</a>
</body>
</html>