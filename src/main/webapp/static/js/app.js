$(function () {
    var init = function () {
        $('.add-comment').click(addComment);
        $('#btn-next').click(btnCancelNext);
        $('#btn-previous').click(btnCancelPrevious);
    };

    var btnCancelNext = function(e){
        var countPage = $('.blog-post').attr('data-count-page');
        var currentPage = $('.blog-post').attr('data-current-page');
        if (currentPage>= countPage) {
            e.preventDefault();
        }
    }
    var btnCancelPrevious = function(e){
        var currentPage = $('.blog-post').attr('data-current-page');
        if (currentPage == 1) {
            e.preventDefault();
        }
    }

    var addComment = function () {
        console.log('WWW');
        var user = $('#user').val();
        var comment = $('#comment').val();
        var articleId = $('.blog-post').attr('data-articleid');
        var countComment = parseInt($('#count-comments').html());

        $.ajax({
            url: '/ajax/comment/add',
            method: 'POST',
            data: {
                user: user,
                comment: comment,
                id: articleId
            },
            success: function (data) {

                var userDiv = $('<div/>', {
                    class: 'user-name',
                    text: user
                });
                var userComment = $('<div/>', {
                    class: 'user-comment',
                    text: comment
                });

                var divComment = $('<div/>', {
                    class: 'one-comment'

                });
                html-tem

                $(divComment).add(userDiv).add(userComment).add('<hr/>').appendTo('.comments');
                $('#collapseExample.in').remove();
                countComment++;
                $('#count-comments').text(countComment);

            },
            error: function (data) {
                console.log("error");
            }
        });
    };

    init();
});
