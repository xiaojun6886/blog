$(function () {
   $.ajax({
       url:"/ajaxGetIndexDetail",
       contentType:"application/json",
       success:function (dataList) {
           if (dataList != null && dataList.length>0) {
               for (var i=0; i<dataList.length;i++) {
                   var title = dataList[i].title;
                   var articleZhai = dataList[i].articleZhai;
                   var releaseDate = dataList[i].releaseDate;
                   var editName = dataList[i].createName;
                   var readNumber = dataList[i].readNumber;
                    $("#index_title"+i).html(title);
                    $("#title"+i).html(title);
                    $("#articleZhai"+i).html(articleZhai);
                    $("#releaseDate"+i).html(getTsFormatDate(releaseDate));
                    $("#editName"+i).html(editName);
                    $("#readNumber"+i).html(readNumber);
               }
           }
       }
   })
});

