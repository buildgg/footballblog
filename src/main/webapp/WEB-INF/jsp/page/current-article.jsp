<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="blog-post">
<h4 class="blog-post-title"><a href="#" class="a-black"> ${CURRENT_ARTICLE.header}</a></h4>
<nav>
  <ul class="blog-post-meta">
    <li>${CURRENT_ARTICLE.created}</li>
    <li class="navbar-right"><i class="fa fa-bookmark" aria-hidden="true"></i><a href="#"> ${CURRENT_ARTICLE.category}</a></li>
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
  <i class="fa fa-comments title-comment" aria-hidden="true">Комментарии</i><span class="badge">${COUNT_COMMENTS}</span>
  <jsp:include page="../fragment/comments-list.jsp"/>
</div>
  <i class="fa fa-comments write-comment" aria-hidden="true">Написать комментарий</i>
  <form class="input-comment" >
    <div class="form-group">
      <label for="user">Имя пользователя</label>
      <input type="text" class="form-control"
             id="user" placeholder="Введите имя" required size="40" maxlength="64" oninvalid="this.setCustomValidity('Пожалуйста введите имя')">
    </div>
     <div class="form-group">
      <label for="comment">Комментарий</label>
      <textarea class="form-control" rows="3" id="comment" placeholder="Оставьте комментарий"
                required maxlength="1024"></textarea>
    </div>
    <div class="form-group">
      <button type="submit" class="btn btn-success">Оставить комментарий</button>
    </div>

  </form>
  </div>
