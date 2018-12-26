<%--
  Created by IntelliJ IDEA.
  User: Bravery Federal
  Date: 2018/12/24
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Meow Blog-所有文章</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="../vendors/iconfonts/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="../vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- inject:css -->
    <link rel="stylesheet" href="../css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="../images/favicon.png" />
</head>
<body>
<div class="container-scroller">
    <!-- partial:../../partials/_navbar.html -->
    <jsp:include page="common/header.jsp"/>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <!-- partial:../../partials/_sidebar.html -->
        <nav class="sidebar sidebar-offcanvas" id="sidebar">
            <ul class="nav">
                <li class="nav-item nav-profile">
                    <a href="#" class="nav-link">
                        <div class="nav-profile-image">
                            <img src="../images/faces/face1.jpg" alt="profile">
                            <span class="login-status online"></span> <!--change to offline or busy as needed-->
                        </div>
                        <div class="nav-profile-text d-flex flex-column">
                            <span class="font-weight-bold mb-2">${user.user_login}</span>
                            <span class="text-secondary text-small">管理员</span>
                        </div>
                        <i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">
                        <span class="menu-title">仪表盘</span>
                        <i class="mdi mdi-home menu-icon"></i>
                    </a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
                        <span class="menu-title">文章管理</span>
                        <i class="menu-arrow"></i>
                        <i class="mdi mdi-crosshairs-gps menu-icon"></i>
                    </a>
                    <div class="collapse show" id="ui-basic">
                        <ul class="nav flex-column sub-menu">
                            <li class="nav-item"> <a class="nav-link" href="edit.jsp">写文章</a></li>
                            <li class="nav-item active"> <a class="nav-link active" href="showPosts.do">查看所有文章</a></li>
                        </ul>
                    </div>
                </li>
                <li class="nav-item sidebar-actions">
            <span class="nav-link">
              <div class="border-bottom">
                <h6 class="font-weight-normal mb-3">快捷功能</h6>
              </div>
              <a href="${pageContext.request.contextPath }/index.do" class="btn btn-block btn-lg btn-gradient-primary mt-4">回到主页</a>
              <div class="mt-4">
                <div class="border-bottom">
                  <p class="text-secondary">Categories</p>
                </div>
                <ul class="gradient-bullet-list mt-4">
                  <li>Free</li>
                  <li>Pro</li>
                </ul>
              </div>
            </span>
                </li>
            </ul>
        </nav>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="page-header">
                    <h3 class="page-title">
                        文章管理
                    </h3>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#">文章管理</a></li>
                            <li class="breadcrumb-item active" aria-current="page">显示所有文章</li>
                        </ol>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">当前所有文章</h4>
                                <p class="card-description">
                                    你可以在这里看到当前的所有文章。
                                </p>
                                <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>
                                            文章ID
                                        </th>
                                        <th>
                                            文章标题
                                        </th>
                                        <th>
                                            文章作者
                                        </th>
                                        <th>
                                            发布时间
                                        </th>
                                        <th>
                                            文章类别
                                        </th>
                                        <th>
                                            文章操作
                                        </th>

                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${posts}" varStatus="status">
                                        <tr>
                                            <td>
                                                    ${item.ID}
                                            </td>
                                            <td>
                                                    ${item.post_title}
                                            </td>
                                            <td>
                                                    ${item.s_post_author}
                                            </td>

                                            <td>
                                                    ${item.post_date}

                                            </td>
                                            <td>
                                                    ${item.post_name}
                                            </td>
                                            <td>
                                                <a href="re-edit.do?id=${item.ID}" class="btn btn-gradient-primary btn-rounded btn-sm" >修改</a>
                                                <a href="delete.do?id=${item.ID}" class="btn btn-gradient-danger btn-rounded btn-sm" onClick="delete_confirm">删除</a>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
            <!-- partial:../../partials/_footer.html -->
            <jsp:include page="common/footer.jsp"/>
            <!-- partial -->
        </div>
        <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
<!-- plugins:js -->
<script src="../vendors/js/vendor.bundle.base.js"></script>
<script src="../vendors/js/vendor.bundle.addons.js"></script>
<!-- endinject -->
<script>
    function delete_confirm(e)
    {
        if (event.srcElement.outerText == "删除")
        {
            event.returnValue = confirm("删除是不可恢复的，你确认要删除吗？");
        }
    }
    document.onclick = delete_confirm;
</script>
<!-- inject:js -->
<script src="../js/off-canvas.js"></script>
<script src="../js/misc.js"></script>
<!-- endinject -->
</body>
</html>
