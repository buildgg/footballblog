<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach  var="article_list" items="${articles_on_page}">
<h4 class="blog-post-title">
    <a href="/current-article" class="a-black">${article_list.header}</a>
</h4>
<nav>
    <ul class="blog-post-meta">
        <li>${article_list.created} </li>
        <li class="navbar-right"><i class="fa fa-bookmark" aria-hidden="true"></i><a href="#"> ${article_list.category} </a></li>
    </ul>
</nav>

<div class="blog-post-img">
    <img src="${article_list.urlImg}" alt='${article_list.header}'>
</div>
    ${article_list.description}
<nav>
    <ul class="blog-post-sign">
        <li><span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
            <a href="/current-article"> Читать далее</a>
        </li>
        <li class="navbar-right"><i class="fa fa-comment" aria-hidden="true"></i>
            <a href="#"> Комментарии</a><span class="badge">${article_list.countComments}</span>
        </li>
    </ul>
</nav>
</c:forEach>