<%--
  Created by IntelliJ IDEA.
  User: Bravery Federal
  Date: 2018/12/24
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Meow Blog-写文章</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- inject:css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/images/favicon.png" />
</head>
<body>
<div class="container-scroller">
    <!-- partial:../../partials/_navbar.html -->
    <jsp:include page="../common/header.jsp"/>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <!--import sidebar start-->
        <jsp:include page="../common/sidebar_edit.jsp"/>
        <!--import sidebar end-->
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="page-header">
                    <h3 class="page-title">
                        撰写文章
                    </h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">文章管理</a></li>
                            <li class="breadcrumb-item active" aria-current="page">写文章</li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-md-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">${status}</h4>
                                <div class="media">
                                    <i class="mdi mdi-earth icon-md text-info d-flex align-self-center mr-3"></i>
                                    <div class="media-body">
                                        <p class="card-text">您的文章已经成功发布/更新，您可以返回主页<a href="${pageContext.request.contextPath }/single?id=${post.ID}">查看文章</a>或继续发布/更新文章。</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
            <!-- partial:../../partials/_footer.html -->
            <jsp:include page="../common/footer.jsp"/>
            <!-- partial -->
        </div>
        <!-- main-panel ends -->
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
