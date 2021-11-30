<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="col-12">
	<a href="/SOF3011_IT16201/admin/users/create" class="btn btn-success">Thêm mới</a>
</div>
<table class="table">
	<thead>
		<tr>
			<td>Id</td>
			<td>Họ Tên</td>
			<td>Email</td>
			<td>Liked</td>
			<td>Phân quyền</td>
			<td colspan="2">Thao tác</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ listUser }" var="user">
		<tr>
			<td>${ user.id }</td>
			<td>${ user.fullname }</td>
			<td>${ user.email }</td>
			<td>${ fn:length(user.favorites) }</td>
			<td>${ user.admin == 0 ? "Người dùng" : "Quản trị" }</td>
			<td>
				<a
					href="/SOF3011_IT16201/admin/users/edit?id=${ user.id }"
					class="btn btn-primary">Cập nhật</a>
			</td>
			<td>
				<!-- https://getbootstrap.com/docs/4.0/components/modal/ -->
				<a href="/SOF3011_IT16201/admin/users/delete?id=${ user.id }"
					class="btn btn-danger">Xóa</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>

</table>