<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach var="comment" items="${COMMENTSLIST_BY_ARTICLE}">
    <div class="one-comment" id = "${comment.id}">
        <div class="user-name">${comment.userName}</div>
        <div class="user-comment">${comment.message}</div>
        <hr>
    </div>
</c:forEach>