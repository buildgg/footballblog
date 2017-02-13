<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>


<div class="sidebar-module">
    <h4>Категории</h4>
<c:forEach var="category" items="${categoryList}">
    <ol class="list-unstyled size-category">
        <li><a href="/fblog${category.url}">${category.name}</a></li>
    </ol>
</c:forEach>
</div>

<div class="sidebar-module">
    <h4>Elsewhere</h4>
    <ol class="list-unstyled">
        <li><a href="#">GitHub</a></li>
        <li><a href="#">Twitter</a></li>
        <li><a href="#">Facebook</a></li>
    </ol>
</div>
