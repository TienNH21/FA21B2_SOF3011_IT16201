<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab 3 - Bài 1 - Form</title>
</head>
<body>
	<form action="/SOF3011_IT16201/Bai1Upload"
		method="POST" enctype="multipart/form-data">
		<input type="file" name="photo_file" />
		<input type="file" name="doc_file" />
		<button type="submit">Submit</button>
	</form>
</body>
</html>