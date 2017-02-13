<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fblog" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
<c:when test="${count_page > 0}">
<div class="blog-post" data-count-page="${count_page}" data-current-page="${current_page}">
    <jsp:include page="../fragment/articles-list.jsp"/>
    <hr>
</div>
<fblog:pager-button/>
</c:when>
    <c:otherwise>
        <div class="alert alert-warning" role="alert">Данной страницы не существует</div>
    </c:otherwise>
</c:choose>