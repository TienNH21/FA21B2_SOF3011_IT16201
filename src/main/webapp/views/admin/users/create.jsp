<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form
	method="POST"
	action="/SOF3011_IT16201/admin/users/create">
	<div>
		<label>Họ tên</label>
		<input name="fullname" type="text" />
	</div>
	<div>
		<label>Email</label>
		<input name="email" type="email" />
	</div>
	<div>
		<label>Mật khẩu</label>
		<input name="password" type="password" />
	</div>
	<div>
		<label>Phân quyền</label>
		<select name="admin">
			<option value="0">Người dùng</option>
			<option value="1">Quản trị</option>
		</select>
	</div>
	<button>Thêm mới</button>
</form>
