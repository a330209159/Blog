<%--
  Created by IntelliJ IDEA.
  User: Bravery Federal
  Date: 2018/12/23
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<form name="loginform" id="loginform" action="login.do" method="post">
    <p>
        <label for="user_login">用户名<br />
            <input type="text" name="log" id="user_login" class="input" value="" size="20" /></label>
    </p>
    <p>
        <label for="user_pass">密码<br />
            <input type="password" name="pwd" id="user_pass" class="input" value="" size="20" /></label>
    </p>
    <p>${states}</p>

    <p class="submit">
        <input type="submit" name="wp-submit" id="wp-submit" class="button button-primary button-large" value="登录" />

    </p>
</form>
</body>
</html>
