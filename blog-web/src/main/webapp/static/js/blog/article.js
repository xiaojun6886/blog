$(function(){
    $.ajax({
        url:"/ajaxGetIndexDetail",
        contentType:"application/json",
        success:function (dataList) {
            if (dataList != null && dataList.length>0) {
                for (var i=0;i<dataList.length;i++){
                    var title = dataList[i].title;
                    var blogDetailId = dataList[i].blogDetailId;
                    var articleSummary = dataList[i].articleSummary;
                    var releaseDate = dataList[i].releaseDate;
                    var editName = dataList[i].editName;
                    var readNumber = dataList[i].readNumber;
                    var label = dataList[i].label;
                    //展示每一篇文章的标题和文章摘要等
                    showArticle(title,blogDetailId,articleSummary,releaseDate,editName,readNumber,i);
                    //首页每一篇文章的标签
                    showLabel(label,i);
                }
            }
        }
    });
});

function showArticle(title,blogDetailId,articleSummary,releaseDate,editName,readNumber,i) {
    var a = "label"+i;
    var hrefs = "/article/detail/blogDetailId/"+blogDetailId;
    var artiches = '<div class="panel panel-default w_article_item">' +
        '<div class="panel-body"><div class="row"><div class="col-xs-6 col-md-3">\n' +
        '<a href="#" class="thumbnail w_thumbnail"><img th:src="@{static/img/aticleview.png}" alt="...">\n' +
        '</a></div><h4 class="media-heading">' +
        '<a class="title" href='+hrefs+'  target="_blank">'+title+'</a></h4>\n' +
        '<p id='+a+'></p><p class="w_list_overview overView"><a href='+hrefs+' target="_blank">' + articleSummary + '</a></p>\n' +
        '<p class="count_r"><span class="count"><i class="glyphicon glyphicon-user"></i>' +
        '<a href="#"><span>' + editName + '</span></a></span> <span class="count"><i class="glyphicon glyphicon-eye-open"></i>' +
        '阅读:<span>'+readNumber+'</span></span><span class="count"><i class="glyphicon glyphicon-comment"></i>评论:2</span>' +
        '<span class="count"><i class="glyphicon glyphicon-time"></i><span>'+getTsFormatDate(releaseDate)+'</span></span></p></div></div></div>';
    $("#articleList").append(artiches);
}

function showLabel(label,i) {
    var arr = label.split(",");
    for(var v = 0, len = arr.length; v < len; v++){
        var popContent = '<a class="label label-default">'+arr[v]+'</a>';
        $("#label"+i).append(popContent);
    }
}