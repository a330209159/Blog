<%--
  Created by IntelliJ IDEA.
  User: Bravery Federal
  Date: 2018/12/23
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Meow Blog Admin</title>
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
    <!-- import header start -->
    <jsp:include page="common/header.jsp"/>
    <!-- import header end -->
    <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_sidebar.html -->
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
                <li class="nav-item">
                    <a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
                        <span class="menu-title">文章管理</span>
                        <i class="menu-arrow"></i>
                        <i class="mdi mdi-crosshairs-gps menu-icon"></i>
                    </a>
                    <div class="collapse" id="ui-basic">
                        <ul class="nav flex-column sub-menu">
                            <li class="nav-item"> <a class="nav-link" href="edit.jsp">写文章</a></li>
                            <li class="nav-item"> <a class="nav-link" href="showPosts.do">查看所有文章</a></li>
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
                <div class="row">
                    <div class="col-12">
              <span class="d-flex align-items-center purchase-popup">
                <p>${user.user_nickname},欢迎回来,来看看我们可以做什么!</p>
                <a href="https://github.com/a330209159/Blog" target="_blank" class="btn ml-auto download-button">本项目Github</a>
                <a href="${pageContext.request.contextPath}/index.do" target="_blank" class="btn purchase-button">回到主页</a>
                <i class="mdi mdi-airplane"></i>
              </span>
                    </div>
                </div>
                <div class="page-header">
                    <h3 class="page-title">
              <span class="page-title-icon bg-gradient-primary text-white mr-2">
                <i class="mdi mdi-home"></i>
              </span>
                        仪表盘
                    </h3>
                    <nav aria-label="breadcrumb">
                        <ul class="breadcrumb">
                            <li class="breadcrumb-item active" aria-current="page">
                                <span></span>概 览
                                <i class="mdi mdi-alert-circle-outline icon-sm text-primary align-middle"></i>
                            </li>
                        </ul>
                    </nav>
                </div>
                <div class="row">
                    <div class="col-md-4 stretch-card grid-margin">
                        <div class="card bg-gradient-danger card-img-holder text-white">
                            <div class="card-body">
                                <img src="../images/dashboard/circle.svg" class="card-img-absolute" alt="circle-image"/>
                                <h4 class="font-weight-normal mb-3">本周文章数量
                                    <i class="mdi mdi-chart-line mdi-24px float-right"></i>
                                </h4>
                                <h2 class="mb-5">20</h2>
                                <h6 class="card-text">提升了 60%</h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 stretch-card grid-margin">
                        <div class="card bg-gradient-info card-img-holder text-white">
                            <div class="card-body">
                                <img src="../images/dashboard/circle.svg" class="card-img-absolute" alt="circle-image"/>
                                <h4 class="font-weight-normal mb-3">本月文章数量
                                    <i class="mdi mdi-bookmark-outline mdi-24px float-right"></i>
                                </h4>
                                <h2 class="mb-5">136</h2>
                                <h6 class="card-text">提升了 10%</h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 stretch-card grid-margin">
                        <div class="card bg-gradient-success card-img-holder text-white">
                            <div class="card-body">
                                <img src="../images/dashboard/circle.svg" class="card-img-absolute" alt="circle-image"/>
                                <h4 class="font-weight-normal mb-3">总访客数
                                    <i class="mdi mdi-diamond mdi-24px float-right"></i>
                                </h4>
                                <h2 class="mb-5">5741</h2>
                                <h6 class="card-text">提升了 5%</h6>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-7 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <div class="clearfix">
                                    <h4 class="card-title float-left">访客地区分析</h4>
                                    <div id="visit-sale-chart-legend" class="rounded-legend legend-horizontal legend-top-right float-right"></div>
                                </div>
                                <canvas id="visit-sale-chart" class="mt-4"></canvas>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">访客来源</h4>
                                <canvas id="traffic-chart"></canvas>
                                <div id="traffic-chart-legend" class="rounded-legend legend-vertical legend-bottom-left pt-4"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12 grid-margin">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">最近的文章</h4>
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>
                                                作者
                                            </th>
                                            <th>
                                                标题
                                            </th>
                                            <th>
                                                状态
                                            </th>
                                            <th>
                                                上次更新
                                            </th>
                                            <th>
                                                用户ID
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>
                                                <img src="../images/faces/face1.jpg" class="mr-2" alt="image">
                                                王老板
                                            </td>
                                            <td>
                                                柴犬虾饺的日常
                                            </td>
                                            <td>
                                                <label class="badge badge-gradient-success">DONE</label>
                                            </td>
                                            <td>
                                                Dec 5, 2017
                                            </td>
                                            <td>
                                                WD-12345
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <img src="../images/faces/face2.jpg" class="mr-2" alt="image">
                                                赛琳娜
                                            </td>
                                            <td>
                                                旅行的时光
                                            </td>
                                            <td>
                                                <label class="badge badge-gradient-warning">PROGRESS</label>
                                            </td>
                                            <td>
                                                Dec 12, 2017
                                            </td>
                                            <td>
                                                WD-12346
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <img src="../images/faces/face3.jpg" class="mr-2" alt="image">
                                                黑大爷
                                            </td>
                                            <td>
                                                代码测试阶段的注意事项
                                            </td>
                                            <td>
                                                <label class="badge badge-gradient-info">ON HOLD</label>
                                            </td>
                                            <td>
                                                Dec 16, 2017
                                            </td>
                                            <td>
                                                WD-12347
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <img src="../images/faces/face4.jpg" class="mr-2" alt="image">
                                                熊叔
                                            </td>
                                            <td>
                                                魔兽世界操作手册
                                            </td>
                                            <td>
                                                <label class="badge badge-gradient-danger">REJECTED</label>
                                            </td>
                                            <td>
                                                Dec 3, 2017
                                            </td>
                                            <td>
                                                WD-12348
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">最近更新</h4>
                                <div class="d-flex">
                                    <div class="d-flex align-items-center mr-4 text-muted font-weight-light">
                                        <i class="mdi mdi-account-outline icon-sm mr-2"></i>
                                        <span>Big Cat</span>
                                    </div>
                                    <div class="d-flex align-items-center text-muted font-weight-light">
                                        <i class="mdi mdi-clock icon-sm mr-2"></i>
                                        <span>October 3rd, 2018</span>
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-6 pr-1">
                                        <img src="../images/dashboard/img_1.jpg" class="mb-2 mw-100 w-100 rounded" alt="image">
                                        <img src="../images/dashboard/img_4.jpg" class="mw-100 w-100 rounded" alt="image">
                                    </div>
                                    <div class="col-6 pl-1">
                                        <img src="../images/dashboard/img_2.jpg" class="mb-2 mw-100 w-100 rounded" alt="image">
                                        <img src="../images/dashboard/img_3.jpg" class="mw-100 w-100 rounded" alt="image">
                                    </div>
                                </div>
                                <div class="d-flex mt-5 align-items-top">
                                    <img src="../images/faces/face3.jpg" class="img-sm rounded-circle mr-3" alt="image">
                                    <div class="mb-0 flex-grow">
                                        <h5 class="mr-2 mb-2">学校网站 - 认证模块</h5>
                                        <p class="mb-0 font-weight-light">告诉你如何完成学校网站认证模块的设计,本文附带了认证模块的源代码以及解析
                                            </p>
                                    </div>
                                    <div class="ml-auto">
                                        <i class="mdi mdi-heart-outline text-muted"></i>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">项目进度</h4>
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>
                                                ID
                                            </th>
                                            <th>
                                                用户名
                                            </th>
                                            <th>
                                                截止日期
                                            </th>
                                            <th>
                                                进度
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>
                                                1
                                            </td>
                                            <td>
                                                大佬猫
                                            </td>
                                            <td>
                                                May 15, 2018
                                            </td>
                                            <td>
                                                <div class="progress">
                                                    <div class="progress-bar bg-gradient-success" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                2
                                            </td>
                                            <td>
                                                黑大爷
                                            </td>
                                            <td>
                                                Jul 01, 2018
                                            </td>
                                            <td>
                                                <div class="progress">
                                                    <div class="progress-bar bg-gradient-danger" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                3
                                            </td>
                                            <td>
                                                熊叔闯世界
                                            </td>
                                            <td>
                                                Apr 12, 2018
                                            </td>
                                            <td>
                                                <div class="progress">
                                                    <div class="progress-bar bg-gradient-warning" role="progressbar" style="width: 90%" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100"></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                4
                                            </td>
                                            <td>
                                                朱总逮虾户
                                            </td>
                                            <td>
                                                May 15, 2018
                                            </td>
                                            <td>
                                                <div class="progress">
                                                    <div class="progress-bar bg-gradient-primary" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                5
                                            </td>
                                            <td>
                                                王脑板
                                            </td>
                                            <td>
                                                May 03, 2018
                                            </td>
                                            <td>
                                                <div class="progress">
                                                    <div class="progress-bar bg-gradient-danger" role="progressbar" style="width: 35%" aria-valuenow="35" aria-valuemin="0" aria-valuemax="100"></div>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                5
                                            </td>
                                            <td>
                                                吉娃娃
                                            </td>
                                            <td>
                                                Jun 05, 2018
                                            </td>
                                            <td>
                                                <div class="progress">
                                                    <div class="progress-bar bg-gradient-info" role="progressbar" style="width: 65%" aria-valuenow="65" aria-valuemin="0" aria-valuemax="100"></div>
                                                </div>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
            <!-- partial:partials/_footer.html -->
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
<!-- Plugin js for this page-->
<!-- End plugin js for this page-->
<!-- inject:js -->
<script src="../js/off-canvas.js"></script>
<script src="../js/misc.js"></script>
<!-- endinject -->
<!-- Custom js for this page-->
<script src="../js/dashboard.js"></script>
<!-- End custom js for this page-->
</body>
</html>
