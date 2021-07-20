<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<body>	
		<div class="form-group text-right container">
		<a href="/qna/insert">
		<button type="button" class="btn btn-primary btn-sm" id="writeBtn">글쓰기</button>
		</a>
	</div>
	<div class="container">
		<table class="table table-hover">
		
			<thead>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</thead>

			<c:forEach items="${lists.content}" var="qna" varStatus="st">
				<tbody>
					<tr>	
						<td>${rowNo-st.index }</td>
						<td><a href="/qna/detail/${qna.qnaNo}">${qna.title}</a></td>
						<td>${qna.user.username }</td>
						<td><fmt:formatDate value="${qna.qnaDate }" pattern="yyyy-MM-dd" /></td>
					</tr>
				</tbody>

			</c:forEach>
			
		</table>
			<ul class="pagination">
				<c:if test="${lists.first  ==false }">
					<li class="page-item"><a class="page-link" href="?page=${lists.number-1}">Previous</a></li>
				</c:if>
				<c:if test="${lists.last == false}">
					<li class="page-item"><a class="page-link" href="?page=${lists.number+1}">Next</a></li>
				</c:if>
			</ul>
	</div>
 	</body>
</html>	