<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<c:if test="${ myName == 'TienNH21' }">
	<h1>Hello GV lop IT16201 mon SOF3011</h1>
</c:if>

<c:if test="${ myName != 'TienNH21' }">
	<h1>Hello SV lop IT16201 mon SOF3011</h1>
</c:if>


<!--
	Thực hiện truyền tham số diem từ servlet sang jsp.
	Kiểm tra:
		diem < 5: Trượt
		diem < 7: TB
		diem < 9: Khá
		diem <= 10: Giỏi
-->

<c:choose>
	<c:when test="${ diem < 5 }"><p>Trượt</p></c:when>
	<c:when test="${ diem < 7 }"><p>Trung bình</p></c:when>
	<c:when test="${ diem < 9 }"><p>Khá</p></c:when>
	<c:when test="${ diem <= 10 }"><p>Giỏi</p></c:when>
</c:choose>


<script src="${ pageContext.request.contextPath }/js/hello.js"></script>
