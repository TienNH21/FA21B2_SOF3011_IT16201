<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
</head>
<body>
	<form
		enctype="multipart/form-data"
		method="POST"
		action="/SOF3011_IT16201/register">
		<div>
			<label>Họ tên</label>
			<input name="name" type="text" />
		</div>
		
		<div>
			<label>Chuyên ngành</label>
			<select name="chuyen_nganh">
				<option value="udpm">UDPM</option>
				<option value="tktw">TKTW</option>
				<option value="ltmt">LTMT</option>
			</select>
		</div>
		
		<div>
			<label>Giới tính</label>
			<input type="radio" name="gioi_tinh" value="nam" /> <label>Nam</label>
			<input type="radio" name="gioi_tinh" value="nu" />  <label>Nữ</label>
		</div>
		
		<div>
			<label>Chuyên ngành mong muốn</label>
			<input name="cn_mong_muon" type="checkbox" value="java" /> <label>Java</label>
			<input name="cn_mong_muon" type="checkbox" value="c#" /> <label>C#</label>
		</div>
		
		<div>
			<label>Ảnh đại diện</label>
			<input type="file" name="avatar" />
		</div>
		
		<button>Submit</button>
	</form>
</body>
</html>