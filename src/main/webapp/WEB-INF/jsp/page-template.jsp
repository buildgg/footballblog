<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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

            <div class="blog-post">
                <h4 class="blog-post-title"><a href="#" class="a-black">Официально. Александар Пантич - игрок "Динамо"</a></h4>
             <%--   <div class="blog-post-meta">--%>
                <nav>
                <ul class="blog-post-meta">
                        <li>Февраль 1, 2017 </li>
                        <li class="navbar-right"><i class="fa fa-bookmark" aria-hidden="true"></i><a href="#"> Украина</a></li>
                </ul>
                </nav>
               <%-- </div>--%>

                <%--<p class="navbar-text navbar-right">Signed in as <a href="#" class="navbar-link">Mark Otto</a></p>--%>
                <%--<p class="blog-post-meta">Февраль 1, 2017 </p>
                <p class="blog-post-meta"><i class="fa fa-bookmark" aria-hidden="true"></i><a href="#" class="a-black"> Украина</a></p>--%>
               <%-- <div class="blog-post-meta">
                    <ul>
                        <li>Февраль 1, 2017</li>
                        <li><i class="fa fa-bookmark" aria-hidden="true"></i><a href="#" class="a-black"> Украина</a></li>
                    </ul>
                </div>--%>
                <div class="blog-post-img">
                    <img src="/static/img/post360752_b5a5b_content.png" alt='Александар Пантич - игрок "Динамо"'>
                </div>

                <p> Футбольный клуб «Динамо» подписал контракт с сербским защитником Александаром Пантичем.</p>
                <p>Пантичу 24 года, его рост составляет 185 сантиметров, основная позиция на поле - центральный защитник.</p>
                <p>Новичок примет участие во втором тренировочном сборе «Динамо» в Испании.</p>

                <nav>
                    <ul class="blog-post-sign">
                        <li><span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
                             <a href="#"> Читать далее</a>
                        </li>
                        <li class="navbar-right"><i class="fa fa-comment" aria-hidden="true"></i>
                            <a href="#"> Комментарии</a><span class="badge">4</span>
                        </li>
                    </ul>
                </nav>


                <%--<div class="read-next">
                &lt;%&ndash;<span class="glyphicon glyphicon-option-horizontal" aria-hidden="true"></span>&ndash;%&gt;
                <span class="glyphicon glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
                <a href="#"> Читать далее</a>
               </div>--%>


                <hr>
            </div><!-- /.blog-post -->

            <div class="blog-post">
                <h2 class="blog-post-title">Another blog post</h2>
                <p class="blog-post-meta">December 23, 2013 by <a href="#">Jacob</a></p>

                <p>Cum sociis natoque penatibus et magnis <a href="#">dis parturient montes</a>, nascetur ridiculus mus. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Sed posuere consectetur est at lobortis. Cras mattis consectetur purus sit amet fermentum.</p>
                <blockquote>
                    <p>Curabitur blandit tempus porttitor. <strong>Nullam quis risus eget urna mollis</strong> ornare vel eu leo. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                </blockquote>
                <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
                <p>Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.</p>
            </div><!-- /.blog-post -->

            <div class="blog-post">
                <h2 class="blog-post-title">New feature</h2>
                <p class="blog-post-meta">December 14, 2013 by <a href="#">Chris</a></p>

                <p>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aenean lacinia bibendum nulla sed consectetur. Etiam porta sem malesuada magna mollis euismod. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                <ul>
                    <li>Praesent commodo cursus magna, vel scelerisque nisl consectetur et.</li>
                    <li>Donec id elit non mi porta gravida at eget metus.</li>
                    <li>Nulla vitae elit libero, a pharetra augue.</li>
                </ul>
                <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
                <p>Donec ullamcorper nulla non metus auctor fringilla. Nulla vitae elit libero, a pharetra augue.</p>
            </div><!-- /.blog-post -->

            <nav>
                <ul class="pager">
                    <li><a href="#">Previous</a></li>
                    <li><a href="#">Next</a></li>
                </ul>
            </nav>

        </div><!-- /.blog-main -->

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
            <jsp:include page="fragment/aside.jsp" />
        </div><!-- /.blog-sidebar -->

    </div><!-- /.row -->

   <%-- <div class="row">
        <aside class="col-xs-12 col-sm-4 col-md-3 col-lg-2">
            <jsp:include page="fragment/aside.jsp" />
        </aside>
        <main class="col-xs-12 col-sm-8 col-md-9 col-lg-10">
            &lt;%&ndash;<jsp:include page="${CURRENT_PAGE}" />&ndash;%&gt;
        </main>
    </div>--%>
</div>
<footer class="footer">
    <jsp:include page="fragment/footer.jsp" />
</footer>
<script src="/static/js/jquery.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/app.js"></script>
</body>
</html>
<p>Футбольный клуб «Динамо» подписал контракт с сербским защитником Александаром Пантичем.</p>
<p>Его рост составляет 185 сантиметров, основная позиция на поле - центральный защитник.</p>
<p>Новичок примет участие во втором тренировочном сборе «Динамо» в Испании.</p>