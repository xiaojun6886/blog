$(function(){
    var blogDetailId = $("#blogDetailIdTemp").val();
    $.ajax({
        url:"/article/detail/ajaxGetArticleDetail?blogDetailId="+blogDetailId,
        contentType:"application/x-www-form-urlencoded;charset=UTF-8",
        success:function (data) {
            if (data != null) {
                var title = data.title;
                var releaseDate = data.releaseDate;
                var editName = data.editName;
                var readNumber = data.readNumber;
                var content = data.content;
               $("#Detail_title").html(title);
               $("#article_Detail_title").html(title);
               $("#release_date").html(getTsFormatDate(releaseDate));
               $("#edit_name").html(editName);
               $("#read_number").html(readNumber);
               $("#content").html(content);
            }
        }
    });
});


