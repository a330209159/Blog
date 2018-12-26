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
    <link rel="stylesheet" href="../vendors/iconfonts/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="../vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- inject:css -->
    <link rel="stylesheet" href="../css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="../images/favicon.png" />
    <!-- ueditor-->
    <script type="text/javascript" charset="utf-8" src="ueditor2/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor2/ueditor.all.js"></script>
    <link href="ueditor2/themes/default/css/ueditor.css" rel="stylesheet">
    <script type="text/javascript" charset="utf-8" src="ueditor2/lang/zh-cn/zh-cn.js"></script>
    <!-- endueditor -->
</head>
<body>
<div class="container-scroller">
    <!-- import header start -->
    <jsp:include page="common/header.jsp"/>
    <!-- import header end -->
    <div class="container-fluid page-body-wrapper">

        <!--import sidebar start-->
        <jsp:include page="common/sidebar_edit.jsp"/>
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
                    <div class="col-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">发表文章</h4>

                                <form class="form-sample" action="post.do" method="post">
                                    <div class="form-group">
                                        <label>文章标题</label>
                                        <input type="text" name="post_title" class="form-control" id="articletitle_" placeholder="请输入文章标题" autocomplete="off" value="${post.post_title}">
                                    </div>
                                    <div class="form-group">
                                        <label>文章内容</label>
                                        <textarea name="post_content" id="editor" rows="12">${post.post_content}</textarea>
                                    </div>
                                    <input type="hidden" name="post_author" value="${user.ID}" />

                                    <button type="submit" class="btn btn-gradient-primary mr-6">发表</button>
                                </form>
                                <script type="text/javascript">
                                    UE.getEditor('editor',{ initialFrameHeight: 380});
                                </script>
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
<!-- inject:js -->
<script src="../js/off-canvas.js"></script>
<script src="../js/misc.js"></script>
<!-- endinject -->
</body>
</html>
