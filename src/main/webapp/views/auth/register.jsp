<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
</head>
<body>
	<!-- Header -->
	<!-- Sidebar -->
	<form
		method="POST"
		action="/SOF3011_IT16201/register">
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
			<label>Xác nhận mật khẩu</label>
			<input name="password_confirm" type="password" />
		</div>
		<button>Đăng ký</button>
	</form>

	<!-- Footer -->
</body>
</html>