<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상품 조회</title>	
		<!-- head.jsp import -->
		<c:import url = "/WEB-INF/views/layout/head.jsp"></c:import>	 
	</head>
	<body>
		<div id="wrap">
			<!-- top.jsp import -->
			<c:import url = "/WEB-INF/views/layout/top.jsp"></c:import>
			<br>
			<h3>주문 조회</h3>	<br>
			<table border="1" width="70%">
				<tr><th>주문 번호</th>
				<th>주문일</th>
				<th>수령인</th>
				<th>배송지</th></tr>
			<!-- 주문 내용 반복 출력 -->
				<c:forEach var="ord" items="${ordList}">
					<tr>
						<td><a href="<c:url value='/order/detailViewOrder'/>">${ord.ordNo}</a></td>
						<td>${ord.ordDate}</td>
						<td>${ord.ordReceiver}</td>
						<td>${ord.ordRcvAddress1} ${ord.ordRcvAddress2}</td>
					</tr>
				</c:forEach>						
			</table><br><br>

			<!-- footer.jsp import -->
			<c:import url = "/WEB-INF/views/layout/bottom.jsp"></c:import>
		</div>
	</body>
</html>