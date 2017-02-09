<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<div class="input-comment" <%--action="/sign-out"--%> <%--method="get"--%>>
    <div class="form-group">
        <label for="user">Имя пользователя</label>
        <input type="text" class="form-control" name="user-name"
               id="user" placeholder="Введите имя" required size="40" maxlength="64">
    </div>
    <div class="form-group">
        <label for="comment">Комментарий</label>
      <textarea class="form-control" rows="5" id="comment" placeholder="Оставьте комментарий"
                required maxlength="1024" name="user-comment"></textarea>
    </div>
    <div class="form-group">
        <button type="submit" class="btn btn-success add-comment">Оставить комментарий</button>
    </div>
</div>
