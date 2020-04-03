//异步加载首页数据
$(function () {
   $.ajax({
       url:"/ajaxGetIndexDetail",
       contentType:"application/json",
       success:function (dataList) {
           if (dataList != null && dataList.length>0) {
               var labelCount = "";
               for (var i=0; i<dataList.length;i++) {
                   var title = dataList[i].title;
                   var articleZhai = dataList[i].articleZhai;
                   var releaseDate = dataList[i].releaseDate;
                   var editName = dataList[i].createName;
                   var readNumber = dataList[i].readNumber;
                   var label = dataList[i].label;
                   labelCount += dataList[i].label+",";

                   var arr = label.split(",");
                   for(var v = 0, len = arr.length; v < len; v++){
                       var popContent = '<a class="label label-default">'+arr[v]+'</a>';
                       $("#label"+i).append(popContent);
                   }

                    $("#index_title"+i).html(title);
                    $("#title"+i).html(title);
                    $("#articleZhai"+i).html(articleZhai);
                    $("#releaseDate"+i).html(getTsFormatDate(releaseDate));
                    $("#editName"+i).html(editName);
                    $("#readNumber"+i).html(readNumber);
               }
               var split = labelCount.split(",");
               var unique = unqiue3(split);
               for(var s = 0, len = unique.length; s < len; s++){
                   var labelContent = '<a class="label label-default">'+unique[s]+'</a>';
                   $(".labelList").append(labelContent);
               }
           }
       }
   })
});

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

