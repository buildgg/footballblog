<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<nav>
    <ul class="pager">
        <li class="previous ${current_page != 1 ? '': 'disabled'}">
            <a href="/fblog?page=${current_page-1}" id="btn-previous">Previous</a></li>
        <li class="next ${(count_page > 1 and current_page<count_page) ? '': 'disabled'}">
            <a href="/fblog?page=${current_page+1}" id="btn-next">Next</a></li>
    </ul>
</nav>