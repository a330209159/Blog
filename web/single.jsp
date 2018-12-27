<%--
  Created by IntelliJ IDEA.
  User: Bravery Federal
  Date: 2018/12/24
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meow &amp; Blog</title>

    <!-- meta -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- css -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/ionicons.min.css">
    <link rel="stylesheet" href="css/pace.css">
    <link rel="stylesheet" href="css/custom.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/images/caticon.ico" />
    <!-- js -->
    <script src="js/jquery-2.1.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/pace.min.js"></script>
    <script src="js/modernizr.custom.js"></script>
    <!-- syntax highlight -->
    <script type="text/javascript" src="js/shCore.js"></script>
    <link rel="stylesheet" href="css/shCoreDefault.css">
    <script type="text/javascript">
        SyntaxHighlighter.all();
    </script>
    <script>
        $(function(){
            SyntaxHighlighter.highlight();
            $("table.syntaxhighlighter").each(function () {
                if (!$(this).hasClass("nogutter")) {
                    var $gutter = $($(this).find(".gutter")[0]);
                    var $codeLines = $($(this).find(".code .line"));
                    $gutter.find(".line").each(function (i) {
                        $(this).height($($codeLines[i]).height());
                        $($codeLines[i]).height($($codeLines[i]).height());
                    });
                }
            });
        });
    </script>

</head>
<body id="single">
<div class="container">
    <header id="site-header">
        <div class="row">
            <div class="col-md-4 col-sm-5 col-xs-8">
                <div class="logo">
                    <h1><a href="index.do"><b>Meow</b> &amp; Blog</a></h1>
                </div>
            </div><!-- col-md-4 -->
            <div class="col-md-8 col-sm-7 col-xs-4">
                <nav class="main-nav" role="navigation">
                    <div class="navbar-header">
                        <button type="button" id="trigger-overlay" class="navbar-toggle">
                            <span class="ion-navicon"></span>
                        </button>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="cl-effect-11"><a href="index.do" data-hover="Home">Home</a></li>
                            <li class="cl-effect-11"><a href="admin/edit.jsp" data-hover="Post">Post</a></li>

                        </ul>
                    </div><!-- /.navbar-collapse -->
                </nav>
                <div id="header-search-box">
                    <a id="search-menu" href="#"><span id="search-icon" class="ion-ios-search-strong"></span></a>
                    <div id="search-form" class="search-form">
                        <form role="search" method="get" id="searchform" action="#">
                            <input type="search" placeholder="Search" required>
                            <button type="submit"><span class="ion-ios-search-strong"></span></button>
                        </form>
                    </div>
                </div>
            </div><!-- col-md-8 -->
        </div>
    </header>
</div>

<div class="content-body">
    <div class="container">
        <div class="row">
            <main class="col-md-8">
                <article class="post post-1">
                    <header class="entry-header">
                        <h1 class="entry-title">${post.post_title}</h1>
                        <div class="entry-meta">
                            <span class="post-category"><a href="#">${post.post_name}</a></span>

                            <span class="post-date"><a href="#"><time class="entry-date" datetime="${post.post_date}">${post.post_date}</time></a></span>

                            <span class="post-author"><a href="#">${post.s_post_author}</a></span>

                            <span class="comments-link"><a href="admin/re-edit.do?id=${post.ID}">编辑</a></span>
                        </div>
                    </header>
                    <div class="entry-content clearfix">
                        ${post.post_content}
                    </div>
                </article>
            </main>
            <aside class="col-md-4">
                <div class="widget widget-recent-posts">
                    <h3 class="widget-title">Recent Posts</h3>
                    <ul>
                        <c:forEach items="${posts}" var="item" begin="0" end="6">
                            <li>
                                <a href="single?id=${item.ID}">${item.post_title}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="widget widget-archives">
                    <h3 class="widget-title">Archives</h3>
                    <ul>
                        <li>
                            <a href="#">November 2018</a>
                        </li>
                        <li>
                            <a href="#">December 2018</a>
                        </li>
                        <li>
                            <a href="#">January 2019</a>
                        </li>
                    </ul>
                </div>

                <div class="widget widget-category">
                    <h3 class="widget-title">Category</h3>
                    <ul>
                        <li>
                            <a href="#">Web Design</a>
                        </li>
                        <li>
                            <a href="#">Web Development</a>
                        </li>
                        <li>
                            <a href="#">SEO</a>
                        </li>
                    </ul>
                </div>
            </aside>
        </div>
    </div>
</div>
<footer id="site-footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p class="copyright">&copy;Meow Blog 2018 Powered By WangYue</p>
            </div>
        </div>
    </div>
</footer>

<!-- Mobile Menu -->
<div class="overlay overlay-hugeinc">
    <button type="button" class="overlay-close"><span class="ion-ios-close-empty"></span></button>
    <nav>
        <ul>
            <li><a href="index.do">Home</a></li>
            <li><a href="admin/edit.jsp">Post</a></li>
        </ul>
    </nav>
</div>

<script src="js/script.js"></script>

</body>
</html>
