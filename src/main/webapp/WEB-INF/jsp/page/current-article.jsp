<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fblog" tagdir="/WEB-INF/tags" %>
<div class="blog-post" data-articleid = ${CURRENT_ARTICLE.id}>
  <h4 class="blog-post-title"><a href="#" class="a-black"> ${CURRENT_ARTICLE.header}</a></h4>
  <nav>
    <ul class="blog-post-meta">
      <li>${CURRENT_ARTICLE.created}</li>
      <li class="navbar-right"><i class="fa fa-bookmark" aria-hidden="true"></i><a
              href="#"> ${CURRENT_ARTICLE.category}</a></li>
    </ul>
  </nav>
  <div class="blog-post-img">
    <img src="${CURRENT_ARTICLE.urlImg}" alt='${CURRENT_ARTICLE.header}'>
  </div>
  <div class="current-article">
    ${CURRENT_ARTICLE.text}
  </div>
  <hr class="underline-article">
  <div class="comments">
    <i class="fa fa-comments title-comment" aria-hidden="true">Комментарии</i>
    <span class="badge" id="count-comments">${COUNT_COMMENTS}</span>
    <jsp:include page="../fragment/comments-list.jsp"/>
  </div>

  <a class="btn btn-success write-comment" role="button" data-toggle="collapse"
     href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
    <i class="fa fa-comments" aria-hidden="true">Написать комментарий</i>
  </a>
  <div class="collapse in" id="collapseExample">
    <div class="well">
  <fblog:form-comment/>
    </div>
  </div>
</div>
