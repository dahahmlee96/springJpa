<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>

</head>
<body>
    <form action="/login" method="get" name="lfrm">
        <div>
            <input type="text" class="form-control" name="username" placeholder="E-mail">
        </div>
        <div>
            <input type="password" class="form-control" name="password" placeholder="Password">
        </div>
        <button type="submit" id="btn" value="Log In">email login</button>
        <div class="social-login">
            <a href="./google/login" class="google btn d-flex justify-content-center align-items-center">
                 Login with  Google
            </a>
        </div>
    </form>

    <script type="text/javascript">

    </script>
</body>
</html>