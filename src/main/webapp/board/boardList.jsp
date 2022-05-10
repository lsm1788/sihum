<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 50%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<div>
<h2>게시판 목록</h2>
<table>
  <tr>
  	<button onclick="location.href='BoardServlet?command=board_write_form'">게시글 등록</button>
    <th>글번호</th>
    <th>제목</th>
    <th>작성자</th>
    <th>작성일</th>
  </tr>
  <c:forEach var="board" items="${boardList}">
  <tr>
  	<td>${board.num}</td>
  	<td>
  		<a href="BoardServlet?command=board_view&num=${board.num}">${board.title}</a>
  	</td>
    <td>${board.writer}</td>
    <td><fmt:formatDate value="${board.writerDate}"/></td>
  </tr>
  </c:forEach>
</table>
</div>
</body>
</html>