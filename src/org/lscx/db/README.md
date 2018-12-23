#数据库设计
##用户(users)表
|字段名称|含义|数据类型|是否主键|是否为空|是否外键|其他约束|
|:----:|:---:|:-----:|-----:|:-----:|:----:|:-----:|
|ID   |用户ID| bigint(20) |Yes|No|No|AUTO_INCREMENT|
|user_login|用户名|varchar(60)|No|No|No| |
|user_pass|用户登录密码|varchar(255)|No|No|No| |
|user_nickname|用户昵称|varchar(50)|No|No|No| |
|user_email|用户E-mail|varchar(100)|No|No|No| |
##文章(posts)表
|字段名称|含义|数据类型|是否主键|是否为空|是否外键|其他约束|
|:----:|:---:|:-----:|-----:|:-----:|:----:|:-----:|
|ID|文章ID|bigint(20)|Yes|No|No|AUTO_INCREMENT|
|post_author|文章作者|bigint(20)|No|No|No|
|post_date|发布时间|datetime|No|No|No|
|post_title|文章标题|text|No|No|No| |
|post_content|文章内容|text|No|No|No| |
|post_name|文章类别|varchar(200)|No|No|No| |
##评论(comments)表
|字段名称|含义|数据类型|是否主键|是否为空|是否外键|其他约束|
|:----:|:---:|:-----:|-----:|:-----:|:----:|:-----:|
|comment_ID|评论ID|bigint(20)|Yes|No|No|AUTO_INCREMENT|
|comment_post_ID|评论文章ID|bigint(20)|No|No|No| |
|comment_author|评论人|tinytext|No|No|No| |
|comment_author_email|评论人E-mail|varchar(100)|No|No|No| |
|comment_author_url|评论人URL|varchar(200)|No|No|No| |
|comment_date|评论时间|datetime|No|No|No| |
|comment_content|评论内容|text|No|No|No| |
|comment_agent|评论人UA|varchar(255)|No|No|No| |