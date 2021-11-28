<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form
	method="POST"
	action="/SOF3011_IT16201/admin/users/edit?id=${ user.id }">
	<div>
		<label>Họ tên</label>
		<input name="fullname" type="text" value="${ user.fullname }" />
	</div>
	<div>
		<label>Email</label>
		<input name="email" type="email" value="${ user.email }" />
	</div>
	<div>
		<label>Mật khẩu</label>
		<input name="password" type="password" />
	</div>
	<div>
		<label>Phân quyền</label>
		<select name="admin">
			<option ${ user.admin == 0 ? "selected" : "" } value="0">Người dùng</option>
			<option ${ user.admin == 1 ? "selected" : "" } value="1">Quản trị</option>
		</select>
	</div>
	<button>Cập nhật</button>
</form>
