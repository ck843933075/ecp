<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/maven/down">下载a.txt文件</a>
	<img src="${img.img[0] }" />
	<form action="/maven/addPics" method="post" enctype="multipart/form-data">
		<input type="text" name="username" />
		<input type="file" name="file" />
		<input type="file" name="file" />
		<input type="submit" />
	
	</form>
</body>
</html>