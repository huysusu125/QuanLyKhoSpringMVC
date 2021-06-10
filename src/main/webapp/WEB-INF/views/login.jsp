<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng nhập</title>
</head>
<body>
<div class="main">

    <form action="j_spring_security_check" method="post" class="form" id="form-1">
        <h3 class="heading">Đăng nhập</h3>
        <div class="spacer"></div>
        <div class="form-group">
            <label for="username" class="form-label">Tên đăng nhập</label>
            <input id="username" name="j_username" type="text" placeholder="Tên tài khoản" class="form-control">
            <span class="form-message"></span>
        </div>
        <div class="form-group">
            <label for="password" class="form-label">Mật khẩu</label>
            <input id="password" name="j_password" type="password" placeholder="Mật khẩu" class="form-control">
            <span class="form-message"></span>
        </div>
        <button class="form-submit">Đăng nhập</button>
    </form>

</div>
</body>
</html>