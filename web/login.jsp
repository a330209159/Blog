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
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>MEOW BLOG登陆界面</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/images/favicon.png" />
</head>

<body>
<div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-center auth">
            <div class="row w-100">
                <div class="col-lg-4 mx-auto">
                    <div class="auth-form-light text-left p-5">
                        <div class="brand-logo">
                            <img src="${pageContext.request.contextPath }/images/logo.svg">
                        </div>
                        <h4>你好！让我们开始吧！</h4>
                        <h6 class="font-weight-light">登陆以继续...</h6>
                        <form class="pt-3" action="${pageContext.request.contextPath }/login" method="post">
                            <div class="form-group">
                                <input name="log" type="username" class="form-control form-control-lg" id="exampleInputEmail1" placeholder="用户名">
                            </div>
                            <div class="form-group">
                                <input name="pwd" type="password" class="form-control form-control-lg" id="exampleInputPassword1" placeholder="密码">
                            </div>
                            <div class="mt-3">
                                <button class="btn btn-block btn-gradient-primary btn-lg font-weight-medium auth-form-btn" type="submit">登 录</button>
                            </div>
                            <div class="my-2 d-flex justify-content-between align-items-center">
                                <div class="form-check">
                                    <label class="form-check-label text-muted">
                                        <input type="checkbox" class="form-check-input" checked="checked">
                                        保持我的登陆状态
                                    </label>
                                </div>
                                <a href="#" class="auth-link text-black">忘记密码?</a>
                            </div>
                            <div class="text-center mt-4 font-weight-light">
                                <p class="align-items-center">${states}</p>
                            </div>
                            <div class="text-center mt-4 font-weight-light">
                                没有账户? <a href="admin/register.do" class="text-primary">创建</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- content-wrapper ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
<!-- plugins:js -->
<script src="${pageContext.request.contextPath }/vendors/js/vendor.bundle.base.js"></script>
<script src="${pageContext.request.contextPath }/vendors/js/vendor.bundle.addons.js"></script>
<!-- endinject -->
<!-- inject:js -->
<script src="${pageContext.request.contextPath }/js/off-canvas.js"></script>
<script src="${pageContext.request.contextPath }/js/misc.js"></script>
<!-- endinject -->
</body>
</html>