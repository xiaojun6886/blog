//异步加载首页数据
$(function () {
   $.ajax({
       url:"/ajaxGetIndexDetail",
       contentType:"application/json",
       success:function (datas) {
           if (datas != null && datas.length>0) {
               var dataList = datas.slice(0,10);
               var labelCount = "";
               for (var i=0; i<dataList.length;i++) {
                   var title = dataList[i].title;
                   var blogDetailId = dataList[i].blogDetailId;
                   var articleSummary = dataList[i].articleSummary;
                   var releaseDate = dataList[i].releaseDate;
                   var editName = dataList[i].editName;
                   var readNumber = dataList[i].readNumber;
                   var label = dataList[i].label;
                   labelCount += dataList[i].label+",";
                   //展示每一篇文章的标题和文章摘要等
                   showIndexDetail(title,blogDetailId,articleSummary,releaseDate,editName,readNumber,i);
                   //首页每一篇文章的标签
                   showLabel(label,i);
               }
               //热门标签
               showSumLabel(labelCount);
           }
       }
   })
});

function showIndexDetail(title,blogDetailId,articleSummary,releaseDate,editName,readNumber,i) {
    if (i<6) {
        var a = "label"+i;
        var hrefs = "/article/detail/"+blogDetailId;
        var articheZhais = '<div class="panel panel-default">' +
            '<div class="panel-body">' +
            '<h4><a class="title" href='+hrefs+' target="_blank">' + title + '</a></h4>' +
            '<p id='+a+'></p>' +
            '<p class="overView"><a href='+hrefs+' target="_blank">' + articleSummary + '</a></p>' +
            '<p><span class="count"><i class="glyphicon glyphicon-user"></i><a href="#">' +
            '<span>' + editName + '</span></a></span> <span class="count">' +
            '<i class="glyphicon glyphicon-eye-open"></i>阅读:' +
            '<span>' + readNumber + '</span></span><span class="count">' +
            '<i class="glyphicon glyphicon-comment">' +
            '</i>评论:18</span><span class="count"><i class="glyphicon glyphicon-time">' +
            '</i><span>' + getTsFormatDate(releaseDate) + '</span></span></p></div></div>';
        $("#index_detail").append(articheZhais);
    }
}

function showLabel(label,i) {
    var arr = label.split(",");
    for(var v = 0, len = arr.length; v < len; v++){
        var popContent = '<a class="label label-default">'+arr[v]+'</a>';
        $("#label"+i).append(popContent);
    }
}

function showSumLabel(labelCount) {
    var split = labelCount.split(",");
    var unique = unqiue3(split);
    for(var s = 0, len = unique.length; s < len; s++){
        var queryHref =  "/article/"+ unique[s];
        var labelContent = '<a href='+queryHref+' target="_blank" class="label label-default">'+unique[s]+'</a>';
        $(".labelList").append(labelContent);
    }
}

//过滤重复的标签
function unqiue3(array){
    var cache=[];
    var myresult=[];
    for(var i=0;i<array.length;i++){
        cache[array[i]]=i;
    }
    for(key in cache){
        myresult.push(key);
    }
    return myresult;
}

function elasticSearch() {

    var searchHome = $("#searchHome").val();

    $.ajax({
        url:"/ajaxGetSearchHome?"+searchHome,
        contentType:"application/json",
        success:function (datas) {

        }
    })

}

