<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ru-RU">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>FBlog</title>
    <link href="/static/css/bootstrap.css" rel="stylesheet">
    <link href="/static/css/bootstrap-theme.css" rel="stylesheet">
    <link href="/static/css/font-awesome.css" rel="stylesheet">
    <link href="/static/css/app.css" rel="stylesheet">

</head>
<body>
<header>
    <jsp:include page="fragment/header.jsp" />

</header>
<div class="container">
    <div class="row">

        <div class="col-sm-8 blog-main">
            <jsp:include page="${PAGE}" />
        </div><!-- /.blog-main -->

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
            <jsp:include page="fragment/aside.jsp" />
        </div><!-- /.blog-sidebar -->

    </div><!-- /.row -->

</div>
<footer class="footer">
    <jsp:include page="fragment/footer.jsp" />
</footer>
<script src="/static/js/jquery.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/app.js"></script>
</body>
</html>